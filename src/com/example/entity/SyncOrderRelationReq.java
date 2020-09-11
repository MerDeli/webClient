package com.example.entity;

import lombok.Data;

@Data
public class SyncOrderRelationReq {
    private String MsgType;
    private String TransactionID;
    private String Version;
    private AddressInfoSchema Send_Address;
    private AddressInfoSchema Dest_Address;
    private AddressInfoSchema Original_Address;
    private UserIdSchema FeeUser_ID;
    private UserIdSchema DestUser_ID;
    private String LinkID;
    private Integer ActionID;
    private Integer ActionReasonID;
    private String SPID;
    private String SPServiceID;
    private Integer AccessMode;
    private String FeatureStr;
}
