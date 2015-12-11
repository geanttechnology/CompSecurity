// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.PMNotificationManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            UserSettingsFragment

class this._cls0
    implements android.view.gsFragment._cls2
{

    final UserSettingsFragment this$0;

    public void onClick(View view)
    {
        PMApi.logout(null);
        PMNotificationManager.fireNotification("com.poshmark.intents.INITIATE_LOGOUT");
    }

    ()
    {
        this$0 = UserSettingsFragment.this;
        super();
    }
}
