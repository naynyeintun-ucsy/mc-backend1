package com.nnt.backend.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/***
 * created by Nay Nyein Tun
 * March 19 2019
 ***/

@Component
public class IDGen {

    public static final String showRoomLocation = "SRL";
    public static final String  employee = "EMP";
    public static final String employeeServingHistory ="ESH";
    public static final String employeeWorkingHistory ="EWH";
    public static final String customerServingAllocation ="CSA";
    public static final String employeeServingDeatil  = "ESD";
    public static final String customerServingHistory = "CSH";
    public static final String customerServingDetail = "CSD";
    public  final String DASH_="-";

    public String generateID(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(DASH_);
        sb.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        sb.append(DASH_);
        sb.append(UUID.randomUUID().toString());
        return sb.toString();
    }

}
