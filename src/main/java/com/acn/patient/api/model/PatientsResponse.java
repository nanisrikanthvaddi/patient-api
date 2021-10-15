package com.acn.patient.api.model;

import java.util.Objects;
import com.acn.patient.api.model.PatientInnerJSON;
import com.acn.patient.api.model.ResponseHeaderInnerJSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PatientsResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-15T15:42:52.111188900+08:00[Asia/Singapore]")

public class PatientsResponse   {
  @JsonProperty("responseHeader")
  private ResponseHeaderInnerJSON responseHeader;

  @JsonProperty("patient")
  private PatientInnerJSON patient;

  public PatientsResponse responseHeader(ResponseHeaderInnerJSON responseHeader) {
    this.responseHeader = responseHeader;
    return this;
  }

  /**
   * Get responseHeader
   * @return responseHeader
  */
  @ApiModelProperty(value = "")

  @Valid

  public ResponseHeaderInnerJSON getResponseHeader() {
    return responseHeader;
  }

  public void setResponseHeader(ResponseHeaderInnerJSON responseHeader) {
    this.responseHeader = responseHeader;
  }

  public PatientsResponse patient(PatientInnerJSON patient) {
    this.patient = patient;
    return this;
  }

  /**
   * Get patient
   * @return patient
  */
  @ApiModelProperty(value = "")

  @Valid

  public PatientInnerJSON getPatient() {
    return patient;
  }

  public void setPatient(PatientInnerJSON patient) {
    this.patient = patient;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientsResponse patientsResponse = (PatientsResponse) o;
    return Objects.equals(this.responseHeader, patientsResponse.responseHeader) &&
        Objects.equals(this.patient, patientsResponse.patient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseHeader, patient);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientsResponse {\n");
    
    sb.append("    responseHeader: ").append(toIndentedString(responseHeader)).append("\n");
    sb.append("    patient: ").append(toIndentedString(patient)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

