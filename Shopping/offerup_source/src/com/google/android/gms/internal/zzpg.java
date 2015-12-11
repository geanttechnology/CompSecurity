// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpg extends zze
{

    public boolean zzaLx;
    public String zzaqZ;

    public zzpg()
    {
    }

    public final String getDescription()
    {
        return zzaqZ;
    }

    public final void setDescription(String s)
    {
        zzaqZ = s;
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("description", zzaqZ);
        hashmap.put("fatal", Boolean.valueOf(zzaLx));
        return zzB(hashmap);
    }

    public final void zza(zzpg zzpg1)
    {
        if (!TextUtils.isEmpty(zzaqZ))
        {
            zzpg1.setDescription(zzaqZ);
        }
        if (zzaLx)
        {
            zzpg1.zzak(zzaLx);
        }
    }

    public final volatile void zza(zze zze1)
    {
        zza((zzpg)zze1);
    }

    public final void zzak(boolean flag)
    {
        zzaLx = flag;
    }

    public final boolean zzyK()
    {
        return zzaLx;
    }
}
