// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import com.facebook.appevents.AppEventsLogger;
import com.mobileapptracker.MobileAppTracker;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.fragments.PMFragment;
import net.singular.sdk.Singular;

// Referenced classes of package com.poshmark.utils:
//            ListingManager, NewRelicCustomInteractions

class this._cls0
    implements PMApiResponseHandler
{

    final ListingManager this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            NewRelicWrapper.stopCustomInteraction(NewRelicCustomInteractions.CREATE_LISTING);
            if (callingFragment.isAdded())
            {
                callingFragment.hideProgressDialog();
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                Analytics.getInstance().trackEvent("new_listing_screen", "listing", "new_listing_complete", null);
                pmapiresponse = PMApplication.getHasOffersObject();
                if (pmapiresponse != null)
                {
                    pmapiresponse.measureAction("listing");
                }
                Singular.trackEvent("listing");
                AppEventsLogger.newLogger(PMApplication.getContext()).logEvent("listing");
                ListingNotificationManager.getListingNotificationManager().fireNewListingCreatedMessage();
                callingFragment.finishActivityWithResult(102, null);
            }
            return;
        }
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.INVALID_LISTING)
        {
            ListingManager.access$300(ListingManager.this, pmapiresponse);
            return;
        }
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.BRAND_CHANGE_LIMIT_EXCEEDED)
        {
            String s = PMApplication.getContext().getString(0x7f0600d0);
            callingFragment.showAlertMessage(s, pmapiresponse.apiError.getUserMessage());
            return;
        } else
        {
            ListingManager.access$200(ListingManager.this, ListingManager.access$100(ListingManager.this, pmapiresponse.apiError));
            return;
        }
    }

    orType()
    {
        this$0 = ListingManager.this;
        super();
    }
}
