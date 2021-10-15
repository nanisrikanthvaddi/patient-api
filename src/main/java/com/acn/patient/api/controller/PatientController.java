package com.acn.patient.api.controller;


import com.acn.patient.api.model.ErrorResponse;
import com.acn.patient.api.model.PatientInnerJSON;
import com.acn.patient.api.model.PatientsResponse;
import com.acn.patient.api.model.ResponseHeaderInnerJSON;
import com.acn.patient.api.repository.PatientRepo;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.inject.Singleton;
import java.sql.Timestamp;
import java.util.Optional;

@Singleton
@Component
@RestController
public class PatientController implements  GetPatientInfoApi {


    @Autowired
    PatientRepo patientRepo;

    @RequestMapping(value = "/getPatientInfo/{patientid}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    @Override
    public  ResponseEntity<PatientsResponse> getPatientInfoById(@ApiParam(value = "",required=true) @PathVariable("patientid") String patientid, @ApiParam(value = "Request Message ID header" ,required=true) @RequestHeader(value="MessageId", required=true) String messageId, @ApiParam(value = "Requester ID header" ,required=true) @RequestHeader(value="requestorId", required=true) String requestorId) {

        try {


            Optional<PatientInnerJSON> patient = patientRepo.findById(patientid);
            if (patient.isPresent()) {
                PatientsResponse fp = new PatientsResponse();
                ResponseHeaderInnerJSON rps = new ResponseHeaderInnerJSON();
                rps.setMessageId(messageId);
                rps.setTimestamp((new Timestamp(System.currentTimeMillis())).toString());
                rps.setRequestorId(requestorId);
                fp.setResponseHeader(rps);
                fp.setPatient(patient.get());
                return new ResponseEntity(fp, HttpStatus.OK);
            } else {
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setCode(404);
                errorResponse.setMessage("Resource Not found");
                return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e ){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setCode(500);
            errorResponse.setMessage("Internal Server Error");
            return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
