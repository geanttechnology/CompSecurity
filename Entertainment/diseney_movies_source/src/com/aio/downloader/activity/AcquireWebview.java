// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.aio.downloader.utils.ProgressWheel;
import com.umeng.analytics.MobclickAgent;

public class AcquireWebview extends Activity
{

    private ImageView acqu_fanhui;
    private TextView acqu_title;
    private ProgressWheel progress_wheel_video;
    private WebView wv_acqu;

    public AcquireWebview()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030001);
        acqu_fanhui = (ImageView)findViewById(0x7f070020);
        acqu_title = (TextView)findViewById(0x7f070021);
        acqu_fanhui.setOnClickListener(new android.view.View.OnClickListener() {

            final AcquireWebview this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = AcquireWebview.this;
                super();
            }
        });
        wv_acqu = (WebView)findViewById(0x7f070022);
        progress_wheel_video = (ProgressWheel)findViewById(0x7f070023);
        bundle = getIntent().getStringExtra("url_load");
        acqu_title.setText(bundle);
        wv_acqu.loadUrl(bundle);
        wv_acqu.getSettings().setJavaScriptEnabled(true);
        wv_acqu.setWebChromeClient(new WebChromeClient());
        wv_acqu.setWebViewClient(new WebViewClient() {

            final AcquireWebview this$0;

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
                this$0 = AcquireWebview.this;
                super();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && wv_acqu.canGoBack())
        {
            wv_acqu.canGoBack();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        wv_acqu.onPause();
        MobclickAgent.onPause(this);
        super.onPause();
    }

    protected void onResume()
    {
        wv_acqu.onResume();
        MobclickAgent.onResume(this);
        super.onResume();
    }

}
