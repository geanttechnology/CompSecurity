// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.LatLngBounds;
import com.amazon.geo.mapsv2.model.internal.ILatLngBoundsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class LatLngBoundsPrimitive extends PrimitiveBase
    implements ILatLngBoundsPrimitive
{

    private final ILatLngPrimitive mNortheast;
    private final ILatLngPrimitive mSouthwest;

    public LatLngBoundsPrimitive(LatLngBounds latlngbounds)
    {
        super(latlngbounds);
        mSouthwest = Primitives.create(latlngbounds.southwest);
        mNortheast = Primitives.create(latlngbounds.northeast);
    }

    public ILatLngPrimitive getNortheast()
    {
        return mNortheast;
    }

    public ILatLngPrimitive getSouthwest()
    {
        return mSouthwest;
    }
}
