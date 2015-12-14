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

class zzQs
    implements com.google.android.gms.games.StatusChangeResult
{

    final Status zzQs;
    final zzQs zzavi;

    public Status getStatus()
    {
        return zzQs;
    }

    esult(esult esult, Status status)
    {
        zzavi = esult;
        zzQs = status;
        super();
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$1

/* anonymous class */
    class NotificationsImpl._cls1 extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        final String zzavh;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb1);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzd(this, zzavh, true);
        }

        public com.google.android.gms.games.Notifications.GameMuteStatusChangeResult zzal(Status status)
        {
            return new NotificationsImpl._cls1._cls1(this, status);
        }

        public Result zzb(Status status)
        {
            return zzal(status);
        }
    }

}
