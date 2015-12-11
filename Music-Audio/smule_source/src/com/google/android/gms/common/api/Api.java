// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            Scope

public final class Api
{

    private final String mName;
    private final zzb zzPl;
    private final zze zzPm = null;
    private final zzc zzPn;
    private final zzf zzPo = null;
    private final ArrayList zzPp;

    public transient Api(String s, zzb zzb, zzc zzc, Scope ascope[])
    {
        zzv.zzb(zzb, "Cannot construct an Api with a null ClientBuilder");
        zzv.zzb(zzc, "Cannot construct an Api with a null ClientKey");
        mName = s;
        zzPl = zzb;
        zzPn = zzc;
        zzPp = new ArrayList(Arrays.asList(ascope));
    }

    public String getName()
    {
        return mName;
    }

    public zzb zzkC()
    {
        boolean flag;
        if (zzPl != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzv.zza(flag, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return zzPl;
    }

    public zze zzkD()
    {
        boolean flag;
        if (zzPm != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzv.zza(flag, "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return zzPm;
    }

    public List zzkE()
    {
        return zzPp;
    }

    public zzc zzkF()
    {
        boolean flag;
        if (zzPn != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzv.zza(flag, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return zzPn;
    }

    public boolean zzkG()
    {
        return zzPo != null;
    }
}
