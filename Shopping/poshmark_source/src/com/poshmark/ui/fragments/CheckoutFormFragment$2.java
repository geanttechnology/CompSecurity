// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import android.widget.CheckBox;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.data_model.models.inner_models.Address;
import com.poshmark.utils.CheckoutFlowHandler;
import com.poshmark.utils.view_holders.CheckoutFormViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

class this._cls0
    implements android.view.rmFragment._cls2
{

    final CheckoutFormFragment this$0;

    public void onClick(View view)
    {
        if (CheckoutFormFragment.access$100(CheckoutFormFragment.this))
        {
            if (CheckoutFormFragment.access$400(CheckoutFormFragment.this) == ECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD)
            {
                CheckoutFormFragment.access$200(CheckoutFormFragment.this);
                view = CheckoutFormFragment.access$000(CheckoutFormFragment.this).getPoshmarkOrder().getOrderId();
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "update_credit_card", view);
                if (CheckoutFormFragment.access$500(CheckoutFormFragment.this).billingCheckbox.isChecked())
                {
                    CheckoutFormFragment.access$700(CheckoutFormFragment.this).copy(CheckoutFormFragment.access$600(CheckoutFormFragment.this));
                } else
                {
                    CheckoutFormFragment.access$800(CheckoutFormFragment.this);
                }
                CheckoutFormFragment.access$900(CheckoutFormFragment.this);
            } else
            if (CheckoutFormFragment.access$400(CheckoutFormFragment.this) == ECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS)
            {
                view = CheckoutFormFragment.access$000(CheckoutFormFragment.this).getPoshmarkOrder().getOrderId();
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "update_shipping_address", view);
                CheckoutFormFragment.access$300(CheckoutFormFragment.this);
                return;
            }
        }
    }

    ss()
    {
        this$0 = CheckoutFormFragment.this;
        super();
    }
}
