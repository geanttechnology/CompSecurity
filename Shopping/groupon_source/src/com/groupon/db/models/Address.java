// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


public class Address
{

    public String city;
    public String country;
    public double lat;
    public double lng;
    public String state;

    public Address()
    {
        city = "";
        state = "";
        country = "";
        lat = 0.0D;
        lng = 0.0D;
    }
}
