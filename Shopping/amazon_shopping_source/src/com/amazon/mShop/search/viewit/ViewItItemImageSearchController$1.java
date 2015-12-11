// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.res.Resources;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItItemImageSearchController, ViewItMetricHelper, ViewItSearchResultWrapper, ViewItScannedItemAnimationFrame, 
//            ViewItActivity

class val.value
    implements Runnable
{

    final ViewItItemImageSearchController this$0;
    final ServiceCall val$sc;
    final BasicProductsResponse val$value;

    public void run()
    {
        if (ViewItItemImageSearchController.access$000(ViewItItemImageSearchController.this) == val$sc)
        {
            ViewItItemImageSearchController.access$100(ViewItItemImageSearchController.this).cancelFlowImageFailObserver();
            Object obj = val$value.getProducts();
            if (!Util.isEmpty(((java.util.Collection) (obj))))
            {
                obj = new ViewItSearchResultWrapper(ViewItItemImageSearchController.access$200(ViewItItemImageSearchController.this), ((java.util.List) (obj)), null, ViewItSearchResultWrapper.getCurrentDate(), true);
                ViewItItemImageSearchController.access$300(ViewItItemImageSearchController.this).updateToShowItemContentInLoadingWindow(((ViewItSearchResultWrapper) (obj)));
                ViewItItemImageSearchController.access$100(ViewItItemImageSearchController.this).finishFlowImageSuccessObserver();
                RefMarkerObserver.logRefMarker("fl_image_success");
            } else
            {
                ViewItItemImageSearchController.access$300(ViewItItemImageSearchController.this).showServiceCallErrorInLoadingWindow(null, ViewItItemImageSearchController.access$400(ViewItItemImageSearchController.this).getResources().getString(com.amazon.mShop.android.lib.item_found), R_NO_MATCHED_ITEM);
                ViewItItemImageSearchController.access$100(ViewItItemImageSearchController.this).cancelFlowImageSuccessObserver();
            }
            ViewItItemImageSearchController.access$002(ViewItItemImageSearchController.this, null);
        }
    }

    ()
    {
        this$0 = final_viewititemimagesearchcontroller;
        val$sc = servicecall;
        val$value = BasicProductsResponse.this;
        super();
    }
}
