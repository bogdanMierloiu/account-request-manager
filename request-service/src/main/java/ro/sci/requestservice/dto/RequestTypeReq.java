package ro.sci.requestservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestTypeReq {

    private Long id;

    @NotBlank
    private String requestName;


}
