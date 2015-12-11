// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import com.amazon.geo.mapsv2.model.BoundedTileReplacer;
import com.amazon.geo.mapsv2.model.TileProvider;
import com.amazon.geo.mapsv2.model.TileReplacer;
import com.amazon.geo.mapsv2.model.UrlTileReplacer;
import com.amazon.geo.mapsv2.model.internal.ITileProviderPrimitive;
import com.amazon.geo.mapsv2.model.pvt.BoundedTileReplacerPrimitive;
import com.amazon.geo.mapsv2.model.pvt.CoverageGapTileReplacer;
import com.amazon.geo.mapsv2.model.pvt.CoverageGapTileReplacerPrimitive;
import com.amazon.geo.mapsv2.model.pvt.TileReplacerPrimitive;
import com.amazon.geo.mapsv2.model.pvt.UrlTileReplacerPrimitive;

// Referenced classes of package com.amazon.geo.mapsv2.pvt:
//            InternalPrimitiveFactory

public class InternalPrimitiveFactoryImpl
    implements InternalPrimitiveFactory
{

    public InternalPrimitiveFactoryImpl()
    {
    }

    public ITileProviderPrimitive create(TileProvider tileprovider)
    {
        CoverageGapTileReplacerPrimitive coveragegaptilereplacerprimitive = null;
        if (tileprovider instanceof CoverageGapTileReplacer)
        {
            coveragegaptilereplacerprimitive = new CoverageGapTileReplacerPrimitive((CoverageGapTileReplacer)tileprovider);
        } else
        {
            if (tileprovider instanceof BoundedTileReplacer)
            {
                return new BoundedTileReplacerPrimitive((BoundedTileReplacer)tileprovider);
            }
            if (tileprovider instanceof UrlTileReplacer)
            {
                return new UrlTileReplacerPrimitive((UrlTileReplacer)tileprovider);
            }
            if (tileprovider instanceof TileReplacer)
            {
                return new TileReplacerPrimitive((TileReplacer)tileprovider);
            }
        }
        return coveragegaptilereplacerprimitive;
    }
}
