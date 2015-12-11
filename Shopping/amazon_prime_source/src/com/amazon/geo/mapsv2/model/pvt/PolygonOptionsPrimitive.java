// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.PolygonOptions;
import com.amazon.geo.mapsv2.model.internal.IPolygonOptionsPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class PolygonOptionsPrimitive extends PrimitiveBase
    implements IPolygonOptionsPrimitive
{

    public PolygonOptionsPrimitive(PolygonOptions polygonoptions)
    {
        super(polygonoptions);
    }

    public int getFillColor()
    {
        return ((PolygonOptions)get()).getFillColor();
    }

    public List getHoles()
    {
        return Primitives.createListListLatLngDelegate(((PolygonOptions)get()).getHoles());
    }

    public List getPoints()
    {
        return Primitives.createListLatLngDelegate(((PolygonOptions)get()).getPoints());
    }

    public int getStrokeColor()
    {
        return ((PolygonOptions)get()).getStrokeColor();
    }

    public float getStrokeWidth()
    {
        return ((PolygonOptions)get()).getStrokeWidth();
    }

    public float getZIndex()
    {
        return ((PolygonOptions)get()).getZIndex();
    }

    public boolean isGeodesic()
    {
        return ((PolygonOptions)get()).isGeodesic();
    }

    public boolean isVisible()
    {
        return ((PolygonOptions)get()).isVisible();
    }
}
