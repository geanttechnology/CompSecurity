// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsDrawerFragment, ListingDetailsFragment

class this._cls1
    implements android.content.gment._cls3._cls1
{

    final cation this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            dialoginterface = new Bundle();
            dialoginterface.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
            PMNotificationManager.fireNotification("com.poshmark.intents.MAKE_AVAILABLE_LISTING_ACTION", dialoginterface);
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/ListingDetailsDrawerFragment$3

/* anonymous class */
    class ListingDetailsDrawerFragment._cls3
        implements android.view.View.OnClickListener
    {

        final ListingDetailsDrawerFragment this$0;

        public void onClick(View view)
        {
            ((PMContainerActivity)getActivity()).hideDrawer();
            showConfirmationMessage(getString(0x7f06019f), getString(0x7f06019e), new ListingDetailsDrawerFragment._cls3._cls1());
        }

            
            {
                this$0 = ListingDetailsDrawerFragment.this;
                super();
            }
    }

}
