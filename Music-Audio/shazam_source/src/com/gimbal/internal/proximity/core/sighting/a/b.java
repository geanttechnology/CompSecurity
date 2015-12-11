// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting.a;

import com.gimbal.internal.proximity.core.c.g;
import com.gimbal.internal.proximity.core.c.j;
import com.gimbal.internal.proximity.core.c.m;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import com.gimbal.internal.proximity.core.sighting.c;
import java.util.Arrays;
import java.util.Date;

public final class b
    implements c
{

    public b()
    {
    }

    public final Sighting a(j j1, int i)
    {
        String s = g.a(com.gimbal.internal.c.c.a(j1.a));
        Sighting sighting = new Sighting();
        sighting.setSequenceNumber(Long.valueOf(0L));
        sighting.setVersion(Byte.valueOf((byte)0));
        sighting.setServiceId(s);
        sighting.setRssi(i);
        j1 = j1.b.b;
        byte abyte0[] = Arrays.copyOfRange(j1, 2, 5);
        i = (byte)((byte)(j1[5] & 0xff) - 70);
        byte byte0 = (byte)((j1[6] & 0xff) >> 6);
        sighting.setTemperature(i);
        sighting.setBatteryLevel(byte0);
        sighting.setPayload(com.gimbal.internal.c.c.a(abyte0));
        sighting.setDate(new Date());
        sighting.setPacketFormat(Byte.valueOf((byte)2));
        return sighting;
    }
}
