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

    public String getContent()
    {
        return zzvY;
    }

    public String getId()
    {
        return zzwN;
    }

    public String getName()
    {
        return mName;
    }

    public String getSource()
    {
        return zzaGu;
    }

    public void setName(String s)
    {
        mName = s;
    }

    public String toString()
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

    public void zza(zzpc zzpc1)
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

    public volatile void zza(zze zze1)
    {
        zza((zzpc)zze1);
    }

    public void zzdH(String s)
    {
        zzaGu = s;
    }

    public void zzdI(String s)
    {
        zzaLn = s;
    }

    public void zzdJ(String s)
    {
        zzaLo = s;
    }

    public void zzdK(String s)
    {
        zzvY = s;
    }

    public void zzdL(String s)
    {
        zzwN = s;
    }

    public void zzdM(String s)
    {
        zzaLp = s;
    }

    public void zzdN(String s)
    {
        zzaLq = s;
    }

    public void zzdO(String s)
    {
        zzaLr = s;
    }

    public void zzdP(String s)
    {
        zzaLs = s;
    }

    public String zzyu()
    {
        return zzaLn;
    }

    public String zzyv()
    {
        return zzaLo;
    }

    public String zzyw()
    {
        return zzaLp;
    }

    public String zzyx()
    {
        return zzaLq;
    }

    public String zzyy()
    {
        return zzaLr;
    }

    public String zzyz()
    {
        return zzaLs;
    }
}
