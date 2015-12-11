// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.view.View;
import com.amazon.geo.mapsv2.model.Marker;
import com.amazon.geo.mapsv2.model.internal.IMarkerDelegate;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import com.amazon.geo.mapsv2.pvt.Wrappers;

// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMap

private static class pterDelegate extends PrimitiveBase
    implements com.amazon.geo.mapsv2.internal.ate
{

    private static com.amazon.geo.mapsv2.internal.ate create(pterDelegate pterdelegate)
    {
        if (pterdelegate == null)
        {
            return null;
        } else
        {
            return new <init>(pterdelegate);
        }
    }

    public View getInfoContents(IMarkerDelegate imarkerdelegate)
    {
        return ((<init>)get()).ontents((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
    }

    public View getInfoWindow(IMarkerDelegate imarkerdelegate)
    {
        return ((ontents)get()).indow((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
    }


    private pterDelegate(pterDelegate pterdelegate)
    {
        super(pterdelegate);
    }
}
