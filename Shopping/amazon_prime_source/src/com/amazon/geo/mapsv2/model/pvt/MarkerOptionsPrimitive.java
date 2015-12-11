// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.MarkerOptions;
import com.amazon.geo.mapsv2.model.internal.IBitmapDescriptorDelegate;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.model.internal.IMarkerOptionsPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

class MarkerOptionsPrimitive extends PrimitiveBase
    implements IMarkerOptionsPrimitive
{

    public MarkerOptionsPrimitive(MarkerOptions markeroptions)
    {
        super(markeroptions);
    }

    public float getAlpha()
    {
        return ((MarkerOptions)get()).getAlpha();
    }

    public float getAnchorU()
    {
        return ((MarkerOptions)get()).getAnchorU();
    }

    public float getAnchorV()
    {
        return ((MarkerOptions)get()).getAnchorV();
    }

    public IBitmapDescriptorDelegate getIcon()
    {
        return Primitives.unwrap(((MarkerOptions)get()).getIcon());
    }

    public float getInfoWindowAnchorU()
    {
        return ((MarkerOptions)get()).getInfoWindowAnchorU();
    }

    public float getInfoWindowAnchorV()
    {
        return ((MarkerOptions)get()).getInfoWindowAnchorV();
    }

    public ILatLngPrimitive getPosition()
    {
        return Primitives.create(((MarkerOptions)get()).getPosition());
    }

    public float getRotation()
    {
        return ((MarkerOptions)get()).getRotation();
    }

    public String getSnippet()
    {
        return ((MarkerOptions)get()).getSnippet();
    }

    public String getTitle()
    {
        return ((MarkerOptions)get()).getTitle();
    }

    public boolean isDraggable()
    {
        return ((MarkerOptions)get()).isDraggable();
    }

    public boolean isFlat()
    {
        return ((MarkerOptions)get()).isFlat();
    }

    public boolean isVisible()
    {
        return ((MarkerOptions)get()).isVisible();
    }
}
