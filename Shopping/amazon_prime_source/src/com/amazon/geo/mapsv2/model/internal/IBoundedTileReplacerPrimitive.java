// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            IUrlTileReplacerPrimitive

public interface IBoundedTileReplacerPrimitive
    extends IUrlTileReplacerPrimitive
{

    public abstract List getLatLngBounds();

    public abstract double getZoomCap();

    public abstract int getZoomFloor();
}
