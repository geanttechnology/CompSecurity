// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.PMErrorType;
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
label0:
        {
            if (isAdded())
            {
                hideProgressDialog();
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                listingDetails = (ListingDetails)pmapiresponse.data;
                FBDPAHelper.trackListingView(listingDetails, getTrackingList());
                ListingDetailsFragment.access$100(ListingDetailsFragment.this);
                ListingDetailsFragment.access$000(ListingDetailsFragment.this);
                ListingDetailsFragment.access$200(ListingDetailsFragment.this);
            }
            return;
        }
        String s;
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_NOT_FOUND || pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_GONE)
        {
            s = getResources().getString(0x7f0600e3);
        } else
        {
            s = getResources().getString(0x7f0600e6);
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.Context.LOAD_LISTING, s));
    }

    ext()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
