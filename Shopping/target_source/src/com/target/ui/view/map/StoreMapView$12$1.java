// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import com.pointinside.maps.CameraAnimation;
import com.pointinside.maps.Location;
import com.pointinside.maps.PIMap;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class this._cls1
    implements com.pointinside.maps.ck
{

    final is._cls0 this$1;

    public void onCameraSet()
    {
        StoreMapView.j(_fld0);
    }

    l.cameraAnimation()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/target/ui/view/map/StoreMapView$12

/* anonymous class */
    class StoreMapView._cls12
        implements Runnable
    {

        final StoreMapView this$0;
        final CameraAnimation val$cameraAnimation;
        final Location val$location;
        final float val$zoomPercent;

        public void run()
        {
            StoreMapView.i(StoreMapView.this).animateCamera((new com.pointinside.maps.model.CameraPosition.Builder(StoreMapView.i(StoreMapView.this).getCameraPosition())).pointInZone(location.getMapPoint()).zoomPercent(zoomPercent).build(), new StoreMapView._cls12._cls1(), cameraAnimation);
        }

            
            {
                this$0 = final_storemapview;
                location = location1;
                zoomPercent = f;
                cameraAnimation = CameraAnimation.this;
                super();
            }
    }

}
