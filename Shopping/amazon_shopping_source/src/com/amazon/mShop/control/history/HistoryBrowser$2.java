// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.history;

import com.amazon.mShop.control.home.BasicProductsSubscriber;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control.history:
//            HistoryBrowser

class val.exp
    implements Runnable
{

    final HistoryBrowser this$0;
    final Exception val$exp;
    final ServiceCall val$sc;

    public void run()
    {
        cancelled(val$sc);
        HistoryBrowser.access$100(HistoryBrowser.this).onError(val$exp, val$sc);
    }

    ber()
    {
        this$0 = final_historybrowser;
        val$sc = servicecall;
        val$exp = Exception.this;
        super();
    }
}
