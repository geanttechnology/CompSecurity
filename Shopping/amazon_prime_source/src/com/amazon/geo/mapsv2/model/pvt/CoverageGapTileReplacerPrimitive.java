// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.UrlTileProvider;
import com.amazon.geo.mapsv2.model.internal.ICoverageGapTileReplacerPrimitive;
import com.amazon.geo.mapsv2.model.internal.ITilePrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            CoverageGapTileReplacer, Primitives

public class CoverageGapTileReplacerPrimitive extends PrimitiveBase
    implements ICoverageGapTileReplacerPrimitive
{

    public CoverageGapTileReplacerPrimitive(CoverageGapTileReplacer coveragegaptilereplacer)
    {
        super(coveragegaptilereplacer);
    }

    public int getHeight()
    {
        return com.amazon.geo.mapsv2.model.UrlTileProvider.a.c((UrlTileProvider)get());
    }

    public List getLatLngBounds()
    {
        return Primitives.create(((CoverageGapTileReplacer)get()).latLngBounds);
    }

    public ITilePrimitive getTile(int i, int j, int k)
    {
        return Primitives.create(((CoverageGapTileReplacer)get()).getTile(i, j, k));
    }

    public URL getTileUrl(int i, int j, int k)
    {
        return ((CoverageGapTileReplacer)get()).getTileUrl(i, j, k);
    }

    public String getVersion()
    {
        return ((CoverageGapTileReplacer)get()).version;
    }

    public int getWidth()
    {
        return com.amazon.geo.mapsv2.model.UrlTileProvider.a.b((UrlTileProvider)get());
    }

    public double getZoomCap()
    {
        return ((CoverageGapTileReplacer)get()).zoomCap;
    }

    public int getZoomFloor()
    {
        return ((CoverageGapTileReplacer)get()).zoomFloor;
    }
}
