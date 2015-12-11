// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;

import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control:
//            PagedListingBrowser

class val.objects
    implements Runnable
{

    final PagedListingBrowser this$0;
    final List val$objects;
    final ServiceCall val$sc;

    public void run()
    {
        if (val$sc == currentRequest && !PagedListingBrowser.access$000(PagedListingBrowser.this))
        {
            listingObjects.addAll(val$objects);
            PagedListingBrowser.access$300(PagedListingBrowser.this);
            requestFinished(0, null, val$sc);
        }
    }

    ()
    {
        this$0 = final_pagedlistingbrowser;
        val$sc = servicecall;
        val$objects = List.this;
        super();
    }
}
