// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzrd, zzre, zzrf

public class zzrg
{

    public zzrg()
    {
    }

    int zzCq()
    {
        return android.os.Build.VERSION.SDK_INT;
    }

    public zzrf zzEt()
    {
        if (zzCq() < 8)
        {
            return new zzrd();
        } else
        {
            return new zzre();
        }
    }
}
