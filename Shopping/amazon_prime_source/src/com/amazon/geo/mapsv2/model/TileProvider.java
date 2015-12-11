// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;


// Referenced classes of package com.amazon.geo.mapsv2.model:
//            Tile

public interface TileProvider
{

    public static final Tile NO_TILE = new Tile(0, 0, null);

    public abstract Tile getTile(int i, int j, int k);

}
