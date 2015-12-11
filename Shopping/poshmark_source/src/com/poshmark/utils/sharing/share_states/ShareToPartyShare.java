// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.Context;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.NewRelicCustomInteractions;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.PMShareContent;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class ShareToPartyShare extends ShareState
{

    public static UUID id = UUID.randomUUID();

    public ShareToPartyShare(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
    }

    public void executeState()
    {
        final PMFragment callingFragment = shareManager.getFragment();
        final ListingSummary listingItem = shareManager.getShareContent().getListing();
        PartyEvent partyevent = shareManager.getShareContent().getParty();
        final boolean isFragmentAdded;
        if (shareManager.getFragment() != null && shareManager.getFragment().isAdded())
        {
            isFragmentAdded = true;
        } else
        {
            isFragmentAdded = false;
        }
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.SHARE_LISTING_TO_PARTY);
            callingFragment.showProgressDialogWithMessage(PMApplication.getContext().getString(0x7f06025d));
            PMApi.shareListing(listingItem.getIdAsString(), null, partyevent.getId(), null, new PMApiResponseHandler() {

                final ShareToPartyShare this$0;
                final PMFragment val$callingFragment;
                final boolean val$isFragmentAdded;
                final ListingSummary val$listingItem;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    NewRelicWrapper.stopCustomInteraction(NewRelicCustomInteractions.SHARE_LISTING_TO_PARTY);
                    callingFragment.hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        if (isFragmentAdded)
                        {
                            callingFragment.showAutoHideProgressDialogWithMessage(PMApplication.getContext().getString(0x7f060259));
                        }
                        pmapiresponse = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
                        Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_poshmark_poshparty", pmapiresponse);
                        listener.stateCompleted();
                        return;
                    }
                    String s = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
                    Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_failed", s);
                    if (isFragmentAdded)
                    {
                        callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING, PMApplication.getContext().getString(0x7f0600fa)));
                    }
                    listener.stateFailed();
                }

            
            {
                this$0 = ShareToPartyShare.this;
                callingFragment = pmfragment;
                isFragmentAdded = flag;
                listingItem = listingsummary;
                super();
            }
            });
        }
    }

    public UUID getId()
    {
        return id;
    }

}
