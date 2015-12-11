// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;

import java.util.ArrayList;

// Referenced classes of package com.pointinside.maps.model:
//            NearbyDef

public class LocationDefs
{

    public ArrayList nearbyDefs;

    public LocationDefs()
    {
        nearbyDefs = new ArrayList();
    }

    public void add(NearbyDef nearbydef)
    {
        nearbyDefs.add(nearbydef);
    }
}
