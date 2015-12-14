// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus:
//            Plus

public static final class Builder
    implements com.google.android.gms.common.api.tional
{
    public static final class Builder
    {

        String zzaLe;
        final Set zzaLf = new HashSet();

        public transient Builder addActivityTypes(String as[])
        {
            zzx.zzb(as, "activityTypes may not be null.");
            for (int i = 0; i < as.length; i++)
            {
                zzaLf.add(as[i]);
            }

            return this;
        }

        public Plus.PlusOptions build()
        {
            return new Plus.PlusOptions(this, null);
        }

        public Builder setServerClientId(String s)
        {
            zzaLe = s;
            return this;
        }

        public Builder()
        {
        }
    }


    final String zzaLe;
    final Set zzaLf;

    public static Builder builder()
    {
        return new Builder();
    }

    private Builder()
    {
        zzaLe = null;
        zzaLf = new HashSet();
    }

    zzaLf(zzaLf zzalf)
    {
        this();
    }

    private Builder(Builder builder1)
    {
        zzaLe = builder1.zzaLe;
        zzaLf = builder1.zzaLf;
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
