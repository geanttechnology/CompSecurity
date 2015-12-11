// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.fullscreens;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PromoHouseFullscreenActivity extends Activity
{

    public static final String INTENT_URL = "Intent_URL";
    public static final String PromoHouseActivityFinish = "PROMO_HOUSE_ACTIVITY_FINISH";
    public static final String PromoHouseAdClicked = "PROMO_HOUSE_AD_CLICKED";
    public static final String PromoHouseAdFailed = "PROMO_HOUSE_AD_FAILED";
    private static final String ServerResponseClose = "krassapp://close";
    private static final String ServerResponseNoAd = "internal:noad";
    private String currentUrl;
    private Intent intent;
    private WebView webView;

    public PromoHouseFullscreenActivity()
    {
    }

    private WebViewClient createWebViewClient()
    {
        return new WebViewClient() {

            final PromoHouseFullscreenActivity this$0;

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                if (s.equals("internal:noad"))
                {
                    intent = new Intent();
                    intent.setAction("PROMO_HOUSE_AD_FAILED");
                    sendBroadcast(intent);
                }
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                super.onReceivedError(webview, i, s, s1);
                intent = new Intent();
                intent.setAction("PROMO_HOUSE_ACTIVITY_FINISH");
                sendBroadcast(intent);
                finish();
            }

            public boolean shouldOverrideKeyEvent(WebView webview, KeyEvent keyevent)
            {
                return super.shouldOverrideKeyEvent(webview, keyevent);
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                webview = Uri.parse(s).getHost();
                if (s.equals("krassapp://close"))
                {
                    finishActivity();
                } else
                {
                    if (s.equals("internal:noad"))
                    {
                        intent = new Intent();
                        intent.setAction("PROMO_HOUSE_AD_FAILED");
                        sendBroadcast(intent);
                        finishActivity();
                        return false;
                    }
                    if (webview != null && !webview.contains("krassgames"))
                    {
                        intent = new Intent();
                        intent.setAction("PROMO_HOUSE_AD_CLICKED");
                        sendBroadcast(intent);
                        webview = new Intent("android.intent.action.VIEW");
                        webview.setData(Uri.parse(s));
                        startActivity(webview);
                        finishActivity();
                        return true;
                    }
                }
                return false;
            }

            
            {
                this$0 = PromoHouseFullscreenActivity.this;
                super();
            }
        };
    }

    private void finishActivity()
    {
        ViewGroup viewgroup = (ViewGroup)webView.getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(webView);
        }
        intent = new Intent();
        intent.setAction("PROMO_HOUSE_ACTIVITY_FINISH");
        sendBroadcast(intent);
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
        currentUrl = getIntent().getStringExtra("Intent_URL");
    }

    protected void onStart()
    {
        super.onStart();
        webView = new WebView(this);
        webView.setWebViewClient(createWebViewClient());
        webView.getSettings().setCacheMode(1);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            webView.getSettings().setMixedContentMode(2);
        }
        webView.loadUrl(currentUrl);
        show();
    }

    public void show()
    {
        setContentView(webView, new android.view.ViewGroup.LayoutParams(-1, -1));
    }




/*
    static Intent access$102(PromoHouseFullscreenActivity promohousefullscreenactivity, Intent intent1)
    {
        promohousefullscreenactivity.intent = intent1;
        return intent1;
    }

*/
}
