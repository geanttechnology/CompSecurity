// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

// Referenced classes of package com.amazon.device.ads:
//            Log, AndroidTargetUtils

class PermissionChecker
{

    private static PermissionChecker INSTANCE = new PermissionChecker();
    private static final String INTERNET_PERMISSION = "android.permission.INTERNET";
    private static final String LOG_TAG = com/amazon/device/ads/PermissionChecker.getSimpleName();
    private boolean isInternetPermissionPresent;

    protected PermissionChecker()
    {
        isInternetPermissionPresent = false;
    }

    static PermissionChecker getInstance()
    {
        return INSTANCE;
    }

    private static final boolean permissionCheckErrorCondition()
    {
        Log.d(LOG_TAG, "App permissions were not read.");
        return true;
    }

    protected static void setInstance(PermissionChecker permissionchecker)
    {
        INSTANCE = permissionchecker;
    }

    public final boolean passesInternetPermissionCheck(Context context)
    {
        return passesInternetPermissionCheck(context, null);
    }

    public final boolean passesInternetPermissionCheck(Context context, String s)
    {
        if (isInternetPermissionPresent)
        {
            return true;
        }
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            return permissionCheckErrorCondition();
        }
        String s1 = AndroidTargetUtils.getPackageCodePath(context);
        if (s1 == null)
        {
            return permissionCheckErrorCondition();
        }
        context = context.getPackageManager();
        if (context == null)
        {
            return permissionCheckErrorCondition();
        }
        context = context.getPackageArchiveInfo(s1, 4096);
        if (context == null)
        {
            return permissionCheckErrorCondition();
        }
        context = ((PackageInfo) (context)).requestedPermissions;
        if (context == null)
        {
            return permissionCheckErrorCondition();
        }
        int j = context.length;
        for (int i = 0; i < j; i++)
        {
            if (context[i].equals("android.permission.INTERNET"))
            {
                isInternetPermissionPresent = true;
                return true;
            }
        }

        if (s != null)
        {
            Log.e(s, "Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
        }
        return false;
    }

}
