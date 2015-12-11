// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpb extends zze
{

    private String zzOZ;
    private String zzPa;
    private String zzaLl;
    private String zzaLm;

    public zzpb()
    {
    }

    public void setAppId(String s)
    {
        zzaLl = s;
    }

    public void setAppInstallerId(String s)
    {
        zzaLm = s;
    }

    public void setAppName(String s)
    {
        zzOZ = s;
    }

    public void setAppVersion(String s)
    {
        zzPa = s;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("appName", zzOZ);
        hashmap.put("appVersion", zzPa);
        hashmap.put("appId", zzaLl);
        hashmap.put("appInstallerId", zzaLm);
        return zzB(hashmap);
    }

    public void zza(zzpb zzpb1)
    {
        if (!TextUtils.isEmpty(zzOZ))
        {
            zzpb1.setAppName(zzOZ);
        }
        if (!TextUtils.isEmpty(zzPa))
        {
            zzpb1.setAppVersion(zzPa);
        }
        if (!TextUtils.isEmpty(zzaLl))
        {
            zzpb1.setAppId(zzaLl);
        }
        if (!TextUtils.isEmpty(zzaLm))
        {
            zzpb1.setAppInstallerId(zzaLm);
        }
    }

    public volatile void zza(zze zze1)
    {
        zza((zzpb)zze1);
    }

    public String zzkp()
    {
        return zzOZ;
    }

    public String zzkr()
    {
        return zzPa;
    }

    public String zzuM()
    {
        return zzaLl;
    }

    public String zzyt()
    {
        return zzaLm;
    }
}
