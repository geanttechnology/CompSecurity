// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.DateUtils;

// Referenced classes of package com.appnexus.opensdk.b:
//            b, j, k

public final class o
{

    public static void a(WebView webview)
    {
        if (webview != null)
        {
            webview.getSettings().setBuiltInZoomControls(false);
            webview.getSettings().setSupportZoom(true);
            webview.getSettings().setUseWideViewPort(true);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.getSettings().setDomStorageEnabled(true);
            if (android.os.Build.VERSION.SDK_INT >= 17)
            {
                webview.getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                CookieManager cookiemanager = CookieManager.getInstance();
                if (cookiemanager != null)
                {
                    cookiemanager.setAcceptThirdPartyCookies(webview, true);
                    return;
                } else
                {
                    com.appnexus.opensdk.b.b.b(b.b, "Failed to set Webview to accept 3rd party cookie");
                    return;
                }
            }
        }
    }

    public static void a(List list)
    {
        CookieManager cookiemanager;
        StringBuilder stringbuilder;
        Cookie cookie;
        Date date;
        try
        {
            cookiemanager = CookieManager.getInstance();
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            return;
        }
        if (cookiemanager != null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        com.appnexus.opensdk.b.b.c(b.f, "Unable to find a CookieManager");
        return;
        if (!k.a(cookiemanager.getCookie(j.y)))
        {
            com.appnexus.opensdk.b.b.b(b.f, "Webview already has our cookie");
            return;
        }
        stringbuilder = new StringBuilder();
        list = list.iterator();
_L1:
        do
        {
            if (!list.hasNext())
            {
                break MISSING_BLOCK_LABEL_291;
            }
            cookie = (Cookie)list.next();
        } while (!"uuid2".equals(cookie.getName()));
        if (!k.a(cookie.getDomain()))
        {
            stringbuilder.append("domain=").append(cookie.getDomain()).append("; ");
        }
        if (!k.a(cookie.getPath()))
        {
            stringbuilder.append("path=").append(cookie.getPath()).append("; ");
        }
        stringbuilder.append(cookie.getName()).append('=').append(cookie.getValue()).append("; ");
        date = cookie.getExpiryDate();
        if (date == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        if (date.getTime() > 0L)
        {
            stringbuilder.append("expires=").append(DateUtils.formatDate(date)).append("; ");
        }
        if (!cookie.isSecure())
        {
            break MISSING_BLOCK_LABEL_281;
        }
        stringbuilder.append("secure");
_L2:
        com.appnexus.opensdk.b.b.b(b.f, (new StringBuilder("set-cookie: ")).append(stringbuilder.toString()).toString());
        cookiemanager.setCookie(j.x, stringbuilder.toString());
          goto _L1
        stringbuilder.append("HttpOnly");
          goto _L2
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        list = CookieSyncManager.getInstance();
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        com.appnexus.opensdk.b.b.c(b.f, "Unable to find a CookieSyncManager");
        return;
        list.sync();
        return;
        cookiemanager.flush();
        return;
    }

    public static void b(WebView webview)
    {
        if (webview == null)
        {
            return;
        }
        try
        {
            android/webkit/WebView.getDeclaredMethod("onResume", new Class[0]).invoke(webview, new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return;
        }
    }

    public static void c(WebView webview)
    {
        if (webview == null)
        {
            return;
        }
        try
        {
            android/webkit/WebView.getDeclaredMethod("onPause", new Class[0]).invoke(webview, new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return;
        }
    }
}
