// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
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
                ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(listingId);
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.Context.UPDATE_LISTING, getString(0x7f0600e5)));
    }

    ext()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
