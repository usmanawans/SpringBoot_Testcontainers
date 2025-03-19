package no.norbay.testcontainers.service;

import no.norbay.testcontainers.exception.NotFoundRestException;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Unit test: OrganizationService")
class OrganizationServiceTest {

    @Mock
    private BrregRestClient brregRestClient;

    @InjectMocks
    private OrganizationService organizationService;

    public OrganizationServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Parsing av riktig organisasjon er vellykket")
    void parseOrganisasjonRiktig() {
        when(brregRestClient.hentOrgFraBrreg(anyString())).thenReturn(new BrregResponse("111", "Norbay"));

        Organization org = organizationService.hentOrganisasjon("111");

        assertEquals("NO111MVA", org.getTaxNumber());
    }

    @Test
    @DisplayName("Parsing av feil organisasjon feiler")
    void parseFeilOrganisasjonGirFeil() {
        when(brregRestClient.hentOrgFraBrreg(anyString())).thenThrow(new NotFoundRestException());

        Exception exception = assertThrows(NotFoundRestException.class, () -> {
            organizationService.hentOrganisasjon("111");
        });
    }
}