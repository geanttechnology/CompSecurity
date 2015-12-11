// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;
import android.webkit.WebView;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPAndroidWebViewHelper

class val.callback
    implements Callback
{

    final MAPAndroidWebViewHelper this$0;
    final Callback val$callback;
    final String val$directedId;
    final String val$domain;
    final WebView val$webView;

    public void onError(Bundle bundle)
    {
        val$callback.onError(bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        String as[] = bundle.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
        if (as.length != 0)
        {
            MAPAndroidWebViewHelper.access$500(MAPAndroidWebViewHelper.this, as, val$domain, val$directedId);
        }
        String s = bundle.getString("com.amazon.identity.auth.device.api.cookiekeys.ResponseUrl");
        MAPAndroidWebViewHelper.access$600(MAPAndroidWebViewHelper.this, val$webView, s);
        val$callback.onSuccess(bundle);
    }

    ()
    {
        this$0 = final_mapandroidwebviewhelper;
        val$domain = s;
        val$directedId = s1;
        val$webView = webview;
        val$callback = Callback.this;
        super();
    }
}
