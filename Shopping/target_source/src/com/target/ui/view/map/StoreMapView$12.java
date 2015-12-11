// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import com.pointinside.maps.CameraAnimation;
import com.pointinside.maps.Location;
import com.pointinside.maps.PIMap;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class val.cameraAnimation
    implements Runnable
{

    final StoreMapView this$0;
    final CameraAnimation val$cameraAnimation;
    final Location val$location;
    final float val$zoomPercent;

    public void run()
    {
        StoreMapView.i(StoreMapView.this).animateCamera((new com.pointinside.maps.model.uilder(StoreMapView.i(StoreMapView.this).getCameraPosition())).pointInZone(val$location.getMapPoint()).zoomPercent(val$zoomPercent).build(), new com.pointinside.maps.PIMap.CameraCallback() {

            final StoreMapView._cls12 this$1;

            public void onCameraSet()
            {
                StoreMapView.j(this$0);
            }

            
            {
                this$1 = StoreMapView._cls12.this;
                super();
            }
        }, val$cameraAnimation);
    }

    _cls1.this._cls1()
    {
        this$0 = final_storemapview;
        val$location = location1;
        val$zoomPercent = f;
        val$cameraAnimation = CameraAnimation.this;
        super();
    }
}
