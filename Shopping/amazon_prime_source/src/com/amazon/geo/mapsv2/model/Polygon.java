// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.model.internal.IPolygonDelegate;
import com.amazon.geo.mapsv2.model.pvt.Primitives;
import java.util.List;

public final class Polygon
{

    private final IPolygonDelegate mDelegate;

    public Polygon(IPolygonDelegate ipolygondelegate)
    {
        if (ipolygondelegate == null)
        {
            throw new IllegalArgumentException("Delegate cannot be null.");
        } else
        {
            mDelegate = ipolygondelegate;
            mDelegate.setWrapper(this);
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Polygon))
        {
            return false;
        } else
        {
            obj = (Polygon)obj;
            return mDelegate.equals(((Polygon) (obj)).mDelegate);
        }
    }

    public int getFillColor()
    {
        return mDelegate.getFillColor();
    }

    public List getHoles()
    {
        return Primitives.createListListLatLng(mDelegate.getHoles());
    }

    public String getId()
    {
        return mDelegate.getId();
    }

    public List getPoints()
    {
        return Primitives.createListLatLng(mDelegate.getPoints());
    }

    public int getStrokeColor()
    {
        return mDelegate.getStrokeColor();
    }

    public float getStrokeWidth()
    {
        return mDelegate.getStrokeWidth();
    }

    public float getZIndex()
    {
        return mDelegate.getZIndex();
    }

    public int hashCode()
    {
        return mDelegate.hashCode();
    }

    public boolean isGeodesic()
    {
        return mDelegate.isGeodesic();
    }

    public boolean isVisible()
    {
        return mDelegate.isVisible();
    }

    public void remove()
    {
        mDelegate.remove();
    }

    public void setFillColor(int i)
    {
        mDelegate.setFillColor(i);
    }

    public void setGeodesic(boolean flag)
    {
        mDelegate.setGeodesic(flag);
    }

    public void setHoles(List list)
    {
        mDelegate.setHoles(Primitives.createListListLatLngDelegate(list));
    }

    public void setPoints(List list)
    {
        mDelegate.setPoints(Primitives.createListLatLngDelegate(list));
    }

    public void setStrokeColor(int i)
    {
        mDelegate.setStrokeColor(i);
    }

    public void setStrokeWidth(float f)
    {
        mDelegate.setStrokeWidth(f);
    }

    public void setVisible(boolean flag)
    {
        mDelegate.setVisible(flag);
    }

    public void setZIndex(float f)
    {
        mDelegate.setZIndex(f);
    }

    public String toString()
    {
        return mDelegate.toString();
    }
}
