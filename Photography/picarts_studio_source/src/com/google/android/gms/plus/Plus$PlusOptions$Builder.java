// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.Set;

public final class 
{

    String zzaSe;
    final Set zzaSf = new HashSet();

    public final transient  addActivityTypes(String as[])
    {
        zzx.zzb(as, "activityTypes may not be null.");
        for (int i = 0; i < as.length; i++)
        {
            zzaSf.add(as[i]);
        }

        return this;
    }

    public final zzaSf build()
    {
        return new zzaSf(this, null);
    }

    public final zzaSf setServerClientId(String s)
    {
        zzaSe = s;
        return this;
    }

    public ()
    {
    }
}
