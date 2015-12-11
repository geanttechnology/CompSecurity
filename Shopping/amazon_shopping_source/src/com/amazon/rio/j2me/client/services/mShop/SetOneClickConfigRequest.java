// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class SetOneClickConfigRequest
{

    private String addressId;
    private String deviceName;
    private Boolean oneClickStatus;
    private String paymentId;

    public SetOneClickConfigRequest()
    {
    }

    public String getAddressId()
    {
        return addressId;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public Boolean getOneClickStatus()
    {
        return oneClickStatus;
    }

    public String getPaymentId()
    {
        return paymentId;
    }

    public void setAddressId(String s)
    {
        addressId = s;
    }

    public void setDeviceName(String s)
    {
        deviceName = s;
    }

    public void setOneClickStatus(Boolean boolean1)
    {
        oneClickStatus = boolean1;
    }

    public void setPaymentId(String s)
    {
        paymentId = s;
    }
}
