// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting.a;

import com.gimbal.internal.proximity.core.b.a;
import com.gimbal.internal.proximity.core.b.b;
import com.gimbal.internal.proximity.core.c.g;
import com.gimbal.internal.proximity.core.c.j;
import com.gimbal.internal.proximity.core.c.m;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import java.util.Date;
import java.util.TimeZone;

public final class c
    implements com.gimbal.internal.proximity.core.sighting.c
{

    public c()
    {
    }

    public final Sighting a(j j1, int i)
    {
        byte abyte0[] = j1.a;
        byte abyte1[] = j1.b.c;
        if (abyte0 == null || abyte0.length != 16 || abyte1 == null || abyte1.length != 11)
        {
            throw new b(a.c);
        } else
        {
            j1 = g.a(com.gimbal.internal.c.c.a(abyte0));
            String s = com.gimbal.internal.c.c.a(abyte1);
            Sighting sighting = new Sighting();
            sighting.setPayload(s);
            sighting.setServiceId(j1);
            sighting.setDate(new Date());
            sighting.setRssi(i);
            sighting.setTimezone(TimeZone.getDefault().getID());
            sighting.setBatteryLevel(com.gimbal.internal.proximity.a.b.b(j1).intValue());
            sighting.setTemperature(com.gimbal.internal.proximity.a.b.a(j1).intValue());
            sighting.setPacketFormat(Byte.valueOf((byte)3));
            return sighting;
        }
    }
}
