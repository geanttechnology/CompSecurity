// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.CameraPosition;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.LatLngBounds;
import com.amazon.geo.mapsv2.model.VisibleRegion;
import com.amazon.geo.mapsv2.model.internal.ICameraPositionPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngBoundsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.model.internal.IPrimitivesFactory;
import com.amazon.geo.mapsv2.model.internal.IVisibleRegionPrimitive;
import com.amazon.geo.mapsv2.pvt.Wrappers;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class PrimitivesFactory
    implements IPrimitivesFactory
{

    public PrimitivesFactory()
    {
    }

    public ICameraPositionPrimitive createCameraPosition(ILatLngPrimitive ilatlngprimitive, float f, float f1, float f2)
    {
        return Primitives.create(new CameraPosition((LatLng)Wrappers.unwrapAs(ilatlngprimitive, com/amazon/geo/mapsv2/model/LatLng), f, f1, f2));
    }

    public ILatLngPrimitive createLatLng(double d, double d1)
    {
        return Primitives.create(new LatLng(d, d1));
    }

    public ILatLngBoundsPrimitive createLatLngBounds(ILatLngPrimitive ilatlngprimitive, ILatLngPrimitive ilatlngprimitive1)
    {
        return Primitives.create(new LatLngBounds((LatLng)Wrappers.unwrapAs(ilatlngprimitive, com/amazon/geo/mapsv2/model/LatLng), (LatLng)Wrappers.unwrapAs(ilatlngprimitive1, com/amazon/geo/mapsv2/model/LatLng)));
    }

    public IVisibleRegionPrimitive createVisibleRegion(ILatLngPrimitive ilatlngprimitive, ILatLngPrimitive ilatlngprimitive1, ILatLngPrimitive ilatlngprimitive2, ILatLngPrimitive ilatlngprimitive3, ILatLngBoundsPrimitive ilatlngboundsprimitive)
    {
        return Primitives.create(new VisibleRegion((LatLng)Wrappers.unwrapAs(ilatlngprimitive, com/amazon/geo/mapsv2/model/LatLng), (LatLng)Wrappers.unwrapAs(ilatlngprimitive1, com/amazon/geo/mapsv2/model/LatLng), (LatLng)Wrappers.unwrapAs(ilatlngprimitive2, com/amazon/geo/mapsv2/model/LatLng), (LatLng)Wrappers.unwrapAs(ilatlngprimitive3, com/amazon/geo/mapsv2/model/LatLng), (LatLngBounds)Wrappers.unwrapAs(ilatlngboundsprimitive, com/amazon/geo/mapsv2/model/LatLngBounds)));
    }
}
