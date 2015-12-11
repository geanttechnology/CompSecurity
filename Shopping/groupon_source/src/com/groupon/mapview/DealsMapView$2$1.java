// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import android.view.View;
import com.google.android.gms.maps.model.Marker;

// Referenced classes of package com.groupon.mapview:
//            DealsMapView

class this._cls1
    implements WindowImageLoadedListener
{

    final ker.showInfoWindow this$1;

    public void onImageLoaded(Marker marker)
    {
        if (marker.isInfoWindowShown())
        {
            marker.hideInfoWindow();
            marker.showInfoWindow();
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/mapview/DealsMapView$2

/* anonymous class */
    class DealsMapView._cls2
        implements com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    {

        final DealsMapView this$0;

        public View getInfoContents(Marker marker)
        {
            return null;
        }

        public View getInfoWindow(Marker marker)
        {
            DealsMapView.MerchantMapDetail merchantmapdetail = new DealsMapView.MerchantMapDetail(DealsMapView.this, getContext());
            if (DealsMapView.access$300(DealsMapView.this) == null || !DealsMapView.access$300(DealsMapView.this).equals(marker))
            {
                merchantmapdetail.setListener(new DealsMapView._cls2._cls1());
            }
            merchantmapdetail.setData(marker);
            DealsMapView.access$302(DealsMapView.this, marker);
            return merchantmapdetail;
        }

            
            {
                this$0 = DealsMapView.this;
                super();
            }
    }

}
