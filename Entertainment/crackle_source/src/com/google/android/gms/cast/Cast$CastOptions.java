// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;


// Referenced classes of package com.google.android.gms.cast:
//            Cast, CastDevice

public static final class Builder
    implements com.google.android.gms.common.api.piOptions
{
    public static final class Builder
    {

        CastDevice kv;
        Cast.Listener kw;
        private int kx;

        static int a(Builder builder1)
        {
            return builder1.kx;
        }

        public Cast.CastOptions build()
        {
            return new Cast.CastOptions(this, null);
        }

        public Builder setDebuggingEnabled()
        {
            kx = kx | 1;
            return this;
        }

        private Builder(CastDevice castdevice, Cast.Listener listener)
        {
            kv = castdevice;
            kw = listener;
            kx = 0;
        }

        Builder(CastDevice castdevice, Cast.Listener listener, Cast._cls1 _pcls1)
        {
            this(castdevice, listener);
        }
    }


    final CastDevice ks;
    final Builder kt;
    private final int ku;

    static int a(Builder.kx kx)
    {
        return kx.ku;
    }

    public static Builder builder(CastDevice castdevice, ku ku1)
    {
        return new Builder(castdevice, ku1, null);
    }

    private Builder(Builder builder1)
    {
        ks = builder1.kv;
        kt = builder1.kw;
        ku = Builder.a(builder1);
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
