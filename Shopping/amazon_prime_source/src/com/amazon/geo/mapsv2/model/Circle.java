// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.model.internal.ICircleDelegate;
import com.amazon.geo.mapsv2.model.pvt.Primitives;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            LatLng

public final class Circle
{

    private final ICircleDelegate mDelegate;

    public Circle(ICircleDelegate icircledelegate)
    {
        if (icircledelegate == null)
        {
            throw new IllegalArgumentException("Delegate cannot be null.");
        } else
        {
            mDelegate = icircledelegate;
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
        if (!(obj instanceof Circle))
        {
            return false;
        } else
        {
            obj = (Circle)obj;
            return mDelegate.equals(((Circle) (obj)).mDelegate);
        }
    }

    public LatLng getCenter()
    {
        return Primitives.create(mDelegate.getCenter());
    }

    public int getFillColor()
    {
        return mDelegate.getFillColor();
    }

    public String getId()
    {
        return mDelegate.getId();
    }

    public double getRadius()
    {
        return mDelegate.getRadius();
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

    public boolean isVisible()
    {
        return mDelegate.isVisible();
    }

    public void remove()
    {
        mDelegate.remove();
    }

    public void setCenter(LatLng latlng)
    {
        mDelegate.setCenter(Primitives.create(latlng));
    }

    public void setFillColor(int i)
    {
        mDelegate.setFillColor(i);
    }

    public void setRadius(double d)
    {
        mDelegate.setRadius(d);
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
