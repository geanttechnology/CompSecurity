// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItItemBarcodeSearchController, ViewItScannedItemAnimationFrame, ViewItMetricHelper

class val.sc
    implements Runnable
{

    final ViewItItemBarcodeSearchController this$0;
    final ServiceCall val$sc;

    public void run()
    {
        if (ViewItItemBarcodeSearchController.access$000(ViewItItemBarcodeSearchController.this) == val$sc)
        {
            ViewItItemBarcodeSearchController.access$500(ViewItItemBarcodeSearchController.this).dismissAnimationWindow(true);
            ViewItItemBarcodeSearchController.access$002(ViewItItemBarcodeSearchController.this, null);
            ViewItItemBarcodeSearchController.access$100(ViewItItemBarcodeSearchController.this).cancelFlowBarcodeNoMatchesObserver();
            ViewItItemBarcodeSearchController.access$100(ViewItItemBarcodeSearchController.this).cancelFlowBarcodeFailObserver();
            ViewItItemBarcodeSearchController.access$100(ViewItItemBarcodeSearchController.this).cancelFlowBarcodeSuccessObserver();
        }
    }

    ()
    {
        this$0 = final_viewititembarcodesearchcontroller;
        val$sc = ServiceCall.this;
        super();
    }
}
