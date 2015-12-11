// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.model.internal.IPolylineDelegate;
import com.amazon.geo.mapsv2.model.pvt.Primitives;
import java.util.List;

public final class Polyline
{

    private final IPolylineDelegate mDelegate;

    public Polyline(IPolylineDelegate ipolylinedelegate)
    {
        if (ipolylinedelegate == null)
        {
            throw new IllegalArgumentException("Delegate cannot be null.");
        } else
        {
            mDelegate = ipolylinedelegate;
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
        if (!(obj instanceof Polyline))
        {
            return false;
        } else
        {
            obj = (Polyline)obj;
            return mDelegate.equals(((Polyline) (obj)).mDelegate);
        }
    }

    public int getColor()
    {
        return mDelegate.getColor();
    }

    public String getId()
    {
        return mDelegate.getId();
    }

    public List getPoints()
    {
        return Primitives.createListLatLng(mDelegate.getPoints());
    }

    public float getWidth()
    {
        return mDelegate.getWidth();
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

    public void setColor(int i)
    {
        mDelegate.setColor(i);
    }

    public void setGeodesic(boolean flag)
    {
        mDelegate.setGeodesic(flag);
    }

    public void setPoints(List list)
    {
        mDelegate.setPoints(Primitives.createListLatLngDelegate(list));
    }

    public void setVisible(boolean flag)
    {
        mDelegate.setVisible(flag);
    }

    public void setWidth(float f)
    {
        mDelegate.setWidth(f);
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
