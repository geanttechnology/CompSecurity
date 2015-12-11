// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;


// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            ILatLngPrimitive, ILatLngBoundsPrimitive

public interface IVisibleRegionPrimitive
{

    public abstract ILatLngPrimitive getFarLeft();

    public abstract ILatLngPrimitive getFarRight();

    public abstract ILatLngBoundsPrimitive getLatLngBounds();

    public abstract ILatLngPrimitive getNearLeft();

    public abstract ILatLngPrimitive getNearRight();
}
