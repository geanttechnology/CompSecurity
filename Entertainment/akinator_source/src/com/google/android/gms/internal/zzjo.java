// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzjo extends zze
{

    private String zzGY;
    private String zzMi;
    private String zzMj;
    private String zzMk;
    private boolean zzMl;
    private String zzMm;
    private boolean zzMn;
    private double zzMo;

    public zzjo()
    {
    }

    public String getClientId()
    {
        return zzMj;
    }

    public String getUserId()
    {
        return zzGY;
    }

    public void setClientId(String s)
    {
        zzMj = s;
    }

    public void setSampleRate(double d)
    {
        boolean flag;
        if (d >= 0.0D && d <= 100D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Sample rate must be between 0% and 100%");
        zzMo = d;
    }

    public void setUserId(String s)
    {
        zzGY = s;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("hitType", zzMi);
        hashmap.put("clientId", zzMj);
        hashmap.put("userId", zzGY);
        hashmap.put("androidAdId", zzMk);
        hashmap.put("AdTargetingEnabled", Boolean.valueOf(zzMl));
        hashmap.put("sessionControl", zzMm);
        hashmap.put("nonInteraction", Boolean.valueOf(zzMn));
        hashmap.put("sampleRate", Double.valueOf(zzMo));
        return zzB(hashmap);
    }

    public void zzG(boolean flag)
    {
        zzMl = flag;
    }

    public void zzH(boolean flag)
    {
        zzMn = flag;
    }

    public void zza(zzjo zzjo1)
    {
        if (!TextUtils.isEmpty(zzMi))
        {
            zzjo1.zzaU(zzMi);
        }
        if (!TextUtils.isEmpty(zzMj))
        {
            zzjo1.setClientId(zzMj);
        }
        if (!TextUtils.isEmpty(zzGY))
        {
            zzjo1.setUserId(zzGY);
        }
        if (!TextUtils.isEmpty(zzMk))
        {
            zzjo1.zzaV(zzMk);
        }
        if (zzMl)
        {
            zzjo1.zzG(true);
        }
        if (!TextUtils.isEmpty(zzMm))
        {
            zzjo1.zzaW(zzMm);
        }
        if (zzMn)
        {
            zzjo1.zzH(zzMn);
        }
        if (zzMo != 0.0D)
        {
            zzjo1.setSampleRate(zzMo);
        }
    }

    public volatile void zza(zze zze1)
    {
        zza((zzjo)zze1);
    }

    public void zzaU(String s)
    {
        zzMi = s;
    }

    public void zzaV(String s)
    {
        zzMk = s;
    }

    public void zzaW(String s)
    {
        zzMm = s;
    }

    public String zzia()
    {
        return zzMi;
    }

    public String zzib()
    {
        return zzMk;
    }

    public boolean zzic()
    {
        return zzMl;
    }

    public String zzid()
    {
        return zzMm;
    }

    public boolean zzie()
    {
        return zzMn;
    }

    public double zzif()
    {
        return zzMo;
    }
}
