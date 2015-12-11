// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import java.util.Map;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class this._cls0
    implements com.pointinside.maps.lback
{

    final StoreMapView this$0;

    public void onCameraSet()
    {
        if (StoreMapView.a(StoreMapView.this) != null && (this._cls0)StoreMapView.c(StoreMapView.this).get(StoreMapView.b(StoreMapView.this)) != null)
        {
            StoreMapView.a(StoreMapView.this).();
        }
    }

    ack()
    {
        this$0 = StoreMapView.this;
        super();
    }
}
