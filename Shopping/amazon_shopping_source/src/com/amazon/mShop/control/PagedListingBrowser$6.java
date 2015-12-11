// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;

import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control:
//            PagedListingBrowser

class val.requestFinished
    implements Runnable
{

    final PagedListingBrowser this$0;
    final List val$objects;
    final boolean val$requestFinished;
    final ServiceCall val$sc;

    public void run()
    {
        if (val$sc == currentRequest && !PagedListingBrowser.access$000(PagedListingBrowser.this))
        {
            if (!Util.isEmpty(val$objects))
            {
                listingObjects.addAll(val$objects);
            }
            PagedListingBrowser.access$300(PagedListingBrowser.this);
            if (val$requestFinished)
            {
                PagedListingBrowser.this.requestFinished(0, null, val$sc);
            }
        }
    }

    ()
    {
        this$0 = final_pagedlistingbrowser;
        val$sc = servicecall;
        val$objects = list;
        val$requestFinished = Z.this;
        super();
    }
}
