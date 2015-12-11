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

class zzVb
    implements com.google.android.gms.games.StatusLoadResult
{

    final Status zzVb;
    final zzVb zzaxI;

    public Status getStatus()
    {
        return zzVb;
    }

    ult(ult ult, Status status)
    {
        zzaxI = ult;
        zzVb = status;
        super();
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$3

/* anonymous class */
    class NotificationsImpl._cls3 extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        final String zzaxF;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb1);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzo(this, zzaxF);
        }

        public com.google.android.gms.games.Notifications.GameMuteStatusLoadResult zzal(Status status)
        {
            return new NotificationsImpl._cls3._cls1(this, status);
        }

        public Result zzb(Status status)
        {
            return zzal(status);
        }
    }

}
