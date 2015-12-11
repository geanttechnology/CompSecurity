// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.groupon.mapview:
//            BaseMapView

class this._cls0
    implements com.google.android.gms.maps.meraChangeListener
{

    final BaseMapView this$0;

    public void onCameraChange(CameraPosition cameraposition)
    {
        if (googleMap != null)
        {
            if (lastCameraUpdate != null)
            {
                googleMap.moveCamera(lastCameraUpdate);
            }
            lastCameraUpdate = null;
            googleMap.setOnCameraChangeListener(null);
        }
    }

    CameraPosition()
    {
        this$0 = BaseMapView.this;
        super();
    }
}
