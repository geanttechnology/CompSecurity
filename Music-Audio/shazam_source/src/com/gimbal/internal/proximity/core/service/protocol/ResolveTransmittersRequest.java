// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.protocol;

import com.gimbal.internal.proximity.core.sighting.Sighting;

public class ResolveTransmittersRequest
{

    private String a;
    private Sighting b;

    public ResolveTransmittersRequest()
    {
    }

    public String getPayload()
    {
        return a;
    }

    public Sighting getSighting()
    {
        return b;
    }

    public void setPayload(String s)
    {
        a = s;
    }

    public void setSighting(Sighting sighting)
    {
        b = sighting;
    }

    public String toString()
    {
        return String.format("PostSightingsRequest [payload=%s]", new Object[] {
            a
        });
    }
}
