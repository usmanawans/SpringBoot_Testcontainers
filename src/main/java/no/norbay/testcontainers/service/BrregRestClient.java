package no.norbay.testcontainers.service;

import no.norbay.testcontainers.exception.NotFoundRestException;
import no.norbay.testcontainers.model.BrregResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
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

    public BrregResponse hentOrganisasjon(String organisasjonsnummer) {
        return restClient.get()
                .uri(organisasjonsnummer)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new NotFoundRestException("Organisasjonsnummer: "+organisasjonsnummer+" finnes ikke i enhetsregisteret. ");
                })
                .body(BrregResponse.class);
    }
}
