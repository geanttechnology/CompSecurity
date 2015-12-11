// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.a.b;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OAuth2WebViewActivity extends b
{
    private class OAuth2WebViewClient extends WebViewClient
    {

        final OAuth2WebViewActivity this$0;

        private boolean equalUrls(String s, String s1)
        {
            s = Uri.parse(s);
            for (s1 = Uri.parse(s1); !s.getScheme().equals(s1.getScheme()) || !s.getHost().equals(s1.getHost()) || !s.getPath().equals(s1.getPath());)
            {
                return false;
            }

            return true;
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (equalUrls(s, redirectUri))
            {
                webview.loadUrl("about:blank");
                webview = new Intent();
                webview.putExtra("authResultUrl", s);
                setResult(-1, webview);
                finish();
            } else
            {
                webview.loadUrl(s);
            }
            return false;
        }

        private OAuth2WebViewClient()
        {
            this$0 = OAuth2WebViewActivity.this;
            super();
        }

    }


    public static final String EXTRA_AUTH_RESULT_URL = "authResultUrl";
    public static final String EXTRA_AUTH_URL = "authUrl";
    public static final String EXTRA_REDIRECT_URI = "redirectUri";
    private static final String TAG = "OAuth2WebViewActivity";
    private String authUrl;
    private String redirectUri;
    private WebView webView;

    public OAuth2WebViewActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        redirectUri = bundle.getStringExtra("redirectUri");
        authUrl = bundle.getStringExtra("authUrl");
        if (redirectUri == null || authUrl == null)
        {
            throw new UnsupportedOperationException("You must supply an auth url and redirect uri as intent extras");
        }
        bundle = CookieManager.getInstance();
        bundle.setAcceptCookie(true);
        webView = new WebView(this);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            bundle.setAcceptThirdPartyCookies(webView, true);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new OAuth2WebViewClient());
        setContentView(webView);
        webView.loadUrl(authUrl);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(com.rdio.android.sdk.R.menu.oauth2_web_view, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == com.rdio.android.sdk.R.id.action_settings)
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

}
