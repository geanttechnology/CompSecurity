// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.groupon.mapview:
//            DealsMapView

class this._cls0
    implements com.google.android.gms.maps.eraChangeListener
{

    final DealsMapView this$0;

    public void onCameraChange(CameraPosition cameraposition)
    {
        cameraposition = getGoogleMap();
        if (cameraposition != null && getHeight() > 0 && getWidth() > 0)
        {
            if (DealsMapView.access$400(DealsMapView.this) != null)
            {
                cameraposition.moveCamera(DealsMapView.access$400(DealsMapView.this));
            }
            DealsMapView.access$402(DealsMapView.this, null);
            cameraposition.setOnCameraChangeListener(null);
        }
    }

    ameraPosition()
    {
        this$0 = DealsMapView.this;
        super();
    }
}
