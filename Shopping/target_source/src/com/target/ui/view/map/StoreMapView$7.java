// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;


// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class this._cls0
    implements com.pointinside.maps.lback
{

    final StoreMapView this$0;

    public void onCameraSet()
    {
        if (StoreMapView.d(StoreMapView.this) != null)
        {
            StoreMapView.d(StoreMapView.this).onCameraSet();
        }
    }

    ack()
    {
        this$0 = StoreMapView.this;
        super();
    }
}
