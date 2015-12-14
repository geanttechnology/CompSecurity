// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;

public class ApiUtils
{

    public static final int BUILD_INT = 10350;
    public static final int BUILD_INT_440 = 10355;
    public static final int BUILD_INT_VER_2_2 = 10351;
    public static final int BUILD_INT_VER_2_3 = 10352;
    public static final int BUILD_INT_VER_2_5 = 10353;
    private static final String TAG = com/sina/weibo/sdk/ApiUtils.getName();

    public ApiUtils()
    {
    }

    private static boolean containSign(Signature asignature[], String s)
    {
        if (asignature != null && s != null)
        {
            int j = asignature.length;
            int i = 0;
            while (i < j) 
            {
                if (s.equals(MD5.hexdigest(asignature[i].toByteArray())))
                {
                    LogUtil.d(TAG, "check pass");
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public static boolean validateWeiboSign(Context context, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        try
        {
            context = context.getPackageManager().getPackageInfo(s, 64);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return containSign(((PackageInfo) (context)).signatures, "18da2bf10352443a00a5e046d9fca6bd");
    }

}
