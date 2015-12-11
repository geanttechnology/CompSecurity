// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ebay.common.Preferences;
import com.ebay.common.SsoScopeLoader;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.motors.videos.FwContextUtil;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, LinkHandlerActivity

public class RtmHtmlActivity extends BaseActivity
{
    private class RtmWebViewClient extends WebViewClient
    {

        final RtmHtmlActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            if (RtmHtmlActivity.log.isLoggable)
            {
                RtmHtmlActivity.log.log((new StringBuilder()).append("Page finished: ").append(s).toString());
            }
            RtmHtmlActivity rtmhtmlactivity = RtmHtmlActivity.this;
            boolean flag;
            if (isDoneFlag || isUrlLastPage(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            rtmhtmlactivity.isDoneFlag = flag;
            super.onPageFinished(webview, s);
            if (s.equals(url) && historyReset)
            {
                myWebView.clearHistory();
                historyReset = false;
            }
            setTitle(title);
            CookieSyncManager.getInstance().sync();
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            if (RtmHtmlActivity.log.isLoggable)
            {
                RtmHtmlActivity.log.log((new StringBuilder()).append("Page started: ").append(s).toString());
            }
            if (!isFinishing())
            {
                Util.resetAppStatus(RtmHtmlActivity.this);
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            Log.e("RtmHtmlActivity", (new StringBuilder()).append((new Exception()).getStackTrace()[0].getMethodName()).append(": errorCode = <").append(i).append(">").append(": description = <").append(s).append(">").append(": failingUrl = <").append(s1).append(">").toString());
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
            webview = Uri.parse(s);
            if (s.startsWith("ebay://link"))
            {
                if (RtmHtmlActivity.log.isLoggable)
                {
                    RtmHtmlActivity.log.log("  Handle as ebay link");
                }
                webview = new Intent("android.intent.action.VIEW", webview, RtmHtmlActivity.this, com/ebay/mobile/activities/LinkHandlerActivity);
                startActivity(webview);
                return true;
            }
            if (s.startsWith("http://market.android.com"))
            {
                if (RtmHtmlActivity.log.isLoggable)
                {
                    RtmHtmlActivity.log.log("  Handle as market link");
                }
                int i = "http://market.android.com".length();
                if (s.length() > i)
                {
                    webview = Uri.parse((new StringBuilder()).append("market://").append(s.substring(i + 1)).toString());
                    s = new Intent("android.intent.action.VIEW");
                    s.setData(webview);
                    startActivity(s);
                    return true;
                }
            } else
            {
                if (s.startsWith("market://"))
                {
                    if (RtmHtmlActivity.log.isLoggable)
                    {
                        RtmHtmlActivity.log.log("  Handle as market link");
                    }
                    webview = Uri.parse(s);
                    s = new Intent("android.intent.action.VIEW");
                    s.setData(webview);
                    startActivity(s);
                    return true;
                }
                if ("tel".equals(webview.getScheme()) || "mailto".equals(webview.getScheme()))
                {
                    if (RtmHtmlActivity.log.isLoggable)
                    {
                        RtmHtmlActivity.log.log("  Handle as other non-heirarchical link");
                    }
                    webview = new Intent("android.intent.action.VIEW", webview);
                    startActivity(webview);
                    return true;
                }
                s = webview.getHost();
                if (!TextUtils.isEmpty(s) && s.toLowerCase(Locale.getDefault()).equals("pages.ebay.com") && webview.getPath().toLowerCase(Locale.getDefault()).startsWith("/link/"))
                {
                    webview = new Intent("android.intent.action.VIEW", webview);
                    webview = FwContextUtil.getLocalActivity(RtmHtmlActivity.this, webview);
                    if (webview.getComponent() != null)
                    {
                        startActivity(webview);
                        finish();
                        return true;
                    }
                }
            }
            if (RtmHtmlActivity.log.isLoggable)
            {
                RtmHtmlActivity.log.log("  Handle as a regular link");
            }
            return false;
        }

        private RtmWebViewClient()
        {
            this$0 = RtmHtmlActivity.this;
            super();
        }

    }


    protected static final String COMPLETION_STATUS = "ebay-mobile-status";
    private static final int LOADER_ID_SSO_TOKEN = 1;
    private static final String TAG = "RtmHtmlActivity";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("RtmHtmlActivity", 3, "RTM webview");
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private boolean historyReset;
    protected boolean isDoneFlag;
    private WebView myWebView;
    private String title;
    private String url;

    public RtmHtmlActivity()
    {
        myWebView = null;
        title = new String();
        url = null;
        historyReset = false;
        isDoneFlag = false;
    }

    public String getTrackingEventName()
    {
        return "RtmHtml";
    }

    protected boolean isUrlLastPage(String s)
    {
        boolean flag = false;
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        if (Uri.parse(s).getQueryParameter("ebay-mobile-status") != null)
        {
            flag = true;
        }
        return flag;
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag1;
        super.onCreate(bundle);
        final View progressView = getIntent().getExtras();
        bundle = null;
        boolean flag = false;
        if (progressView != null)
        {
            title = progressView.getString("android.intent.extra.TITLE");
            url = progressView.getString("url");
            bundle = progressView.getString("ssoScope");
            if (!TextUtils.isEmpty(bundle))
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        setContentView(0x7f03024b);
        myWebView = (WebView)findViewById(0x7f100316);
        myWebView.setBackgroundColor(0xff000000);
        myWebView.setScrollBarStyle(0);
        myWebView.setWebViewClient(new RtmWebViewClient());
        progressView = findViewById(0x7f100143);
        myWebView.setWebChromeClient(new WebChromeClient() {

            final RtmHtmlActivity this$0;
            final View val$progressView;

            public void onProgressChanged(WebView webview, int i)
            {
                webview = progressView;
                if (i <= 99)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                webview.setVisibility(i);
            }

            
            {
                this$0 = RtmHtmlActivity.this;
                progressView = view;
                super();
            }
        });
        progressView = getSharedPreferences("WebViewSettings", 0);
        if (progressView.getInt("double_tap_toast_count", 1) > 0)
        {
            progressView.edit().putInt("double_tap_toast_count", 0).commit();
        }
        progressView = myWebView.getSettings();
        progressView.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        progressView.setLoadsImagesAutomatically(true);
        progressView.setJavaScriptEnabled(true);
        progressView.setJavaScriptCanOpenWindowsAutomatically(false);
        progressView.setSupportZoom(true);
        progressView.setBuiltInZoomControls(true);
        progressView.setDisplayZoomControls(false);
        progressView.setLoadWithOverviewMode(true);
        progressView.setSavePassword(false);
        flag1 = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        progressView = MyApp.getPrefs().getAuthentication();
        flag1 = flag;
        if (progressView == null)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        bundle = new SsoScopeLoader(getEbayContext(), progressView, bundle, url);
        getFwLoaderManager().start(1, bundle, true);
        flag1 = flag;
_L2:
        if (!flag1)
        {
            myWebView.loadUrl(url);
        }
        bundle = findViewById(0x7f1003ab);
        if (bundle != null)
        {
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final RtmHtmlActivity this$0;

                public void onClick(View view)
                {
                    finish();
                }

            
            {
                this$0 = RtmHtmlActivity.this;
                super();
            }
            });
        }
        return;
        bundle;
        flag1 = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (!isDoneFlag && i == 4 && myWebView.canGoBack())
        {
            myWebView.goBack();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (!isDoneFlag && 0x102002c == menuitem.getItemId() && myWebView.canGoBack())
        {
            myWebView.goBack();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu);
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

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        super.onTaskComplete(i, fwloader);
        if (isFinishing())
        {
            return;
        }
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            fwloader = (SsoScopeLoader)fwloader;
            break;
        }
        if (fwloader.isError())
        {
            if (Util.hasNetwork())
            {
                Log.e("RtmHtmlActivity", (new StringBuilder()).append("SSO failed: ").append(((SsoScopeLoader) (fwloader)).errorCode).append(" ").append(((SsoScopeLoader) (fwloader)).errorDescription).toString());
                myWebView.loadUrl(url);
                return;
            } else
            {
                (new EbayErrorHandler(this)).handleEbayError(null, fwloader);
                finish();
                return;
            }
        } else
        {
            fwloader = fwloader.getSsoUrl();
            historyReset = true;
            myWebView.loadUrl(fwloader);
            return;
        }
    }

    protected void recoverFromSavedInstanceState(Bundle bundle)
    {
        if (bundle != null);
    }






/*
    static boolean access$302(RtmHtmlActivity rtmhtmlactivity, boolean flag)
    {
        rtmhtmlactivity.historyReset = flag;
        return flag;
    }

*/


}
