// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

public final class Api
{

    private final String mName;
    private final zzc zzZM;
    private final zza zzaav;
    private final zze zzaaw = null;
    private final zzf zzaax = null;

    public Api(String s, zza zza, zzc zzc)
    {
        zzx.zzb(zza, "Cannot construct an Api with a null ClientBuilder");
        zzx.zzb(zzc, "Cannot construct an Api with a null ClientKey");
        mName = s;
        zzaav = zza;
        zzZM = zzc;
    }

    public final String getName()
    {
        return mName;
    }

    public final zza zznv()
    {
        boolean flag;
        if (zzaav != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return zzaav;
    }

    public final zze zznw()
    {
        boolean flag;
        if (zzaaw != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return zzaaw;
    }

    public final zzc zznx()
    {
        boolean flag;
        if (zzZM != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return zzZM;
    }

    public final boolean zzny()
    {
        return zzaax != null;
    }
}
