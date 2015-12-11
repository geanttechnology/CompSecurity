// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import java.util.Locale;

public final class Builder
    implements com.google.android.gms.common.api.ions
{

    public final int environment;
    public final int theme;

    private Builder()
    {
        class Builder
        {

            private int mTheme;
            private int zzbdL;

            static int zza(Builder builder)
            {
                return builder.zzbdL;
            }

            static int zzb(Builder builder)
            {
                return builder.mTheme;
            }

            public final Wallet.WalletOptions build()
            {
                return new Wallet.WalletOptions(this, null);
            }

            public final Builder setEnvironment(int i)
            {
                if (i == 0 || i == 2 || i == 1 || i == 3)
                {
                    zzbdL = i;
                    return this;
                } else
                {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[] {
                        Integer.valueOf(i)
                    }));
                }
            }

            public final Builder setTheme(int i)
            {
                if (i == 0 || i == 1)
                {
                    mTheme = i;
                    return this;
                } else
                {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[] {
                        Integer.valueOf(i)
                    }));
                }
            }

            public Builder()
            {
                zzbdL = 3;
                mTheme = 0;
            }
        }

        this(new Builder());
    }

    Builder(Builder builder)
    {
        this();
    }

    private Builder(Builder builder)
    {
        environment = Builder.zza(builder);
        theme = Builder.zzb(builder);
    }

    Builder(Builder builder, Builder builder1)
    {
        this(builder);
    }
}
