// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.aio.downloader.utils.ProgressWheel;
import com.umeng.analytics.MobclickAgent;

public class ShowAideoActivity extends Activity
{

    private ProgressWheel progress_wheel_video;
    private WebView wv;

    public ShowAideoActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000e);
        wv = (WebView)findViewById(0x7f07008e);
        progress_wheel_video = (ProgressWheel)findViewById(0x7f07008f);
        bundle = getIntent().getStringExtra("strurl");
        Log.e("tag", (new StringBuilder(String.valueOf(bundle))).append("------------------------").toString());
        wv.loadUrl(bundle);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClient() {

            final ShowAideoActivity this$0;

            public void onPageFinished(WebView webview, String s)
            {
                progress_wheel_video.setVisibility(8);
                super.onPageFinished(webview, s);
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                progress_wheel_video.setVisibility(0);
                super.onPageStarted(webview, s, bitmap);
            }

            
            {
                this$0 = ShowAideoActivity.this;
                super();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && wv.canGoBack())
        {
            wv.canGoBack();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        wv.onPause();
        MobclickAgent.onPause(this);
        super.onPause();
    }

    protected void onResume()
    {
        wv.onResume();
        MobclickAgent.onResume(this);
        super.onResume();
    }

}
