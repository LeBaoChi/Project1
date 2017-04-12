/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author PhuDX
 */
public class ReaderModel {
    private String readerCoode;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String allowDate;
    private String allowDateFrom;
    private String allowDateTo;
    private String deadLine;
    private String deadLineFrom;
    private String deadLineTo;
    private boolean status;
    
    public ReaderModel(String readerCoode,String fullName,String address,String phone,String email,
                       String allowDateFrom,String allowDateTo,String deadLineFrom,String deadLineTo){
        this.readerCoode=readerCoode;
        this.fullName=fullName;
        this.address=address;
        this.phone=phone;
        this.email=email;
        this.allowDateFrom=allowDateFrom;
        this.allowDateTo=allowDateTo;
        this.deadLineFrom=deadLineFrom;
        this.deadLineTo=deadLineTo;
        this.status=true;
    }
    
    public ReaderModel(String readerCoode,String fullName,String address,String phone,String email,String allowDate,String deadLine){
        this.readerCoode=readerCoode;
        this.fullName=fullName;
        this.address=address;
        this.phone=phone;
        this.email=email;
        this.allowDate=allowDate;
        this.deadLine=deadLine;
    }

    public String getReaderCoode() {
        return readerCoode;
    }

    public void setReaderCoode(String readerCoode) {
        this.readerCoode = readerCoode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAllowDate() {
        return allowDate;
    }

    public void setAllowDate(String allowDate) {
        this.allowDate = allowDate;
    }

    public String getAllowDateFrom() {
        return allowDateFrom;
    }

    public void setAllowDateFrom(String allowDateFrom) {
        this.allowDateFrom = allowDateFrom;
    }

    public String getAllowDateTo() {
        return allowDateTo;
    }

    public void setAllowDateTo(String allowDateTo) {
        this.allowDateTo = allowDateTo;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getDeadLineFrom() {
        return deadLineFrom;
    }

    public void setDeadLineFrom(String deadLineFrom) {
        this.deadLineFrom = deadLineFrom;
    }

    public String getDeadLineTo() {
        return deadLineTo;
    }

    public void setDeadLineTo(String deadLineTo) {
        this.deadLineTo = deadLineTo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
