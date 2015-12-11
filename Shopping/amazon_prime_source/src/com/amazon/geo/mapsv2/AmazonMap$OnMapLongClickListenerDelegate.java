// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.model.pvt.Primitives;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMap

private static class enerDelegate extends PrimitiveBase
    implements com.amazon.geo.mapsv2.internal.ate
{

    private static com.amazon.geo.mapsv2.internal.ate create(enerDelegate enerdelegate)
    {
        if (enerdelegate == null)
        {
            return null;
        } else
        {
            return new <init>(enerdelegate);
        }
    }

    public void onMapLongClick(ILatLngPrimitive ilatlngprimitive)
    {
        ((<init>)get()).gClick(Primitives.create(ilatlngprimitive));
    }


    public enerDelegate(enerDelegate enerdelegate)
    {
        super(enerdelegate);
    }
}
