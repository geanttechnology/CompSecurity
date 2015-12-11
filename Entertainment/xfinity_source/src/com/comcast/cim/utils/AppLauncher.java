// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;

public class AppLauncher
{

    private final AndroidDevice androidDevice;

    public AppLauncher(AndroidDevice androiddevice)
    {
        androidDevice = androiddevice;
    }

    private void showInMarket(String s, Activity activity)
    {
        String s1;
        if (androidDevice.isKindleOrFromAmazonStore())
        {
            s1 = activity.getResources().getString(com.comcast.cim.android.R.string.url_amazon_market_app_url);
        } else
        {
            s1 = activity.getResources().getString(com.comcast.cim.android.R.string.url_android_market_app_url);
        }
        s = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(s1).append(s).toString()));
        s.setFlags(0x10000000);
        activity.startActivity(s);
    }

    public void startApplication(String s, Activity activity)
    {
        Intent intent = activity.getPackageManager().getLaunchIntentForPackage(s);
        if (intent != null)
        {
            try
            {
                intent.addFlags(0x10000);
                activity.startActivity(intent);
                return;
            }
            catch (Exception exception)
            {
                showInMarket(s, activity);
            }
            break MISSING_BLOCK_LABEL_40;
        }
        showInMarket(s, activity);
        return;
    }

    public void startUri(Uri uri, Activity activity)
    {
        uri = new Intent("android.intent.action.VIEW", uri);
        uri.addFlags(0x10000);
        activity.startActivity(uri);
    }
}
