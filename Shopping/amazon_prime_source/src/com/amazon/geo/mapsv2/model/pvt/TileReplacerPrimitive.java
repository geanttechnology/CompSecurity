// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.TileReplacer;
import com.amazon.geo.mapsv2.model.internal.ITilePrimitive;
import com.amazon.geo.mapsv2.model.internal.ITileReplacerPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class TileReplacerPrimitive extends PrimitiveBase
    implements ITileReplacerPrimitive
{

    public TileReplacerPrimitive(TileReplacer tilereplacer)
    {
        super(tilereplacer);
    }

    public ITilePrimitive getTile(int i, int j, int k)
    {
        return Primitives.create(((TileReplacer)get()).getTile(i, j, k));
    }
}
