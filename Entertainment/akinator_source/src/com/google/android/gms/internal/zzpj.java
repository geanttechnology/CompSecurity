// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpj extends zze
{

    public String mCategory;
    public String zzaLI;
    public long zzaLJ;
    public String zzaLw;

    public zzpj()
    {
    }

    public String getLabel()
    {
        return zzaLw;
    }

    public long getTimeInMillis()
    {
        return zzaLJ;
    }

    public void setTimeInMillis(long l)
    {
        zzaLJ = l;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("variableName", zzaLI);
        hashmap.put("timeInMillis", Long.valueOf(zzaLJ));
        hashmap.put("category", mCategory);
        hashmap.put("label", zzaLw);
        return zzB(hashmap);
    }

    public void zza(zzpj zzpj1)
    {
        if (!TextUtils.isEmpty(zzaLI))
        {
            zzpj1.zzdX(zzaLI);
        }
        if (zzaLJ != 0L)
        {
            zzpj1.setTimeInMillis(zzaLJ);
        }
        if (!TextUtils.isEmpty(mCategory))
        {
            zzpj1.zzdQ(mCategory);
        }
        if (!TextUtils.isEmpty(zzaLw))
        {
            zzpj1.zzdS(zzaLw);
        }
    }

    public volatile void zza(zze zze1)
    {
        zza((zzpj)zze1);
    }

    public void zzdQ(String s)
    {
        mCategory = s;
    }

    public void zzdS(String s)
    {
        zzaLw = s;
    }

    public void zzdX(String s)
    {
        zzaLI = s;
    }

    public String zzyJ()
    {
        return mCategory;
    }

    public String zzyR()
    {
        return zzaLI;
    }
}
