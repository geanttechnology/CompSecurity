// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            IBitmapDescriptorDelegate, ILatLngPrimitive

public interface IMarkerOptionsPrimitive
    extends IObjectDelegate
{

    public abstract float getAlpha();

    public abstract float getAnchorU();

    public abstract float getAnchorV();

    public abstract IBitmapDescriptorDelegate getIcon();

    public abstract float getInfoWindowAnchorU();

    public abstract float getInfoWindowAnchorV();

    public abstract ILatLngPrimitive getPosition();

    public abstract float getRotation();

    public abstract String getSnippet();

    public abstract String getTitle();

    public abstract boolean isDraggable();

    public abstract boolean isFlat();

    public abstract boolean isVisible();
}
