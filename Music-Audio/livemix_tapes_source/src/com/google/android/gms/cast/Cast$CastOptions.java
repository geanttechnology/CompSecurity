// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, CastDevice

public static final class Builder
    implements com.google.android.gms.common.api.sOptions
{
    public static final class Builder
    {

        CastDevice zzTj;
        Cast.Listener zzTk;
        private int zzTl;

        static int zza(Builder builder1)
        {
            return builder1.zzTl;
        }

        public Cast.CastOptions build()
        {
            return new Cast.CastOptions(this, null);
        }

        public Builder setVerboseLoggingEnabled(boolean flag)
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

        public Builder(CastDevice castdevice, Cast.Listener listener)
        {
            zzx.zzb(castdevice, "CastDevice parameter cannot be null");
            zzx.zzb(listener, "CastListener parameter cannot be null");
            zzTj = castdevice;
            zzTk = listener;
            zzTl = 0;
        }
    }


    final CastDevice zzTg;
    final zzTi zzTh;
    private final int zzTi;

    public static Builder builder(CastDevice castdevice, Builder.zzTl zztl)
    {
        return new Builder(castdevice, zztl);
    }

    static int zza(Builder builder1)
    {
        return builder1.zzTi;
    }

    private Builder(Builder builder1)
    {
        zzTg = builder1.zzTj;
        zzTh = builder1.zzTk;
        zzTi = Builder.zza(builder1);
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
