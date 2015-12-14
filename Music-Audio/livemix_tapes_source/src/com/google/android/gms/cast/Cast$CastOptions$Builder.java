// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, CastDevice

public static final class zzTl
{

    CastDevice zzTj;
    zzTl zzTk;
    private int zzTl;

    static int zza(zzTl zztl)
    {
        return zztl.zzTl;
    }

    public zzTl build()
    {
        return new zzTl(this, null);
    }

    public zzTl setVerboseLoggingEnabled(boolean flag)
    {
        if (flag)
        {
            zzTl = zzTl | 1;
            return this;
        } else
        {
            zzTl = zzTl & -2;
            return this;
        }
    }

    public (CastDevice castdevice,  )
    {
        zzx.zzb(castdevice, "CastDevice parameter cannot be null");
        zzx.zzb(, "CastListener parameter cannot be null");
        zzTj = castdevice;
        zzTk = ;
        zzTl = 0;
    }
}
