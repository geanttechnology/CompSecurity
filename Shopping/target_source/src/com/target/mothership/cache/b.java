// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.target.mothership.util.o;

public class b
{

    private static final String COUPON_ACCESS_KEY = "com.target.mothership.cache.CouponsCacheManager.APP_ACCESS_KEY";
    private static b mInstance;
    private Context mContext;

    private b(Context context)
    {
        mContext = context;
    }

    public static b getInstance()
    {
        if (mInstance == null)
        {
            throw new IllegalStateException("CouponsCacheManager was not initialized. Have you called CouponsCacheManager.init()?");
        } else
        {
            return mInstance;
        }
    }

    private SharedPreferences getSharedPreferences()
    {
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public static void init(Context context)
    {
        mInstance = new b(context);
    }

    public String getValidCouponAccessKey()
    {
        return getSharedPreferences().getString("com.target.mothership.cache.CouponsCacheManager.APP_ACCESS_KEY", null);
    }

    public boolean hasValidCouponAccessKey()
    {
        SharedPreferences sharedpreferences = getSharedPreferences();
        return sharedpreferences.contains("com.target.mothership.cache.CouponsCacheManager.APP_ACCESS_KEY") && o.g(sharedpreferences.getString("com.target.mothership.cache.CouponsCacheManager.APP_ACCESS_KEY", null));
    }

    public void purgeCouponAccessKey()
    {
        SharedPreferences sharedpreferences = getSharedPreferences();
        if (sharedpreferences.contains("com.target.mothership.cache.CouponsCacheManager.APP_ACCESS_KEY"))
        {
            sharedpreferences.edit().remove("com.target.mothership.cache.CouponsCacheManager.APP_ACCESS_KEY").commit();
        }
    }

    public void updateAppAccessKey(String s)
    {
        SharedPreferences sharedpreferences = getSharedPreferences();
        android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
        if (sharedpreferences.contains("com.target.mothership.cache.CouponsCacheManager.APP_ACCESS_KEY"))
        {
            editor.remove("com.target.mothership.cache.CouponsCacheManager.APP_ACCESS_KEY").commit();
        }
        editor.putString("com.target.mothership.cache.CouponsCacheManager.APP_ACCESS_KEY", s).commit();
    }
}
