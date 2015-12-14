// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.http;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class UserAgent
{

    private static final String TAG = com/amazon/gallery/framework/network/http/rest/http/UserAgent.getName();
    private String userAgent;

    public UserAgent(Context context, String s)
    {
        userAgent = initUserAgent(context, s);
    }

    private String initUserAgent(Context context, String s)
    {
        String s1 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        context = s1;
        if (s1 == null)
        {
            context = "0";
        }
_L1:
        if (BuildFlavors.isAosp())
        {
            return String.format("%s/%s", new Object[] {
                s, context
            });
        } else
        {
            return String.format("%s/%s (%s)", new Object[] {
                s, context, Build.DISPLAY
            });
        }
        context;
        GLogger.wx(TAG, "Could not get package name", context);
        context = "0";
          goto _L1
    }

    public String toString()
    {
        return userAgent;
    }

}
