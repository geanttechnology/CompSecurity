// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity;

import com.gimbal.android.Beacon;
import com.gimbal.android.BeaconSighting;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import com.gimbal.internal.proximity.impl.TransmitterInternal;
import java.util.Date;

public final class b
{

    private static com.gimbal.internal.c.b a = new com.gimbal.internal.c.b(com/gimbal/android/BeaconSighting);
    private static com.gimbal.internal.c.b b = new com.gimbal.internal.c.b(com/gimbal/android/Beacon);

    public static BeaconSighting a(Sighting sighting, TransmitterInternal transmitterinternal)
    {
        BeaconSighting beaconsighting = new BeaconSighting();
        Beacon beacon = new Beacon();
        com.gimbal.internal.c.b b1 = b;
        Object obj = Integer.valueOf(transmitterinternal.getBattery());
        if (obj == null || ((Integer) (obj)).intValue() == 0 || ((Integer) (obj)).intValue() == 1)
        {
            obj = com.gimbal.android.Beacon.a.a;
        } else
        if (((Integer) (obj)).intValue() == 2 || ((Integer) (obj)).intValue() == 3)
        {
            obj = com.gimbal.android.Beacon.a.d;
        } else
        {
            obj = null;
        }
        b1.a(beacon, "batteryLevel", obj);
        b.a(beacon, "iconURL", transmitterinternal.getIconUrl());
        b.a(beacon, "identifier", transmitterinternal.getIdentifier());
        b.a(beacon, "uuid", transmitterinternal.getUuid());
        b.a(beacon, "name", transmitterinternal.getName());
        b.a(beacon, "temperature", Integer.valueOf(transmitterinternal.getTemperature()));
        a.a(beaconsighting, "beacon", beacon);
        a.a(beaconsighting, "beacon", beacon);
        a.a(beaconsighting, "timeInMillis", Long.valueOf(sighting.giveDate().getTime()));
        a.a(beaconsighting, "rSSI", Integer.valueOf(sighting.getRssi()));
        return beaconsighting;
    }

}
