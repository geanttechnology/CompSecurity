// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.pf.common.utility.m;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{

    public static void a(String s)
    {
        f(s);
        e(s);
    }

    public static void a(String s, JSONObject jsonobject)
    {
        z.a((new StringBuilder()).append("CacheUtils ").append(s).toString(), jsonobject.toString(), Globals.d());
    }

    public static boolean a(String s, long l)
    {
        if (System.currentTimeMillis() - c(s).longValue() <= l && com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b().equalsIgnoreCase(d(s)))
        {
            m.e("CacheUtils ", (new StringBuilder()).append(s).append("Within ").append(l).append(" millis and same language, try to use the local cache.").toString());
            return false;
        } else
        {
            return true;
        }
    }

    public static JSONObject b(String s)
    {
        s = z.b((new StringBuilder()).append("CacheUtils ").append(s).toString(), Globals.d());
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.b("CacheUtils ", "getJsonCache", s);
            return null;
        }
        return s;
    }

    private static Long c(String s)
    {
        return z.b((new StringBuilder()).append(s).append("_LAST_QUERY_TIME").toString(), Long.valueOf(0L), Globals.d());
    }

    private static String d(String s)
    {
        return z.b((new StringBuilder()).append(s).append("_LAST_QUERY_LANGUAGE").toString(), "", Globals.d());
    }

    private static void e(String s)
    {
        z.a((new StringBuilder()).append(s).append("_LAST_QUERY_LANGUAGE").toString(), com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b(), Globals.d());
    }

    private static void f(String s)
    {
        z.a((new StringBuilder()).append(s).append("_LAST_QUERY_TIME").toString(), Long.valueOf(System.currentTimeMillis()), Globals.d());
    }
}
