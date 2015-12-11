// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            cz, cv

public final class cm
{

    public final int oM;
    public final boolean oN;
    public final boolean oO;
    public final String oP;
    public final String oQ;
    public final boolean oR = cz.aW();
    public final boolean oS;
    public final boolean oT;
    public final String oU;
    public final String oV;
    public final int oW;
    public final int oX;
    public final int oY;
    public final int oZ;
    public final int pa;
    public final int pb;
    public final float pc;
    public final int pd;
    public final int pe;

    public cm(Context context)
    {
        boolean flag1 = true;
        super();
        AudioManager audiomanager = (AudioManager)context.getSystemService("audio");
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        Locale locale = Locale.getDefault();
        PackageManager packagemanager = context.getPackageManager();
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        oM = audiomanager.getMode();
        boolean flag;
        if (a(packagemanager, "geo:0,0?q=donuts") != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        oN = flag;
        if (a(packagemanager, "http://www.google.com") != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        oO = flag;
        oP = telephonymanager.getNetworkOperator();
        oQ = locale.getCountry();
        oS = audiomanager.isMusicActive();
        oT = audiomanager.isSpeakerphoneOn();
        oU = locale.getLanguage();
        oV = a(packagemanager);
        oW = audiomanager.getStreamVolume(3);
        oX = a(context, connectivitymanager, packagemanager);
        oY = telephonymanager.getNetworkType();
        oZ = telephonymanager.getPhoneType();
        pa = audiomanager.getRingerMode();
        pb = audiomanager.getStreamVolume(2);
        pc = displaymetrics.density;
        pd = displaymetrics.widthPixels;
        pe = displaymetrics.heightPixels;
    }

    private static int a(Context context, ConnectivityManager connectivitymanager, PackageManager packagemanager)
    {
label0:
        {
            int i = -2;
            if (cv.a(packagemanager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
            {
                context = connectivitymanager.getActiveNetworkInfo();
                if (context == null)
                {
                    break label0;
                }
                i = context.getType();
            }
            return i;
        }
        return -1;
    }

    private static ResolveInfo a(PackageManager packagemanager, String s)
    {
        return packagemanager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)), 0x10000);
    }

    private static String a(PackageManager packagemanager)
    {
        Object obj = a(packagemanager, "market://details?id=com.google.android.gms.ads");
        if (obj != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((obj = ((ResolveInfo) (obj)).activityInfo) == null) goto _L1; else goto _L3
_L3:
        try
        {
            packagemanager = packagemanager.getPackageInfo(((ActivityInfo) (obj)).packageName, 0);
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            return null;
        }
        if (packagemanager == null) goto _L1; else goto _L4
_L4:
        packagemanager = (new StringBuilder()).append(((PackageInfo) (packagemanager)).versionCode).append(".").append(((ActivityInfo) (obj)).packageName).toString();
        return packagemanager;
    }
}
