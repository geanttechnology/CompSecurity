// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            ft, UriUtils, fl, AdUnit, 
//            FlurryFullscreenTakeoverActivity, FlurryAds, cy

final class gg extends WebViewClient
{

    private ft dp;

    gg(ft ft1)
    {
        this(ft1, (byte)0);
    }

    private gg(ft ft1, byte byte0)
    {
        dp = ft1;
        super();
    }

    public final void onLoadResource(WebView webview, String s)
    {
        (new StringBuilder()).append("onLoadResource: url = ").append(s).toString();
        super.onLoadResource(webview, s);
        if (s != null && webview != null && webview == ft.b(dp))
        {
            if (!s.equalsIgnoreCase(ft.b(dp).getUrl()))
            {
                ft.c(dp);
            }
            if (!ft.d(dp))
            {
                webview = Uri.parse(s).getLastPathSegment();
                if (webview != null && webview.equalsIgnoreCase("mraid.js"))
                {
                    ft.a(dp, true);
                    ft.e(dp);
                    if (ft.f(dp))
                    {
                        ft.g(dp);
                        ft.h(dp);
                        return;
                    }
                }
            }
        }
    }

    public final void onPageFinished(WebView webview, String s)
    {
        (new StringBuilder()).append("onPageFinished: url = ").append(s).toString();
        if (s != null && webview != null && webview == ft.b(dp))
        {
            ft.c(dp);
            ft.k(dp);
            if (!dp.a(ft.b(dp)) && (dp.bw() == 2 || dp.bw() == 1))
            {
                dp.addView(ft.b(dp));
            }
            ft.b(dp, true);
            if (ft.d(dp))
            {
                ft.g(dp);
                ft.h(dp);
                return;
            }
        }
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        (new StringBuilder()).append("onPageStarted: url = ").append(s).toString();
        if (s == null || webview == null || webview != ft.b(dp))
        {
            return;
        } else
        {
            ft.i(dp);
            ft.j(dp);
            ft.b(dp, false);
            ft.a(dp, false);
            return;
        }
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        dp.a("renderFailed", Collections.emptyMap(), dp.T, dp.S, dp.U, 0);
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        (new StringBuilder()).append("shouldOverrideUrlLoading: url = ").append(s).toString();
        if (s == null || webview == null || webview != ft.b(dp))
        {
            return false;
        }
        Object obj = UriUtils.currentDir(ft.b(dp).getUrl());
        webview = s;
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            webview = s;
            if (s.startsWith(((String) (obj))))
            {
                obj = s.substring(((String) (obj)).length());
                Uri uri = Uri.parse(((String) (obj)));
                webview = s;
                if (uri.isHierarchical())
                {
                    webview = s;
                    if (!TextUtils.isEmpty(uri.getScheme()))
                    {
                        webview = s;
                        if (!TextUtils.isEmpty(uri.getAuthority()))
                        {
                            (new StringBuilder()).append("shouldOverrideUrlLoading: target url = ").append(((String) (obj))).toString();
                            webview = ((WebView) (obj));
                        }
                    }
                }
            }
        }
        s = Uri.parse(webview);
        if (s.getScheme() != null && s.getScheme().equals("flurry"))
        {
            webview = s.getQueryParameter("event");
            if (webview != null)
            {
                ft.l(dp).add(webview);
                s = fl.H(s.getEncodedQuery());
                if (s.containsKey("guid"))
                {
                    obj = ft.a(dp, (String)s.get("guid"));
                    cw cw = ft.b(dp, (String)s.get("guid"));
                    if (obj != null && cw != null)
                    {
                        dp.a(webview, s, ((AdUnit) (obj)), cw, 0, 0);
                    }
                } else
                {
                    dp.a(webview, s, dp.T, dp.S, dp.U, 0);
                }
            }
            return true;
        }
        dp.a("clicked", Collections.emptyMap(), dp.T, dp.S, dp.U, 0);
        if (dp.bz())
        {
            ft.b(dp).loadUrl(webview);
            return true;
        }
        s = dp.T.getAdSpace().toString();
        obj = new Intent(ft.m(dp), com/flurry/android/FlurryFullscreenTakeoverActivity);
        ((Intent) (obj)).putExtra("url", webview);
        if (!dp.R.a(ft.m(dp), ((Intent) (obj)), s))
        {
            cy.d(ft.a(dp), "Unable to launch FlurryFullscreenTakeoverActivity, falling back to browser. Fix by declaring this Activity in your AndroidManifest.xml");
            dp.R.c(ft.m(dp), webview, s);
        }
        return true;
    }
}
