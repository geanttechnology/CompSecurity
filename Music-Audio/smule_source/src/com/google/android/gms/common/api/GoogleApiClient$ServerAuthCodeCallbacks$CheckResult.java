// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzv;
import java.util.Set;

public class zzPP
{

    private boolean zzPO;
    private Set zzPP;

    public static zzPP newAuthNotRequiredResult()
    {
        return new <init>(false, null);
    }

    public static <init> newAuthRequiredResult(Set set)
    {
        boolean flag;
        if (set != null && !set.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzv.zzb(flag, "A non-empty scope set is required if further auth is needed.");
        return new <init>(true, set);
    }

    public boolean zzkN()
    {
        return zzPO;
    }

    public Set zzkO()
    {
        return zzPP;
    }

    private (boolean flag, Set set)
    {
        zzPO = flag;
        zzPP = set;
    }
}
