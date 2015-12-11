// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;


// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class this._cls0
    implements com.pointinside.maps.dCallback
{

    final StoreMapView this$0;

    public void postZoneLoad(String s, int i, int j)
    {
        if (StoreMapView.f(StoreMapView.this) != null)
        {
            StoreMapView.f(StoreMapView.this).postZoneLoad(s, i, j);
        }
    }

    public void preZoneLoad(String s, int i, int j)
    {
        if (StoreMapView.f(StoreMapView.this) != null)
        {
            StoreMapView.f(StoreMapView.this).preZoneLoad(s, i, j);
        }
    }

    allback()
    {
        this$0 = StoreMapView.this;
        super();
    }
}
