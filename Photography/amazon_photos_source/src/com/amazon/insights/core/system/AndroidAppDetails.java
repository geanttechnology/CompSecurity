// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.amazon.insights.core.log.Logger;

// Referenced classes of package com.amazon.insights.core.system:
//            AppDetails

public class AndroidAppDetails
    implements AppDetails
{

    private static Logger logger = Logger.getLogger(com/amazon/insights/core/system/AndroidAppDetails);
    private Context applicationContext;
    private PackageInfo packageInfo;

    public AndroidAppDetails(Context context)
    {
        applicationContext = context.getApplicationContext();
        try
        {
            packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            logger.w((new StringBuilder()).append("Unable to get details for package ").append(applicationContext.getPackageName()).toString());
        }
    }

    public String packageName()
    {
        if (packageInfo != null)
        {
            return packageInfo.packageName;
        } else
        {
            return null;
        }
    }

    public String versionCode()
    {
        if (packageInfo != null)
        {
            return String.valueOf(packageInfo.versionCode);
        } else
        {
            return null;
        }
    }

    public String versionName()
    {
        if (packageInfo != null)
        {
            return packageInfo.versionName;
        } else
        {
            return null;
        }
    }

}
