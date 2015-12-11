// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.common.internal.zzv;
import java.util.HashSet;
import java.util.Set;

public final class 
{

    String zzayN;
    final Set zzayO = new HashSet();

    public transient  addActivityTypes(String as[])
    {
        zzv.zzb(as, "activityTypes may not be null.");
        for (int i = 0; i < as.length; i++)
        {
            zzayO.add(as[i]);
        }

        return this;
    }

    public zzayO build()
    {
        return new zzayO(this, null);
    }

    public zzayO setServerClientId(String s)
    {
        zzayN = s;
        return this;
    }

    public ()
    {
    }
}
