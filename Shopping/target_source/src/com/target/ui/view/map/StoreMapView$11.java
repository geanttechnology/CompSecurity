// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.graphics.PointF;
import com.pointinside.maps.Marker;
import java.util.Map;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class this._cls0
    implements com.pointinside.maps.ickListener
{

    final StoreMapView this$0;

    public void onMarkerClick(Marker marker, PointF pointf, PointF pointf1)
    {
label0:
        {
            if (StoreMapView.h(StoreMapView.this) != null)
            {
                pointf = (this._cls0)StoreMapView.c(StoreMapView.this).get(marker);
                if (StoreMapView.b(StoreMapView.this) != marker)
                {
                    break label0;
                }
                StoreMapView.a(StoreMapView.this, null);
                StoreMapView.h(StoreMapView.this).((pointf));
            }
            return;
        }
        StoreMapView.a(StoreMapView.this, marker);
        StoreMapView.h(StoreMapView.this).((pointf));
    }

    kListener()
    {
        this$0 = StoreMapView.this;
        super();
    }
}
