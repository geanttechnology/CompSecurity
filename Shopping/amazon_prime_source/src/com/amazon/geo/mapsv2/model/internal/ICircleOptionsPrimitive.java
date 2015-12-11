// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            ILatLngPrimitive

public interface ICircleOptionsPrimitive
    extends IObjectDelegate
{

    public abstract ILatLngPrimitive getCenter();

    public abstract int getFillColor();

    public abstract double getRadius();

    public abstract int getStrokeColor();

    public abstract float getStrokeWidth();

    public abstract float getZIndex();

    public abstract boolean isVisible();
}
