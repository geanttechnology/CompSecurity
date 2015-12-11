// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpd extends zze
{

    public int zzAD;
    public int zzAE;
    private String zzVT;
    public int zzaLt;
    public int zzaLu;
    public int zzaLv;

    public zzpd()
    {
    }

    public final String getLanguage()
    {
        return zzVT;
    }

    public final void setLanguage(String s)
    {
        zzVT = s;
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("language", zzVT);
        hashmap.put("screenColors", Integer.valueOf(zzaLt));
        hashmap.put("screenWidth", Integer.valueOf(zzAD));
        hashmap.put("screenHeight", Integer.valueOf(zzAE));
        hashmap.put("viewportWidth", Integer.valueOf(zzaLu));
        hashmap.put("viewportHeight", Integer.valueOf(zzaLv));
        return zzB(hashmap);
    }

    public final void zza(zzpd zzpd1)
    {
        if (zzaLt != 0)
        {
            zzpd1.zzhW(zzaLt);
        }
        if (zzAD != 0)
        {
            zzpd1.zzhX(zzAD);
        }
        if (zzAE != 0)
        {
            zzpd1.zzhY(zzAE);
        }
        if (zzaLu != 0)
        {
            zzpd1.zzhZ(zzaLu);
        }
        if (zzaLv != 0)
        {
            zzpd1.zzia(zzaLv);
        }
        if (!TextUtils.isEmpty(zzVT))
        {
            zzpd1.setLanguage(zzVT);
        }
    }

    public final volatile void zza(zze zze1)
    {
        zza((zzpd)zze1);
    }

    public final void zzhW(int i)
    {
        zzaLt = i;
    }

    public final void zzhX(int i)
    {
        zzAD = i;
    }

    public final void zzhY(int i)
    {
        zzAE = i;
    }

    public final void zzhZ(int i)
    {
        zzaLu = i;
    }

    public final void zzia(int i)
    {
        zzaLv = i;
    }

    public final int zzyA()
    {
        return zzaLt;
    }

    public final int zzyB()
    {
        return zzAD;
    }

    public final int zzyC()
    {
        return zzAE;
    }

    public final int zzyD()
    {
        return zzaLu;
    }

    public final int zzyE()
    {
        return zzaLv;
    }
}
