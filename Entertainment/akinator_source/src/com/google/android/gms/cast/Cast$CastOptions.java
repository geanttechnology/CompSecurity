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

        CastDevice zzUY;
        Cast.Listener zzUZ;
        private int zzVa;

        static int zza(Builder builder1)
        {
            return builder1.zzVa;
        }

        public Cast.CastOptions build()
        {
            return new Cast.CastOptions(this, null);
        }

        public Builder setVerboseLoggingEnabled(boolean flag)
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

        public Builder(CastDevice castdevice, Cast.Listener listener)
        {
            zzx.zzb(castdevice, "CastDevice parameter cannot be null");
            zzx.zzb(listener, "CastListener parameter cannot be null");
            zzUY = castdevice;
            zzUZ = listener;
            zzVa = 0;
        }
    }


    final CastDevice zzUV;
    final zzUX zzUW;
    private final int zzUX;

    public static Builder builder(CastDevice castdevice, Builder.zzVa zzva)
    {
        return new Builder(castdevice, zzva);
    }

    static int zza(Builder builder1)
    {
        return builder1.zzUX;
    }

    private Builder(Builder builder1)
    {
        zzUV = builder1.zzUY;
        zzUW = builder1.zzUZ;
        zzUX = Builder.zza(builder1);
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
