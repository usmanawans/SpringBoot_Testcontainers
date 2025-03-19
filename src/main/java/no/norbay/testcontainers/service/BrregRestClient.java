package no.norbay.testcontainers.service;

import no.norbay.testcontainers.exception.NotFoundRestException;
import no.norbay.testcontainers.model.BrregResponse;
import no.norbay.testcontainers.model.Organization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class BrregRestClient {

    @Value("${brreg.no.enhetsregisteret.url}")
    private String baseUrl;

    @Value("${brreg.no.enhetsregisteret.accept}")
    private String acceptHeader;

    private final RestClient restClient;

    public BrregRestClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl(baseUrl)
                .defaultHeader("Accept", acceptHeader)
                .build();
    }

    public BrregResponse hentOrgFraBrreg(String organisasjonsnummer) {
        return restClient.get()
                .uri(baseUrl + organisasjonsnummer)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new NotFoundRestException("Organisasjonsnummer: "+organisasjonsnummer+" finnes ikke i enhetsregisteret. ");
                })
                .body(BrregResponse.class);
    }

    public Organization getOrganisasjon(String organisasjonsnummer) {
        BrregResponse response = hentOrgFraBrreg(organisasjonsnummer);
        return Organization.builder()
                .companyNumber(response.getOrganisasjonsnummer())
                .taxNumber("NO"+response.getOrganisasjonsnummer()+"MVA")
                .name(response.getNavn())
                .build();
    }
}
