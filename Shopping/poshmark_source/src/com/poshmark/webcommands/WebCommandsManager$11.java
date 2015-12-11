// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager

class val.viewCount
    implements com.poshmark.utils.er._cls11
{

    final WebCommandsManager this$0;
    final int val$viewCount;

    public void runOnUIThread(Object obj)
    {
        if (val$viewCount > 1)
        {
            parentActivity.popTopNFragments(val$viewCount - 1, true);
        }
        parentActivity.onBackPressed();
        PMApi.logout(null);
        PMNotificationManager.fireNotification("com.poshmark.intents.INITIATE_LOGOUT");
    }

    r()
    {
        this$0 = final_webcommandsmanager;
        val$viewCount = I.this;
        super();
    }
}
