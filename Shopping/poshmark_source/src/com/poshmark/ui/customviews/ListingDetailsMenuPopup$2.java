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

// Referenced classes of package com.poshmark.ui.customviews:
//            ListingDetailsMenuPopup

class this._cls0
    implements android.view.ilsMenuPopup._cls2
{

    final ListingDetailsMenuPopup this$0;

    public void onClick(View view)
    {
        view = (PMContainerActivity)context;
        dismiss();
        view = new Bundle();
        view.putParcelable("PARENT_ID", new ParcelUuid(parentFragment.getFragmentId()));
        PMNotificationManager.fireNotification("com.poshmark.intents.VIEW_BUNDLE_ACTION", view);
    }

    ()
    {
        this$0 = ListingDetailsMenuPopup.this;
        super();
    }
}
