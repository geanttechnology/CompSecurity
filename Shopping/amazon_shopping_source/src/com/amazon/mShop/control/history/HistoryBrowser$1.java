// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.history;

import com.amazon.mShop.control.home.BasicProductsSubscriber;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;

// Referenced classes of package com.amazon.mShop.control.history:
//            HistoryBrowser

class val.sc
    implements Runnable
{

    final HistoryBrowser this$0;
    final BasicProductsResponse val$response;
    final ServiceCall val$sc;

    public void run()
    {
        HistoryBrowser.access$000(HistoryBrowser.this, val$response.getProducts(), val$sc);
        HistoryBrowser.access$100(HistoryBrowser.this).onBasicProductsReceived(val$response);
    }

    ductsResponse()
    {
        this$0 = final_historybrowser;
        val$response = basicproductsresponse;
        val$sc = ServiceCall.this;
        super();
    }
}
