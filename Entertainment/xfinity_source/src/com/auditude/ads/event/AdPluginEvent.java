// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.auditude.ads.event;

import java.util.HashMap;

public class AdPluginEvent
{

    private HashMap data;
    private String type;

    public AdPluginEvent(String s, HashMap hashmap)
    {
        type = s;
        data = hashmap;
    }

    public final HashMap getData()
    {
        return data;
    }

    public final String getType()
    {
        return type;
    }
}
