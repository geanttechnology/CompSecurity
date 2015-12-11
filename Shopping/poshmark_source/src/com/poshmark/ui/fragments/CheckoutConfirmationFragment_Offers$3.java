// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.utils.CheckoutFlowHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment_Offers

class this._cls0
    implements android.view.ent_Offers._cls3
{

    final CheckoutConfirmationFragment_Offers this$0;

    public void onClick(View view)
    {
        view = flowHandler.getPoshmarkOrder().getOrderId();
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "offer_submit_button_tapped", view);
        CheckoutConfirmationFragment_Offers.access$000(CheckoutConfirmationFragment_Offers.this);
    }

    ()
    {
        this$0 = CheckoutConfirmationFragment_Offers.this;
        super();
    }
}
