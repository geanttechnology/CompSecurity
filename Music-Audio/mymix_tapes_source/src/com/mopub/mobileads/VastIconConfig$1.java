// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Bundle;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.UrlAction;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;

// Referenced classes of package com.mopub.mobileads:
//            VastIconConfig

class val.context
    implements com.mopub.common.Actions
{

    final VastIconConfig this$0;
    final Context val$context;

    public void urlHandlingFailed(String s, UrlAction urlaction)
    {
    }

    public void urlHandlingSucceeded(String s, UrlAction urlaction)
    {
        if (urlaction != UrlAction.OPEN_IN_APP_BROWSER)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        urlaction = new Bundle();
        urlaction.putString("URL", s);
        s = Intents.getStartActivityIntent(val$context, com/mopub/common/MoPubBrowser, urlaction);
        Intents.startActivity(val$context, s);
        return;
        s;
        MoPubLog.d(s.getMessage());
        return;
    }

    bleException()
    {
        this$0 = final_vasticonconfig;
        val$context = Context.this;
        super();
    }
}
