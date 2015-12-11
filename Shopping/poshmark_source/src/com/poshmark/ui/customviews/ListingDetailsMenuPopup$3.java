// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.utils.ReportListingDialog;

// Referenced classes of package com.poshmark.ui.customviews:
//            ListingDetailsMenuPopup

class this._cls0
    implements android.view.ilsMenuPopup._cls3
{

    final ListingDetailsMenuPopup this$0;

    public void onClick(View view)
    {
        view = (PMContainerActivity)context;
        dismiss();
        (new ReportListingDialog(view, new com.poshmark.utils.ReportListingDialog.ReportReasonListener() {

            final ListingDetailsMenuPopup._cls3 this$1;

            public void reasonPicked(String s)
            {
                Bundle bundle = new Bundle();
                bundle.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
                bundle.putString("REPORT_REASON", s);
                PMNotificationManager.fireNotification("com.poshmark.intents.REPORT_LISTING_ACTION", bundle);
            }

            
            {
                this$1 = ListingDetailsMenuPopup._cls3.this;
                super();
            }
        })).show();
    }

    _cls1.this._cls1()
    {
        this$0 = ListingDetailsMenuPopup.this;
        super();
    }
}
