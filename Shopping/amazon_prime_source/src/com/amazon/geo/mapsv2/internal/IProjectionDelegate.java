// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;

import android.graphics.Point;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.model.internal.IVisibleRegionPrimitive;

// Referenced classes of package com.amazon.geo.mapsv2.internal:
//            IObjectDelegate

public interface IProjectionDelegate
    extends IObjectDelegate
{

    public abstract ILatLngPrimitive fromScreenLocation(Point point);

    public abstract IVisibleRegionPrimitive getVisibleRegion();

    public abstract Point toScreenLocation(ILatLngPrimitive ilatlngprimitive);
}
