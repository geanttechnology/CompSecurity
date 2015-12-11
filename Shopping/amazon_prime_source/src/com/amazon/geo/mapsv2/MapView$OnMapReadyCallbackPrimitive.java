// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.IMapDelegate;
import com.amazon.geo.mapsv2.internal.IOnMapReadyCallbackPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2:
//            MapView, AmazonMap, OnMapReadyCallback

private static class e extends PrimitiveBase
    implements IOnMapReadyCallbackPrimitive
{

    private static e wrap(OnMapReadyCallback onmapreadycallback)
    {
        if (onmapreadycallback == null)
        {
            return null;
        } else
        {
            return new <init>(onmapreadycallback);
        }
    }

    public void onMapReady(IMapDelegate imapdelegate)
    {
        AmazonMap amazonmap = (AmazonMap)imapdelegate.getWrapper();
        if (amazonmap != null)
        {
            ((OnMapReadyCallback)get()).onMapReady(amazonmap);
            return;
        } else
        {
            ((OnMapReadyCallback)get()).onMapReady(new AmazonMap(imapdelegate));
            return;
        }
    }


    private e(OnMapReadyCallback onmapreadycallback)
    {
        super(onmapreadycallback);
    }
}
