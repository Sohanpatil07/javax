package com.Stock_Screener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
public class ErrorDetails {

    private Date date;;
    private String message;
    private String url;

    public ErrorDetails(Date date, String message, String url) {
        this.date = date;
        this.message = message;
        this.url = url;

    }
}