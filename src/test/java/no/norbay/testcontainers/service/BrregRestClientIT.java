package no.norbay.testcontainers.service;

import no.norbay.testcontainers.model.BrregResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DisplayName("Integrasjonstest: BrregRestClient")
class BrregRestClientIT {

    @Autowired
    private BrregRestClient brregRestClient;

    @Test
    @DisplayName("Klarer å hente en organisasjon fra Brreg")
    void hentOrganisasjon() {
        BrregResponse norbay = brregRestClient.hentOrgFraBrreg("927396904");
        assertNotNull(norbay);
        assertEquals(norbay.getNavn(), "NORBAY AS");
    }
}