// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.utils.BundleFlowHandler;
import com.poshmark.utils.FBDPAHelper;

// Referenced classes of package com.poshmark.ui.fragments:
//            ViewBundleFragment

class this._cls0
    implements android.view.leFragment._cls5
{

    final ViewBundleFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "buy_bundle_tapped", null);
        FBDPAHelper.trackBundlePurchaseInitiated(bundleData);
        (new BundleFlowHandler(ViewBundleFragment.this)).beginCheckoutForBundle(bundleData);
    }

    ()
    {
        this$0 = ViewBundleFragment.this;
        super();
    }
}
