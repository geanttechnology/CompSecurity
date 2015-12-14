// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.oauth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;

// Referenced classes of package com.parse.oauth:
//            OAuth1FlowDialog

private class <init> extends WebViewClient
{

    final OAuth1FlowDialog this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        try
        {
            OAuth1FlowDialog.access$400(OAuth1FlowDialog.this).dismiss();
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview) { }
        OAuth1FlowDialog.access$500(OAuth1FlowDialog.this).setBackgroundColor(0);
        OAuth1FlowDialog.access$600(OAuth1FlowDialog.this).setVisibility(0);
        OAuth1FlowDialog.access$700(OAuth1FlowDialog.this).setVisibility(0);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        OAuth1FlowDialog.access$400(OAuth1FlowDialog.this).show();
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        dismiss();
        OAuth1FlowDialog.access$000(OAuth1FlowDialog.this).Error(i, s, s1);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s.startsWith(OAuth1FlowDialog.access$200(OAuth1FlowDialog.this)))
        {
            dismiss();
            OAuth1FlowDialog.access$000(OAuth1FlowDialog.this).Complete(s);
            return true;
        }
        if (s.contains(OAuth1FlowDialog.access$300(OAuth1FlowDialog.this)))
        {
            return false;
        } else
        {
            getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            return true;
        }
    }

    private ()
    {
        this$0 = OAuth1FlowDialog.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
