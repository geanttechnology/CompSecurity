// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.android;

import com.gimbal.proguard.Keep;

// Referenced classes of package com.gimbal.android:
//            Beacon

public class BeaconSighting
    implements Keep
{

    private int RSSI;
    private Beacon beacon;
    private long timeInMillis;

    public BeaconSighting()
    {
    }

    private void setBeacon(Beacon beacon1)
    {
        beacon = beacon1;
    }

    private void setRSSI(Integer integer)
    {
        RSSI = integer.intValue();
    }

    private void setTimeInMillis(long l)
    {
        timeInMillis = l;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (BeaconSighting)obj;
            if (RSSI != ((BeaconSighting) (obj)).RSSI)
            {
                return false;
            }
            if (beacon == null)
            {
                if (((BeaconSighting) (obj)).beacon != null)
                {
                    return false;
                }
            } else
            if (!beacon.equals(((BeaconSighting) (obj)).beacon))
            {
                return false;
            }
            if (timeInMillis != ((BeaconSighting) (obj)).timeInMillis)
            {
                return false;
            }
        }
        return true;
    }

    public Beacon getBeacon()
    {
        return beacon;
    }

    public Integer getRSSI()
    {
        return Integer.valueOf(RSSI);
    }

    public long getTimeInMillis()
    {
        return timeInMillis;
    }

    public String toString()
    {
        return (new StringBuilder("BeaconSighting [RSSI=")).append(RSSI).append(", date=").append(timeInMillis).append(", beacon=").append(beacon).append("]").toString();
    }
}
