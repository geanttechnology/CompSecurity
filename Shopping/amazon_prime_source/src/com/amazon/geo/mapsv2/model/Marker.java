// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.model.internal.IMarkerDelegate;
import com.amazon.geo.mapsv2.model.pvt.Primitives;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            LatLng, BitmapDescriptor

public final class Marker
{

    private final IMarkerDelegate mMarkerDelegate;

    public Marker(IMarkerDelegate imarkerdelegate)
    {
        mMarkerDelegate = imarkerdelegate;
        mMarkerDelegate.setWrapper(this);
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (Marker)obj;
        if (mMarkerDelegate != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Marker) (obj)).mMarkerDelegate == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mMarkerDelegate.equals(((Marker) (obj)).mMarkerDelegate)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public float getAlpha()
    {
        return mMarkerDelegate.getAlpha();
    }

    public String getId()
    {
        return mMarkerDelegate.getId();
    }

    public LatLng getPosition()
    {
        return Primitives.create(mMarkerDelegate.getPosition());
    }

    public float getRotation()
    {
        return mMarkerDelegate.getRotation();
    }

    public String getSnippet()
    {
        return mMarkerDelegate.getSnippet();
    }

    public String getTitle()
    {
        return mMarkerDelegate.getTitle();
    }

    public int hashCode()
    {
        int i;
        if (mMarkerDelegate == null)
        {
            i = 0;
        } else
        {
            i = mMarkerDelegate.hashCode();
        }
        return i + 31;
    }

    public void hideInfoWindow()
    {
        mMarkerDelegate.hideInfoWindow();
    }

    public boolean isDraggable()
    {
        return mMarkerDelegate.isDraggable();
    }

    public boolean isFlat()
    {
        return mMarkerDelegate.isFlat();
    }

    public boolean isInfoWindowShown()
    {
        return mMarkerDelegate.isInfoWindowShown();
    }

    public boolean isVisible()
    {
        return mMarkerDelegate.isVisible();
    }

    public void remove()
    {
        mMarkerDelegate.remove();
    }

    public void setAlpha(float f)
    {
        mMarkerDelegate.setAlpha(f);
    }

    public void setAnchor(float f, float f1)
    {
        mMarkerDelegate.setAnchor(f, f1);
    }

    public void setDraggable(boolean flag)
    {
        mMarkerDelegate.setDraggable(flag);
    }

    public void setFlat(boolean flag)
    {
        mMarkerDelegate.setFlat(flag);
    }

    public void setIcon(BitmapDescriptor bitmapdescriptor)
    {
        mMarkerDelegate.setIcon(Primitives.unwrap(bitmapdescriptor));
    }

    public void setInfoWindowAnchor(float f, float f1)
    {
        mMarkerDelegate.setInfoWindowAnchor(f, f1);
    }

    public void setPosition(LatLng latlng)
    {
        mMarkerDelegate.setPosition(Primitives.create(latlng));
    }

    public void setRotation(float f)
    {
        mMarkerDelegate.setRotation(f);
    }

    public void setSnippet(String s)
    {
        mMarkerDelegate.setSnippet(s);
    }

    public void setTitle(String s)
    {
        mMarkerDelegate.setTitle(s);
    }

    public void setVisible(boolean flag)
    {
        mMarkerDelegate.setVisible(flag);
    }

    public void showInfoWindow()
    {
        mMarkerDelegate.showInfoWindow();
    }
}
