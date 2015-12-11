// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            Address

public class CreditCard
{

    private Address billingAddress;
    private String expirationMonth;
    private String expirationYear;
    private String number;
    private String securityCode;
    private boolean useShippingAddress;

    public CreditCard()
    {
    }

    public void copy(CreditCard creditcard)
    {
        number = creditcard.number;
        expirationMonth = creditcard.expirationMonth;
        expirationYear = creditcard.expirationYear;
        securityCode = creditcard.securityCode;
        if (billingAddress == null)
        {
            billingAddress = new Address();
        }
        billingAddress.copy(creditcard.billingAddress);
        useShippingAddress = creditcard.useShippingAddress;
    }

    public Address getBillingAddress()
    {
        return billingAddress;
    }

    public String getExpirationMonth()
    {
        return expirationMonth;
    }

    public String getExpirationYear()
    {
        return expirationYear;
    }

    public String getNumber()
    {
        return number;
    }

    public String getSecurityCode()
    {
        return securityCode;
    }

    public void setBillingAddress(Address address)
    {
        billingAddress = address;
    }

    public void setExpirationMonth(String s)
    {
        expirationMonth = s;
    }

    public void setExpirationYear(String s)
    {
        expirationYear = s;
    }

    public void setNumber(String s)
    {
        number = s;
    }

    public void setSecurityCode(String s)
    {
        securityCode = s;
    }

    public void setUseShippingAddress(boolean flag)
    {
        useShippingAddress = flag;
    }

    public boolean shouldUseShippingAddress()
    {
        return useShippingAddress;
    }
}
