// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.content.SharedPreferences;

public class CrossAnalytics
{

    private static final String PREF_NAME = "cross_analytics";
    public static final String PRE_INSTALL_SIGN_UP = "pre_install_sign up";
    private static CrossAnalytics sINSTANCE;
    private final SharedPreferences mPrefs;

    private CrossAnalytics(Context context)
    {
        mPrefs = context.getSharedPreferences("cross_analytics", 0);
    }

    public static CrossAnalytics getInstance(Context context)
    {
        if (sINSTANCE == null)
        {
            sINSTANCE = new CrossAnalytics(context);
        }
        return sINSTANCE;
    }

    public void clear(String s)
    {
        mPrefs.edit().remove(s).commit();
    }

    public String get(String s)
    {
        return mPrefs.getString(s, null);
    }

    public boolean isSet(String s)
    {
        return get(s) != null;
    }

    public void set(String s, String s1)
    {
        mPrefs.edit().putString(s, s1).commit();
    }
}
