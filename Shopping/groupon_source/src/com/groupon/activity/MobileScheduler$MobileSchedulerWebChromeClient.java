// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.groupon.activity:
//            MobileScheduler

private class <init> extends WebChromeClient
{

    final MobileScheduler this$0;

    public boolean onJsAlert(WebView webview, String s, String s1, final JsResult result)
    {
        (new com.groupon.util.ent(MobileScheduler.this))._mth0("Alert")._mth0(s1)._mth0(0x104000a, new android.content.DialogInterface.OnClickListener() {

            final MobileScheduler.MobileSchedulerWebChromeClient this$1;
            final JsResult val$result;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                result.confirm();
            }

            
            {
                this$1 = MobileScheduler.MobileSchedulerWebChromeClient.this;
                result = jsresult;
                super();
            }
        }).meClient().show();
        return true;
    }

    public void onReceivedTitle(WebView webview, String s)
    {
        if (isGdt)
        {
            updateActionBarTitle(s);
        }
        super.onReceivedTitle(webview, s);
    }

    private _cls1.val.result()
    {
        this$0 = MobileScheduler.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
