// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import com.amazon.android.webkit.AmazonCookieManager;
import com.amazon.identity.auth.device.api.AmazonWebViewUtils;
import com.amazon.identity.auth.device.api.MAPWebViewHelper;
import com.amazon.identity.auth.device.token.MAPCookie;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.http.cookie.Cookie;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class AmazonWebviewCookieUtils
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils.getName();

    private AmazonWebviewCookieUtils()
    {
    }

    public static Cookie getCookieFromCookieManager(Context context, String s, String s1, String s2)
    {
        for (context = getCookiesFromCookieManager(context, s1, s).iterator(); context.hasNext();)
        {
            s = (Cookie)context.next();
            if (s2.equals(s.getName()))
            {
                return s;
            }
        }

        return null;
    }

    public static List getCookiesFromCookieManager(Context context, String s, String s1)
    {
        context = getCookiesStringFromCookieManager(context, s);
        String s2 = LOG_TAG;
        return parseCookieString(s, s1, context);
    }

    public static String getCookiesStringFromCookieManager(Context context, String s)
    {
        AmazonCookieManager amazoncookiemanager = AmazonWebViewUtils.getAmazonCookieManager(context);
        amazoncookiemanager.setAcceptCookie(true);
        AmazonWebViewUtils.syncAmazonCookieSyncManager(context);
        String s1 = s;
        context = s1;
        if (s.startsWith("."))
        {
            context = (new StringBuilder("www")).append(s1).toString();
        }
        s = amazoncookiemanager.getCookie(context);
        s1 = LOG_TAG;
        (new StringBuilder("Extracting cookies from CookieManager for domain=")).append(context).toString();
        return s;
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
                    MAPLog.w(LOG_TAG, "Unexpected cookie format");
                    String s3 = LOG_TAG;
                }
            }

        } else
        {
            s = LOG_TAG;
        }
        return arraylist;
    }

    public static void setCookie(Context context, String s, MAPCookie mapcookie)
    {
        AmazonCookieManager amazoncookiemanager = AmazonWebViewUtils.getAmazonCookieManager(context);
        amazoncookiemanager.setAcceptCookie(true);
        amazoncookiemanager.setCookie(s, mapcookie.getSetCookieHeader());
        AmazonWebViewUtils.syncAmazonCookieSyncManager(context);
    }

    public static void setCookie(Context context, String s, String s1, String s2, String s3, String s4, boolean flag, boolean flag1)
    {
        String s5;
        try
        {
            s5 = MAPWebViewHelper.getCookieDomainFromUrl(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MetricsHelper.increasePeriodicCounter("failedParsingCookieDomain", new String[] {
                "MalformedURLException"
            });
            MAPLog.e(LOG_TAG, "Could not parse cookie domain from malformed URL.", context);
            return;
        }
        setCookie(context, s, new MAPCookie(s1, s2, s5, s4, s3, null, flag, flag1));
    }

}
