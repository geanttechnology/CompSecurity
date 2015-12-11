// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzmj

public class zzaHd
{

    private final Status zzKr;
    private final zza zzaHb;
    private final byte zzaHc[];
    private final long zzaHd;
    private final zzmj zzaHe;
    private final zza zzaHf;

    public Status getStatus()
    {
        return zzKr;
    }

    public zza zzyn()
    {
        return zzaHb;
    }

    public byte[] zzyo()
    {
        return zzaHc;
    }

    public zzmj zzyp()
    {
        return zzaHe;
    }

    public zzaHe zzyq()
    {
        return zzaHf;
    }

    public long zzyr()
    {
        return zzaHd;
    }

    public zza(Status status, zzmj zzmj, zza zza)
    {
        this(status, zzmj, null, null, zza, 0L);
    }

    public zza(Status status, zzmj zzmj, byte abyte0[], zza zza, zza zza1, long l)
    {
        zzKr = status;
        zzaHe = zzmj;
        zzaHc = abyte0;
        zzaHf = zza;
        zzaHb = zza1;
        zzaHd = l;
    }
}
