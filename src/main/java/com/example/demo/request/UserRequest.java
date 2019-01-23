package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.hateoas.ResourceSupport;

import java.math.BigInteger;

@JacksonXmlRootElement
public class UserRequest extends ResourceSupport {

    @JacksonXmlProperty
    private String fname;

    @JacksonXmlProperty
    private String lname;

    @JacksonXmlProperty
    private Integer age;

    @JacksonXmlProperty
    private BigInteger cell;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigInteger getCell() {
        return cell;
    }

    public void setCell(BigInteger cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserResponse{");
        sb.append("fname='").append(fname).append('\'');
        sb.append(", lname='").append(lname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", cell=").append(cell);
        sb.append('}');
        return sb.toString();
    }
}
