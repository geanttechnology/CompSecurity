// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.protocol;

import com.gimbal.internal.proximity.core.sighting.Sighting;
import java.util.List;

public class ResolveTransmittersResponse
{

    private String a;
    private String b;
    private String c;
    private String d;
    private List e;
    private List f;
    private int g;
    private Sighting h;

    public ResolveTransmittersResponse()
    {
    }

    public List getDataMasks()
    {
        return f;
    }

    public String getExternalUuid()
    {
        return b;
    }

    public List getLookupKeys()
    {
        return e;
    }

    public String getName()
    {
        return c;
    }

    public String getOwnerId()
    {
        return d;
    }

    public Sighting getSighting()
    {
        return h;
    }

    public String getUuid()
    {
        return a;
    }

    public int getVisibility()
    {
        return g;
    }

    public void setDataMasks(List list)
    {
        f = list;
    }

    public void setExternalUuid(String s)
    {
        b = s;
    }

    public void setLookupKeys(List list)
    {
        e = list;
    }

    public void setName(String s)
    {
        c = s;
    }

    public void setOwnerId(String s)
    {
        d = s;
    }

    public void setSighting(Sighting sighting)
    {
        h = sighting;
    }

    public void setUuid(String s)
    {
        a = s;
    }

    public void setVisibility(int i)
    {
        g = i;
    }
}
