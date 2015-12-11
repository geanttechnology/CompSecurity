// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.res.Resources;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItItemBarcodeSearchController, ViewItMetricHelper, ViewItSearchResultWrapper, ViewItScannedItemAnimationFrame, 
//            ViewItUtil, ViewItActivity

class val.sc
    implements Runnable
{

    final ViewItItemBarcodeSearchController this$0;
    final ServiceCall val$sc;

    public void run()
    {
        if (ViewItItemBarcodeSearchController.access$000(ViewItItemBarcodeSearchController.this) != val$sc) goto _L2; else goto _L1
_L1:
        Object obj;
        String s;
        int i;
        ViewItItemBarcodeSearchController.access$100(ViewItItemBarcodeSearchController.this).cancelFlowBarcodeFailObserver();
        obj = new ArrayList();
        i = ViewItItemBarcodeSearchController.access$200(ViewItItemBarcodeSearchController.this);
        s = (new StringBuilder()).append(this._fld0.e()).append(ViewItItemBarcodeSearchController.access$300(ViewItItemBarcodeSearchController.this)).toString();
        if (i != 1) goto _L4; else goto _L3
_L3:
        ((List) (obj)).add(ViewItItemBarcodeSearchController.access$400(ViewItItemBarcodeSearchController.this));
        obj = new ViewItSearchResultWrapper(s, ((List) (obj)), null, ViewItSearchResultWrapper.getCurrentDate(), true);
        ViewItItemBarcodeSearchController.access$500(ViewItItemBarcodeSearchController.this).updateToShowItemContentInLoadingWindow(((ViewItSearchResultWrapper) (obj)));
        ViewItItemBarcodeSearchController.access$100(ViewItItemBarcodeSearchController.this).cancelFlowBarcodeNoMatchesObserver();
        ViewItItemBarcodeSearchController.access$100(ViewItItemBarcodeSearchController.this).finishFlowBarcodeSuccessObserver();
        RefMarkerObserver.logRefMarker("fl_barcode_success");
_L6:
        ViewItItemBarcodeSearchController.access$002(ViewItItemBarcodeSearchController.this, null);
_L2:
        return;
_L4:
        if (i == 2)
        {
            if (ViewItItemBarcodeSearchController.access$400(ViewItItemBarcodeSearchController.this) != null)
            {
                ((List) (obj)).add(ViewItItemBarcodeSearchController.access$400(ViewItItemBarcodeSearchController.this));
            }
            if (!Util.isEmpty(ViewItItemBarcodeSearchController.access$600(ViewItItemBarcodeSearchController.this)))
            {
                ViewItUtil.removeIfContained(ViewItItemBarcodeSearchController.access$600(ViewItItemBarcodeSearchController.this), ViewItItemBarcodeSearchController.access$400(ViewItItemBarcodeSearchController.this));
                ((List) (obj)).addAll(ViewItItemBarcodeSearchController.access$600(ViewItItemBarcodeSearchController.this));
            }
            obj = new ViewItSearchResultWrapper(s, ((List) (obj)), null, ViewItSearchResultWrapper.getCurrentDate(), true);
            ViewItItemBarcodeSearchController.access$500(ViewItItemBarcodeSearchController.this).updateToShowItemContentInLoadingWindow(((ViewItSearchResultWrapper) (obj)));
            ViewItItemBarcodeSearchController.access$100(ViewItItemBarcodeSearchController.this).cancelFlowBarcodeNoMatchesObserver();
            ViewItItemBarcodeSearchController.access$100(ViewItItemBarcodeSearchController.this).finishFlowBarcodeSuccessObserver();
            RefMarkerObserver.logRefMarker("fl_barcode_success");
        } else
        if (i == 0)
        {
            ViewItItemBarcodeSearchController.access$500(ViewItItemBarcodeSearchController.this).showServiceCallErrorInLoadingWindow(null, ViewItItemBarcodeSearchController.access$700(ViewItItemBarcodeSearchController.this).getResources().getString(com.amazon.mShop.android.lib.em_found), NO_MATCHED_ITEM);
            ViewItItemBarcodeSearchController.access$100(ViewItItemBarcodeSearchController.this).finishFlowBarcodeNoMatchesObserver();
            ViewItItemBarcodeSearchController.access$100(ViewItItemBarcodeSearchController.this).cancelFlowBarcodeSuccessObserver();
            RefMarkerObserver.logRefMarker("fl_barcode_nomatch");
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    ()
    {
        this$0 = final_viewititembarcodesearchcontroller;
        val$sc = ServiceCall.this;
        super();
    }
}
