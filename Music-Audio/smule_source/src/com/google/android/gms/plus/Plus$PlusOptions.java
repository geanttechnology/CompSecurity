// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.common.internal.zzv;
import java.util.HashSet;
import java.util.Set;

public final class Builder
    implements com.google.android.gms.common.api.tional
{

    final String zzayN;
    final Set zzayO;

    public static Builder builder()
    {
        return new Builder();
    }

    private Builder()
    {
        zzayN = null;
        zzayO = new HashSet();
    }

    zzayO(zzayO zzayo)
    {
        this();
    }

    private Builder(Builder builder1)
    {
        class Builder
        {

            String zzayN;
            final Set zzayO = new HashSet();

            public transient Builder addActivityTypes(String as[])
            {
                zzv.zzb(as, "activityTypes may not be null.");
                for (int i = 0; i < as.length; i++)
                {
                    zzayO.add(as[i]);
                }

                return this;
            }

            public Plus.PlusOptions build()
            {
                return new Plus.PlusOptions(this, null);
            }

            public Builder setServerClientId(String s)
            {
                zzayN = s;
                return this;
            }

            public Builder()
            {
            }
        }

        zzayN = builder1.zzayN;
        zzayO = builder1.zzayO;
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
