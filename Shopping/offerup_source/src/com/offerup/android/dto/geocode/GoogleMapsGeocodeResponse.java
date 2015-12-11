// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.geocode;

import java.util.List;

public class GoogleMapsGeocodeResponse
{

    List geocodeResults;
    String status;

    public GoogleMapsGeocodeResponse()
    {
    }

    public List getGeocodeResults()
    {
        return geocodeResults;
    }

    public String getStatus()
    {
        return status;
    }

    public void setGeocodeResults(List list)
    {
        geocodeResults = list;
    }

    public void setStatus(String s)
    {
        status = s;
    }
}
