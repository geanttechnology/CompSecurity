// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.ebay.android.widget.ButtonBar;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.ui_stuff.Util;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity

public class RtmDownloadAppActivity extends BaseActivity
{
    private class RtmWebViewClient extends WebViewClient
    {

        final RtmDownloadAppActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            setTitle(myTitle);
            CookieSyncManager.getInstance().sync();
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            if (!isFinishing())
            {
                Util.resetAppStatus(RtmDownloadAppActivity.this);
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            Log.e("RtmDownloadAppActivity", (new StringBuilder()).append((new Exception()).getStackTrace()[0].getMethodName()).append(": errorCode = <").append(i).append(">").append(": description = <").append(s).append(">").append(": failingUrl = <").append(s1).append(">").toString());
            webview = s;
            if (i > 0)
            {
                webview = (new StringBuilder()).append(s).append(" (").append(i).append(")").toString();
            }
            dialogManager.showDynamicAlertDialog(null, webview, true);
            finish();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            Log.v("RtmDownloadAppActivity", (new StringBuilder()).append("url = <").append(s).append(">").toString());
            webview.loadUrl(s);
            return false;
        }

        private RtmWebViewClient()
        {
            this$0 = RtmDownloadAppActivity.this;
            super();
        }

    }


    private static final String TAG = "RtmDownloadAppActivity";
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private String downloadUrl;
    private String myTitle;
    private WebView myWebView;

    public RtmDownloadAppActivity()
    {
        myWebView = null;
        downloadUrl = null;
        myTitle = null;
    }

    public String getTrackingEventName()
    {
        return "RtmDownload";
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = getIntent().getExtras();
        String s = new String();
        bundle = new String();
        Object obj = new String();
        if (bundle1 != null)
        {
            s = bundle1.getString("android.intent.extra.TITLE");
            bundle = bundle1.getString("url");
            obj = bundle1.getString("downloadUrl");
        }
        downloadUrl = ((String) (obj));
        myTitle = s;
        setContentView(0x7f0301c2);
        setTitle(s);
        myWebView = (WebView)findViewById(0x7f100556);
        obj = myWebView.getSettings();
        ((WebSettings) (obj)).setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        ((WebSettings) (obj)).setLoadsImagesAutomatically(true);
        ((WebSettings) (obj)).setJavaScriptCanOpenWindowsAutomatically(true);
        ((WebSettings) (obj)).setJavaScriptEnabled(false);
        myWebView.setWebViewClient(new RtmWebViewClient());
        ((WebSettings) (obj)).setJavaScriptEnabled(true);
        myWebView.loadUrl(bundle);
        bundle = (ButtonBar)findViewById(0x7f100555);
        bundle.getNegativeButton().setOnClickListener(new android.view.View.OnClickListener() {

            final RtmDownloadAppActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = RtmDownloadAppActivity.this;
                super();
            }
        });
        bundle.getPositiveButton().setOnClickListener(new android.view.View.OnClickListener() {

            final RtmDownloadAppActivity this$0;

            public void onClick(View view)
            {
                if (!TextUtils.isEmpty(downloadUrl)) goto _L2; else goto _L1
_L1:
                finish();
                return;
_L2:
                if (downloadUrl.startsWith("http://market.android.com"))
                {
                    int i = "http://market.android.com".length();
                    if (downloadUrl.length() > i)
                    {
                        view = Uri.parse((new StringBuilder()).append("market://").append(downloadUrl.substring(i + 1)).toString());
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(view);
                        startActivity(intent);
                    }
                } else
                if (downloadUrl.startsWith("market://"))
                {
                    view = Uri.parse(downloadUrl);
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    intent1.setData(view);
                    startActivity(intent1);
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = RtmDownloadAppActivity.this;
                super();
            }
        });
        bundle = findViewById(0x7f1003ab);
        if (bundle != null)
        {
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final RtmDownloadAppActivity this$0;

                public void onClick(View view)
                {
                    finish();
                }

            
            {
                this$0 = RtmDownloadAppActivity.this;
                super();
            }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && myWebView != null && myWebView.canGoBack())
        {
            myWebView.goBack();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    protected void recoverFromSavedInstanceState(Bundle bundle)
    {
        if (bundle != null);
    }


}
