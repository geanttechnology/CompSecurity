// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class OAuthLoginFragment extends PMFragment
{

    PMActivity parentActivity;
    String url;
    WebView webView;

    public OAuthLoginFragment()
    {
        webView = null;
        url = null;
    }

    private void setupWebClient()
    {
        webView.setWebViewClient(new WebViewClient() {

            final OAuthLoginFragment this$0;

            public void onPageFinished(WebView webview, String s)
            {
                hideProgressDialog();
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                showAutoHideProgressDialogWithMessage(s);
            }

            public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
            {
                sslerrorhandler.proceed();
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (s.contains("http://localhost") && s.contains("oauth_verifier"))
                {
                    fireloginCompleteIntent(s);
                    parentActivity.popTopFragment();
                } else
                if (s.contains("http://localhost") && (s.contains("denied") || s.contains("#_=_")))
                {
                    PMNotificationManager.fireNotification("com.poshmark.intents.OAUTH_CANCEL");
                    parentActivity.popTopFragment();
                } else
                {
                    webview.loadUrl(s);
                }
                return true;
            }

            
            {
                this$0 = OAuthLoginFragment.this;
                super();
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {

            final OAuthLoginFragment this$0;

            public boolean onConsoleMessage(ConsoleMessage consolemessage)
            {
                Log.d("MyApplication", (new StringBuilder()).append(consolemessage.message()).append(" -- From line ").append(consolemessage.lineNumber()).append(" of ").append(consolemessage.sourceId()).toString());
                return true;
            }

            
            {
                this$0 = OAuthLoginFragment.this;
                super();
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
    }

    protected void fireloginCompleteIntent(String s)
    {
        Bundle bundle;
        s = (new URL(s)).getQuery().split("&");
        bundle = new Bundle();
        int i = 0;
_L2:
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        String as[] = s[i].split("=");
        bundle.putString(as[0], as[1]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            PMNotificationManager.fireNotification("com.poshmark.intents.OAUTH_REPONSE_OK", bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
    }

    public boolean handleBack()
    {
        if (webView.canGoBack())
        {
            webView.goBack();
            webView.clearHistory();
            return true;
        } else
        {
            return false;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        parentActivity = (PMActivity)getActivity();
        webView = (WebView)getView().findViewById(0x7f0c0318);
        setupWebClient();
        webView.loadUrl(url);
        showProgressDialogWithMessage(getString(0x7f060190));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        url = getArguments().getString("URL");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f0300d2, viewgroup, false);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = getArguments().getString("ANALYTICS_PAGE_NAME", "oauth_login_screen");
    }
}
