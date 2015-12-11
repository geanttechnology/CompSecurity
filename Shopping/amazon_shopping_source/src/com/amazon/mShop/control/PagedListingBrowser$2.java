// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control:
//            PagedListingBrowser

class val.availableCount
    implements Runnable
{

    final PagedListingBrowser this$0;
    final int val$availableCount;
    final ServiceCall val$serviceCall;

    public void run()
    {
        if (val$serviceCall == currentRequest && val$availableCount != PagedListingBrowser.access$100(PagedListingBrowser.this))
        {
            PagedListingBrowser.access$102(PagedListingBrowser.this, val$availableCount);
            PagedListingBrowser.access$200(PagedListingBrowser.this);
        }
    }

    ()
    {
        this$0 = final_pagedlistingbrowser;
        val$serviceCall = servicecall;
        val$availableCount = I.this;
        super();
    }
}
