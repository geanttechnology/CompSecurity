// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.utils.CheckoutFlowHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment

class this._cls0
    implements android.view.onFragment._cls3
{

    final CheckoutConfirmationFragment this$0;

    public void onClick(View view)
    {
        if (flowHandler.getPoshmarkOrder().isOrderCheckoutTypeBundle())
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "submit_order", null);
        } else
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "submit_order", null);
        }
        CheckoutConfirmationFragment.access$000(CheckoutConfirmationFragment.this);
    }

    ()
    {
        this$0 = CheckoutConfirmationFragment.this;
        super();
    }
}
