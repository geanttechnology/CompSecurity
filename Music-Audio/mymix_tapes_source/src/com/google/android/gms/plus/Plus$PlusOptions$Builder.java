// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus:
//            Plus

public static final class 
{

    String zzaLe;
    final Set zzaLf = new HashSet();

    public transient  addActivityTypes(String as[])
    {
        zzx.zzb(as, "activityTypes may not be null.");
        for (int i = 0; i < as.length; i++)
        {
            zzaLf.add(as[i]);
        }

        return this;
    }

    public zzaLf build()
    {
        return new zzaLf(this, null);
    }

    public zzaLf setServerClientId(String s)
    {
        zzaLe = s;
        return this;
    }

    public ()
    {
    }
}
