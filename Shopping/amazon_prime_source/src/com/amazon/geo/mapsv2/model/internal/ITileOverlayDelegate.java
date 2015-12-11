// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

public interface ITileOverlayDelegate
    extends IObjectDelegate
{

    public abstract void clearTileCache();

    public abstract boolean getFadeIn();

    public abstract String getId();

    public abstract int getTileHeightPixels();

    public abstract int getTileWidthPixels();

    public abstract float getZIndex();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setFadeIn(boolean flag);

    public abstract void setVisible(boolean flag);

    public abstract void setZIndex(float f);
}
