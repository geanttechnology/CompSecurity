// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.os.Build;
import java.io.File;

public class t
{

    private static boolean a = false;
    private static boolean b = false;

    public static boolean a()
    {
        boolean flag2 = true;
        if (!a) goto _L2; else goto _L1
_L1:
        boolean flag = b;
_L4:
        return flag;
_L2:
        String s;
        s = Build.TAGS;
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag2;
        if (s.contains("test-keys")) goto _L4; else goto _L3
_L3:
        boolean flag3 = (new File("/system/app/Superuser.apk")).exists();
        flag = flag2;
        if (flag3) goto _L4; else goto _L5
_L5:
        boolean flag1;
        if (a("/system/xbin/which su") || a("/system/bin/which su") || a("which su"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        b = flag1;
        a = true;
        return b;
        Exception exception;
        exception;
        if (true) goto _L5; else goto _L6
_L6:
    }

    private static boolean a(String s)
    {
        try
        {
            Runtime.getRuntime().exec(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

}
