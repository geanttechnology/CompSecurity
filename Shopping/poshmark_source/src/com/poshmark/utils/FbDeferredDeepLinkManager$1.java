// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.PMNotificationManager;
import java.util.HashMap;

// Referenced classes of package com.poshmark.utils:
//            FbDeferredDeepLinkManager

class this._cls0
    implements com.facebook.applinks.r
{

    final FbDeferredDeepLinkManager this$0;

    public void onDeferredAppLinkDataFetched(AppLinkData applinkdata)
    {
        if (applinkdata != null)
        {
            currentState = _STATE.DL_RECEIVED;
            HashMap hashmap = new HashMap();
            hashmap.put("ev", "fbdl");
            hashmap.put("s", "dlf");
            hashmap.put("lrf", FbDeferredDeepLinkManager.INSTANCE.getDeepLinkUrl());
            PMApi.trackDeepLink(hashmap);
            originalDeepLinkUrl = applinkdata.getArgumentBundle().getString("com.facebook.platform.APPLINK_NATIVE_URL");
            FbDeferredDeepLinkManager.access$000(FbDeferredDeepLinkManager.this, originalDeepLinkUrl);
            PMNotificationManager.fireNotification("com.poshmark.intents.PROFILE_UPDATED");
        }
    }

    r()
    {
        this$0 = FbDeferredDeepLinkManager.this;
        super();
    }
}
