// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.TileOverlayOptions;
import com.amazon.geo.mapsv2.model.internal.ITileOverlayOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ITileProviderPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class TileOverlayOptionsPrimitive extends PrimitiveBase
    implements ITileOverlayOptionsPrimitive
{

    public TileOverlayOptionsPrimitive(TileOverlayOptions tileoverlayoptions)
    {
        super(tileoverlayoptions);
    }

    public boolean getFadeIn()
    {
        return ((TileOverlayOptions)get()).getFadeIn();
    }

    public ITileProviderPrimitive getTileProvider()
    {
        return Primitives.create(((TileOverlayOptions)get()).getTileProvider());
    }

    public float getZIndex()
    {
        return ((TileOverlayOptions)get()).getZIndex();
    }

    public boolean isVisible()
    {
        return ((TileOverlayOptions)get()).isVisible();
    }
}
