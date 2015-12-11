// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;

public final class ServiceHelper
{

    private ServiceHelper()
    {
    }

    public static String getPackageNameFromUID(Context context)
    {
        context = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (context == null || context.length == 0)
        {
            return String.valueOf(Binder.getCallingPid());
        } else
        {
            return context[0];
        }
    }
}
