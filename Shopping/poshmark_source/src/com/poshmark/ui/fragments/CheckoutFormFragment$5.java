// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.AddressCheckerResults;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

class this._cls0
    implements PMApiResponseHandler
{

    final CheckoutFormFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
label1:
            {
                if (isAdded())
                {
                    hideProgressDialog();
                    if (pmapiresponse.hasError())
                    {
                        break label0;
                    }
                    pmapiresponse = (AddressCheckerResults)pmapiresponse.data;
                    if (((AddressCheckerResults) (pmapiresponse)).status.equals("exact_match_found"))
                    {
                        break label1;
                    }
                    CheckoutFormFragment.access$1000(CheckoutFormFragment.this, pmapiresponse);
                }
                return;
            }
            CheckoutFormFragment.access$900(CheckoutFormFragment.this);
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.onContext.UPDATE_ORDER_ADDRESS, getString(0x7f0600d6), com.poshmark.ui.model.rity.HIGH));
    }

    ()
    {
        this$0 = CheckoutFormFragment.this;
        super();
    }
}
