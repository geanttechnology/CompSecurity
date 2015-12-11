// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            UrlTileReplacer

public abstract class BoundedTileReplacer extends UrlTileReplacer
{

    public final List latLngBounds;
    public final double zoomCap;
    public final int zoomFloor;

    public BoundedTileReplacer(int i, int j, List list, double d, int k)
    {
        super(i, j);
        latLngBounds = Collections.unmodifiableList(list);
        zoomCap = d;
        zoomFloor = k;
    }
}
