// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import java.util.List;

public interface IPolygonDelegate
    extends IObjectDelegate
{

    public abstract int getFillColor();

    public abstract List getHoles();

    public abstract String getId();

    public abstract List getPoints();

    public abstract int getStrokeColor();

    public abstract float getStrokeWidth();

    public abstract float getZIndex();

    public abstract boolean isGeodesic();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setFillColor(int i);

    public abstract void setGeodesic(boolean flag);

    public abstract void setHoles(List list);

    public abstract void setPoints(List list);

    public abstract void setStrokeColor(int i);

    public abstract void setStrokeWidth(float f);

    public abstract void setVisible(boolean flag);

    public abstract void setZIndex(float f);
}
