// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.TileProvider;
import com.amazon.geo.mapsv2.model.internal.ITilePrimitive;
import com.amazon.geo.mapsv2.model.internal.ITileProviderPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class TileProviderPrimitive extends PrimitiveBase
    implements ITileProviderPrimitive
{

    public TileProviderPrimitive(TileProvider tileprovider)
    {
        super(tileprovider);
    }

    public ITilePrimitive getTile(int i, int j, int k)
    {
        return Primitives.create(((TileProvider)get()).getTile(i, j, k));
    }
}
