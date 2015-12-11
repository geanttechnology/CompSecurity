// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.CircleOptions;
import com.amazon.geo.mapsv2.model.internal.ICircleOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class CircleOptionsPrimitive extends PrimitiveBase
    implements ICircleOptionsPrimitive
{

    public CircleOptionsPrimitive(CircleOptions circleoptions)
    {
        super(circleoptions);
    }

    public ILatLngPrimitive getCenter()
    {
        return Primitives.create(((CircleOptions)get()).getCenter());
    }

    public int getFillColor()
    {
        return ((CircleOptions)get()).getFillColor();
    }

    public double getRadius()
    {
        return ((CircleOptions)get()).getRadius();
    }

    public int getStrokeColor()
    {
        return ((CircleOptions)get()).getStrokeColor();
    }

    public float getStrokeWidth()
    {
        return ((CircleOptions)get()).getStrokeWidth();
    }

    public float getZIndex()
    {
        return ((CircleOptions)get()).getZIndex();
    }

    public boolean isVisible()
    {
        return ((CircleOptions)get()).isVisible();
    }
}
