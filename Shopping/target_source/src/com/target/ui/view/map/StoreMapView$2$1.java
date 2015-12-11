// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import com.pointinside.maps.Location;
import com.pointinside.maps.PIMap;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class this._cls1
    implements com.pointinside.maps.ack
{

    final is._cls0 this$1;

    public void onCameraSet()
    {
        if (StoreMapView.k(_fld0) != null)
        {
            StoreMapView.k(_fld0).();
        }
    }

    l.zoomPercent()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/target/ui/view/map/StoreMapView$2

/* anonymous class */
    class StoreMapView._cls2
        implements Runnable
    {

        final StoreMapView this$0;
        final float val$angleDegrees;
        final Location val$location;
        final float val$zoomPercent;

        public void run()
        {
            StoreMapView.i(StoreMapView.this).moveCamera((new com.pointinside.maps.model.CameraPosition.Builder(StoreMapView.i(StoreMapView.this).getCameraPosition())).pointInZone(location.getMapPoint()).rotation(angleDegrees).zoomPercent(zoomPercent).build(), new StoreMapView._cls2._cls1());
        }

            
            {
                this$0 = final_storemapview;
                location = location1;
                angleDegrees = f;
                zoomPercent = F.this;
                super();
            }
    }

}
