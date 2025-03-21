package no.norbay.testcontainers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

//@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrregResponse {
    String organisasjonsnummer;
    String navn;
}
