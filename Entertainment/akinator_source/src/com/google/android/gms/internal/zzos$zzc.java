// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzos

private static class <init> extends <init>
{

    private final zzp zzagy;
    private final zzp zzarO;

    public void zzo(Status status)
    {
        if (zzarO != null && status.isSuccess())
        {
            zzarO.zzsL();
        }
        zzagy.zzp(status);
    }

    private ( ,  1)
    {
        zzagy = ;
        zzarO = 1;
    }

    zzarO(zzarO zzaro, zzarO zzaro1, zzarO zzaro2)
    {
        this(zzaro, zzaro1);
    }
}
