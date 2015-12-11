// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItItemBarcodeSearchController

class val.value
    implements Runnable
{

    final ViewItItemBarcodeSearchController this$0;
    final ServiceCall val$sc;
    final SearchResult val$value;

    public void run()
    {
        if (ViewItItemBarcodeSearchController.access$000(ViewItItemBarcodeSearchController.this) == val$sc)
        {
            ViewItItemBarcodeSearchController.access$402(ViewItItemBarcodeSearchController.this, val$value);
        }
    }

    ()
    {
        this$0 = final_viewititembarcodesearchcontroller;
        val$sc = servicecall;
        val$value = SearchResult.this;
        super();
    }
}
