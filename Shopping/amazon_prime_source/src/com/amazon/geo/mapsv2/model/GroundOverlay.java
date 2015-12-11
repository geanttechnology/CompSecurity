// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.model.internal.IBitmapDescriptorDelegate;
import com.amazon.geo.mapsv2.model.internal.IGroundOverlayDelegate;
import com.amazon.geo.mapsv2.model.pvt.Primitives;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            BitmapDescriptor, LatLngBounds, LatLng

public final class GroundOverlay
{

    IGroundOverlayDelegate mDelegate;

    public GroundOverlay(IGroundOverlayDelegate igroundoverlaydelegate)
    {
        mDelegate = igroundoverlaydelegate;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof GroundOverlay)
                {
                    obj = (GroundOverlay)obj;
                    return mDelegate.equals(((GroundOverlay) (obj)).mDelegate);
                }
            }
        }
        return flag;
    }

    public float getBearing()
    {
        return mDelegate.getBearing();
    }

    public LatLngBounds getBounds()
    {
        return Primitives.create(mDelegate.getBounds());
    }

    public float getHeight()
    {
        return mDelegate.getHeight();
    }

    public String getId()
    {
        return mDelegate.getId();
    }

    public LatLng getPosition()
    {
        return Primitives.create(mDelegate.getPosition());
    }

    public float getTransparency()
    {
        return mDelegate.getTransparency();
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

    public boolean isVisible()
    {
        return mDelegate.isVisible();
    }

    public void remove()
    {
        mDelegate.remove();
    }

    public void setBearing(float f)
    {
        mDelegate.setBearing(f);
    }

    public void setDimensions(float f)
    {
        mDelegate.setDimensions(f);
    }

    public void setDimensions(float f, float f1)
    {
        mDelegate.setDimensions(f, f1);
    }

    public void setImage(BitmapDescriptor bitmapdescriptor)
    {
        mDelegate.setImage((IBitmapDescriptorDelegate)com/amazon/geo/mapsv2/model/internal/IBitmapDescriptorDelegate.cast(bitmapdescriptor.id()));
    }

    public void setPosition(LatLng latlng)
    {
        mDelegate.setPosition(Primitives.create(latlng));
    }

    public void setPositionFromBounds(LatLngBounds latlngbounds)
    {
        mDelegate.setPositionFromBounds(Primitives.create(latlngbounds));
    }

    public void setTransparency(float f)
    {
        mDelegate.setTransparency(f);
    }

    public void setVisible(boolean flag)
    {
        mDelegate.setVisible(flag);
    }

    public void setZIndex(float f)
    {
        mDelegate.setZIndex(f);
    }
}
