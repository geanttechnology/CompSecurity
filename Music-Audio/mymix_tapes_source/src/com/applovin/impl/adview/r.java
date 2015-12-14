// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

// Referenced classes of package com.applovin.impl.adview:
//            o, AdViewControllerImpl

class r extends WebViewClient
{

    private final AppLovinLogger a;
    private final AdViewControllerImpl b;

    public r(AdViewControllerImpl adviewcontrollerimpl, AppLovinSdk applovinsdk)
    {
        a = applovinsdk.getLogger();
        b = adviewcontrollerimpl;
    }

    private void a(o o1, Uri uri)
    {
        com.applovin.sdk.AppLovinAd applovinad = o1.a();
        o1 = o1.getParent();
        if ((o1 instanceof AppLovinAdView) && applovinad != null)
        {
            b.a(applovinad, (AppLovinAdView)o1, b, uri);
            return;
        } else
        {
            a.e("AdWebViewClient", (new StringBuilder()).append("Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = ").append(uri).toString());
            return;
        }
    }

    void a(WebView webview, String s)
    {
        o o1;
        Uri uri;
label0:
        {
            a.d("AdWebViewClient", (new StringBuilder()).append("Processing click on ad URL \"").append(s).append("\"").toString());
            if (s != null && (webview instanceof o))
            {
                uri = Uri.parse(s);
                o1 = (o)webview;
                String s1 = uri.getScheme();
                String s2 = uri.getHost();
                String s3 = uri.getPath();
                if (!"applovin".equals(s1) || !"com.applovin.sdk".equals(s2))
                {
                    break label0;
                }
                if ("/adservice/next_ad".equals(s3))
                {
                    a(o1);
                } else
                {
                    if ("/adservice/close_ad".equals(s3))
                    {
                        b(o1);
                        return;
                    }
                    if (!AppLovinAdServiceImpl.URI_NO_OP.equals(s3))
                    {
                        if (AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY.equals(s3))
                        {
                            a(o1, Uri.parse(AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY));
                            return;
                        }
                        if (s3 != null && s3.startsWith("/launch/"))
                        {
                            s = uri.getPathSegments();
                            if (s != null && s.size() > 1)
                            {
                                s = (String)s.get(s.size() - 1);
                                try
                                {
                                    webview = webview.getContext();
                                    webview.startActivity(webview.getPackageManager().getLaunchIntentForPackage(s));
                                    a(o1, ((Uri) (null)));
                                    return;
                                }
                                // Misplaced declaration of an exception variable
                                catch (WebView webview)
                                {
                                    a.e("AdWebViewClient", (new StringBuilder()).append("Threw Exception Trying to Launch App for Package: ").append(s).toString(), webview);
                                }
                                return;
                            }
                        } else
                        {
                            a.w("AdWebViewClient", (new StringBuilder()).append("Unknown URL: ").append(s).toString());
                            a.w("AdWebViewClient", (new StringBuilder()).append("Path: ").append(s3).toString());
                            return;
                        }
                    }
                }
            }
            return;
        }
        a(o1, uri);
    }

    void a(o o1)
    {
        o1 = o1.getParent();
        if (o1 instanceof AppLovinAdView)
        {
            ((AppLovinAdView)o1).loadNextAd();
        }
    }

    void b(o o1)
    {
        b.a();
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        b.onAdHtmlLoaded(webview);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        a(webview, s);
        return true;
    }
}
