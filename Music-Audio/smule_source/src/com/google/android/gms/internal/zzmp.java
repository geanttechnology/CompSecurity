// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzmp
    implements Result
{

    private final zza zzaHa;

    public zzmp(zza zza)
    {
        zzaHa = zza;
    }

    public Status getStatus()
    {
        return zzaHa.getStatus();
    }

    public zza zzym()
    {
        return zzaHa;
    }

    private class zza
    {

        private final Status zzKr;
        private final zza zzaHb;
        private final byte zzaHc[];
        private final long zzaHd;
        private final zzmj zzaHe;
        private final zzmq.zzc zzaHf;

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

        public zzmq.zzc zzyq()
        {
            return zzaHf;
        }

        public long zzyr()
        {
            return zzaHd;
        }

        public zza(Status status, zzmj zzmj, zza zza1)
        {
            this(status, zzmj, null, null, zza1, 0L);
        }

        public zza(Status status, zzmj zzmj, byte abyte0[], zzmq.zzc zzc, zza zza1, long l)
        {
            zzKr = status;
            zzaHe = zzmj;
            zzaHc = abyte0;
            zzaHf = zzc;
            zzaHb = zza1;
            zzaHd = l;
        }
    }

}
