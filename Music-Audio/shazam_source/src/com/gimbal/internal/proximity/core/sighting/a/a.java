// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting.a;

import com.gimbal.internal.proximity.core.c.g;
import com.gimbal.internal.proximity.core.c.j;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import com.gimbal.internal.proximity.core.sighting.c;
import java.util.Date;

public final class a
    implements c
{

    public a()
    {
    }

    public final Sighting a(j j1, int i)
    {
        j1 = g.a(com.gimbal.internal.c.c.a(j1.a));
        Sighting sighting = new Sighting();
        sighting.setSequenceNumber(Long.valueOf(0L));
        sighting.setVersion(Byte.valueOf((byte)0));
        sighting.setServiceId(j1);
        sighting.setTemperature(0);
        sighting.setBatteryLevel(0);
        sighting.setPayload("identifier");
        sighting.setDate(new Date());
        sighting.setRssi(i);
        sighting.setPacketFormat(Byte.valueOf((byte)1));
        return null;
    }
}
