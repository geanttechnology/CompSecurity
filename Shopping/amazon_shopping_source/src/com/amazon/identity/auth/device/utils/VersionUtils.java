// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.amazon.identity.auth.device.framework.TrustedPackageManager;

public final class VersionUtils
{

    private static final String TAG = com/amazon/identity/auth/device/utils/VersionUtils.getName();

    private VersionUtils()
    {
    }

    public static Integer getAmazonPackageVersion(Context context, String s)
    {
        if (!(new TrustedPackageManager(context)).isTrustedPackage(s))
        {
            return null;
        }
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(s, 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = TAG;
            String.format("%s cannot be found because it is not installed", new Object[] {
                s
            });
            return null;
        }
        return Integer.valueOf(i);
    }

}
