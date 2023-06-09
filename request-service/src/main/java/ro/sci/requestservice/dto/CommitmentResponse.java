package ro.sci.requestservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommitmentResponse {

    private Long id;

    private String documentName;

    private Boolean isFromAdmin;

    private byte[] documentData;
}
