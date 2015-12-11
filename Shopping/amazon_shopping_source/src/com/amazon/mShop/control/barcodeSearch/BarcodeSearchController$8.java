// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.barcodeSearch;

import com.amazon.rio.j2me.client.services.mShop.SearchResult;

// Referenced classes of package com.amazon.mShop.control.barcodeSearch:
//            BarcodeSearchController, BarcodeSearchSubscriber

class val.index
    implements Runnable
{

    final BarcodeSearchController this$0;
    final int val$index;
    final SearchResult val$value;

    public void run()
    {
        BarcodeSearchController.access$300(BarcodeSearchController.this).onSearchResultReceived(val$value, val$index);
    }

    ()
    {
        this$0 = final_barcodesearchcontroller;
        val$value = searchresult;
        val$index = I.this;
        super();
    }
}
