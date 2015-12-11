// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;


public class Location
{

    private final String countryCode;
    private final String region;

    public Location(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            throw new IllegalArgumentException("Country code and region must not be null.");
        } else
        {
            countryCode = s;
            region = s1;
            return;
        }
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getRegion()
    {
        return region;
    }
}
