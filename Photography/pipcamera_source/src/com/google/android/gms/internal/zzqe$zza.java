// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzpy

public class zzaPr
{

    private final Status zzOt;
    private final zza zzaPp;
    private final byte zzaPq[];
    private final long zzaPr;
    private final zzpy zzaPs;
    private final zza zzaPt;

    public Status getStatus()
    {
        return zzOt;
    }

    public zza zzAh()
    {
        return zzaPp;
    }

    public byte[] zzAi()
    {
        return zzaPq;
    }

    public zzpy zzAj()
    {
        return zzaPs;
    }

    public zzaPs zzAk()
    {
        return zzaPt;
    }

    public long zzAl()
    {
        return zzaPr;
    }

    public zza(Status status, zzpy zzpy, zza zza)
    {
        this(status, zzpy, null, null, zza, 0L);
    }

    public zza(Status status, zzpy zzpy, byte abyte0[], zza zza, zza zza1, long l)
    {
        zzOt = status;
        zzaPs = zzpy;
        zzaPq = abyte0;
        zzaPt = zza;
        zzaPp = zza1;
        zzaPr = l;
    }
}
