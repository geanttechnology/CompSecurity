// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;

import android.graphics.Point;
import com.amazon.geo.mapsv2.model.internal.ICameraPositionPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngBoundsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;

// Referenced classes of package com.amazon.geo.mapsv2.internal:
//            IObjectDelegate

public interface ICameraUpdateDelegate
    extends IObjectDelegate
{

    public abstract Point getFocusPoint();

    public abstract Integer getHeight();

    public abstract ILatLngPrimitive getNewLatLng();

    public abstract ILatLngBoundsPrimitive getNewLatLngBounds();

    public abstract ICameraPositionPrimitive getNewPosition();

    public abstract Float getNewZoom();

    public abstract Integer getPadding();

    public abstract Float getScrollByX();

    public abstract Float getScrollByY();

    public abstract Integer getWidth();

    public abstract Float getZoomBy();

    public abstract Boolean getZoomIn();

    public abstract Boolean getZoomOut();
}
