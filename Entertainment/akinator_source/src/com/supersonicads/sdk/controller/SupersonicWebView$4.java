// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import com.supersonicads.sdk.utils.Logger;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class val.scriptBuilder
    implements Runnable
{

    final SupersonicWebView this$0;
    final StringBuilder val$scriptBuilder;
    final String val$url;

    public void run()
    {
        Logger.i(SupersonicWebView.access$300(SupersonicWebView.this), val$url);
        if (SupersonicWebView.access$5700(SupersonicWebView.this) == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (SupersonicWebView.access$5700(SupersonicWebView.this).booleanValue())
        {
            SupersonicWebView.access$5800(SupersonicWebView.this, val$scriptBuilder.toString());
            return;
        }
        try
        {
            loadUrl(val$url);
            return;
        }
        catch (Throwable throwable)
        {
            Logger.e(SupersonicWebView.access$300(SupersonicWebView.this), (new StringBuilder()).append("injectJavascript: ").append(throwable.toString()).toString());
        }
        return;
        int i = android.os.T;
        if (i < 19)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        SupersonicWebView.access$5800(SupersonicWebView.this, val$scriptBuilder.toString());
        SupersonicWebView.access$5702(SupersonicWebView.this, Boolean.valueOf(true));
        return;
        Object obj;
        obj;
        Logger.e(SupersonicWebView.access$300(SupersonicWebView.this), (new StringBuilder()).append("evaluateJavascrip NoSuchMethodError: SDK version=").append(android.os.T).append(" ").append(obj).toString());
        loadUrl(val$url);
        SupersonicWebView.access$5702(SupersonicWebView.this, Boolean.valueOf(false));
        return;
        obj;
        Logger.e(SupersonicWebView.access$300(SupersonicWebView.this), (new StringBuilder()).append("evaluateJavascrip Exception: SDK version=").append(android.os.T).append(" ").append(obj).toString());
        loadUrl(val$url);
        SupersonicWebView.access$5702(SupersonicWebView.this, Boolean.valueOf(false));
        return;
        loadUrl(val$url);
        SupersonicWebView.access$5702(SupersonicWebView.this, Boolean.valueOf(false));
        return;
    }

    ()
    {
        this$0 = final_supersonicwebview;
        val$url = s;
        val$scriptBuilder = StringBuilder.this;
        super();
    }
}
