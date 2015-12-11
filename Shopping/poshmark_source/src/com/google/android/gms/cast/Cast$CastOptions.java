// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.internal.er;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, CastDevice

public static final class Builder
    implements com.google.android.gms.common.api.piOptions
{
    public static final class Builder
    {

        private int wA;
        CastDevice wy;
        Cast.Listener wz;

        static int a(Builder builder1)
        {
            return builder1.wA;
        }

        public Cast.CastOptions build()
        {
            return new Cast.CastOptions(this, null);
        }

        public Builder setVerboseLoggingEnabled(boolean flag)
        {
            if (flag)
            {
                wA = wA | 1;
                return this;
            } else
            {
                wA = wA & -2;
                return this;
            }
        }

        private Builder(CastDevice castdevice, Cast.Listener listener)
        {
            er.b(castdevice, "CastDevice parameter cannot be null");
            er.b(listener, "CastListener parameter cannot be null");
            wy = castdevice;
            wz = listener;
            wA = 0;
        }

        Builder(CastDevice castdevice, Cast.Listener listener, Cast._cls1 _pcls1)
        {
            this(castdevice, listener);
        }
    }


    final CastDevice wv;
    final Builder ww;
    private final int wx;

    static int a(Builder.wA wa)
    {
        return wa.wx;
    }

    public static Builder builder(CastDevice castdevice, wx wx1)
    {
        return new Builder(castdevice, wx1, null);
    }

    private Builder(Builder builder1)
    {
        wv = builder1.wy;
        ww = builder1.wz;
        wx = Builder.a(builder1);
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
