// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class MetaDataUtils
{

    private static final String TAG = com/amazon/identity/auth/device/utils/MetaDataUtils.getName();

    private MetaDataUtils()
    {
    }

    private static Bundle getApplicationMetaData(Context context, String s)
    {
        try
        {
            context = context.getPackageManager().getApplicationInfo(s, 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.e(TAG, "Could not get meta data for the application", context);
            return null;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        MAPLog.w(TAG, (new StringBuilder("Could not get application meta data for installed pakage ")).append(s).append(".").toString());
        return null;
        context = ((ApplicationInfo) (context)).metaData;
        return context;
    }

    public static Boolean getBooleanMetaDataForAPackage$a09a196(Context context, String s, String s1)
    {
        context = getApplicationMetaData(context, s);
        if (context == null)
        {
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(context.getBoolean(s1, false));
        }
    }

    public static String getMetaDataForAPackage(Context context, String s, String s1)
    {
        context = getApplicationMetaData(context, s);
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(s1);
        }
    }

    public static String getMetaDataForCurrentApplication(Context context, String s)
    {
        return getMetaDataForAPackage(context, context.getPackageName(), s);
    }

}
