// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Date

public class NewAccountRequest
{

    private String captchaId;
    private String captchaResponse;
    private Date dob;
    private String email;
    private Boolean forceMase;
    private String fullName;
    private String password;
    private String pronunciation;

    public NewAccountRequest()
    {
    }

    public String getCaptchaId()
    {
        return captchaId;
    }

    public String getCaptchaResponse()
    {
        return captchaResponse;
    }

    public Date getDob()
    {
        return dob;
    }

    public String getEmail()
    {
        return email;
    }

    public Boolean getForceMase()
    {
        return forceMase;
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getPassword()
    {
        return password;
    }

    public String getPronunciation()
    {
        return pronunciation;
    }

    public void setEmail(String s)
    {
        email = s;
    }

    public void setForceMase(Boolean boolean1)
    {
        forceMase = boolean1;
    }

    public void setFullName(String s)
    {
        fullName = s;
    }

    public void setPassword(String s)
    {
        password = s;
    }

    public void setPronunciation(String s)
    {
        pronunciation = s;
    }
}
