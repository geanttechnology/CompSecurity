// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.UrlTileProvider;
import com.amazon.geo.mapsv2.model.UrlTileReplacer;
import com.amazon.geo.mapsv2.model.internal.ITilePrimitive;
import com.amazon.geo.mapsv2.model.internal.IUrlTileReplacerPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import java.net.URL;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class UrlTileReplacerPrimitive extends PrimitiveBase
    implements IUrlTileReplacerPrimitive
{

    public UrlTileReplacerPrimitive(UrlTileReplacer urltilereplacer)
    {
        super(urltilereplacer);
    }

    public int getHeight()
    {
        return com.amazon.geo.mapsv2.model.UrlTileProvider.a.c((UrlTileProvider)get());
    }

    public ITilePrimitive getTile(int i, int j, int k)
    {
        return Primitives.create(((UrlTileReplacer)get()).getTile(i, j, k));
    }

    public URL getTileUrl(int i, int j, int k)
    {
        return ((UrlTileReplacer)get()).getTileUrl(i, j, k);
    }

    public int getWidth()
    {
        return com.amazon.geo.mapsv2.model.UrlTileProvider.a.b((UrlTileProvider)get());
    }
}
