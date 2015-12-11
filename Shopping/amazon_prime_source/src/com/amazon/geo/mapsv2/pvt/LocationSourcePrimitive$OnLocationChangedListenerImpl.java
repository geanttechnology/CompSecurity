// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.location.Location;

// Referenced classes of package com.amazon.geo.mapsv2.pvt:
//            PrimitiveBase, LocationSourcePrimitive

public static class r extends PrimitiveBase
    implements com.amazon.geo.mapsv2.mpl
{

    public static com.amazon.geo.mapsv2.tener create(com.amazon.geo.mapsv2.internal. )
    {
        if ( == null)
        {
            return null;
        } else
        {
            return new <init>();
        }
    }

    public void onLocationChanged(Location location)
    {
        ((com.amazon.geo.mapsv2.internal.>)get()).ocationChanged(location);
    }

    public r(com.amazon.geo.mapsv2.internal. )
    {
        super();
    }
}
