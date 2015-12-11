// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.utils.CheckoutFlowHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

class this._cls0
    implements android.view.rmFragment._cls1
{

    final CheckoutFormFragment this$0;

    public void onClick(View view)
    {
        boolean flag = CheckoutFormFragment.access$000(CheckoutFormFragment.this).getPoshmarkOrder().isOrderCheckoutTypeBundle();
        CheckoutFormFragment.access$000(CheckoutFormFragment.this).getPoshmarkOrder().getOrderId();
        view = CheckoutFormFragment.access$000(CheckoutFormFragment.this).getPoshmarkOffer();
        if (flag)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "secure_checkout", null);
        } else
        if (view != null)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "offer_payment_and_shipping_entered_next_tapped", null);
        } else
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "secure_checkout", null);
        }
        if (CheckoutFormFragment.access$100(CheckoutFormFragment.this))
        {
            CheckoutFormFragment.access$200(CheckoutFormFragment.this);
            CheckoutFormFragment.access$300(CheckoutFormFragment.this);
        }
    }

    ()
    {
        this$0 = CheckoutFormFragment.this;
        super();
    }
}
