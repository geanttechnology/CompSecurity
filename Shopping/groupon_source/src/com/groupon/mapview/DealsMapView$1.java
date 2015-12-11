// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import com.google.android.gms.maps.model.Marker;
import com.groupon.adapter.DealClickListener;
import java.util.HashMap;

// Referenced classes of package com.groupon.mapview:
//            DealsMapView

class this._cls0
    implements com.google.android.gms.maps.oWindowClickListener
{

    final DealsMapView this$0;

    public void onInfoWindowClick(Marker marker)
    {
        if (DealsMapView.access$000(DealsMapView.this) != null)
        {
            marker = (alSummaryMarkerContainer)DealsMapView.access$100(DealsMapView.this).get(marker.getTitle());
            if (marker != null && alSummaryMarkerContainer.access._mth200(marker) != null)
            {
                DealsMapView.access$000(DealsMapView.this).onDealClicked(-1, alSummaryMarkerContainer.access._mth200(marker));
            }
        }
    }

    arker()
    {
        this$0 = DealsMapView.this;
        super();
    }
}
