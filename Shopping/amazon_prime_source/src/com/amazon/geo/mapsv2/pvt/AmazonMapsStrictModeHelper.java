// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.util.Log;
import com.amazon.geo.mapsv2.AmazonMapsStrictMode;

public final class AmazonMapsStrictModeHelper
{

    public static final String STREET_VIEW_MESSAGE = "The street view API is not supported.";

    private AmazonMapsStrictModeHelper()
    {
    }

    public static void applyStreetViewStrictMode()
    {
        applyUnimplementedStrictModePolicy("The street view API is not supported.");
    }

    public static void applyUnimplementedStrictModePolicy(String s)
    {
        com.amazon.geo.mapsv2.AmazonMapsStrictMode.ApiPolicy apipolicy = AmazonMapsStrictMode.getApiPolicy();
        if (apipolicy != null && apipolicy.detectUnimplemented)
        {
            String s1 = (new StringBuilder()).append("MAPS API STRICT MODE VIOLATION: ").append(s).toString();
            if (apipolicy.penaltyLog)
            {
                Log.d("MapsApi-Strict", s1);
            }
            if (apipolicy.penaltyThrow)
            {
                if (s == null)
                {
                    throw new com.amazon.geo.mapsv2.AmazonMapsStrictMode.StrictModeException();
                } else
                {
                    throw new com.amazon.geo.mapsv2.AmazonMapsStrictMode.StrictModeException(s);
                }
            }
        }
    }
}
