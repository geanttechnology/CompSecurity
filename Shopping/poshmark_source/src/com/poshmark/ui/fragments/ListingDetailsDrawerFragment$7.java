// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsDrawerFragment, ListingDetailsFragment

class this._cls0
    implements android.view.erFragment._cls7
{

    final ListingDetailsDrawerFragment this$0;

    public void onClick(View view)
    {
        ((PMContainerActivity)getActivity()).hideDrawer();
        if (parentFragment.listingDetails.getListingStatus() == com.poshmark.data_model.models.inner_models._08__19_ && !PMApplicationSession.GetPMSession().isUserAdmin())
        {
            showAlertMessage("", getString(0x7f06016a));
            return;
        } else
        {
            showConfirmationMessage(getString(0x7f0600b8), getString(0x7f0600b9), new android.content.DialogInterface.OnClickListener() {

                final ListingDetailsDrawerFragment._cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (i == -1)
                    {
                        dialoginterface = new Bundle();
                        dialoginterface.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                        PMNotificationManager.fireNotification("com.poshmark.intents.DELETE_LISTING_ACTION", dialoginterface);
                    }
                }

            
            {
                this$1 = ListingDetailsDrawerFragment._cls7.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = ListingDetailsDrawerFragment.this;
        super();
    }
}
