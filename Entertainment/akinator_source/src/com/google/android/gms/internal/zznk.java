// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.Log;

public class zznk
{

    private static int zzarj = -1;

    public static boolean zzau(Context context)
    {
        return zzax(context) == 3;
    }

    private static int zzav(Context context)
    {
        return (zzaw(context) % 1000) / 100 + 5;
    }

    private static int zzaw(Context context)
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

    public static int zzax(Context context)
    {
        if (zzarj != -1) goto _L2; else goto _L1
_L1:
        zzav(context);
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
        if (zzay(context))
        {
            i = 1;
        } else
        {
            i = 2;
        }
        zzarj = i;
_L2:
        return zzarj;
_L5:
        zzarj = 3;
        continue; /* Loop/switch isn't completed */
_L4:
        zzarj = 0;
        if (true) goto _L2; else goto _L6
_L6:
    }

    private static boolean zzay(Context context)
    {
        return ((TelephonyManager)context.getSystemService("phone")).getPhoneType() != 0;
    }

}
