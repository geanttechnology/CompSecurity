// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.analytics.Analytics;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.fragments.PMFragment;

// Referenced classes of package com.poshmark.utils:
//            ListingManager

class this._cls0
    implements PMApiResponseHandler
{

    final ListingManager this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            if (callingFragment.isAdded())
            {
                callingFragment.hideProgressDialog();
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                Analytics.getInstance().trackEvent("new_listing_screen", "listing", "edit_listing_complete", null);
                ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(listingId);
                if (ListingManager.access$400(ListingManager.this))
                {
                    ListingManager.access$500(ListingManager.this);
                }
                callingFragment.finishActivityWithResult(-1, null);
            }
            return;
        }
        ListingManager.access$200(ListingManager.this, ListingManager.access$100(ListingManager.this, pmapiresponse.apiError));
    }

    tificationManager()
    {
        this$0 = ListingManager.this;
        super();
    }
}
