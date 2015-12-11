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

class this._cls1
    implements com.poshmark.utils.istener
{

    final cation this$1;

    public void reasonPicked(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
        bundle.putString("REPORT_REASON", s);
        PMNotificationManager.fireNotification("com.poshmark.intents.REPORT_LISTING_ACTION", bundle);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/ListingDetailsDrawerFragment$6

/* anonymous class */
    class ListingDetailsDrawerFragment._cls6
        implements android.view.View.OnClickListener
    {

        final ListingDetailsDrawerFragment this$0;

        public void onClick(View view)
        {
            ((PMContainerActivity)getActivity()).hideDrawer();
            (new ReportListingDialog(getActivity(), new ListingDetailsDrawerFragment._cls6._cls1())).show();
        }

            
            {
                this$0 = ListingDetailsDrawerFragment.this;
                super();
            }
    }

}
