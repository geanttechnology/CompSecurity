// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.Context;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.NewRelicCustomInteractions;
import com.poshmark.utils.sharing.StateCompletionListener;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareToPartyShare

class val.listingItem
    implements PMApiResponseHandler
{

    final ShareToPartyShare this$0;
    final PMFragment val$callingFragment;
    final boolean val$isFragmentAdded;
    final ListingSummary val$listingItem;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        NewRelicWrapper.stopCustomInteraction(NewRelicCustomInteractions.SHARE_LISTING_TO_PARTY);
        val$callingFragment.hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            if (val$isFragmentAdded)
            {
                val$callingFragment.showAutoHideProgressDialogWithMessage(PMApplication.getContext().getString(0x7f060259));
            }
            pmapiresponse = (new StringBuilder()).append(val$listingItem.getIdAsString()).append("/").append(val$listingItem.getTitle()).toString();
            Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_poshmark_poshparty", pmapiresponse);
            listener.stateCompleted();
            return;
        }
        String s = (new StringBuilder()).append(val$listingItem.getIdAsString()).append("/").append(val$listingItem.getTitle()).toString();
        Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_failed", s);
        if (val$isFragmentAdded)
        {
            val$callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ctionContext.SHARE_LISTING, PMApplication.getContext().getString(0x7f0600fa)));
        }
        listener.stateFailed();
    }

    A()
    {
        this$0 = final_sharetopartyshare;
        val$callingFragment = pmfragment;
        val$isFragmentAdded = flag;
        val$listingItem = ListingSummary.this;
        super();
    }
}
