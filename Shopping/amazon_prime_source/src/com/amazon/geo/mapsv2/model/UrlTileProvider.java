// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import java.net.URL;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            TileProvider, Tile

public abstract class UrlTileProvider
    implements TileProvider
{
    public static class a
    {

        public static int b(UrlTileProvider urltileprovider)
        {
            return urltileprovider.width;
        }

        public static int c(UrlTileProvider urltileprovider)
        {
            return urltileprovider.height;
        }

        public a()
        {
        }
    }


    private final int height;
    private final int width;

    public UrlTileProvider(int i, int j)
    {
        width = i;
        height = j;
    }

    public final Tile getTile(int i, int j, int k)
    {
        return NO_TILE;
    }

    public abstract URL getTileUrl(int i, int j, int k);


}
