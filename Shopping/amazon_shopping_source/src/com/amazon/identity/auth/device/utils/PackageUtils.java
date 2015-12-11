// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class PackageUtils
{

    private static final String TAG = com/amazon/identity/auth/device/utils/PackageUtils.getName();

    private PackageUtils()
    {
    }

    public static Integer getPackageVersion(Context context, String s)
    {
        context = context.getPackageManager();
        int i;
        try
        {
            i = context.getPackageInfo(s, 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.e(TAG, String.format("Could not find package %s", new Object[] {
                s
            }), context);
            return null;
        }
        return Integer.valueOf(i);
    }

    public static boolean hasPackage(String s, Context context)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        boolean flag;
        try
        {
            context.getPackageManager().getPackageInfo(s, 0);
            s = context.getPackageManager().getApplicationInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = ((ApplicationInfo) (s)).enabled;
        if (flag)
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

}
