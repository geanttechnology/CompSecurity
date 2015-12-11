// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.BoundedTileReplacer;
import com.amazon.geo.mapsv2.model.UrlTileProvider;
import com.amazon.geo.mapsv2.model.internal.IBoundedTileReplacerPrimitive;
import com.amazon.geo.mapsv2.model.internal.ITilePrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class BoundedTileReplacerPrimitive extends PrimitiveBase
    implements IBoundedTileReplacerPrimitive
{

    public BoundedTileReplacerPrimitive(BoundedTileReplacer boundedtilereplacer)
    {
        super(boundedtilereplacer);
    }

    public int getHeight()
    {
        return com.amazon.geo.mapsv2.model.UrlTileProvider.a.c((UrlTileProvider)get());
    }

    public List getLatLngBounds()
    {
        return Primitives.create(((BoundedTileReplacer)get()).latLngBounds);
    }

    public ITilePrimitive getTile(int i, int j, int k)
    {
        return Primitives.create(((BoundedTileReplacer)get()).getTile(i, j, k));
    }

    public URL getTileUrl(int i, int j, int k)
    {
        return ((BoundedTileReplacer)get()).getTileUrl(i, j, k);
    }

    public int getWidth()
    {
        return com.amazon.geo.mapsv2.model.UrlTileProvider.a.b((UrlTileProvider)get());
    }

    public double getZoomCap()
    {
        return ((BoundedTileReplacer)get()).zoomCap;
    }

    public int getZoomFloor()
    {
        return ((BoundedTileReplacer)get()).zoomFloor;
    }
}
