// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.BrainTreeGatewayInfo;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment

class val.order
    implements PMApiResponseHandler
{

    final CheckoutConfirmationFragment this$0;
    final PMOrder val$order;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            if (isAdded())
            {
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                pmapiresponse = (BrainTreeGatewayInfo)pmapiresponse.data;
                CURRENT_TR_DATA_RETRY_COUNT = 0;
                CheckoutConfirmationFragment.access$100(CheckoutConfirmationFragment.this, pmapiresponse);
            }
            return;
        }
        if (CURRENT_TR_DATA_RETRY_COUNT <= TR_DATA_RETRY_COUNT)
        {
            pmapiresponse = CheckoutConfirmationFragment.this;
            pmapiresponse.CURRENT_TR_DATA_RETRY_COUNT = ((CheckoutConfirmationFragment) (pmapiresponse)).CURRENT_TR_DATA_RETRY_COUNT + 1;
            PMApi.getCreditCardGatewayData(val$order.getOrderId(), this);
            return;
        } else
        {
            hideProgressDialog();
            CURRENT_TR_DATA_RETRY_COUNT = 0;
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.t.SUBMIT_CC, getString(0x7f0600f5), com.poshmark.ui.model.H));
            return;
        }
    }

    ()
    {
        this$0 = final_checkoutconfirmationfragment;
        val$order = PMOrder.this;
        super();
    }
}
