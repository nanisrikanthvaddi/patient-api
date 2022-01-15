package com.acn.patient.api.controller;


import com.acn.patient.api.model.ErrorResponse;
import com.acn.patient.api.model.PatientInnerJSON;
import com.acn.patient.api.model.PatientsResponse;
import com.acn.patient.api.model.ResponseHeaderInnerJSON;
import com.acn.patient.api.repository.PatientRepo;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Optional;

@Singleton
@Component
@RestController
public class PatientController implements  GetPatientInfoApi {


    @Autowired
    PatientRepo patientRepo;


    private String logo;

    @PostConstruct
    public void init() throws IOException {

        try {

            File resource = new ClassPathResource("IHIS.png").getFile();
            String text = new String(Files.readAllBytes(resource.toPath()));


            byte[] encoded = Base64.getEncoder().encode(text.getBytes(StandardCharsets.UTF_8));
            logo = new String(encoded,StandardCharsets.US_ASCII);
            System.out.println(logo);

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/getPatientInfo/{patientid}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    @Override
    public  ResponseEntity<PatientsResponse> getPatientInfoById(@ApiParam(value = "",required=true) @PathVariable("patientid") String patientid, @ApiParam(value = "Request Message ID header" ,required=true) @RequestHeader(value="MessageId", required=true) String messageId, @ApiParam(value = "Requester ID header" ,required=true) @RequestHeader(value="requestorId", required=true) String requestorId) {

        try {


            Optional<PatientInnerJSON> patient = patientRepo.findById(patientid);
            if (patient.isPresent()) {
                PatientsResponse fp = new PatientsResponse();
                fp.setLogo(logo);
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
