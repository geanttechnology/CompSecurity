// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth.mapr5;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.TokenManagement;
import java.net.MalformedURLException;
import org.apache.commons.lang3.StringUtils;

public class AuthenticatedWebViewClient extends WebViewClient
{

    private static final String TAG = com/amazon/gallery/framework/kindle/auth/mapr5/AuthenticatedWebViewClient.getName();
    private final Activity activity;
    private final MAPAccountManager mapAccountManager;
    private String responseUrl;
    private final TokenManagement tokenManagement;

    public AuthenticatedWebViewClient(Activity activity1)
    {
        activity = activity1;
        tokenManagement = new TokenManagement(activity1);
        mapAccountManager = new MAPAccountManager(activity1);
    }

    private void getCookiesFromTokenManagement(final WebView webView, String s)
        throws MalformedURLException
    {
        final String domain = GalleryWebViewHelper.getCookieDomainFromUrl(s);
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh", true);
        bundle.putString("com.amazon.identity.auth.device.api.cookiekeys.options.SignInUrl", s);
        tokenManagement.getCookies(mapAccountManager.getAccount(), domain, bundle, new Callback() {

            final AuthenticatedWebViewClient this$0;
            final String val$domain;
            final WebView val$webView;

            public void onError(Bundle bundle1)
            {
                GLogger.e(AuthenticatedWebViewClient.TAG, "Unable to get authentication cookies.", new Object[0]);
            }

            public void onSuccess(Bundle bundle1)
            {
                String as[] = bundle1.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
                if (as.length != 0)
                {
                    GalleryWebViewHelper.setCookies(activity, domain, as);
                }
                if (StringUtils.isNotEmpty(bundle1.getString("com.amazon.identity.auth.device.api.cookiekeys.ResponseUrl")))
                {
                    responseUrl = bundle1.getString("com.amazon.identity.auth.device.api.cookiekeys.ResponseUrl");
                }
                activity.runOnUiThread(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        webView.loadUrl(responseUrl);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = AuthenticatedWebViewClient.this;
                domain = s;
                webView = webview;
                super();
            }
        });
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (responseUrl == null)
        {
            responseUrl = s;
        }
        if (!GalleryWebViewHelper.isInterceptableUrl(s))
        {
            super.onPageStarted(webview, s, bitmap);
            return;
        }
        webview.stopLoading();
        try
        {
            getCookiesFromTokenManagement(webview, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            GLogger.ex(TAG, "Unable to get authentication cookies.", webview);
        }
    }





/*
    static String access$102(AuthenticatedWebViewClient authenticatedwebviewclient, String s)
    {
        authenticatedwebviewclient.responseUrl = s;
        return s;
    }

*/

}
