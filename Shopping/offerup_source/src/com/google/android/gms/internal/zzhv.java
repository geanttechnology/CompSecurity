// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

public class zzhv
{

    final String zzHP;
    long zzId;
    long zzIe;
    int zzIf;
    int zzIg;
    int zzIh;
    private final Object zzpd = new Object();

    public zzhv(String s)
    {
        zzId = -1L;
        zzIe = -1L;
        zzIf = -1;
        zzIg = 0;
        zzIh = 0;
        zzHP = s;
    }

    public static boolean zzF(Context context)
    {
        ComponentName componentname;
        int i;
        i = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (i == 0)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        componentname = new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity");
        if (i == context.getPackageManager().getActivityInfo(componentname, 0).theme)
        {
            return true;
        }
        try
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to fetch AdActivity theme");
            com.google.android.gms.ads.internal.util.client.zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        return false;
    }

    public void zzb(AdRequestParcel adrequestparcel, long l)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzIe != -1L)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        zzIe = l;
        zzId = zzIe;
_L2:
        if (adrequestparcel.extras == null || adrequestparcel.extras.getInt("gw", 2) != 1)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        return;
        zzId = l;
        if (true) goto _L2; else goto _L1
_L1:
        adrequestparcel;
        obj;
        JVM INSTR monitorexit ;
        throw adrequestparcel;
        zzIf = zzIf + 1;
        obj;
        JVM INSTR monitorexit ;
    }

    public Bundle zze(Context context, String s)
    {
        Bundle bundle;
        synchronized (zzpd)
        {
            bundle = new Bundle();
            bundle.putString("session_id", zzHP);
            bundle.putLong("basets", zzIe);
            bundle.putLong("currts", zzId);
            bundle.putString("seq_num", s);
            bundle.putInt("preqs", zzIf);
            bundle.putInt("pclick", zzIg);
            bundle.putInt("pimp", zzIh);
            bundle.putBoolean("support_transparent_background", zzF(context));
        }
        return bundle;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void zzgf()
    {
        synchronized (zzpd)
        {
            zzIh = zzIh + 1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzgg()
    {
        synchronized (zzpd)
        {
            zzIg = zzIg + 1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long zzgx()
    {
        return zzIe;
    }
}
