// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.atomic.AtomicBoolean;

public final class WebViewUtils
{

    private static final AtomicBoolean COOKIE_SYNC_MANAGER_CREATED = new AtomicBoolean(false);

    private static void initCookieSyncManager(Context context)
    {
        if (COOKIE_SYNC_MANAGER_CREATED.compareAndSet(false, true))
        {
            CookieSyncManager.createInstance(context.getApplicationContext());
        }
    }

    public static void setCookie(Context context, String s, String s1)
    {
        initCookieSyncManager(context);
        CookieManager.getInstance().setCookie(s, s1);
    }

    public static void setCookies(Context context, String s, String as[])
    {
        syncCookieSyncManager(context);
        context = CookieManager.getInstance();
        context.setAcceptCookie(true);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            context.setCookie(s, as[i]);
        }

        CookieSyncManager.getInstance().sync();
    }

    public static void syncCookieSyncManager(Context context)
    {
        initCookieSyncManager(context);
        CookieSyncManager.getInstance().sync();
    }

}
