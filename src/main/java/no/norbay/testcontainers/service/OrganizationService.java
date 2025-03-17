package no.norbay.testcontainers.service;

import no.norbay.testcontainers.exception.NotFoundRestException;
import no.norbay.testcontainers.model.BrregResponse;
import no.norbay.testcontainers.model.Organization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OrganizationService {

    private BrregRestClient brregRestClient;

    public OrganizationService(BrregRestClient brregRestClient) {
        this.brregRestClient = brregRestClient;
    }

    public Organization hentOrganisasjon(String organisasjonsnummer) {
        BrregResponse response = brregRestClient.hentOrgFraBrreg(organisasjonsnummer);
        return Organization.builder()
                .companyNumber(response.getOrganisasjonsnummer())
                .taxNumber("NO"+response.getOrganisasjonsnummer()+"MVA")
                .name(response.getNavn()).build();
    }
}
