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

    public final String getClientId()
    {
        return zzMj;
    }

    public final String getUserId()
    {
        return zzGY;
    }

    public final void setClientId(String s)
    {
        zzMj = s;
    }

    public final void setSampleRate(double d)
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

    public final void setUserId(String s)
    {
        zzGY = s;
    }

    public final String toString()
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

    public final void zzG(boolean flag)
    {
        zzMl = flag;
    }

    public final void zzH(boolean flag)
    {
        zzMn = flag;
    }

    public final void zza(zzjo zzjo1)
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

    public final volatile void zza(zze zze1)
    {
        zza((zzjo)zze1);
    }

    public final void zzaU(String s)
    {
        zzMi = s;
    }

    public final void zzaV(String s)
    {
        zzMk = s;
    }

    public final void zzaW(String s)
    {
        zzMm = s;
    }

    public final String zzia()
    {
        return zzMi;
    }

    public final String zzib()
    {
        return zzMk;
    }

    public final boolean zzic()
    {
        return zzMl;
    }

    public final String zzid()
    {
        return zzMm;
    }

    public final boolean zzie()
    {
        return zzMn;
    }

    public final double zzif()
    {
        return zzMo;
    }
}
