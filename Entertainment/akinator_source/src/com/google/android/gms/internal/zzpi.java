// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpi extends zze
{

    public String zzPp;
    public String zzaLG;
    public String zzaLH;

    public zzpi()
    {
    }

    public String getAction()
    {
        return zzPp;
    }

    public String getTarget()
    {
        return zzaLH;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("network", zzaLG);
        hashmap.put("action", zzPp);
        hashmap.put("target", zzaLH);
        return zzB(hashmap);
    }

    public void zza(zzpi zzpi1)
    {
        if (!TextUtils.isEmpty(zzaLG))
        {
            zzpi1.zzdV(zzaLG);
        }
        if (!TextUtils.isEmpty(zzPp))
        {
            zzpi1.zzdR(zzPp);
        }
        if (!TextUtils.isEmpty(zzaLH))
        {
            zzpi1.zzdW(zzaLH);
        }
    }

    public volatile void zza(zze zze1)
    {
        zza((zzpi)zze1);
    }

    public void zzdR(String s)
    {
        zzPp = s;
    }

    public void zzdV(String s)
    {
        zzaLG = s;
    }

    public void zzdW(String s)
    {
        zzaLH = s;
    }

    public String zzyQ()
    {
        return zzaLG;
    }
}
