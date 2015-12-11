// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.analytics.Analytics;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;

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
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "report_listing", listingId);
                showAutoHideSuccessMessage(getString(0x7f060228));
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ontext.REPORT_LISTING, getString(0x7f0600f6)));
    }

    xt()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
