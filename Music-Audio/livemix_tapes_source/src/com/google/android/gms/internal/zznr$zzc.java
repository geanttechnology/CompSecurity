// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zznr

private static class  extends 
{

    private final com.google.android.gms.common.api.zn zzQz;
    private final  zzapr;

    public void zzr(Status status)
    {
        if (zzapr != null && status.isSuccess())
        {
            zzapr.zzrZ();
        }
        zzQz.zn(status);
    }

    private (com.google.android.gms.common.api. ,  1)
    {
        zzQz = ;
        zzapr = 1;
    }

    (com.google.android.gms.common.api.apr apr,  ,  1)
    {
        this(apr, );
    }
}
