// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.util.Util;

public class CookieHelper
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final String TAG = com/amazon/mShop/sso/CookieHelper.getSimpleName();

    public CookieHelper()
    {
    }

    private static String extractXCookie(Context context, String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            context = as[i].trim();
            if (!Util.isEmpty(context) && (context.startsWith("x-main") || context.startsWith("x-acb")))
            {
                return context;
            }
        }

        return null;
    }

    public static void setCookies(Context context, String as[])
    {
        com/amazon/mShop/sso/CookieHelper;
        JVM INSTR monitorenter ;
        boolean flag = Util.isEmpty(as);
        if (!flag) goto _L2; else goto _L1
_L1:
        com/amazon/mShop/sso/CookieHelper;
        JVM INSTR monitorexit ;
        return;
_L2:
        CookieManager cookiemanager;
        int j;
        cookiemanager = CookieManager.getInstance();
        context = CookieBridge.getMShopURL(context, true);
        j = as.length;
        String s;
        for (int i = 0; i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_63;
        }

        s = as[i];
        if (!Util.isEmpty(s))
        {
            cookiemanager.setCookie(context, s);
        }
        break MISSING_BLOCK_LABEL_114;
        if (DEBUG)
        {
            Log.d(TAG, (new StringBuilder()).append("setCookies: ").append(cookiemanager.getCookie(context)).toString());
        }
        CookieSyncManager.getInstance().sync();
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public static boolean setXCookie(Context context, String as[])
    {
        boolean flag = false;
        com/amazon/mShop/sso/CookieHelper;
        JVM INSTR monitorenter ;
        boolean flag1 = Util.isEmpty(as);
        if (!flag1) goto _L2; else goto _L1
_L1:
        com/amazon/mShop/sso/CookieHelper;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        as = extractXCookie(context, as);
        if (Util.isEmpty(as))
        {
            continue; /* Loop/switch isn't completed */
        }
        context = CookieBridge.getMShopURL(context, true);
        CookieManager cookiemanager = CookieManager.getInstance();
        if (DEBUG)
        {
            Log.v(TAG, (new StringBuilder()).append("setXCookie: ").append(as).toString());
        }
        cookiemanager.setCookie(context, as);
        CookieSyncManager.getInstance().sync();
        flag = true;
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

}
