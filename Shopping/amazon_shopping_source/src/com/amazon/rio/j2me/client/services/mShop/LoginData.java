// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Date, PrimeOneClickStatus

public class LoginData
{

    private Date dob;
    private String fullName;
    private String givenName;
    private Boolean isPrimeFunnelEligible;
    private String primeFunnelUrl;
    private PrimeOneClickStatus primeOneClickStatus;

    public LoginData()
    {
    }

    public Date getDob()
    {
        return dob;
    }

    public String getFullName()
    {
        return fullName;
    }

    public Boolean getIsPrimeFunnelEligible()
    {
        return isPrimeFunnelEligible;
    }

    public String getPrimeFunnelUrl()
    {
        return primeFunnelUrl;
    }

    public PrimeOneClickStatus getPrimeOneClickStatus()
    {
        return primeOneClickStatus;
    }

    public void setDob(Date date)
    {
        dob = date;
    }

    public void setFullName(String s)
    {
        fullName = s;
    }

    public void setGivenName(String s)
    {
        givenName = s;
    }

    public void setIsPrimeFunnelEligible(Boolean boolean1)
    {
        isPrimeFunnelEligible = boolean1;
    }

    public void setPrimeFunnelUrl(String s)
    {
        primeFunnelUrl = s;
    }

    public void setPrimeOneClickStatus(PrimeOneClickStatus primeoneclickstatus)
    {
        primeOneClickStatus = primeoneclickstatus;
    }
}
