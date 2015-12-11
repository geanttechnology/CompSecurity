// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.barcodeSearch;

import com.amazon.rio.j2me.client.services.mShop.SearchResult;

// Referenced classes of package com.amazon.mShop.control.barcodeSearch:
//            BarcodeSearchController, BarcodeSearchSubscriber

class val.value
    implements Runnable
{

    final BarcodeSearchController this$0;
    final SearchResult val$value;

    public void run()
    {
        BarcodeSearchController.access$402(BarcodeSearchController.this, val$value);
        BarcodeSearchController.access$300(BarcodeSearchController.this).onMatchedItemReceived(val$value);
    }

    ()
    {
        this$0 = final_barcodesearchcontroller;
        val$value = SearchResult.this;
        super();
    }
}
