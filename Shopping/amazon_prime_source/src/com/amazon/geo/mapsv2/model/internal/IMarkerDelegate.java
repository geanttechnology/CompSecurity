// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            ILatLngPrimitive, IBitmapDescriptorDelegate

public interface IMarkerDelegate
    extends IObjectDelegate
{

    public abstract float getAlpha();

    public abstract String getId();

    public abstract ILatLngPrimitive getPosition();

    public abstract float getRotation();

    public abstract String getSnippet();

    public abstract String getTitle();

    public abstract void hideInfoWindow();

    public abstract boolean isDraggable();

    public abstract boolean isFlat();

    public abstract boolean isInfoWindowShown();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setAlpha(float f);

    public abstract void setAnchor(float f, float f1);

    public abstract void setDraggable(boolean flag);

    public abstract void setFlat(boolean flag);

    public abstract void setIcon(IBitmapDescriptorDelegate ibitmapdescriptordelegate);

    public abstract void setInfoWindowAnchor(float f, float f1);

    public abstract void setPosition(ILatLngPrimitive ilatlngprimitive);

    public abstract void setRotation(float f);

    public abstract void setSnippet(String s);

    public abstract void setTitle(String s);

    public abstract void setVisible(boolean flag);

    public abstract void showInfoWindow();
}
