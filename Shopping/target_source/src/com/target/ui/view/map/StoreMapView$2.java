// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import com.pointinside.maps.Location;
import com.pointinside.maps.PIMap;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class val.zoomPercent
    implements Runnable
{

    final StoreMapView this$0;
    final float val$angleDegrees;
    final Location val$location;
    final float val$zoomPercent;

    public void run()
    {
        StoreMapView.i(StoreMapView.this).moveCamera((new com.pointinside.maps.model.Builder(StoreMapView.i(StoreMapView.this).getCameraPosition())).pointInZone(val$location.getMapPoint()).rotation(val$angleDegrees).zoomPercent(val$zoomPercent).build(), new com.pointinside.maps.PIMap.CameraCallback() {

            final StoreMapView._cls2 this$1;

            public void onCameraSet()
            {
                if (StoreMapView.k(this$0) != null)
                {
                    StoreMapView.k(this$0).C();
                }
            }

            
            {
                this$1 = StoreMapView._cls2.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_storemapview;
        val$location = location1;
        val$angleDegrees = f;
        val$zoomPercent = F.this;
        super();
    }
}
