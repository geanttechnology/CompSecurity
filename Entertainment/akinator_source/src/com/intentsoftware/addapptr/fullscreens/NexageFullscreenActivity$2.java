// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.fullscreens;

import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.intentsoftware.addapptr.fullscreens:
//            NexageFullscreenActivity

class this._cls0 extends WebViewClient
{

    final NexageFullscreenActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        webview = new Intent();
        webview.setAction("RTB1_ACTIVITY_FINISH");
        sendBroadcast(webview);
        finish();
    }

    public boolean shouldOverrideKeyEvent(WebView webview, KeyEvent keyevent)
    {
        return super.shouldOverrideKeyEvent(webview, keyevent);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (Uri.parse(s).getHost() != null)
        {
            webview = new Intent();
            webview.setAction("RTB1_AD_CLICKED");
            sendBroadcast(webview);
            webview = new Intent("android.intent.action.VIEW");
            webview.setData(Uri.parse(s));
            startActivity(webview);
            NexageFullscreenActivity.access$000(NexageFullscreenActivity.this);
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = NexageFullscreenActivity.this;
        super();
    }
}
