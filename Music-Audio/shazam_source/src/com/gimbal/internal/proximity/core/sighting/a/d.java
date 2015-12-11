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
import com.gimbal.internal.proximity.core.sighting.c;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class d
    implements c
{

    private final com.gimbal.a.a a = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/sighting/a/d.getSimpleName());

    public d()
    {
    }

    public final Sighting a(j j1, int i)
    {
        byte abyte0[] = j1.a;
        byte abyte1[] = j1.b.c;
        if (abyte0 == null || abyte0.length != 2 || abyte1 == null || abyte1.length != 25)
        {
            throw new b(a.c);
        } else
        {
            com.gimbal.internal.c.c.a(abyte1);
            j1 = g.a(com.gimbal.internal.c.c.a(abyte0));
            String s = com.gimbal.internal.c.c.a(Arrays.copyOfRange(abyte1, 3, 19));
            String s1 = com.gimbal.internal.c.c.a(Arrays.copyOfRange(abyte1, 2, 3));
            String s2 = com.gimbal.internal.c.c.a(Arrays.copyOfRange(abyte1, 19, 26));
            Sighting sighting = new Sighting();
            sighting.setPayload(s);
            sighting.setServiceId(j1);
            sighting.setDate(new Date());
            sighting.setRssi(i);
            sighting.setTimezone(TimeZone.getDefault().getID());
            sighting.setBatteryLevel(com.gimbal.internal.proximity.a.b.b(j1).intValue());
            sighting.setTemperature(com.gimbal.internal.proximity.a.b.a(j1).intValue());
            sighting.setPacketFormat(Byte.valueOf((byte)4));
            sighting.setGen4PacketVersion(s1);
            sighting.setGen4MaskedData(s2);
            return sighting;
        }
    }
}
