// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;

import android.content.Context;
import android.content.pm.PackageManager;

public final class a
{

    public static boolean a(Context context)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (android.os.Build.VERSION.SDK_INT <= 4)
            {
                break label0;
            }
            try
            {
                context = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            if (!"com.android.vending".equals(context))
            {
                flag = flag1;
                if (!"com.google.play".equals(context))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }
}
