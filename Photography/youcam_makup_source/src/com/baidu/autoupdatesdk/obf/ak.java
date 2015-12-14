// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

public class ak
{

    private static final String a = "BDAPPID";
    private static final String b = "BDAPPKEY";

    private ak()
    {
    }

    public static int a(Context context)
    {
        int i = a(context, "BDAPPID", -1);
        if (i == -1)
        {
            throw new RuntimeException("app id is illegal!");
        } else
        {
            return i;
        }
    }

    public static int a(Context context, String s, int i)
    {
        int j;
        try
        {
            j = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt(s, i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return i;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return i;
        }
        return j;
    }

    public static String a(Context context, String s, String s1)
    {
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return s1;
        }
        return context;
    }

    public static String b(Context context)
    {
        context = a(context, "BDAPPKEY", ((String) (null)));
        if (TextUtils.isEmpty(context))
        {
            throw new RuntimeException("app key can not be empty!");
        } else
        {
            return context;
        }
    }
}
