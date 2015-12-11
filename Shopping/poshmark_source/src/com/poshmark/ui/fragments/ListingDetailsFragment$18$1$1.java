// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment

class this._cls2
    implements PMApiResponseHandler
{

    final ng this$2;

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
                ListingNotificationManager.getListingNotificationManager().fireListingDeletedMessage(listingId);
                ((PMActivity)getActivity()).onBackPressed();
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.xt.DELETE_LISTING, getString(0x7f0600e2)));
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/ListingDetailsFragment$18

/* anonymous class */
    class ListingDetailsFragment._cls18
        implements android.view.View.OnClickListener
    {

        final ListingDetailsFragment this$0;

        public void onClick(View view)
        {
            if (listingDetails.getListingStatus() == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD && !PMApplicationSession.GetPMSession().canPerformActionForRole("admin"))
            {
                showAlertMessage("", getString(0x7f06016a));
                return;
            } else
            {
                showConfirmationMessage(getString(0x7f0600b7), getString(0x7f060169), new ListingDetailsFragment._cls18._cls1());
                return;
            }
        }

            
            {
                this$0 = ListingDetailsFragment.this;
                super();
            }
    }


    // Unreferenced inner class com/poshmark/ui/fragments/ListingDetailsFragment$18$1

/* anonymous class */
    class ListingDetailsFragment._cls18._cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final ListingDetailsFragment._cls18 this$1;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (i == -1)
            {
                showProgressDialogWithMessage(getString(0x7f0600b7));
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "delete_listing", null);
                PMApi.deleteListing(listingId, new ListingDetailsFragment._cls18._cls1._cls1());
            }
        }

            
            {
                this$1 = ListingDetailsFragment._cls18.this;
                super();
            }
    }

}
