// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.IUiSettingsDelegate;

public final class UiSettings
{

    private final IUiSettingsDelegate mDelegate;

    UiSettings(IUiSettingsDelegate iuisettingsdelegate)
    {
        mDelegate = iuisettingsdelegate;
        mDelegate.setWrapper(this);
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
        obj = (UiSettings)obj;
        if (mDelegate != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((UiSettings) (obj)).mDelegate == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mDelegate.equals(((UiSettings) (obj)).mDelegate)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int i;
        if (mDelegate == null)
        {
            i = 0;
        } else
        {
            i = mDelegate.hashCode();
        }
        return i + 31;
    }

    public boolean isCompassEnabled()
    {
        return mDelegate.isCompassEnabled();
    }

    public boolean isIndoorLevelPickerEnabled()
    {
        return mDelegate.isIndoorLevelPickerEnabled();
    }

    public boolean isMapToolbarEnabled()
    {
        return mDelegate.isMapToolbarEnabled();
    }

    public boolean isMyLocationButtonEnabled()
    {
        return mDelegate.isMyLocationButtonEnabled();
    }

    public boolean isRotateGesturesEnabled()
    {
        return mDelegate.isRotateGesturesEnabled();
    }

    public boolean isScrollGesturesEnabled()
    {
        return mDelegate.isScrollGesturesEnabled();
    }

    public boolean isTiltGesturesEnabled()
    {
        return mDelegate.isTiltGesturesEnabled();
    }

    public boolean isZoomControlsEnabled()
    {
        return mDelegate.isZoomControlsEnabled();
    }

    public boolean isZoomGesturesEnabled()
    {
        return mDelegate.isZoomGesturesEnabled();
    }

    public void setAllGesturesEnabled(boolean flag)
    {
        mDelegate.setAllGesturesEnabled(flag);
    }

    public void setCompassEnabled(boolean flag)
    {
        mDelegate.setCompassEnabled(flag);
    }

    public void setIndoorLevelPickerEnabled(boolean flag)
    {
        mDelegate.setIndoorLevelPickerEnabled(flag);
    }

    public void setMapToolbarEnabled(boolean flag)
    {
        mDelegate.setMapToolbarEnabled(flag);
    }

    public void setMyLocationButtonEnabled(boolean flag)
    {
        mDelegate.setMyLocationButtonEnabled(flag);
    }

    public void setRotateGesturesEnabled(boolean flag)
    {
        mDelegate.setRotateGesturesEnabled(flag);
    }

    public void setScrollGesturesEnabled(boolean flag)
    {
        mDelegate.setScrollGesturesEnabled(flag);
    }

    public void setTiltGesturesEnabled(boolean flag)
    {
        mDelegate.setTiltGesturesEnabled(flag);
    }

    public void setZoomControlsEnabled(boolean flag)
    {
        mDelegate.setZoomControlsEnabled(flag);
    }

    public void setZoomGesturesEnabled(boolean flag)
    {
        mDelegate.setZoomGesturesEnabled(flag);
    }
}
