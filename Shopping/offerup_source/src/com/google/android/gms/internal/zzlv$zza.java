// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;

public final class zzaeF
{

    public final int zzaeE;
    public final int zzaeF;

    public final boolean equals(Object obj)
    {
        if (obj instanceof zzaeF)
        {
            if (this == obj)
            {
                return true;
            }
            obj = (zzaeF)obj;
            if (((zzaeF) (obj)).zzaeE == zzaeE && ((zzaeE) (obj)).zzaeF == zzaeF)
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzaeE), Integer.valueOf(zzaeF)
        });
    }

    public w(int i, int j)
    {
        zzaeE = i;
        zzaeF = j;
    }
}
