// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPAndroidWebViewHelper, MAPAccountManager

class val.url
    implements Callback
{

    final MAPAndroidWebViewHelper this$0;
    final Activity val$activity;
    final String val$directedId;
    final String val$url;
    final WebView val$webView;

    public void onError(Bundle bundle)
    {
        MAPAndroidWebViewHelper.access$100();
        (new StringBuilder("getCookies call failed with error ")).append(bundle.getString("com.amazon.dcp.sso.ErrorMessage"));
        if (!MAPAndroidWebViewHelper.access$200(MAPAndroidWebViewHelper.this).isAccountRegistered(val$directedId))
        {
            MAPAndroidWebViewHelper.access$100();
            (new StringBuilder("account ")).append(val$directedId).append(" is not registered");
            MAPAndroidWebViewHelper.access$400(MAPAndroidWebViewHelper.this, val$activity, MAPAndroidWebViewHelper.access$300(MAPAndroidWebViewHelper.this, val$webView, val$url));
            return;
        } else
        {
            onEvent("ON_UNABLE_TO_GET_COOKIES", bundle);
            return;
        }
    }

    public void onSuccess(Bundle bundle)
    {
        MAPLog.i(MAPAndroidWebViewHelper.access$100(), "Sign in skipped successfully. Loaded next URL in WebView.");
    }

    ()
    {
        this$0 = final_mapandroidwebviewhelper;
        val$directedId = s;
        val$activity = activity1;
        val$webView = webview;
        val$url = String.this;
        super();
    }
}
