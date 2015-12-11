// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.VisibleRegion;
import com.amazon.geo.mapsv2.model.internal.ILatLngBoundsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.model.internal.IVisibleRegionPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class VisibleRegionPrimitive extends PrimitiveBase
    implements IVisibleRegionPrimitive
{

    private final ILatLngPrimitive farLeft;
    private final ILatLngPrimitive farRight;
    private final ILatLngBoundsPrimitive latLngBounds;
    private final ILatLngPrimitive nearLeft;
    private final ILatLngPrimitive nearRight;

    public VisibleRegionPrimitive(VisibleRegion visibleregion)
    {
        super(visibleregion);
        nearLeft = Primitives.create(visibleregion.nearLeft);
        nearRight = Primitives.create(visibleregion.nearRight);
        farLeft = Primitives.create(visibleregion.farLeft);
        farRight = Primitives.create(visibleregion.farRight);
        latLngBounds = Primitives.create(visibleregion.latLngBounds);
    }

    public ILatLngPrimitive getFarLeft()
    {
        return farLeft;
    }

    public ILatLngPrimitive getFarRight()
    {
        return farRight;
    }

    public ILatLngBoundsPrimitive getLatLngBounds()
    {
        return latLngBounds;
    }

    public ILatLngPrimitive getNearLeft()
    {
        return nearLeft;
    }

    public ILatLngPrimitive getNearRight()
    {
        return nearRight;
    }
}
