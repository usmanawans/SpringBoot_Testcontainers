package no.norbay.testcontainers.service;

import no.norbay.testcontainers.model.BrregResponse;
import no.norbay.testcontainers.model.Organization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit test: OrganizationService")
class OrganizationServiceTest {

    @Mock
    private BrregRestClient brregRestClient;

    @InjectMocks
    private OrganizationService organizationService;

    private BrregResponse norbay;

    public OrganizationServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Test for å parse organisasjon riktig")
    void hentOrganisasjon() {
        norbay = new BrregResponse("111", "Norbay");
        when(brregRestClient.hentOrgFraBrreg("111")).thenReturn(norbay);

        Organization org = organizationService.hentOrganisasjon("111");
        assertEquals("NO111MVA", org.getTaxNumber());
    }
}