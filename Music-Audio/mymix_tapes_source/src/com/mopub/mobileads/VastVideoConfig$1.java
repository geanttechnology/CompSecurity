// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoConfig

class val.requestCode
    implements com.mopub.common.ctions
{

    final VastVideoConfig this$0;
    final Context val$context;
    final Integer val$requestCode;

    public void urlHandlingFailed(String s, UrlAction urlaction)
    {
    }

    public void urlHandlingSucceeded(String s, UrlAction urlaction)
    {
        if (urlaction != UrlAction.OPEN_IN_APP_BROWSER)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        urlaction = new Bundle();
        urlaction.putString("URL", s);
        s = Intents.getStartActivityIntent(val$context, com/mopub/common/MoPubBrowser, urlaction);
        if (val$context instanceof Activity)
        {
            Preconditions.checkNotNull(val$requestCode);
            ((Activity)val$context).startActivityForResult(s, val$requestCode.intValue());
            return;
        }
        try
        {
            Intents.startActivity(val$context, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MoPubLog.d((new StringBuilder()).append("Activity ").append(com/mopub/common/MoPubBrowser.getName()).append(" not found. Did you ").append("declare it in your AndroidManifest.xml?").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MoPubLog.d((new StringBuilder()).append("Activity ").append(com/mopub/common/MoPubBrowser.getName()).append(" not found. Did you ").append("declare it in your AndroidManifest.xml?").toString());
        }
    }

    leException()
    {
        this$0 = final_vastvideoconfig;
        val$context = context1;
        val$requestCode = Integer.this;
        super();
    }
}
