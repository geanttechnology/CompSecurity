// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            AdUserAgentManager, WebViewFactory

class val.context
    implements Runnable
{

    final AdUserAgentManager this$0;
    final Context val$context;

    public void run()
    {
        setUserAgentString(WebViewFactory.getInstance().createWebView(val$context).getSettings().getUserAgentString());
    }

    ()
    {
        this$0 = final_aduseragentmanager;
        val$context = Context.this;
        super();
    }
}
