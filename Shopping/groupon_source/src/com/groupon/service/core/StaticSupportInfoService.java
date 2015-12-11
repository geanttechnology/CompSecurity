// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import com.groupon.models.country.Country;
import com.groupon.models.support.StaticSupportInfo;
import roboguice.util.Ln;

public class StaticSupportInfoService
{

    public StaticSupportInfoService()
    {
    }

    private StaticSupportInfo getSupportInfo(String s)
    {
        try
        {
            s = StaticSupportInfo.valueOf(s.toUpperCase());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public StaticSupportInfo getSupportInfo(Country country)
    {
        if (country == null || country.shortName == null)
        {
            return null;
        }
        StaticSupportInfo staticsupportinfo;
        try
        {
            staticsupportinfo = StaticSupportInfo.valueOf(country.shortName.toUpperCase());
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Ln.d((new StringBuilder()).append("Country not supported ").append(country).toString(), new Object[0]);
            return null;
        }
        return staticsupportinfo;
    }

    public boolean isCountrySupported(Country country)
    {
        return getSupportInfo(country) != null;
    }

    public boolean isCountrySupported(String s)
    {
        return getSupportInfo(s) != null;
    }
}
