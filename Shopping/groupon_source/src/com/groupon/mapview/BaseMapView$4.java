// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;


// Referenced classes of package com.groupon.mapview:
//            BaseMapView

class Callback
    implements Runnable
{

    final BaseMapView this$0;
    final com.google.android.gms.maps.elableCallback val$callback;

    public void run()
    {
        val$callback.onFinish();
    }

    Callback()
    {
        this$0 = final_basemapview;
        val$callback = com.google.android.gms.maps.elableCallback.this;
        super();
    }
}
