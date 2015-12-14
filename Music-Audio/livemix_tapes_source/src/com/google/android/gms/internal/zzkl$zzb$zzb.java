// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzkl

protected final class  extends 
{

    final F zzYc;

    public void onDisconnected()
        throws RemoteException
    {
        zzkl.zzmQ().zzb("onDisconnected", new Object[0]);
        zzkl.zza(zzYc.);
        zzYc.zzYc(new t>(Status.zzaaD));
    }

    public void onError(int i)
        throws RemoteException
    {
        zzkl.zzmQ().zzb("onError: %d", new Object[] {
            Integer.valueOf(i)
        });
        zzkl.zza(zzYc.);
        zzYc.zzYc(new t>(Status.zzaaF));
    }

    protected ( )
    {
        zzYc = ;
        super(., null);
    }
}
