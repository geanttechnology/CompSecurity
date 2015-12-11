// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.simulator;

import java.util.List;

// Referenced classes of package com.radiusnetworks.ibeacon.simulator:
//            BeaconSimulator

public class StaticBeaconSimulator
    implements BeaconSimulator
{

    public List beacons;

    public StaticBeaconSimulator()
    {
        beacons = null;
    }

    public List getBeacons()
    {
        return beacons;
    }

    public void setBeacons(List list)
    {
        beacons = list;
    }
}
