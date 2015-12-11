// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpc extends zze
{

    private String mName;
    private String zzaGu;
    private String zzaLn;
    private String zzaLo;
    private String zzaLp;
    private String zzaLq;
    private String zzaLr;
    private String zzaLs;
    private String zzvY;
    private String zzwN;

    public zzpc()
    {
    }

    public final String getContent()
    {
        return zzvY;
    }

    public final String getId()
    {
        return zzwN;
    }

    public final String getName()
    {
        return mName;
    }

    public final String getSource()
    {
        return zzaGu;
    }

    public final void setName(String s)
    {
        mName = s;
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("name", mName);
        hashmap.put("source", zzaGu);
        hashmap.put("medium", zzaLn);
        hashmap.put("keyword", zzaLo);
        hashmap.put("content", zzvY);
        hashmap.put("id", zzwN);
        hashmap.put("adNetworkId", zzaLp);
        hashmap.put("gclid", zzaLq);
        hashmap.put("dclid", zzaLr);
        hashmap.put("aclid", zzaLs);
        return zzB(hashmap);
    }

    public final void zza(zzpc zzpc1)
    {
        if (!TextUtils.isEmpty(mName))
        {
            zzpc1.setName(mName);
        }
        if (!TextUtils.isEmpty(zzaGu))
        {
            zzpc1.zzdH(zzaGu);
        }
        if (!TextUtils.isEmpty(zzaLn))
        {
            zzpc1.zzdI(zzaLn);
        }
        if (!TextUtils.isEmpty(zzaLo))
        {
            zzpc1.zzdJ(zzaLo);
        }
        if (!TextUtils.isEmpty(zzvY))
        {
            zzpc1.zzdK(zzvY);
        }
        if (!TextUtils.isEmpty(zzwN))
        {
            zzpc1.zzdL(zzwN);
        }
        if (!TextUtils.isEmpty(zzaLp))
        {
            zzpc1.zzdM(zzaLp);
        }
        if (!TextUtils.isEmpty(zzaLq))
        {
            zzpc1.zzdN(zzaLq);
        }
        if (!TextUtils.isEmpty(zzaLr))
        {
            zzpc1.zzdO(zzaLr);
        }
        if (!TextUtils.isEmpty(zzaLs))
        {
            zzpc1.zzdP(zzaLs);
        }
    }

    public final volatile void zza(zze zze1)
    {
        zza((zzpc)zze1);
    }

    public final void zzdH(String s)
    {
        zzaGu = s;
    }

    public final void zzdI(String s)
    {
        zzaLn = s;
    }

    public final void zzdJ(String s)
    {
        zzaLo = s;
    }

    public final void zzdK(String s)
    {
        zzvY = s;
    }

    public final void zzdL(String s)
    {
        zzwN = s;
    }

    public final void zzdM(String s)
    {
        zzaLp = s;
    }

    public final void zzdN(String s)
    {
        zzaLq = s;
    }

    public final void zzdO(String s)
    {
        zzaLr = s;
    }

    public final void zzdP(String s)
    {
        zzaLs = s;
    }

    public final String zzyu()
    {
        return zzaLn;
    }

    public final String zzyv()
    {
        return zzaLo;
    }

    public final String zzyw()
    {
        return zzaLp;
    }

    public final String zzyx()
    {
        return zzaLq;
    }

    public final String zzyy()
    {
        return zzaLr;
    }

    public final String zzyz()
    {
        return zzaLs;
    }
}
