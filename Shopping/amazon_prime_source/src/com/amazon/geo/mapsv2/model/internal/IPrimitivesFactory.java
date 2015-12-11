// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;


// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            ILatLngPrimitive, ICameraPositionPrimitive, ILatLngBoundsPrimitive, IVisibleRegionPrimitive

public interface IPrimitivesFactory
{

    public abstract ICameraPositionPrimitive createCameraPosition(ILatLngPrimitive ilatlngprimitive, float f, float f1, float f2);

    public abstract ILatLngPrimitive createLatLng(double d, double d1);

    public abstract ILatLngBoundsPrimitive createLatLngBounds(ILatLngPrimitive ilatlngprimitive, ILatLngPrimitive ilatlngprimitive1);

    public abstract IVisibleRegionPrimitive createVisibleRegion(ILatLngPrimitive ilatlngprimitive, ILatLngPrimitive ilatlngprimitive1, ILatLngPrimitive ilatlngprimitive2, ILatLngPrimitive ilatlngprimitive3, ILatLngBoundsPrimitive ilatlngboundsprimitive);
}
