// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItItemImageSearchController, ViewItScannedItemAnimationFrame, ViewItMetricHelper

class val.sc
    implements Runnable
{

    final ViewItItemImageSearchController this$0;
    final ServiceCall val$sc;

    public void run()
    {
        if (ViewItItemImageSearchController.access$000(ViewItItemImageSearchController.this) == val$sc)
        {
            ViewItItemImageSearchController.access$300(ViewItItemImageSearchController.this).dismissAnimationWindow(true);
            ViewItItemImageSearchController.access$002(ViewItItemImageSearchController.this, null);
            ViewItItemImageSearchController.access$100(ViewItItemImageSearchController.this).cancelFlowImageSuccessObserver();
            ViewItItemImageSearchController.access$100(ViewItItemImageSearchController.this).cancelFlowImageFailObserver();
        }
    }

    ()
    {
        this$0 = final_viewititemimagesearchcontroller;
        val$sc = ServiceCall.this;
        super();
    }
}
