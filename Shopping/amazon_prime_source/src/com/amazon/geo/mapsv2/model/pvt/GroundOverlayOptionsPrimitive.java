// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.GroundOverlayOptions;
import com.amazon.geo.mapsv2.model.internal.IBitmapDescriptorDelegate;
import com.amazon.geo.mapsv2.model.internal.IGroundOverlayOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngBoundsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class GroundOverlayOptionsPrimitive extends PrimitiveBase
    implements IGroundOverlayOptionsPrimitive
{

    public GroundOverlayOptionsPrimitive(GroundOverlayOptions groundoverlayoptions)
    {
        super(groundoverlayoptions);
    }

    public float getAnchorU()
    {
        return ((GroundOverlayOptions)get()).getAnchorU();
    }

    public float getAnchorV()
    {
        return ((GroundOverlayOptions)get()).getAnchorV();
    }

    public float getBearing()
    {
        return ((GroundOverlayOptions)get()).getBearing();
    }

    public ILatLngBoundsPrimitive getBounds()
    {
        return Primitives.create(((GroundOverlayOptions)get()).getBounds());
    }

    public float getHeight()
    {
        return ((GroundOverlayOptions)get()).getHeight();
    }

    public IBitmapDescriptorDelegate getImage()
    {
        return Primitives.unwrap(((GroundOverlayOptions)get()).getImage());
    }

    public ILatLngPrimitive getLocation()
    {
        return Primitives.create(((GroundOverlayOptions)get()).getLocation());
    }

    public float getTransparency()
    {
        return ((GroundOverlayOptions)get()).getTransparency();
    }

    public float getWidth()
    {
        return ((GroundOverlayOptions)get()).getWidth();
    }

    public float getZIndex()
    {
        return ((GroundOverlayOptions)get()).getZIndex();
    }

    public boolean isVisible()
    {
        return ((GroundOverlayOptions)get()).isVisible();
    }
}
