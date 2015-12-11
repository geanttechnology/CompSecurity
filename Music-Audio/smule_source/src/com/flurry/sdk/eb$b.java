// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            eb, gd, ap, b, 
//            av, aw, cv, hp, 
//            cu, i, g

class <init> extends WebViewClient
{

    final eb a;

    public void onLoadResource(WebView webview, String s)
    {
        gd.a(3, eb.c(a), (new StringBuilder()).append("onLoadResource: url = ").append(s).toString());
        super.onLoadResource(webview, s);
        if (s != null && webview != null && webview == eb.d(a)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!s.equalsIgnoreCase(eb.d(a).getUrl()))
        {
            eb.e(a);
        }
        if (!eb.f(a) && Uri.parse(s).getLastPathSegment() != null)
        {
            if (!eb.g(a))
            {
                continue; /* Loop/switch isn't completed */
            }
            eb.a(a, true);
            eb.h(a);
            if (eb.i(a))
            {
                eb.j(a);
                eb.k(a);
                eb.l(a);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (!eb.i(a)) goto _L1; else goto _L3
_L3:
        eb.m(a);
        if (eb.n(a) && eb.o(a) == 2)
        {
            eb.p(a);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onPageFinished(WebView webview, String s)
    {
        gd.a(3, eb.c(a), (new StringBuilder()).append("onPageFinished: url = ").append(s).append(" adcontroller index: ").append(a.getAdController().c()).toString());
        if (s != null && webview != null && webview == eb.d(a)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        eb.e(a);
        eb.s(a);
        a.dismissProgressDialog();
        if (!a.a(eb.d(a)) && (eb.o(a) == 2 || eb.o(a) == 1))
        {
            gd.a(3, eb.c(a), "adding WebView to AdUnityView");
            a.addView(eb.d(a));
        }
        eb.b(a, true);
        if (!eb.g(a))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (eb.f(a))
        {
            eb.j(a);
            eb.k(a);
            eb.l(a);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!eb.f(a)) goto _L1; else goto _L3
_L3:
        webview = b.a("mraidAdNotSupported");
        eb.a(a, webview);
        s = new HashMap();
        a.a(webview, s, a.getAdController(), 0);
        if (eb.n(a) && eb.o(a) == 2)
        {
            eb.p(a);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        gd.a(3, eb.c(a), (new StringBuilder()).append("onPageStarted: url = ").append(s).toString());
        if (s == null || webview == null || webview != eb.d(a))
        {
            return;
        } else
        {
            eb.q(a);
            eb.r(a);
            eb.b(a, false);
            eb.a(a, false);
            return;
        }
    }

    public void onReceivedError(WebView webview, int j, String s, String s1)
    {
        gd.a(3, eb.c(a), (new StringBuilder()).append("onReceivedError: url = ").append(s1).toString());
        a.dismissProgressDialog();
        webview = Uri.parse(s1);
        if ("market".equals(webview.getScheme()))
        {
            s = new Intent("android.intent.action.VIEW");
            s.setData(webview);
            a.getContext().startActivity(s);
            eb.a(a);
            return;
        } else
        {
            webview = new HashMap();
            webview.put("errorCode", Integer.toString(av.q.a()));
            webview.put("webViewErrorCode", Integer.toString(j));
            webview.put("failingUrl", s1);
            a.a(aw.g, webview, a.getAdController(), 0);
            return;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        boolean flag;
        flag = true;
        gd.a(3, eb.c(a), (new StringBuilder()).append("shouldOverrideUrlLoading: url = ").append(s).toString());
        if (s != null && webview != null && webview == eb.d(a)) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        webview = cv.c(eb.d(a).getUrl());
        if (TextUtils.isEmpty(webview) || !s.startsWith(webview))
        {
            break; /* Loop/switch isn't completed */
        }
        webview = s.substring(webview.length());
        Uri uri = Uri.parse(webview);
        if (!uri.isHierarchical() || TextUtils.isEmpty(uri.getScheme()) || TextUtils.isEmpty(uri.getAuthority()))
        {
            break; /* Loop/switch isn't completed */
        }
        gd.a(3, eb.c(a), (new StringBuilder()).append("shouldOverrideUrlLoading: target url = ").append(webview).toString());
_L5:
        s = Uri.parse(webview);
        gd.a(3, eb.c(a), (new StringBuilder()).append("shouldOverrideUrlLoading: getScheme = ").append(s.getScheme()).toString());
        if ("flurry".equals(s.getScheme()))
        {
            webview = s.getQueryParameter("event");
            if (!TextUtils.isEmpty(webview))
            {
                webview = b.a(webview);
                eb.b(a, webview);
                eb.a(a, webview, s);
                s = hp.h(s.getEncodedQuery());
                s.put("requiresCallComplete", "true");
                a.a(webview, s, a.getAdController(), 0);
                return true;
            }
        } else
        {
            if (eb.t(a))
            {
                eb.c(a, false);
                s = new HashMap();
                a.a(aw.h, s, a.getAdController(), 0);
            }
            if (a.getAdController().l())
            {
                boolean flag1;
                boolean flag2;
                if (cv.d(webview))
                {
                    gd.a(3, eb.c(a), "shouldOverrideUrlLoading: isMarketUrl ");
                    flag1 = cu.a(a.getContext(), webview);
                } else
                {
                    flag1 = false;
                }
                flag2 = flag1;
                if (!flag1)
                {
                    flag2 = flag1;
                    if (cv.f(webview))
                    {
                        gd.a(3, eb.c(a), "shouldOverrideUrlLoading: isGooglePlayUrl ");
                        flag2 = cu.b(a.getContext(), webview);
                    }
                }
                if (flag2)
                {
                    a.a(aw.O, Collections.emptyMap(), a.getAdController(), 0);
                    return true;
                } else
                {
                    gd.a(3, eb.c(a), "shouldOverrideUrlLoading: loadUrl doGenericLaunch ");
                    i.a().o().a(a.getContext(), webview, true, a.getAdObject(), true, eb.u(a));
                    return true;
                }
            } else
            {
                gd.a(3, eb.c(a), "shouldOverrideUrlLoading: doGenericLaunch ");
                i.a().o().a(a.getContext(), webview, true, a.getAdObject(), true, eb.u(a));
                return true;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        webview = s;
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    private ew(eb eb1)
    {
        a = eb1;
        super();
    }

    ewClient(eb eb1, ewClient ewclient)
    {
        this(eb1);
    }
}
