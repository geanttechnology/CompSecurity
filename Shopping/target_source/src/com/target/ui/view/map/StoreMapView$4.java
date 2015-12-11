// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import com.pointinside.maps.Marker;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class this._cls0
    implements Runnable
{

    final StoreMapView this$0;

    public void run()
    {
        if (StoreMapView.m(StoreMapView.this) != null)
        {
            StoreMapView.m(StoreMapView.this).remove();
            StoreMapView.b(StoreMapView.this, null);
        }
    }

    ()
    {
        this$0 = StoreMapView.this;
        super();
    }
}
