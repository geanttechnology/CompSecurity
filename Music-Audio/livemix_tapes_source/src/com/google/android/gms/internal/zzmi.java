// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.Log;

public class zzmi
{

    private static int zzaoL = -1;

    public static boolean zzat(Context context)
    {
        return zzaw(context) == 3;
    }

    private static int zzau(Context context)
    {
        return (zzav(context) % 1000) / 100 + 5;
    }

    private static int zzav(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
        return i;
    }

    public static int zzaw(Context context)
    {
        if (zzaoL != -1) goto _L2; else goto _L1
_L1:
        zzau(context);
        JVM INSTR tableswitch 8 13: default 48
    //                   8 72
    //                   9 48
    //                   10 65
    //                   11 48
    //                   12 48
    //                   13 72;
           goto _L3 _L4 _L3 _L5 _L3 _L3 _L4
_L3:
        int i;
        if (zzax(context))
        {
            i = 1;
        } else
        {
            i = 2;
        }
        zzaoL = i;
_L2:
        return zzaoL;
_L5:
        zzaoL = 3;
        continue; /* Loop/switch isn't completed */
_L4:
        zzaoL = 0;
        if (true) goto _L2; else goto _L6
_L6:
    }

    private static boolean zzax(Context context)
    {
        return ((TelephonyManager)context.getSystemService("phone")).getPhoneType() != 0;
    }

}
