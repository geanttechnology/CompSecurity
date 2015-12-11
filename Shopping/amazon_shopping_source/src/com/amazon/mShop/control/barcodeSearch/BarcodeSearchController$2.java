// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.barcodeSearch;


// Referenced classes of package com.amazon.mShop.control.barcodeSearch:
//            BarcodeSearchController, BarcodeSearchSubscriber

class val.index
    implements Runnable
{

    final BarcodeSearchController this$0;
    final int val$index;
    final byte val$value[];

    public void run()
    {
        BarcodeSearchController.access$300(BarcodeSearchController.this).onImageReceived(val$value, val$index);
    }

    ()
    {
        this$0 = final_barcodesearchcontroller;
        val$value = abyte0;
        val$index = I.this;
        super();
    }
}
