// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;

public class User
    implements Serializable
{

    private Boolean allowed;
    private String city;
    private String country;
    private String proxy;
    private String state;
    private String zipcode;

    public User()
    {
    }

    public Boolean getAllowed()
    {
        return allowed;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountry()
    {
        return country;
    }

    public String getProxy()
    {
        return proxy;
    }

    public String getState()
    {
        return state;
    }

    public String getZipCode()
    {
        return zipcode;
    }
}
