// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.supersonicads.sdk.utils.SupersonicSharedPrefHelper;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.supersonicads.sdk.controller:
//            OpenUrlActivity, SupersonicWebView

private class <init> extends WebViewClient
{

    final OpenUrlActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        OpenUrlActivity.access$100(OpenUrlActivity.this).setVisibility(4);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        OpenUrlActivity.access$100(OpenUrlActivity.this).setVisibility(0);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
label0:
        {
            Object obj = SupersonicSharedPrefHelper.getSupersonicPrefHelper().getSearchKeys();
            if (obj == null || ((List) (obj)).isEmpty())
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!s.contains((String)((Iterator) (obj)).next()));
            webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
            startActivity(webview);
            OpenUrlActivity.access$200(OpenUrlActivity.this).interceptedUrlToStore();
            finish();
            return true;
        }
        return super.shouldOverrideUrlLoading(webview, s);
    }

    private ()
    {
        this$0 = OpenUrlActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
