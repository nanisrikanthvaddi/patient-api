package com.acn.patient.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PatientInnerJSON
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-15T15:42:52.111188900+08:00[Asia/Singapore]")


@Entity(name = "patient_info")
public class PatientInnerJSON   {
  @JsonProperty("name")
  private String name;

  @Id
  @JsonProperty("nric")
  private String nric;

  @JsonProperty("birth-date")
  private String birthDate;

  @JsonProperty("address")
  private String address;

  @JsonProperty("phoneNum")
  private String phoneNum;

  public PatientInnerJSON name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PatientInnerJSON nric(String nric) {
    this.nric = nric;
    return this;
  }

  /**
   * Get nric
   * @return nric
  */
  @ApiModelProperty(value = "")


  public String getNric() {
    return nric;
  }

  public void setNric(String nric) {
    this.nric = nric;
  }

  public PatientInnerJSON birthDate(String birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * @return birthDate
  */
  @ApiModelProperty(value = "")


  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public PatientInnerJSON address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @ApiModelProperty(value = "")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public PatientInnerJSON phoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
    return this;
  }

  /**
   * Get phoneNum
   * @return phoneNum
  */
  @ApiModelProperty(value = "")


  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientInnerJSON patientInnerJSON = (PatientInnerJSON) o;
    return Objects.equals(this.name, patientInnerJSON.name) &&
        Objects.equals(this.nric, patientInnerJSON.nric) &&
        Objects.equals(this.birthDate, patientInnerJSON.birthDate) &&
        Objects.equals(this.address, patientInnerJSON.address) &&
        Objects.equals(this.phoneNum, patientInnerJSON.phoneNum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, nric, birthDate, address, phoneNum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientInnerJSON {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nric: ").append(toIndentedString(nric)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    phoneNum: ").append(toIndentedString(phoneNum)).append("\n");
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

