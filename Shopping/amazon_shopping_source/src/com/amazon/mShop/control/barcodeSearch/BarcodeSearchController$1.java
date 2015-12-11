// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.barcodeSearch;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control.barcodeSearch:
//            BarcodeSearchController, BarcodeSearchSubscriber

class val.sc
    implements Runnable
{

    final BarcodeSearchController this$0;
    final ServiceCall val$sc;

    public void run()
    {
        BarcodeSearchController.access$002(BarcodeSearchController.this, 2);
        if (BarcodeSearchController.access$100(BarcodeSearchController.this, val$sc))
        {
            BarcodeSearchController.access$200(BarcodeSearchController.this);
            BarcodeSearchController.access$300(BarcodeSearchController.this).onCompleted();
        }
    }

    ()
    {
        this$0 = final_barcodesearchcontroller;
        val$sc = ServiceCall.this;
        super();
    }
}
