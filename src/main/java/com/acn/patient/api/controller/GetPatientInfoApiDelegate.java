package com.acn.patient.api.controller;

import com.acn.patient.api.model.ErrorResponse;
import com.acn.patient.api.model.PatientsResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link GetPatientInfoApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-15T15:42:52.111188900+08:00[Asia/Singapore]")

public interface GetPatientInfoApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /getPatientInfo/{patientid} : get  patient detais
     * Use this API to know about the patient information
     *
     * @param patientid  (required)
     * @param messageId Request Message ID header (required)
     * @param requestorId Requester ID header (required)
     * @return successful operation (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     *         or Server Error (status code 500)
     * @see GetPatientInfoApi#getPatientInfoById
     */
    default ResponseEntity<PatientsResponse> getPatientInfoById(String patientid,
        String messageId,
        String requestorId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"patient\" : { \"address\" : \"address\", \"birth-date\" : \"birth-date\", \"name\" : \"name\", \"phoneNum\" : \"phoneNum\", \"nric\" : \"nric\" }, \"responseHeader\" : { \"requestorId\" : \"requestorId\", \"Timestamp\" : \"Timestamp\", \"MessageId\" : \"MessageId\" } }";
                    com.acn.patient.api.ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
