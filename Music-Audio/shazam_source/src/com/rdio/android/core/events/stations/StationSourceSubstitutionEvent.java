// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.stations;


public class StationSourceSubstitutionEvent
{

    private final String originalKey;
    private final String stationKey;

    public StationSourceSubstitutionEvent(String s, String s1)
    {
        originalKey = s;
        stationKey = s1;
    }

    public String getOriginalKey()
    {
        return originalKey;
    }

    public String getStationKey()
    {
        return stationKey;
    }
}
