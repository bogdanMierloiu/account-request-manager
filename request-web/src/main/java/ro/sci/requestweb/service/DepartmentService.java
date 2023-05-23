package ro.sci.requestweb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ro.sci.requestweb.dto.DepartmentRequest;
import ro.sci.requestweb.dto.DepartmentResponse;
import ro.sci.requestweb.dto.PoliceStructureRequest;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final WebClient.Builder webClientBuilder;

    public DepartmentResponse[] getBySubunit(Long subunitId) {
        return webClientBuilder.build().get()
                .uri("lb://request-query-service/api/v2/department/{subunitId}", subunitId)
                .retrieve()
                .bodyToMono(DepartmentResponse[].class)
                .block();
    }

    public void addDepartment(DepartmentRequest departmentRequest) {
        webClientBuilder.build().post()
                .uri("lb://request-service/api/v1/department")
                .bodyValue(departmentRequest)
                .retrieve()
                .toBodilessEntity()
                .block();
    }


//    public RequestResponse findById(Long requestId) {
//        return webClientBuilder.build().get()
//                .uri("lb://request-query-service/api/v2/request/find/{requestId}", requestId)
//                .retrieve()
//                .bodyToMono(RequestResponse.class)
//                .block();
//    }

    //    public TicketResponse[] getTicketsByItSpecialistId(Long itSpecialistId) {
//        return webClientBuilder.build().get()
//                .uri("lb://ticket-service/api/it-specialist/{workerId}", itSpecialistId)
//                .retrieve()
//                .bodyToMono(TicketResponse[].class)
//                .block();
//    }
//
//    public TicketResponse getTicketById(Long ticketId) {
//        return webClientBuilder.build().get()
//                .uri("lb://ticket-service/api/{ticketId}", ticketId)
//                .retrieve()
//                .bodyToMono(TicketResponse.class)
//                .block();
//    }
//
    public void addPoliceStructure(PoliceStructureRequest policeStructureRequest) {
        webClientBuilder.build().post()
                .uri("lb://request-service/api/v1/police-structure")
                .retrieve()
                .toBodilessEntity()
                .block();
    }

//    public void assignTicket(AssignTicketRequest request) {
//        webClientBuilder.build().post()
//                .uri("lb://ticket-service/api/assign")
//                .bodyValue(request)
//                .retrieve()
//                .toBodilessEntity()
//                .block();
//    }

}
