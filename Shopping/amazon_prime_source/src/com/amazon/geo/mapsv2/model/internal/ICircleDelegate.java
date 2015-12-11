// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            ILatLngPrimitive

public interface ICircleDelegate
    extends IObjectDelegate
{

    public abstract ILatLngPrimitive getCenter();

    public abstract int getFillColor();

    public abstract String getId();

    public abstract double getRadius();

    public abstract int getStrokeColor();

    public abstract float getStrokeWidth();

    public abstract float getZIndex();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setCenter(ILatLngPrimitive ilatlngprimitive);

    public abstract void setFillColor(int i);

    public abstract void setRadius(double d);

    public abstract void setStrokeColor(int i);

    public abstract void setStrokeWidth(float f);

    public abstract void setVisible(boolean flag);

    public abstract void setZIndex(float f);
}
