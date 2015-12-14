// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.Set;

public final class Builder
    implements com.google.android.gms.common.api.tional
{

    final String zzaSe;
    final Set zzaSf;

    public static Builder builder()
    {
        return new Builder();
    }

    private Builder()
    {
        zzaSe = null;
        zzaSf = new HashSet();
    }

    zzaSf(zzaSf zzasf)
    {
        this();
    }

    private Builder(Builder builder1)
    {
        class Builder
        {

            String zzaSe;
            final Set zzaSf = new HashSet();

            public final transient Builder addActivityTypes(String as[])
            {
                zzx.zzb(as, "activityTypes may not be null.");
                for (int i = 0; i < as.length; i++)
                {
                    zzaSf.add(as[i]);
                }

                return this;
            }

            public final Plus.PlusOptions build()
            {
                return new Plus.PlusOptions(this, null);
            }

            public final Builder setServerClientId(String s)
            {
                zzaSe = s;
                return this;
            }

            public Builder()
            {
            }
        }

        zzaSe = builder1.zzaSe;
        zzaSf = builder1.zzaSf;
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
