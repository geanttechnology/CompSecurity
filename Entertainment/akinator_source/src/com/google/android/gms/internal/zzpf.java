// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpf extends zze
{

    private String mCategory;
    private String zzPp;
    private String zzaLw;
    private long zzavc;

    public zzpf()
    {
    }

    public String getAction()
    {
        return zzPp;
    }

    public String getLabel()
    {
        return zzaLw;
    }

    public long getValue()
    {
        return zzavc;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("category", mCategory);
        hashmap.put("action", zzPp);
        hashmap.put("label", zzaLw);
        hashmap.put("value", Long.valueOf(zzavc));
        return zzB(hashmap);
    }

    public void zzM(long l)
    {
        zzavc = l;
    }

    public void zza(zzpf zzpf1)
    {
        if (!TextUtils.isEmpty(mCategory))
        {
            zzpf1.zzdQ(mCategory);
        }
        if (!TextUtils.isEmpty(zzPp))
        {
            zzpf1.zzdR(zzPp);
        }
        if (!TextUtils.isEmpty(zzaLw))
        {
            zzpf1.zzdS(zzaLw);
        }
        if (zzavc != 0L)
        {
            zzpf1.zzM(zzavc);
        }
    }

    public volatile void zza(zze zze1)
    {
        zza((zzpf)zze1);
    }

    public void zzdQ(String s)
    {
        mCategory = s;
    }

    public void zzdR(String s)
    {
        zzPp = s;
    }

    public void zzdS(String s)
    {
        zzaLw = s;
    }

    public String zzyJ()
    {
        return mCategory;
    }
}
