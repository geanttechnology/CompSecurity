// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.supersonicads.sdk.agent.SupersonicAdsPublisherAgent;
import com.supersonicads.sdk.utils.Logger;
import com.supersonicads.sdk.utils.SupersonicSharedPrefHelper;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

public class OpenUrlActivity extends Activity
{
    private class Client extends WebViewClient
    {

        final OpenUrlActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            mProgressBar.setVisibility(4);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            super.onPageStarted(webview, s, bitmap);
            mProgressBar.setVisibility(0);
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
                mWebViewController.interceptedUrlToStore();
                finish();
                return true;
            }
            return super.shouldOverrideUrlLoading(webview, s);
        }

        private Client()
        {
            this$0 = OpenUrlActivity.this;
            super();
        }

    }


    private static final String TAG = "OpenUrlActivity";
    private static final int WEB_VIEW_VIEW_ID = 1;
    boolean isSecondaryWebview;
    private ProgressBar mProgressBar;
    private String mUrl;
    private SupersonicWebView mWebViewController;
    private RelativeLayout mainLayout;
    private WebView webView;

    public OpenUrlActivity()
    {
        webView = null;
    }

    private void disableTouch()
    {
        getWindow().addFlags(16);
    }

    private void hideActivityTitle()
    {
        requestWindowFeature(1);
    }

    private void hideActivtiyStatusBar()
    {
        getWindow().setFlags(1024, 1024);
    }

    private void initializeWebView()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        webView = new WebView(this);
        webView.setId(1);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new Client());
        mainLayout.addView(webView, layoutparams);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mProgressBar = new ProgressBar(new ContextThemeWrapper(this, 0x1030073));
        } else
        {
            mProgressBar = new ProgressBar(this);
        }
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        mProgressBar.setLayoutParams(layoutparams);
        mProgressBar.setVisibility(4);
        mainLayout.addView(mProgressBar);
        loadUrl(mUrl);
        if (mWebViewController != null)
        {
            mWebViewController.viewableChange(true, "secondary");
        }
    }

    public void finish()
    {
        if (isSecondaryWebview)
        {
            mWebViewController.engageEnd("secondaryClose");
        }
        super.finish();
    }

    public void loadUrl(String s)
    {
        webView.stopLoading();
        webView.clearHistory();
        try
        {
            webView.loadUrl(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.e("OpenUrlActivity", (new StringBuilder()).append("OpenUrlActivity:: loadUrl: ").append(s.toString()).toString());
        }
    }

    public void onBackPressed()
    {
        if (webView.canGoBack())
        {
            webView.goBack();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Logger.i("OpenUrlActivity", "onCreate()");
        mWebViewController = SupersonicAdsPublisherAgent.getInstance(this).getWebViewController();
        hideActivityTitle();
        hideActivtiyStatusBar();
        bundle = getIntent().getExtras();
        mUrl = bundle.getString(SupersonicWebView.EXTERNAL_URL);
        isSecondaryWebview = bundle.getBoolean(SupersonicWebView.SECONDARY_WEB_VIEW);
        mainLayout = new RelativeLayout(this);
        setContentView(mainLayout, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        if (mWebViewController != null)
        {
            mWebViewController.viewableChange(false, "secondary");
            if (mainLayout != null)
            {
                ViewGroup viewgroup = (ViewGroup)webView.getParent();
                if (viewgroup.findViewById(1) != null)
                {
                    viewgroup.removeView(webView);
                    webView.destroy();
                }
            }
        }
    }

    protected void onResume()
    {
        super.onResume();
        initializeWebView();
    }


}
