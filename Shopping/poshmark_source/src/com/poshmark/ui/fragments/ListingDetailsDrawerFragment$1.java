// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsDrawerFragment, ListingDetailsFragment

class this._cls0
    implements android.view.erFragment._cls1
{

    final ListingDetailsDrawerFragment this$0;

    public void onClick(View view)
    {
        ((PMContainerActivity)getActivity()).hideDrawer();
        view = new Bundle();
        view.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
        PMNotificationManager.fireNotification("com.poshmark.intents.EDIT_LISTING_ACTION", view);
    }

    ()
    {
        this$0 = ListingDetailsDrawerFragment.this;
        super();
    }
}
