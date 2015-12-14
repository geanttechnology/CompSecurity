// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import android.content.Context;

class PermissionChecker
{
    public static class PermissionCheckerExecutor
    {

        public boolean hasPermission(Context context, String s)
        {
            return context.checkCallingOrSelfPermission(s) == 0;
        }

        public PermissionCheckerExecutor()
        {
        }
    }


    private static PermissionCheckerExecutor executor = new PermissionCheckerExecutor();

    public static final boolean hasInternetPermission(Context context)
    {
        return executor.hasPermission(context, "android.permission.INTERNET");
    }

}
