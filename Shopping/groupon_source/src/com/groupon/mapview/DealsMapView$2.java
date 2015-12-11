// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import android.view.View;
import com.google.android.gms.maps.model.Marker;

// Referenced classes of package com.groupon.mapview:
//            DealsMapView

class this._cls0
    implements com.google.android.gms.maps.indowAdapter
{

    final DealsMapView this$0;

    public View getInfoContents(Marker marker)
    {
        return null;
    }

    public View getInfoWindow(Marker marker)
    {
        rchantMapDetail rchantmapdetail = new rchantMapDetail(DealsMapView.this, getContext());
        if (DealsMapView.access$300(DealsMapView.this) == null || !DealsMapView.access$300(DealsMapView.this).equals(marker))
        {
            rchantmapdetail.setListener(new DealsMapView.InfoWindowImageLoadedListener() {

                final DealsMapView._cls2 this$1;

                public void onImageLoaded(Marker marker1)
                {
                    if (marker1.isInfoWindowShown())
                    {
                        marker1.hideInfoWindow();
                        marker1.showInfoWindow();
                    }
                }

            
            {
                this$1 = DealsMapView._cls2.this;
                super();
            }
            });
        }
        rchantmapdetail.setData(marker);
        DealsMapView.access$302(DealsMapView.this, marker);
        return rchantmapdetail;
    }

    _cls1.this._cls1()
    {
        this$0 = DealsMapView.this;
        super();
    }
}
