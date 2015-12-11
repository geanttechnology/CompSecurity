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

    public final String getAction()
    {
        return zzPp;
    }

    public final String getLabel()
    {
        return zzaLw;
    }

    public final long getValue()
    {
        return zzavc;
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("category", mCategory);
        hashmap.put("action", zzPp);
        hashmap.put("label", zzaLw);
        hashmap.put("value", Long.valueOf(zzavc));
        return zzB(hashmap);
    }

    public final void zzM(long l)
    {
        zzavc = l;
    }

    public final void zza(zzpf zzpf1)
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

    public final volatile void zza(zze zze1)
    {
        zza((zzpf)zze1);
    }

    public final void zzdQ(String s)
    {
        mCategory = s;
    }

    public final void zzdR(String s)
    {
        zzPp = s;
    }

    public final void zzdS(String s)
    {
        zzaLw = s;
    }

    public final String zzyJ()
    {
        return mCategory;
    }
}
