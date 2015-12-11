// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.BrainTreeGatewayInfo;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.http.BrainTreeHttpResponseHandler;
import com.poshmark.http.PMHttpError;
import com.poshmark.http.PMHttpResponse;
import com.poshmark.http.api.BrainTreeApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.CheckoutFlowHandler;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment

class val.info
    implements BrainTreeHttpResponseHandler
{

    final CheckoutConfirmationFragment this$0;
    final BrainTreeGatewayInfo val$info;
    final Map val$map;

    public void handleResponse(PMHttpResponse pmhttpresponse)
    {
label0:
        {
            if (isAdded())
            {
                if (!pmhttpresponse.hasError())
                {
                    CURRENT_REDIRECT_URL_RETRY_COUNT = 0;
                    for (int i = 0; i < pmhttpresponse.headerArray.length; i++)
                    {
                        Object obj = pmhttpresponse.headerArray[i];
                        if (((Header) (obj)).getName().equals("Location"))
                        {
                            obj = ((Header) (obj)).getValue();
                            PMOrder pmorder = flowHandler.getPoshmarkOrder();
                            HashMap hashmap = new HashMap();
                            hashmap.put("braintree_return_url", obj);
                            hashmap.put("checkout_type", pmorder.getCheckoutType());
                            hashmap.put("inventory_unit_ids", pmorder.getInventoryUnitIds());
                            hashmap.put("order_id", pmorder.getOrderId());
                            hashmap.put("user_id", PMApplicationSession.GetPMSession().getUserId());
                            CheckoutConfirmationFragment.access$200(CheckoutConfirmationFragment.this, hashmap);
                        }
                    }

                } else
                {
                    if (CURRENT_REDIRECT_URL_RETRY_COUNT > REDIRECT_URL_RETRY_COUNT)
                    {
                        break label0;
                    }
                    pmhttpresponse = CheckoutConfirmationFragment.this;
                    pmhttpresponse.CURRENT_REDIRECT_URL_RETRY_COUNT = ((CheckoutConfirmationFragment) (pmhttpresponse)).CURRENT_REDIRECT_URL_RETRY_COUNT + 1;
                    BrainTreeApi.PostBrainTreeValidation(val$map, val$info.form_action, this);
                }
            }
            return;
        }
        hideProgressDialog();
        CURRENT_REDIRECT_URL_RETRY_COUNT = 0;
        pmhttpresponse = new PMApiError(null, pmhttpresponse.httpError.exception, pmhttpresponse.httpCode, PMErrorType.UNKNOWN_ERROR);
        showError(new ActionErrorContext(pmhttpresponse, com.poshmark.ui.model.t.SUBMIT_CC, getString(0x7f0600f5), com.poshmark.ui.model.H));
    }

    ()
    {
        this$0 = final_checkoutconfirmationfragment;
        val$map = map1;
        val$info = BrainTreeGatewayInfo.this;
        super();
    }
}
