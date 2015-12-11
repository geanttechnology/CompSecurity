// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.model.Marker;
import com.amazon.geo.mapsv2.model.internal.IMarkerDelegate;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import com.amazon.geo.mapsv2.pvt.Wrappers;

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

    public void onMarkerDrag(IMarkerDelegate imarkerdelegate)
    {
        ((<init>)get()).Drag((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
    }

    public void onMarkerDragEnd(IMarkerDelegate imarkerdelegate)
    {
        ((Drag)get()).DragEnd((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
    }

    public void onMarkerDragStart(IMarkerDelegate imarkerdelegate)
    {
        ((DragEnd)get()).DragStart((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
    }


    private enerDelegate(enerDelegate enerdelegate)
    {
        super(enerdelegate);
    }
}
