// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Address, PaymentMethod

public class OneClickConfigResponse
{

    private Address address;
    private String deviceName;
    private boolean oneClickStatus;
    private PaymentMethod paymentMethod;
    private String shippingSpeed;

    public OneClickConfigResponse()
    {
    }

    public Address getAddress()
    {
        return address;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public boolean getOneClickStatus()
    {
        return oneClickStatus;
    }

    public PaymentMethod getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setAddress(Address address1)
    {
        address = address1;
    }

    public void setDeviceName(String s)
    {
        deviceName = s;
    }

    public void setOneClickStatus(boolean flag)
    {
        oneClickStatus = flag;
    }

    public void setPaymentMethod(PaymentMethod paymentmethod)
    {
        paymentMethod = paymentmethod;
    }

    public void setShippingSpeed(String s)
    {
        shippingSpeed = s;
    }
}
