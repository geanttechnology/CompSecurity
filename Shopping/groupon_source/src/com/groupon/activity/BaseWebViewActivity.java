// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.crittercism.app.Crittercism;
import com.groupon.service.LoginService;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.WebViewHelper;
import com.groupon.util.WebViewHelperProvider;
import java.net.URISyntaxException;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public abstract class BaseWebViewActivity extends GrouponActivity
    implements GrouponDialogListener, WebViewHelperProvider
{
    public class CustomWebViewClient extends WebViewClient
    {

        private WebViewHelper helper;
        final BaseWebViewActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            progressBar.setVisibility(8);
            navigationFinished(s);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            super.onPageStarted(webview, s, bitmap);
            progressBar.setVisibility(0);
            navigationStarted(s);
            if (helper != null)
            {
                helper.webViewNavigatingStarting(s);
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            webView.loadUrl("about:blank");
            progressBar.setVisibility(8);
            showRetryDialog();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (helper.shouldOverrideUrlLoading(s))
            {
                return true;
            }
            if (s.startsWith("http:") || s.startsWith("https:"))
            {
                return false;
            }
            try
            {
                startActivity(Intent.parseUri(s, 0));
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                Crittercism.logHandledException(webview);
                return false;
            }
            return true;
        }

        public CustomWebViewClient(WebViewHelper webviewhelper)
        {
            this$0 = BaseWebViewActivity.this;
            super();
            helper = webviewhelper;
        }
    }


    private static final String ABOUT_BLANK = "about:blank";
    public static final int SPACESHIP_LIGHTS_FADE_DURATION = 200;
    protected DialogManager dialogManager;
    protected boolean hasSeenWobbleSpaceshipCat;
    protected WebViewHelper helper;
    protected boolean isWobbleSpaceshipCatInProgress;
    protected LoginService loginService;
    protected ProgressBar progressBar;
    protected WebView webView;
    protected FrameLayout webViewPlaceholder;

    public BaseWebViewActivity()
    {
        isWobbleSpaceshipCatInProgress = false;
        hasSeenWobbleSpaceshipCat = false;
    }

    private boolean shouldSkipHistoryItemOnBack(WebHistoryItem webhistoryitem)
    {
        return webhistoryitem != null && (webhistoryitem.getUrl().equals("about:blank") || Strings.equals(webhistoryitem.getUrl(), webView.copyBackForwardList().getCurrentItem().getUrl()));
    }

    public abstract WebViewHelper createHelper();

    protected int getLayoutResId()
    {
        return 0x7f03002f;
    }

    protected void loadUrl()
    {
        webView.loadUrl(helper.getUrl(), helper.createWebViewHeaders(loginService.getAccessToken(), loginService.getUserId()));
    }

    protected void navigationFinished(String s)
    {
    }

    protected void navigationStarted(String s)
    {
    }

    public void onBackPressed()
    {
        if (webView != null && webView.canGoBack())
        {
            int i = webView.copyBackForwardList().getCurrentIndex();
            Object obj = webView.copyBackForwardList();
            i--;
            for (obj = ((WebBackForwardList) (obj)).getItemAtIndex(i); shouldSkipHistoryItemOnBack(((WebHistoryItem) (obj))); obj = ((WebBackForwardList) (obj)).getItemAtIndex(i))
            {
                obj = webView.copyBackForwardList();
                i--;
            }

            i -= webView.copyBackForwardList().getCurrentIndex();
            if (Math.abs(i) > webView.copyBackForwardList().getCurrentIndex())
            {
                super.onBackPressed();
                return;
            } else
            {
                webView.goBackOrForward(i);
                return;
            }
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (webView != null)
        {
            webViewPlaceholder.removeView(webView);
        }
        super.onConfigurationChanged(configuration);
        setupWebView();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(getLayoutResId());
        helper = createHelper();
        setupWebView();
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
        finish();
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
        finish();
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        loadUrl();
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        webView.restoreState(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        webView.saveState(bundle);
    }

    protected void setupWebView()
    {
        if (webView == null)
        {
            webView = new WebView(this);
            setupWebViewClient();
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);
            WebViewHelper.addInAppUserAgent(webView);
            loadUrl();
        }
        webViewPlaceholder.addView(webView);
    }

    protected void setupWebViewClient()
    {
        webView.setWebViewClient(new CustomWebViewClient(helper));
    }

    protected void showRetryDialog()
    {
        GrouponDialogFragment groupondialogfragment = dialogManager.getDialogFragment(null, Integer.valueOf(0x7f0802ef), Integer.valueOf(0x7f080336), Integer.valueOf(0x7f080084), true);
        GrouponDialogFragment.show(getFragmentManager(), groupondialogfragment, "generic_error_dialog");
    }
}
