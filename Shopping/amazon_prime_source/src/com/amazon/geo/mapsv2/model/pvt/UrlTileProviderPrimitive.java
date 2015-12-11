// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.UrlTileProvider;
import com.amazon.geo.mapsv2.model.internal.ITilePrimitive;
import com.amazon.geo.mapsv2.model.internal.IUrlTileProviderPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import java.net.URL;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class UrlTileProviderPrimitive extends PrimitiveBase
    implements IUrlTileProviderPrimitive
{

    public UrlTileProviderPrimitive(UrlTileProvider urltileprovider)
    {
        super(urltileprovider);
    }

    public int getHeight()
    {
        return com.amazon.geo.mapsv2.model.UrlTileProvider.a.c((UrlTileProvider)get());
    }

    public ITilePrimitive getTile(int i, int j, int k)
    {
        return Primitives.create(((UrlTileProvider)get()).getTile(i, j, k));
    }

    public URL getTileUrl(int i, int j, int k)
    {
        return ((UrlTileProvider)get()).getTileUrl(i, j, k);
    }

    public int getWidth()
    {
        return com.amazon.geo.mapsv2.model.UrlTileProvider.a.b((UrlTileProvider)get());
    }
}
