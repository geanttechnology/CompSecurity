// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;


// Referenced classes of package com.target.ui.view.map:
//            StoreMapView

class val.listener
    implements com.pointinside.maps.lback
{

    final StoreMapView this$0;
    final com.target.ui.fragment.map.a.stener val$listener;

    public void onCameraSet()
    {
        if (val$listener == null)
        {
            return;
        } else
        {
            val$listener.stener();
            return;
        }
    }

    ack()
    {
        this$0 = final_storemapview;
        val$listener = com.target.ui.fragment.map.a.stener.this;
        super();
    }
}
