// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.model.internal.ITileOverlayDelegate;

public final class TileOverlay
{

    private final ITileOverlayDelegate mTileOverlayDelegate;

    public TileOverlay(ITileOverlayDelegate itileoverlaydelegate)
    {
        mTileOverlayDelegate = itileoverlaydelegate;
        mTileOverlayDelegate.setWrapper(this);
    }

    public void clearTileCache()
    {
        mTileOverlayDelegate.clearTileCache();
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
        obj = (TileOverlay)obj;
        if (mTileOverlayDelegate != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((TileOverlay) (obj)).mTileOverlayDelegate == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mTileOverlayDelegate.equals(((TileOverlay) (obj)).mTileOverlayDelegate)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public boolean getFadeIn()
    {
        return mTileOverlayDelegate.getFadeIn();
    }

    public String getId()
    {
        return mTileOverlayDelegate.getId();
    }

    public float getZIndex()
    {
        return mTileOverlayDelegate.getZIndex();
    }

    public int hashCode()
    {
        int i;
        if (mTileOverlayDelegate == null)
        {
            i = 0;
        } else
        {
            i = mTileOverlayDelegate.hashCode();
        }
        return i + 31;
    }

    public boolean isVisible()
    {
        return mTileOverlayDelegate.isVisible();
    }

    public void remove()
    {
        mTileOverlayDelegate.remove();
    }

    public void setFadeIn(boolean flag)
    {
        mTileOverlayDelegate.setFadeIn(flag);
    }

    public void setVisible(boolean flag)
    {
        mTileOverlayDelegate.setVisible(flag);
    }

    public void setZIndex(float f)
    {
        mTileOverlayDelegate.setZIndex(f);
    }
}
