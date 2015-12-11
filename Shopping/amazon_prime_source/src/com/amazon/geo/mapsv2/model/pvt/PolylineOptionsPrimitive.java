// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.PolylineOptions;
import com.amazon.geo.mapsv2.model.internal.IPolylineOptionsPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class PolylineOptionsPrimitive extends PrimitiveBase
    implements IPolylineOptionsPrimitive
{

    public PolylineOptionsPrimitive(PolylineOptions polylineoptions)
    {
        super(polylineoptions);
    }

    public int getColor()
    {
        return ((PolylineOptions)get()).getColor();
    }

    public List getPoints()
    {
        return Primitives.createListLatLngDelegate(((PolylineOptions)get()).getPoints());
    }

    public float getWidth()
    {
        return ((PolylineOptions)get()).getWidth();
    }

    public float getZIndex()
    {
        return ((PolylineOptions)get()).getZIndex();
    }

    public boolean isGeodesic()
    {
        return ((PolylineOptions)get()).isGeodesic();
    }

    public boolean isVisible()
    {
        return ((PolylineOptions)get()).isVisible();
    }
}
