// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.barcodeSearch;


// Referenced classes of package com.amazon.mShop.control.barcodeSearch:
//            BarcodeSearchController, BarcodeSearchSubscriber

class val.value
    implements Runnable
{

    final BarcodeSearchController this$0;
    final String val$value;

    public void run()
    {
        BarcodeSearchController.access$802(BarcodeSearchController.this, val$value);
        BarcodeSearchController.access$300(BarcodeSearchController.this).onResultsTitleReceived(val$value);
    }

    ()
    {
        this$0 = final_barcodesearchcontroller;
        val$value = String.this;
        super();
    }
}
