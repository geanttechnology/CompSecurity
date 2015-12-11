// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cookie;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.DataStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NowAppContextCookie
{

    private static String sCookieString;

    public NowAppContextCookie()
    {
    }

    private static String getCookie()
    {
        if (sCookieString == null)
        {
            sCookieString = DataStore.getString("nowAppContextCookieString");
        }
        return sCookieString;
    }

    public static void init()
    {
        syncCookie();
    }

    private static Map parseCookieString(String s)
    {
        HashMap hashmap = new HashMap();
        if (!TextUtils.isEmpty(s))
        {
            s = s.split("\\&");
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                CharSequence charsequence = s[i];
                if (TextUtils.isEmpty(charsequence))
                {
                    continue;
                }
                String as[] = charsequence.split(":");
                if (as.length == 2)
                {
                    hashmap.put(as[0], as[1]);
                }
            }

        }
        return hashmap;
    }

    private static void saveCookie(String s)
    {
        sCookieString = s;
        DataStore.putString("nowAppContextCookieString", s);
    }

    public static void syncCookie()
    {
        CookieManager.getInstance().setCookie(AppUtils.getServiceDomain(), (new StringBuilder()).append("pnctxt=").append(Uri.encode(getCookie())).append(";").toString());
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            CookieSyncManager.getInstance().sync();
            return;
        } else
        {
            CookieManager.getInstance().flush();
            return;
        }
    }

    private static String toCookieString(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = false;
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (flag)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry.getKey()).append(":").append((String)entry.getValue());
            flag = true;
        }

        return stringbuilder.toString();
    }

    public static void updateCookie(String s, String s1)
    {
        Map map = parseCookieString(getCookie());
        map.put(s, s1);
        saveCookie(toCookieString(map));
    }
}
