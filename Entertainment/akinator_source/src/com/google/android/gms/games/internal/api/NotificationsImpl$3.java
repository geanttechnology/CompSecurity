// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.internal.GamesClientImpl;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            NotificationsImpl

class _cls1.zzVb extends com.google.android.gms.games.thodImpl
{

    final String zzaxF;

    protected volatile void zza(com.google.android.gms.common.api.sImpl._cls3 _pcls3)
        throws RemoteException
    {
        zza((GamesClientImpl)_pcls3);
    }

    protected void zza(GamesClientImpl gamesclientimpl)
        throws RemoteException
    {
        gamesclientimpl.zzo(this, zzaxF);
    }

    public com.google.android.gms.games.teStatusLoadResult zzal(Status status)
    {
        return new com.google.android.gms.games.Notifications.GameMuteStatusLoadResult(status) {

            final Status zzVb;
            final NotificationsImpl._cls3 zzaxI;

            public Status getStatus()
            {
                return zzVb;
            }

            
            {
                zzaxI = NotificationsImpl._cls3.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzal(status);
    }
}
