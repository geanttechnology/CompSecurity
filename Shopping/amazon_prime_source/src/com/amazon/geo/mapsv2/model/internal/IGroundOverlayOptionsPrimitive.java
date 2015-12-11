// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            ILatLngBoundsPrimitive, IBitmapDescriptorDelegate, ILatLngPrimitive

public interface IGroundOverlayOptionsPrimitive
    extends IObjectDelegate
{

    public abstract float getAnchorU();

    public abstract float getAnchorV();

    public abstract float getBearing();

    public abstract ILatLngBoundsPrimitive getBounds();

    public abstract float getHeight();

    public abstract IBitmapDescriptorDelegate getImage();

    public abstract ILatLngPrimitive getLocation();

    public abstract float getTransparency();

    public abstract float getWidth();

    public abstract float getZIndex();

    public abstract boolean isVisible();
}
