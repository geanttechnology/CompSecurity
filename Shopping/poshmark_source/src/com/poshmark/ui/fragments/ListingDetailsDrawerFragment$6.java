// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.ReportListingDialog;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsDrawerFragment, ListingDetailsFragment

class this._cls0
    implements android.view.erFragment._cls6
{

    final ListingDetailsDrawerFragment this$0;

    public void onClick(View view)
    {
        ((PMContainerActivity)getActivity()).hideDrawer();
        (new ReportListingDialog(getActivity(), new com.poshmark.utils.ReportListingDialog.ReportReasonListener() {

            final ListingDetailsDrawerFragment._cls6 this$1;

            public void reasonPicked(String s)
            {
                Bundle bundle = new Bundle();
                bundle.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                bundle.putString("REPORT_REASON", s);
                PMNotificationManager.fireNotification("com.poshmark.intents.REPORT_LISTING_ACTION", bundle);
            }

            
            {
                this$1 = ListingDetailsDrawerFragment._cls6.this;
                super();
            }
        })).show();
    }

    _cls1.this._cls1()
    {
        this$0 = ListingDetailsDrawerFragment.this;
        super();
    }
}
