// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting.b;

import com.gimbal.a.a;
import com.gimbal.internal.proximity.core.c.d;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import com.gimbal.internal.proximity.core.sighting.g;
import com.gimbal.internal.proximity.impl.TransmitterInternal;

// Referenced classes of package com.gimbal.internal.proximity.core.sighting.b:
//            d

public class c
    implements com.gimbal.internal.proximity.core.sighting.b.d
{

    private static final a a = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/sighting/b/c.getSimpleName());
    private g b;

    public c(g g1)
    {
        b = g1;
    }

    public final boolean a(Sighting sighting)
    {
        if (com.gimbal.internal.c.c.c(d.c).equalsIgnoreCase(sighting.getServiceId()))
        {
            sighting.getServiceId();
            TransmitterInternal transmitterinternal = new TransmitterInternal();
            transmitterinternal.setBattery(Integer.valueOf(sighting.getBatteryLevel()));
            transmitterinternal.setIdentifier(sighting.getPayload());
            transmitterinternal.setTemperature(Integer.valueOf(sighting.getTemperature()));
            b.a(sighting, transmitterinternal);
            return true;
        } else
        {
            return false;
        }
    }

}
