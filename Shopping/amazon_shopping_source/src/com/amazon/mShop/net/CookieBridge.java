// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CookieBridge extends CookieHandler
{

    public CookieBridge()
    {
    }

    private static String buildSetCookie(Context context, boolean flag, String s, String s1)
    {
        context = getCookieDomain(context, flag);
        s = (new StringBuilder()).append(s).append("=").append(s1).append("; Domain=").append(context).append("; ");
        if (flag)
        {
            context = " Secure; ";
        } else
        {
            context = "";
        }
        return s.append(context).append("Path=/").toString();
    }

    public static void clearCookiesOfAllLocales(Context context)
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        init(context);
        CookieManager cookiemanager = CookieManager.getInstance();
        obj1 = getCookie("lc", context);
        obj = getCookie("ubid", context);
        cookiemanager.removeAllCookie();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        for (Iterator iterator = ((Map) (obj1)).entrySet().iterator(); iterator.hasNext(); setCookie(context, false, (String)((java.util.Map.Entry) (obj1)).getKey(), (String)((java.util.Map.Entry) (obj1)).getValue()))
        {
            obj1 = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_96;
        context;
        throw context;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        java.util.Map.Entry entry;
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); setCookie(context, false, (String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        CookieSyncManager.getInstance().sync();
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
    }

    public static void clearCurrentLocaleCookies(Context context)
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        String s;
        boolean flag;
        init(context);
        s = CookieManager.getInstance().getCookie(getMShopURL(context, true));
        flag = Util.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return;
_L2:
        String as[] = s.split(";");
        if (Util.isEmpty(as)) goto _L4; else goto _L3
_L3:
        int i = 0;
_L7:
        if (i >= as.length) goto _L4; else goto _L5
_L5:
        if (as[i].indexOf("=") != -1)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        s = as[i].trim();
_L6:
        if (!Util.isEmpty(s) && !s.startsWith("lc") && !s.startsWith("ubid"))
        {
            setCookie(context, false, s, "");
        }
        break MISSING_BLOCK_LABEL_148;
        s = as[i].substring(0, as[i].indexOf("=")).trim();
          goto _L6
_L4:
        CookieSyncManager.getInstance().sync();
          goto _L1
        context;
        throw context;
        i++;
          goto _L7
    }

    public static String getAtMainCookie(Context context)
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        String s;
        init(context);
        s = CookieManager.getInstance().getCookie(getMShopURL(context, true));
        Object obj;
        obj = null;
        context = obj;
        if (Util.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String as[];
        int j;
        as = s.split(";");
        j = as.length;
        int i = 0;
_L7:
        context = obj;
        if (i >= j) goto _L2; else goto _L3
_L3:
        context = as[i].trim();
        if (!context.startsWith("at-main") && !context.startsWith("at-acb")) goto _L5; else goto _L4
_L4:
        context = context.substring(context.indexOf("=") + 1).replace("\"", "");
_L2:
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return context;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        context;
        throw context;
    }

    public static Map getCookie(String s, Context context)
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        init(context);
        context = CookieManager.getInstance().getCookie(getMShopURL(context, true));
        if (context == null) goto _L2; else goto _L1
_L1:
        Matcher matcher;
        matcher = Pattern.compile((new StringBuilder()).append("(").append(s).append("(-[\\w\\-]+)?)\\s*=\\s*([^;]+)").toString()).matcher(context);
        context = new HashMap();
_L4:
        s = context;
        if (!matcher.find())
        {
            break; /* Loop/switch isn't completed */
        }
        context.put(matcher.group(1), matcher.group(3));
        if (true) goto _L4; else goto _L3
        s;
        throw s;
_L2:
        s = Collections.emptyMap();
_L3:
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return s;
    }

    public static String getCookieDomain(Context context, boolean flag)
    {
        return getDomainFromURL(context, getMShopURL(context, flag));
    }

    public static String getCookiesOfCurrentLocale(Context context, boolean flag)
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        init(context);
        context = CookieManager.getInstance().getCookie(getMShopURL(context, flag));
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static final String getCurrentSessionId()
    {
        Object obj = null;
        Map map = getCookie("session", (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext());
        String s = obj;
        if (map != null)
        {
            s = obj;
            if (map.size() > 0)
            {
                s = (String)map.get("session-id");
            }
        }
        return s;
    }

    public static String getDomainFromURL(Context context, String s)
    {
        context = URI.create(s).getHost();
        return Pattern.compile(".*(\\.amazon\\..*)").matcher(context).replaceFirst("$1");
    }

    public static String getMShopURL(Context context, boolean flag)
    {
        int i;
        if (flag)
        {
            i = com.amazon.mShop.android.lib.R.string.config_serviceSecureURL;
        } else
        {
            i = com.amazon.mShop.android.lib.R.string.config_serviceURL;
        }
        return ConfigUtils.getString(context, i);
    }

    public static String getUbidCookie(Context context)
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        Object obj = null;
        Map map = getCookie("ubid", context);
        context = obj;
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        context = obj;
        if (map.size() == 1)
        {
            context = (String)map.values().iterator().next();
        }
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static void init(Context context)
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        if (CookieHandler.getDefault() == null)
        {
            CookieSyncManager.createInstance(context);
            CookieSyncManager.getInstance().startSync();
            CookieHandler.setDefault(new CookieBridge());
        }
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void setCookie(Context context, boolean flag, String s, String s1)
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        init(context);
        s = buildSetCookie(context, flag, s, s1);
        context = getMShopURL(context, flag);
        CookieManager.getInstance().setCookie(context, s);
        CookieSyncManager.getInstance().sync();
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void setCookies(Context context, String s, boolean flag)
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        boolean flag1;
        init(context);
        flag1 = Util.isEmpty(s);
        if (!flag1) goto _L2; else goto _L1
_L1:
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return;
_L2:
        String as[] = s.split(";");
        if (Util.isEmpty(as)) goto _L4; else goto _L3
_L3:
        int i = 0;
_L9:
        if (i >= as.length) goto _L4; else goto _L5
_L5:
        if (as[i].indexOf("=") == -1)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        String s1;
        int j;
        j = as[i].indexOf("=");
        s1 = as[i].substring(0, j).trim();
        if (as[i].length() <= j + 1) goto _L7; else goto _L6
_L6:
        s = as[i].substring(j + 1);
_L8:
        if (!Util.isEmpty(s))
        {
            setCookie(context, flag, s1, s);
        }
        break MISSING_BLOCK_LABEL_152;
        context;
        throw context;
_L7:
        s = null;
        if (true) goto _L8; else goto _L4
_L4:
        CookieSyncManager.getInstance().sync();
          goto _L1
        i++;
          goto _L9
    }

    public final Map get(URI uri, Map map)
        throws IOException
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        CookieSyncManager.getInstance().sync();
        uri = CookieManager.getInstance().getCookie(uri.toString());
        if (!Util.isEmpty(uri))
        {
            break MISSING_BLOCK_LABEL_36;
        }
        uri = Collections.emptyMap();
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return uri;
        uri = Collections.singletonMap("Cookie", Collections.singletonList(uri));
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return uri;
        uri;
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        throw uri;
    }

    public final void put(URI uri, Map map)
        throws IOException
    {
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorenter ;
        Object obj = null;
        if (!map.containsKey("Set-Cookie")) goto _L2; else goto _L1
_L1:
        obj = (List)map.get("Set-Cookie");
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (!((List) (obj)).isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (map.containsKey("set-cookie"))
        {
            obj = (List)map.get("set-cookie");
        }
        if (true) goto _L4; else goto _L3
_L3:
        map = CookieManager.getInstance();
        String s;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); map.setCookie(uri.toString(), s))
        {
            s = (String)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_125;
        uri;
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
        throw uri;
        CookieSyncManager.getInstance().sync();
        com/amazon/mShop/net/CookieBridge;
        JVM INSTR monitorexit ;
    }
}
