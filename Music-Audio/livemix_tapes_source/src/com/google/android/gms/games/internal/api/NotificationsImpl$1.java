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

class _cls1.zzQs extends com.google.android.gms.games.thodImpl
{

    final String zzavh;

    protected volatile void zza(com.google.android.gms.common.api.sImpl._cls1 _pcls1)
        throws RemoteException
    {
        zza((GamesClientImpl)_pcls1);
    }

    protected void zza(GamesClientImpl gamesclientimpl)
        throws RemoteException
    {
        gamesclientimpl.zzd(this, zzavh, true);
    }

    public com.google.android.gms.games.teStatusChangeResult zzal(Status status)
    {
        return new com.google.android.gms.games.Notifications.GameMuteStatusChangeResult(status) {

            final Status zzQs;
            final NotificationsImpl._cls1 zzavi;

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzavi = NotificationsImpl._cls1.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzal(status);
    }
}
