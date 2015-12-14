// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.webkit.WebView;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPAndroidWebViewHelper

class val.webView
    implements Runnable
{

    final MAPAndroidWebViewHelper this$0;
    final WebView val$webView;

    public void run()
    {
        val$webView.loadUrl(MAPAndroidWebViewHelper.access$600(MAPAndroidWebViewHelper.this).returnToURL);
    }

    rameters()
    {
        this$0 = final_mapandroidwebviewhelper;
        val$webView = WebView.this;
        super();
    }
}
