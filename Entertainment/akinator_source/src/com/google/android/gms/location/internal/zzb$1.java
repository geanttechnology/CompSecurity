// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.DeadObjectException;
import android.os.IInterface;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzp, zzb, zzi

class zzaFc
    implements zzp
{

    final zzb zzaFc;

    public void zzpb()
    {
        zzb.zza(zzaFc);
    }

    public IInterface zzpc()
        throws DeadObjectException
    {
        return zzwB();
    }

    public zzi zzwB()
        throws DeadObjectException
    {
        return (zzi)zzaFc.zzpc();
    }

    (zzb zzb1)
    {
        zzaFc = zzb1;
        super();
    }
}
