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
//            ClosetDrawerFragment

class this._cls0
    implements android.view.erFragment._cls4
{

    final ClosetDrawerFragment this$0;

    public void onClick(View view)
    {
        ((PMContainerActivity)getActivity()).hideDrawer();
        showConfirmationMessage("Unblock User", "Are you sure you want to unblock this user?", new android.content.DialogInterface.OnClickListener() {

            final ClosetDrawerFragment._cls4 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -1)
                {
                    dialoginterface = new Bundle();
                    dialoginterface.putParcelable("PARENT_ID", new ParcelUuid(parentFragmentId));
                    PMNotificationManager.fireNotification("com.poshmark.intents.UNBLOCK_USER_ACTION", dialoginterface);
                }
            }

            
            {
                this$1 = ClosetDrawerFragment._cls4.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = ClosetDrawerFragment.this;
        super();
    }
}
