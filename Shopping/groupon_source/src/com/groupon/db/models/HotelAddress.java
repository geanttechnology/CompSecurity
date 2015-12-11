// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.io.Serializable;

public class HotelAddress
    implements Serializable
{

    public String city;
    public String country;
    public Double lat;
    public Double lng;
    public String postalCode;
    public String state;
    public String streetAddress1;
    public String streetAddress2;

    public HotelAddress()
    {
        streetAddress1 = "";
        streetAddress2 = "";
        city = "";
        state = "";
        postalCode = "";
        country = "";
    }
}
