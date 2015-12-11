// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.Tile;
import com.amazon.geo.mapsv2.model.internal.ITilePrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

public class TilePrimitive extends PrimitiveBase
    implements ITilePrimitive
{

    public TilePrimitive(Tile tile)
    {
        super(tile);
    }

    public byte[] getData()
    {
        return ((Tile)get()).data;
    }

    public int getHeight()
    {
        return ((Tile)get()).height;
    }

    public int getWidth()
    {
        return ((Tile)get()).width;
    }
}
