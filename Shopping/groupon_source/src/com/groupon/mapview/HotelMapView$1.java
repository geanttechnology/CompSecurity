// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import com.google.android.gms.maps.model.Marker;
import java.util.List;

// Referenced classes of package com.groupon.mapview:
//            HotelMapView

class this._cls0
    implements arkerClickListener
{

    final HotelMapView this$0;

    public boolean onMarkerClicked(Marker marker)
    {
        marker.showInfoWindow();
        if (HotelMapView.access$000(HotelMapView.this) != null)
        {
            int i = markerList.indexOf(marker);
            HotelMapView.access$000(HotelMapView.this).onHotelClicked(i);
            setSelectedMarker(i, true, false);
            return true;
        } else
        {
            return false;
        }
    }

    arker()
    {
        this$0 = HotelMapView.this;
        super();
    }
}
