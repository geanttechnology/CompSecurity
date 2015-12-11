// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.mShop.platform.AppLocale;

public class ResourcesUtils
{

    public ResourcesUtils()
    {
    }

    public static boolean getBoolForCurrentLocale(Context context, String s)
    {
        s = getLocalizedKeyForCurrentLocale(s);
        int i = context.getResources().getIdentifier(s, "bool", context.getPackageName());
        if (i != 0)
        {
            return context.getResources().getBoolean(i);
        } else
        {
            return false;
        }
    }

    private static String getLocalizedKeyForCurrentLocale(String s)
    {
        String s1 = AppLocale.getInstance().getCurrentLocaleName();
        return (new StringBuilder()).append(s).append("_").append(s1.toLowerCase()).toString();
    }

    private static String getLocalizedKeyForSpecificLocale(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("_").append(s1.toLowerCase()).toString();
    }

    public static String getStringForCurrentLocale(Context context, String s)
    {
        s = getLocalizedKeyForCurrentLocale(s);
        int i = context.getResources().getIdentifier(s, "string", context.getPackageName());
        if (i != 0)
        {
            return context.getResources().getString(i);
        } else
        {
            return null;
        }
    }

    public static String getStringOfSpecificLocale(Context context, String s, String s1)
    {
        s = getLocalizedKeyForSpecificLocale(s, s1);
        int i = context.getResources().getIdentifier(s, "string", context.getPackageName());
        if (i != 0)
        {
            return context.getResources().getString(i);
        } else
        {
            return null;
        }
    }
}
