// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent.checker;

import android.os.Build;
import java.io.File;
import java.io.IOException;

public class RootAccessChecker
{

    public static boolean isRooted()
        throws IOException
    {
        return isTestKeyFound() || isSUFound() || isSuperuserApkFound();
    }

    public static boolean isSUFound()
    {
        boolean flag;
        try
        {
            flag = (new File("/system/xbin/su")).exists();
        }
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }

    public static boolean isSuperuserApkFound()
    {
        boolean flag;
        try
        {
            flag = (new File("/system/app/Superuser.apk")).exists();
        }
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }

    public static boolean isTestKeyFound()
    {
        return Build.TAGS != null && Build.TAGS.contains("test-keys");
    }
}
