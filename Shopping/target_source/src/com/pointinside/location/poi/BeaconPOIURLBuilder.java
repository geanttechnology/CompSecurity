// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;

import java.util.HashMap;

// Referenced classes of package com.pointinside.location.poi:
//            PointOfInterestURLBuilder

public class BeaconPOIURLBuilder extends PointOfInterestURLBuilder
{

    public BeaconPOIURLBuilder(String s, String s1)
    {
        super(s, s1, PIPointOfInterest.POIType.Beacon);
    }

    public void onPrepareURL()
    {
        super.onPrepareURL();
        parameters.put("type", "Beacon");
    }
}
