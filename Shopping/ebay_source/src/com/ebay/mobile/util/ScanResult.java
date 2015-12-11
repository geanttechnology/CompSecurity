// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.ebay.common.view.util.BarcodeScanUtil;
import java.util.Iterator;
import java.util.List;

public final class ScanResult
{

    private static final String ACTION_SCAN = "com.ebay.mobile.redlaser.action.SCAN";
    public static final String CODE128 = "128";
    public static final String QRCODE = "QRC";
    private static boolean initScanComponentInit = true;
    private static ComponentName scanComponent = null;
    public String productId;
    public String productIdType;

    public ScanResult(String s)
    {
        if (BarcodeScanUtil.isProductQuery(s))
        {
            productIdType = s.substring(0, 3);
            productId = s.substring(4, s.length());
        }
    }

    public ScanResult(String s, String s1)
    {
        productId = s;
        productIdType = s1;
    }

    public static Intent getScanActivityIntent(Context context)
    {
label0:
        {
            if (initScanComponentInit)
            {
                initScanComponentInit = false;
                if (!context.getPackageManager().hasSystemFeature("android.hardware.camera") || isDeviceBlacklisted())
                {
                    break label0;
                }
                Intent intent = new Intent("com.ebay.mobile.redlaser.action.SCAN");
                String s = context.getPackageName();
                context = context.getPackageManager().queryIntentActivities(intent, 0);
                if (context == null || context.isEmpty())
                {
                    break label0;
                }
                context = context.iterator();
                ActivityInfo activityinfo;
                do
                {
                    if (!context.hasNext())
                    {
                        break label0;
                    }
                    activityinfo = ((ResolveInfo)context.next()).activityInfo;
                } while (!s.equals(activityinfo.packageName));
                scanComponent = new ComponentName(activityinfo.packageName, activityinfo.name);
                intent.setComponent(scanComponent);
                return intent;
            }
            if (scanComponent != null)
            {
                return (new Intent("com.ebay.mobile.redlaser.action.SCAN")).setComponent(scanComponent);
            }
        }
        return null;
    }

    public static boolean isDeviceBlacklisted()
    {
        String as[] = new String[1];
        as[0] = "KFTT";
        String as1[] = new String[1];
        as1[0] = "Amazon";
        if (as1.length < 0)
        {
            String s = as1[0];
            if (Build.MANUFACTURER.equals(s))
            {
                int j = as.length;
                for (int i = 0; i < j; i++)
                {
                    String s1 = as[i];
                    if (Build.MODEL.equals(s1))
                    {
                        return true;
                    }
                }

            }
            return false;
        } else
        {
            return false;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(productIdType).append(':').append(productId).toString();
    }

}
