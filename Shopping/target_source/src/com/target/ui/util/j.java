// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class j
{

    public static int a(Context context)
    {
        return b(context).versionCode;
    }

    public static boolean a()
    {
        return android.os.Build.VERSION.SDK_INT >= 16;
    }

    public static PackageInfo b(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException("Cannot retrieve PackageInfo for our own package!?", context);
        }
        return context;
    }

    public static boolean b()
    {
        return android.os.Build.VERSION.SDK_INT >= 21;
    }
}
