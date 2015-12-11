// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            MySizeFragment

class this._cls0
    implements PMApiResponseHandler
{

    final MySizeFragment this$0;

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
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "my_size_updated", null);
                UserStateSummaryController.getGlobalInteractionsController().refreshModels();
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.t.ActionContext.UPDATE_MY_SIZE, getString(0x7f0600fe)));
    }

    tionContext()
    {
        this$0 = MySizeFragment.this;
        super();
    }
}
