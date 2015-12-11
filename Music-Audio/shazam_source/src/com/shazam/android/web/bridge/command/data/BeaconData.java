// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;

import java.util.Map;

public class BeaconData
{

    private String event;
    private Map parameters;

    private BeaconData()
    {
    }

    public BeaconData(String s, Map map)
    {
        event = s;
        parameters = map;
    }

    public String getEvent()
    {
        return event;
    }

    public Map getParameters()
    {
        return parameters;
    }
}
