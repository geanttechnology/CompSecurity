// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.realm;

import io.realm.RealmObject;

public class RLMCountryCurrencyInfo extends RealmObject
{

    private String countryCodeAlpha2;
    private String countryCodeAlpha3;
    private String currencyCode;
    private String defaultLocale;
    private int id;

    public RLMCountryCurrencyInfo()
    {
    }

    public String getCountryCodeAlpha2()
    {
        return countryCodeAlpha2;
    }

    public String getCountryCodeAlpha3()
    {
        return countryCodeAlpha3;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public String getDefaultLocale()
    {
        return defaultLocale;
    }

    public int getId()
    {
        return id;
    }

    public void setCountryCodeAlpha2(String s)
    {
        countryCodeAlpha2 = s;
    }

    public void setCountryCodeAlpha3(String s)
    {
        countryCodeAlpha3 = s;
    }

    public void setCurrencyCode(String s)
    {
        currencyCode = s;
    }

    public void setDefaultLocale(String s)
    {
        defaultLocale = s;
    }

    public void setId(int i)
    {
        id = i;
    }
}
