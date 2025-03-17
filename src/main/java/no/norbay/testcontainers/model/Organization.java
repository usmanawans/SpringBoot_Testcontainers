package no.norbay.testcontainers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    String companyNumber;
    String taxNumber;
    String name;
}
