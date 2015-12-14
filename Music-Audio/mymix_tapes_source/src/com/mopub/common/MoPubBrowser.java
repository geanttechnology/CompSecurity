// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.util.WebViews;

// Referenced classes of package com.mopub.common:
//            BrowserWebViewClient

public class MoPubBrowser extends Activity
{

    public static final String DESTINATION_URL_KEY = "URL";
    private static final int INNER_LAYOUT_ID = 1;
    public static final int MOPUB_BROWSER_REQUEST_CODE = 1;
    private ImageButton mBackButton;
    private ImageButton mCloseButton;
    private ImageButton mForwardButton;
    private ImageButton mRefreshButton;
    private WebView mWebView;

    public MoPubBrowser()
    {
    }

    private void enableCookies()
    {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    private ImageButton getButton(Drawable drawable)
    {
        ImageButton imagebutton = new ImageButton(this);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2, 1.0F);
        layoutparams.gravity = 16;
        imagebutton.setLayoutParams(layoutparams);
        imagebutton.setImageDrawable(drawable);
        return imagebutton;
    }

    private View getMoPubBrowserView()
    {
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        linearlayout.setOrientation(1);
        RelativeLayout relativelayout = new RelativeLayout(this);
        relativelayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        linearlayout.addView(relativelayout);
        Object obj = new LinearLayout(this);
        ((LinearLayout) (obj)).setId(1);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.addRule(12);
        ((LinearLayout) (obj)).setLayoutParams(layoutparams);
        ((LinearLayout) (obj)).setBackgroundDrawable(Drawables.BACKGROUND.createDrawable(this));
        relativelayout.addView(((View) (obj)));
        mBackButton = getButton(Drawables.LEFT_ARROW.createDrawable(this));
        mForwardButton = getButton(Drawables.RIGHT_ARROW.createDrawable(this));
        mRefreshButton = getButton(Drawables.REFRESH.createDrawable(this));
        mCloseButton = getButton(Drawables.CLOSE.createDrawable(this));
        ((LinearLayout) (obj)).addView(mBackButton);
        ((LinearLayout) (obj)).addView(mForwardButton);
        ((LinearLayout) (obj)).addView(mRefreshButton);
        ((LinearLayout) (obj)).addView(mCloseButton);
        mWebView = new BaseWebView(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(2, 1);
        mWebView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        relativelayout.addView(mWebView);
        return linearlayout;
    }

    private void initializeButtons()
    {
        mBackButton.setBackgroundColor(0);
        mBackButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MoPubBrowser this$0;

            public void onClick(View view)
            {
                if (mWebView.canGoBack())
                {
                    mWebView.goBack();
                }
            }

            
            {
                this$0 = MoPubBrowser.this;
                super();
            }
        });
        mForwardButton.setBackgroundColor(0);
        mForwardButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MoPubBrowser this$0;

            public void onClick(View view)
            {
                if (mWebView.canGoForward())
                {
                    mWebView.goForward();
                }
            }

            
            {
                this$0 = MoPubBrowser.this;
                super();
            }
        });
        mRefreshButton.setBackgroundColor(0);
        mRefreshButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MoPubBrowser this$0;

            public void onClick(View view)
            {
                mWebView.reload();
            }

            
            {
                this$0 = MoPubBrowser.this;
                super();
            }
        });
        mCloseButton.setBackgroundColor(0);
        mCloseButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MoPubBrowser this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = MoPubBrowser.this;
                super();
            }
        });
    }

    private void initializeWebView()
    {
        WebSettings websettings = mWebView.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setSupportZoom(true);
        websettings.setBuiltInZoomControls(true);
        websettings.setUseWideViewPort(true);
        mWebView.loadUrl(getIntent().getStringExtra("URL"));
        mWebView.setWebViewClient(new BrowserWebViewClient(this));
        mWebView.setWebChromeClient(new WebChromeClient() {

            final MoPubBrowser this$0;

            public void onProgressChanged(WebView webview, int i)
            {
                setTitle("Loading...");
                setProgress(i * 100);
                if (i == 100)
                {
                    setTitle(webview.getUrl());
                }
            }

            
            {
                this$0 = MoPubBrowser.this;
                super();
            }
        });
    }

    public static void open(Context context, String s)
    {
        MoPubLog.d((new StringBuilder()).append("Opening url in MoPubBrowser: ").append(s).toString());
        Intent intent = new Intent(context, com/mopub/common/MoPubBrowser);
        intent.putExtra("URL", s);
        intent.addFlags(0x10000000);
        context.startActivity(intent);
    }

    public void finish()
    {
        ((ViewGroup)getWindow().getDecorView()).removeAllViews();
        super.finish();
    }

    public ImageButton getBackButton()
    {
        return mBackButton;
    }

    public ImageButton getCloseButton()
    {
        return mCloseButton;
    }

    public ImageButton getForwardButton()
    {
        return mForwardButton;
    }

    public ImageButton getRefreshButton()
    {
        return mRefreshButton;
    }

    public WebView getWebView()
    {
        return mWebView;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setResult(-1);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        setContentView(getMoPubBrowserView());
        initializeWebView();
        initializeButtons();
        enableCookies();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        mWebView.destroy();
        mWebView = null;
    }

    protected void onPause()
    {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        WebViews.onPause(mWebView, isFinishing());
    }

    protected void onResume()
    {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        WebViews.onResume(mWebView);
    }

    void setWebView(WebView webview)
    {
        mWebView = webview;
    }

}
