// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class OktaAuthentication extends GrouponActivity
{
    private class OktaAuthenticationWebView extends WebViewClient
    {

        final OktaAuthentication this$0;

        private void showErrorDialog()
        {
            GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(Integer.valueOf(0x7f080165)), "http_error_dialog");
        }

        public void onPageFinished(WebView webview, String s)
        {
            if (s.startsWith("https://groupon.okta.com/app/UserHome"))
            {
                startActivity(intentFactory.newSecretAdminSettingsIntent());
                finish();
            }
            super.onPageFinished(webview, s);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            webView.loadUrl("about:blank");
            showErrorDialog();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }

        private OktaAuthenticationWebView()
        {
            this$0 = OktaAuthentication.this;
            super();
        }

    }


    private static final String LOGIN_SUCCESS_URL = "https://groupon.okta.com/app/UserHome";
    private static final String OKTA_LOGIN_URL = "https://groupon.okta.com/";
    private DialogManager dialogManager;
    private IntentFactory intentFactory;
    WebView webView;
    LinearLayout webViewContent;

    public OktaAuthentication()
    {
    }

    private void cleanupWebView()
    {
        webView.setWebViewClient(null);
        webViewContent.removeAllViews();
        webView.destroy();
    }

    private void setupWebView()
    {
        webView.setWebViewClient(new OktaAuthenticationWebView());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://groupon.okta.com/");
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030183);
        setupWebView();
    }

    public void onDestroy()
    {
        super.onDestroy();
        cleanupWebView();
    }


}
