// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.fullscreens;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;

// Referenced classes of package com.intentsoftware.addapptr.fullscreens:
//            CloseDrawable

public class SmaatoFullscreenActivity extends Activity
{

    public static final String ActivityFinish = "SMAATO_ACTIVITY_FINISH";
    public static final String AdClicked = "SMAATO_AD_CLICKED";
    public static final int CLOSE_BUTTON_SIZE = 44;
    public static final String INTENT_BASE_URL = "Intent_base_URL";
    public static final String INTENT_HTML = "Intent_HTML";
    private FrameLayout adFrame;
    private String baseUrl;
    private String htmlString;
    private WebView webView;

    public SmaatoFullscreenActivity()
    {
    }

    private WebViewClient createWebViewClient()
    {
        return new WebViewClient() {

            final SmaatoFullscreenActivity this$0;

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                super.onReceivedError(webview, i, s, s1);
                webview = new Intent();
                webview.setAction("SMAATO_ACTIVITY_FINISH");
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
                    webview.setAction("SMAATO_AD_CLICKED");
                    sendBroadcast(webview);
                    webview = new Intent("android.intent.action.VIEW");
                    webview.setData(Uri.parse(s));
                    startActivity(webview);
                    finishActivity();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = SmaatoFullscreenActivity.this;
                super();
            }
        };
    }

    private void finishActivity()
    {
        Object obj = (ViewGroup)webView.getParent();
        if (obj != null)
        {
            ((ViewGroup) (obj)).removeView(webView);
        }
        obj = new Intent();
        ((Intent) (obj)).setAction("SMAATO_ACTIVITY_FINISH");
        sendBroadcast(((Intent) (obj)));
        finish();
    }

    public void onBackPressed()
    {
        finishActivity();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        bundle = getIntent();
        baseUrl = bundle.getStringExtra("Intent_base_URL");
        htmlString = bundle.getStringExtra("Intent_HTML");
    }

    protected void onStart()
    {
        super.onStart();
        adFrame = new FrameLayout(this);
        webView = new WebView(this);
        webView.setWebViewClient(createWebViewClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            webView.getSettings().setMixedContentMode(2);
        }
        webView.loadDataWithBaseURL(baseUrl, htmlString, null, "utf-8", baseUrl);
        ImageView imageview = new ImageView(this);
        imageview.setBackgroundDrawable(new CloseDrawable(true));
        imageview.setOnClickListener(new android.view.View.OnClickListener() {

            final SmaatoFullscreenActivity this$0;

            public void onClick(View view)
            {
                finishActivity();
            }

            
            {
                this$0 = SmaatoFullscreenActivity.this;
                super();
            }
        });
        float f = getResources().getDisplayMetrics().density;
        adFrame.addView(webView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        adFrame.addView(imageview, new android.widget.FrameLayout.LayoutParams((int)(44F * f), (int)(44F * f), 53));
        show();
    }

    public void show()
    {
        setContentView(adFrame, new android.widget.FrameLayout.LayoutParams(-1, -1));
    }

}
