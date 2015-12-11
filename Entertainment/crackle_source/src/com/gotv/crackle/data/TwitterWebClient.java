// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.gotv.crackle.TwitterWebActivity;

public class TwitterWebClient extends WebViewClient
{

    private ProgressBar mProgress;
    private TwitterWebActivity mWebActivity;

    public TwitterWebClient(TwitterWebActivity twitterwebactivity, ProgressBar progressbar)
    {
        mWebActivity = twitterwebactivity;
        mProgress = progressbar;
    }

    public void onPageFinished(WebView webview, String s)
    {
        mProgress.setVisibility(8);
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        mProgress.setVisibility(0);
        if (s.equalsIgnoreCase("https://twitter.com/intent/tweet/complete") || s.equalsIgnoreCase("https://twitter.com/"))
        {
            mWebActivity.finish();
        } else
        {
            int j = s.lastIndexOf("=");
            int i = j;
            if (j == -1)
            {
                i = s.length();
            }
            webview = s.substring(0, i);
            if (!webview.equalsIgnoreCase("https://twitter.com/intent/session?return_to") && webview.equalsIgnoreCase("https://twitter.com/intent/tweet?status"))
            {
                return;
            }
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        mProgress.setVisibility(8);
        super.onReceivedError(webview, i, s, s1);
    }
}
