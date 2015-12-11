// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import java.util.List;

public interface IPolylineOptionsPrimitive
    extends IObjectDelegate
{

    public abstract int getColor();

    public abstract List getPoints();

    public abstract float getWidth();

    public abstract float getZIndex();

    public abstract boolean isGeodesic();

    public abstract boolean isVisible();
}
