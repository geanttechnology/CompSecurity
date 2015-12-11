// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.a;

import android.content.Context;
import android.content.SharedPreferences;

public class a
{

    private static final String APP_CONFIG = "app_config";
    private static final int DEFAULT_GOOGLE_NOW_DELAY = 8640;
    private static final String DEFAULT_PAY_PAL_CANCEL = "www-secure.target.com/webapp/wcs/stores/servlet/Order";
    private static final String DEFAULT_PAY_PAL_REDIRECT = "www-secure.target.com/webapp/wcs/stores/servlet/CVReturnFromPayPal";
    private static final boolean DEFAULT_USE_ATP_FOR_STORE_AVAILABILITY = true;
    private static final boolean DEFAULT_VLC_DISABLED = false;
    private static a sConfigProvider;
    private SharedPreferences mPreferences;

    private a(Context context)
    {
        mPreferences = context.getSharedPreferences("app_config", 0);
    }

    public static a a()
    {
        if (sConfigProvider == null)
        {
            throw new IllegalStateException("AppConfigProvider was not initialized. Have you called AppConfigProvider.init()?");
        } else
        {
            return sConfigProvider;
        }
    }

    public static void a(Context context)
    {
        if (sConfigProvider == null)
        {
            sConfigProvider = new a(context);
        }
    }

    private void a(String s, int i)
    {
        mPreferences.edit().putInt(s, i).apply();
    }

    private void a(String s, String s1)
    {
        mPreferences.edit().putString(s, s1).apply();
    }

    private void a(String s, boolean flag)
    {
        mPreferences.edit().putBoolean(s, flag).apply();
    }

    public void a(int i)
    {
        a("config_app_version", i);
    }

    public void a(String s)
    {
        a("pay_pal_redirect", s);
    }

    public void a(boolean flag)
    {
        a("use_atp_for_store_availability", flag);
    }

    public int b()
    {
        return mPreferences.getInt("config_app_version", 0);
    }

    public void b(int i)
    {
        a("google_now_delay", i);
    }

    public void b(String s)
    {
        a("pay_pal_cancel", s);
    }

    public void b(boolean flag)
    {
        a("vlc_disabled", flag);
    }

    public int c()
    {
        return mPreferences.getInt("google_now_delay", 8640);
    }

    public String d()
    {
        return mPreferences.getString("pay_pal_redirect", "www-secure.target.com/webapp/wcs/stores/servlet/CVReturnFromPayPal");
    }

    public String e()
    {
        return mPreferences.getString("pay_pal_cancel", "www-secure.target.com/webapp/wcs/stores/servlet/Order");
    }

    public boolean f()
    {
        return mPreferences.getBoolean("use_atp_for_store_availability", true);
    }

    public boolean g()
    {
        return mPreferences.getBoolean("vlc_disabled", false);
    }
}
