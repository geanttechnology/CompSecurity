// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzkw

protected final class  extends 
{

    final d zzZS;

    public void onDisconnected()
        throws RemoteException
    {
        zzkw.zznm().zzb("onDisconnected", new Object[0]);
        zzkw.zza(zzZS.);
        zzZS.zzZS(new t>(Status.zzabb));
    }

    public void onError(int i)
        throws RemoteException
    {
        zzkw.zznm().zzb("onError: %d", new Object[] {
            Integer.valueOf(i)
        });
        zzkw.zza(zzZS.);
        zzZS.zzZS(new t>(Status.zzabd));
    }

    protected ( )
    {
        zzZS = ;
        super(., null);
    }
}
