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
    final Boolean val$value;

    public void run()
    {
        BarcodeSearchController.access$602(BarcodeSearchController.this, val$value.booleanValue());
        BarcodeSearchController.access$300(BarcodeSearchController.this).onMatchedItemsReturnedReceived(val$value.booleanValue());
    }

    ()
    {
        this$0 = final_barcodesearchcontroller;
        val$value = Boolean.this;
        super();
    }
}
