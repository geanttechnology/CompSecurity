// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            BasicUserAgentManager, WebViewFactory

class AdUserAgentManager extends BasicUserAgentManager
{

    private final ThreadUtils.ThreadRunner threadRunner;

    public AdUserAgentManager()
    {
        this(new ThreadUtils.ThreadRunner());
    }

    AdUserAgentManager(ThreadUtils.ThreadRunner threadrunner)
    {
        threadRunner = threadrunner;
    }

    void buildAndSetUserAgentString(final Context context)
    {
        threadRunner.execute(new Runnable() {

            final AdUserAgentManager this$0;
            final Context val$context;

            public void run()
            {
                setUserAgentString(WebViewFactory.getInstance().createWebView(context).getSettings().getUserAgentString());
            }

            
            {
                this$0 = AdUserAgentManager.this;
                context = context1;
                super();
            }
        }, ThreadUtils.ExecutionStyle.RUN_ASAP, ThreadUtils.ExecutionThread.MAIN_THREAD);
    }
}
