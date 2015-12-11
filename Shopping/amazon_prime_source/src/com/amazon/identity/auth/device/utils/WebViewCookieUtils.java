// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.amazon.identity.auth.device.api.MAPWebViewHelper;
import com.amazon.identity.auth.device.token.MAPCookie;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.cookie.Cookie;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            WebViewUtils, MAPLog, CookieUtils

public final class WebViewCookieUtils
{

    private static final String TAG = com/amazon/identity/auth/device/utils/WebViewCookieUtils.getName();

    private WebViewCookieUtils()
    {
    }

    public static Cookie getCookieFromCookieManager(Context context, String s, String s1, String s2)
    {
        CookieManager cookiemanager = CookieManager.getInstance();
        cookiemanager.setAcceptCookie(true);
        WebViewUtils.syncCookieSyncManager(context);
        if (s1.startsWith("."))
        {
            context = (new StringBuilder("www")).append(s1).toString();
        } else
        {
            context = s1;
        }
        for (context = parseCookieString(s1, s, cookiemanager.getCookie(context)).iterator(); context.hasNext();)
        {
            s = (Cookie)context.next();
            if (s2.equals(s.getName()))
            {
                return s;
            }
        }

        return null;
    }

    public static String getCookieUrl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        Object obj = Uri.parse(s);
        if (obj == null)
        {
            MAPLog.e(TAG, "error happens when parsing the url string");
            return null;
        } else
        {
            s = ((Uri) (obj)).getScheme();
            obj = ((Uri) (obj)).getAuthority();
            return String.format(Locale.US, "%s://%s", new Object[] {
                s, obj
            });
        }
    }

    public static List parseCookieString(String s, String s1, String s2)
    {
        ArrayList arraylist = new ArrayList();
        if (s2 != null)
        {
            for (s2 = new StringTokenizer(s2, ";"); s2.hasMoreTokens();)
            {
                String as[] = s2.nextToken().trim().split("=", 2);
                if (as.length == 2)
                {
                    arraylist.add(new MAPCookie(as[0], as[1], s, s1, false));
                } else
                {
                    MAPLog.w(TAG, "Unexpected cookie format");
                }
            }

        }
        return arraylist;
    }

    public static void setCookie(Context context, String s, MAPCookie mapcookie)
    {
        WebViewUtils.syncCookieSyncManager(context);
        CookieManager cookiemanager = CookieManager.getInstance();
        cookiemanager.setAcceptCookie(true);
        cookiemanager.setCookie(s, mapcookie.getSetCookieHeader());
        WebViewUtils.syncCookieSyncManager(context);
    }

    public static void setCookie$218ec1f1(Context context, String s, String s1, String s2, String s3, String s4, boolean flag)
    {
label0:
        {
            {
                if (!flag)
                {
                    break label0;
                }
                String s5;
                try
                {
                    s5 = CookieUtils.getFullCookieDomainFromUrl(s);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    MetricsHelper.incrementCounter("failedParsingCookieDomain", new String[] {
                        "MalformedURLException"
                    });
                    MAPLog.e(TAG, "Could not parse cookie domain from malformed URL.", context);
                    return;
                }
            }
            setCookie(context, s, new MAPCookie(s1, s2, s5, s4, s3, null, true, true));
            return;
        }
        s5 = MAPWebViewHelper.getCookieDomainFromUrl(s);
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_11;
        }
    }

}
