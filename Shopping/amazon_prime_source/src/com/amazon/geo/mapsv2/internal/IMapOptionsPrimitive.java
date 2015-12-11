// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;

import com.amazon.geo.mapsv2.model.internal.ICameraPositionPrimitive;

// Referenced classes of package com.amazon.geo.mapsv2.internal:
//            IObjectDelegate

public interface IMapOptionsPrimitive
    extends IObjectDelegate
{

    public abstract Boolean getAlignCompassBottom();

    public abstract Boolean getAlignCompassLeft();

    public abstract Boolean getAlignCompassRight();

    public abstract Boolean getAlignCompassTop();

    public abstract Boolean getAlignLocatorBottom();

    public abstract Boolean getAlignLocatorLeft();

    public abstract Boolean getAlignLocatorRight();

    public abstract Boolean getAlignLocatorTop();

    public abstract ICameraPositionPrimitive getCamera();

    public abstract Integer getCompassDrawable();

    public abstract Boolean getCompassEnabled();

    public abstract Boolean getLiteMode();

    public abstract Integer getLocatorDrawable();

    public abstract Boolean getMapToolbarEnabled();

    public abstract int getMapType();

    public abstract Boolean getRestrictCamera();

    public abstract String getRestrictCameraBounds();

    public abstract Boolean getRotateGesturesEnabled();

    public abstract Boolean getScrollGesturesEnabled();

    public abstract Boolean getTileReplacer();

    public abstract Boolean getTiltGesturesEnabled();

    public abstract Boolean getUseViewLifecycleInFragment();

    public abstract Boolean getZOrderOnTop();

    public abstract Boolean getZoomControlsEnabled();

    public abstract Boolean getZoomGesturesEnabled();
}
