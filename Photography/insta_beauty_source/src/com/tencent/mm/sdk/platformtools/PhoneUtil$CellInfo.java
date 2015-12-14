// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;


public class dbm
{

    public static final int MAX_CID = 65535;
    public static final int MAX_LAC = 65535;
    public String cellid;
    public String dbm;
    public String lac;
    public String mcc;
    public String mnc;
    public String networkId;
    public String stationId;
    public String systemId;
    public String type;

    public _cls9(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8)
    {
        mcc = s;
        mnc = s1;
        lac = s2;
        type = s5;
        cellid = s3;
        stationId = s6;
        networkId = s7;
        systemId = s8;
        dbm = s4;
    }
}
