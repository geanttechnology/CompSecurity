// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdController, AdListener, AdProperties

class val.props
    implements Runnable
{

    final AdController this$0;
    final AdProperties val$props;

    public void run()
    {
        AdController.access$200(AdController.this).onAdLoaded(AdController.access$100(AdController.this), val$props);
        AdController.access$300(AdController.this, true);
    }

    ()
    {
        this$0 = final_adcontroller;
        val$props = AdProperties.this;
        super();
    }
}
