// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.sina.weibo.sdk.ApiUtils;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            MD5

public class SecurityHelper
{

    public SecurityHelper()
    {
    }

    public static boolean checkResponseAppLegal(Context context, com.sina.weibo.sdk.WeiboAppManager.WeiboInfo weiboinfo, Intent intent)
    {
        if ((weiboinfo == null || weiboinfo.getSupportApi() > 10352) && weiboinfo != null)
        {
            if (intent != null)
            {
                weiboinfo = intent.getStringExtra("_weibo_appPackage");
            } else
            {
                weiboinfo = null;
            }
            if (weiboinfo == null || intent.getStringExtra("_weibo_transaction") == null || !ApiUtils.validateWeiboSign(context, weiboinfo))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean containSign(Signature asignature[], String s)
    {
        if (asignature != null && s != null)
        {
            int j = asignature.length;
            int i = 0;
            while (i < j) 
            {
                if (s.equals(MD5.hexdigest(asignature[i].toByteArray())))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public static boolean validateAppSignatureForIntent(Context context, Intent intent)
    {
        context = context.getPackageManager();
        if (context != null)
        {
            if ((intent = context.resolveActivity(intent, 0)) != null)
            {
                intent = ((ResolveInfo) (intent)).activityInfo.packageName;
                boolean flag;
                try
                {
                    flag = containSign(context.getPackageInfo(intent, 64).signatures, "18da2bf10352443a00a5e046d9fca6bd");
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context.printStackTrace();
                    return false;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context.printStackTrace();
                    return false;
                }
                return flag;
            }
        }
        return false;
    }
}
