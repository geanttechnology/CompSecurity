// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

public class LatLngPrimitive extends PrimitiveBase
    implements ILatLngPrimitive
{

    public LatLngPrimitive(LatLng latlng)
    {
        super(latlng);
    }

    public double getLatitude()
    {
        return ((LatLng)get()).latitude;
    }

    public double getLongitude()
    {
        return ((LatLng)get()).longitude;
    }
}
