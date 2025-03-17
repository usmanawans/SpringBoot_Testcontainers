package no.norbay.testcontainers.model;

public class BrregResponse {
    String organisasjonsnummer;
    String navn;

    public BrregResponse(String organisasjonsnummer, String navn) {
        this.organisasjonsnummer = organisasjonsnummer;
        this.navn = navn;
    }

    public String getOrganisasjonsnummer() {
        return organisasjonsnummer;
    }

    public void setOrganisasjonsnummer(String organisasjonsnummer) {
        this.organisasjonsnummer = organisasjonsnummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
