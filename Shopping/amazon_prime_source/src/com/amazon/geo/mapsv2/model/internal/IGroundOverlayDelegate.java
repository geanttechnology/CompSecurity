// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            ILatLngBoundsPrimitive, ILatLngPrimitive, IBitmapDescriptorDelegate

public interface IGroundOverlayDelegate
    extends IObjectDelegate
{

    public abstract float getBearing();

    public abstract ILatLngBoundsPrimitive getBounds();

    public abstract float getHeight();

    public abstract String getId();

    public abstract ILatLngPrimitive getPosition();

    public abstract float getTransparency();

    public abstract float getWidth();

    public abstract float getZIndex();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setBearing(float f);

    public abstract void setDimensions(float f);

    public abstract void setDimensions(float f, float f1);

    public abstract void setImage(IBitmapDescriptorDelegate ibitmapdescriptordelegate);

    public abstract void setPosition(ILatLngPrimitive ilatlngprimitive);

    public abstract void setPositionFromBounds(ILatLngBoundsPrimitive ilatlngboundsprimitive);

    public abstract void setTransparency(float f);

    public abstract void setVisible(boolean flag);

    public abstract void setZIndex(float f);
}
