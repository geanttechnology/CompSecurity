// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.PMOfferInfo;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.data_model.models.inner_models.CreditCard;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.CheckoutFlowHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

class this._cls0
    implements PMApiResponseHandler
{

    final CheckoutFormFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (!isAdded()) goto _L2; else goto _L1
_L1:
        hideProgressDialog();
        if (pmapiresponse.hasError()) goto _L4; else goto _L3
_L3:
        CheckoutFormFragment.access$000(CheckoutFormFragment.this).updatePoshmarkOrder(((PMOfferInfo)pmapiresponse.data).data);
        pmapiresponse = CheckoutFormFragment.access$000(CheckoutFormFragment.this).getPoshmarkOrder().getOrderId();
        if (CheckoutFormFragment.access$400(CheckoutFormFragment.this) != ECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD && CheckoutFormFragment.access$400(CheckoutFormFragment.this) != ECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS) goto _L6; else goto _L5
_L5:
        CheckoutFormFragment.access$000(CheckoutFormFragment.this).getCreditCard().copy(cc_local);
        CheckoutFormFragment.access$000(CheckoutFormFragment.this).setCreditCardUpdated(true);
_L7:
        finishActivityWithResult(-1, null);
_L2:
        return;
_L6:
        if (CheckoutFormFragment.access$400(CheckoutFormFragment.this) == ECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "updated_order_address", pmapiresponse);
        }
        if (true) goto _L7; else goto _L4
_L4:
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.onContext.UPDATE_ORDER_ADDRESS, getString(0x7f0600d6), com.poshmark.ui.model.rity.HIGH));
        return;
    }

    ()
    {
        this$0 = CheckoutFormFragment.this;
        super();
    }
}
