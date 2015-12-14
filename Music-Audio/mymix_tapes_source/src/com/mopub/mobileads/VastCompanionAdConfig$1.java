// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;

// Referenced classes of package com.mopub.mobileads:
//            VastCompanionAdConfig

class val.requestCode
    implements com.mopub.common.
{

    final VastCompanionAdConfig this$0;
    final Context val$context;
    final int val$requestCode;

    public void urlHandlingFailed(String s, UrlAction urlaction)
    {
    }

    public void urlHandlingSucceeded(String s, UrlAction urlaction)
    {
        if (urlaction != UrlAction.OPEN_IN_APP_BROWSER)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        urlaction = new Bundle();
        urlaction.putString("URL", s);
        s = Intents.getStartActivityIntent(val$context, com/mopub/common/MoPubBrowser, urlaction);
        ((Activity)val$context).startActivityForResult(s, val$requestCode);
        return;
        s;
        MoPubLog.d((new StringBuilder()).append("Activity ").append(com/mopub/common/MoPubBrowser.getName()).append(" not found. Did you ").append("declare it in your AndroidManifest.xml?").toString());
        return;
    }

    ()
    {
        this$0 = final_vastcompanionadconfig;
        val$context = context1;
        val$requestCode = I.this;
        super();
    }
}
