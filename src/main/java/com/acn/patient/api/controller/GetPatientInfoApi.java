/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.3).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.acn.patient.api.controller;

import com.acn.patient.api.model.ErrorResponse;
import com.acn.patient.api.model.PatientsResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-15T15:42:52.111188900+08:00[Asia/Singapore]")

@Validated
@Api(value = "getPatientInfo", description = "the getPatientInfo API")
public interface GetPatientInfoApi {

    default GetPatientInfoApiDelegate getDelegate() {
        return new GetPatientInfoApiDelegate() {};
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
     */
    @ApiOperation(value = "get  patient details", nickname = "getPatientInfoById", notes = "Use this API to know about the patient information", response = PatientsResponse.class, tags={ "patientid", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = PatientsResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
        @ApiResponse(code = 500, message = "Server Error", response = ErrorResponse.class) })
    @RequestMapping(value = "/getPatientInfo/{patientid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<PatientsResponse> getPatientInfoById(@ApiParam(value = "",required=true) @PathVariable("patientid") String patientid,@ApiParam(value = "Request Message ID header" ,required=true) @RequestHeader(value="MessageId", required=true) String messageId,@ApiParam(value = "Requester ID header" ,required=true) @RequestHeader(value="requestorId", required=true) String requestorId) {
        return getDelegate().getPatientInfoById(patientid, messageId, requestorId);
    }

}
