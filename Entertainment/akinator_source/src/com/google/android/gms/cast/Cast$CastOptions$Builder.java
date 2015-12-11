// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, CastDevice

public static final class zzVa
{

    CastDevice zzUY;
    zzVa zzUZ;
    private int zzVa;

    static int zza(zzVa zzva)
    {
        return zzva.zzVa;
    }

    public zzVa build()
    {
        return new zzVa(this, null);
    }

    public zzVa setVerboseLoggingEnabled(boolean flag)
    {
        if (flag)
        {
            zzVa = zzVa | 1;
            return this;
        } else
        {
            zzVa = zzVa & -2;
            return this;
        }
    }

    public (CastDevice castdevice,  )
    {
        zzx.zzb(castdevice, "CastDevice parameter cannot be null");
        zzx.zzb(, "CastListener parameter cannot be null");
        zzUY = castdevice;
        zzUZ = ;
        zzVa = 0;
    }
}
