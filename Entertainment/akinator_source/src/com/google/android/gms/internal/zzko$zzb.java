// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zzb;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzo;

// Referenced classes of package com.google.android.gms.internal:
//            zzko

public abstract class piClient extends zzb
{

    final zzko zzXV;
    protected zzo zzXu;

    public abstract void execute();

    protected void zza(zze zze1)
    {
        execute();
    }

    protected volatile void zza(com.google.android.gms.common.api.ecute ecute)
        throws RemoteException
    {
        zza((zze)ecute);
    }

    public zzo zzmG()
    {
        return zzXu;
    }

    public piClient(zzko zzko1)
    {
        zzXV = zzko1;
        super(com.google.android.gms.internal.zzko.zzb(zzko1));
    }
}
