// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.fragments.ListingDetailsFragment;

// Referenced classes of package com.poshmark.ui.customviews:
//            ListingDetailsMenuPopup

class this._cls1
    implements android.content.ner
{

    final ification this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            dialoginterface = new Bundle();
            dialoginterface.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
            PMNotificationManager.fireNotification("com.poshmark.intents.DELETE_LISTING_ACTION", dialoginterface);
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/customviews/ListingDetailsMenuPopup$4

/* anonymous class */
    class ListingDetailsMenuPopup._cls4
        implements android.view.View.OnClickListener
    {

        final ListingDetailsMenuPopup this$0;

        public void onClick(View view)
        {
            if (listingDetails.getListingStatus() == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD && !PMApplicationSession.GetPMSession().isUserAdmin())
            {
                parentFragment.showAlertMessage("", context.getString(0x7f06016a));
                return;
            } else
            {
                parentFragment.showConfirmationMessage(context.getString(0x7f0600b8), context.getString(0x7f0600b9), new ListingDetailsMenuPopup._cls4._cls1());
                return;
            }
        }

            
            {
                this$0 = ListingDetailsMenuPopup.this;
                super();
            }
    }

}
