// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class zzj extends zzc.zza
{

    private final com.google.android.gms.common.api.zzc.zzb zzaKb;

    private zzj(com.google.android.gms.common.api.zzc.zzb zzb)
    {
        zzaKb = zzb;
    }

    static zzj zzj(com.google.android.gms.common.api.zzc.zzb zzb)
    {
        return new zzj(zzb);
    }

    public void zzaU(Status status)
        throws RemoteException
    {
        zzaKb.zzn(status);
    }
}
