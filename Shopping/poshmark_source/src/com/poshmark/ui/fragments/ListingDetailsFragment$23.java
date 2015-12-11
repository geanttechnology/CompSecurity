// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.FBDPAHelper;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment

class this._cls0
    implements PMApiResponseHandler
{

    final ListingDetailsFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        hideProgressDialog();
        if (pmapiresponse.hasError())
        {
            if (pmapiresponse.apiError.isAlreadyExistsError())
            {
                ListingDetailsFragment.access$500(ListingDetailsFragment.this);
                return;
            } else
            {
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ontext.ADD_TO_BUNDLE, getString(0x7f0600d3), com.poshmark.ui.model.y.LOW));
                return;
            }
        } else
        {
            FBDPAHelper.trackAddToCart(listingDetails, FBDPAHelper.PURCHASE_TYPE_BUNDLE);
            ListingDetailsFragment.access$500(ListingDetailsFragment.this);
            return;
        }
    }

    xt()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
