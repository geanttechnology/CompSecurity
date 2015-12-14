// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzqe
    implements Result
{

    private final zza zzaPo;

    public zzqe(zza zza)
    {
        zzaPo = zza;
    }

    public Status getStatus()
    {
        return zzaPo.getStatus();
    }

    public zza zzAg()
    {
        return zzaPo;
    }

    private class zza
    {

        private final Status zzOt;
        private final zza zzaPp;
        private final byte zzaPq[];
        private final long zzaPr;
        private final zzpy zzaPs;
        private final zzqf.zzc zzaPt;

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

        public zzqf.zzc zzAk()
        {
            return zzaPt;
        }

        public long zzAl()
        {
            return zzaPr;
        }

        public zza(Status status, zzpy zzpy, zza zza1)
        {
            this(status, zzpy, null, null, zza1, 0L);
        }

        public zza(Status status, zzpy zzpy, byte abyte0[], zzqf.zzc zzc, zza zza1, long l)
        {
            zzOt = status;
            zzaPs = zzpy;
            zzaPq = abyte0;
            zzaPt = zzc;
            zzaPp = zza1;
            zzaPr = l;
        }
    }

}
