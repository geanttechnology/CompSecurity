// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.common.api:
//            Result, Status

public class BooleanResult
    implements Result
{

    private final Status zzSC;
    private final boolean zzaaE;

    public BooleanResult(Status status, boolean flag)
    {
        zzSC = (Status)zzx.zzb(status, "Status must not be null");
        zzaaE = flag;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof BooleanResult))
            {
                return false;
            }
            obj = (BooleanResult)obj;
            if (!zzSC.equals(((BooleanResult) (obj)).zzSC) || zzaaE != ((BooleanResult) (obj)).zzaaE)
            {
                return false;
            }
        }
        return true;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public boolean getValue()
    {
        return zzaaE;
    }

    public final int hashCode()
    {
        int j = zzSC.hashCode();
        int i;
        if (zzaaE)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + (j + 527) * 31;
    }
}
