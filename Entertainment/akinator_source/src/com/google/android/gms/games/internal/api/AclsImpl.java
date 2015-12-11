// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;

public final class AclsImpl
    implements Acls
{
    private static abstract class LoadNotifyAclImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.internal.game.Acls.LoadAclResult zzZ(Status status)
        {
            return AclsImpl.zzY(status);
        }

        public Result zzb(Status status)
        {
            return zzZ(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }
    }


    public AclsImpl()
    {
    }

    private static com.google.android.gms.games.internal.game.Acls.LoadAclResult zzX(Status status)
    {
        return new com.google.android.gms.games.internal.game.Acls.LoadAclResult(status) {

            final Status zzVb;

            public Status getStatus()
            {
                return zzVb;
            }

            public void release()
            {
            }

            
            {
                zzVb = status;
                super();
            }
        };
    }

    static com.google.android.gms.games.internal.game.Acls.LoadAclResult zzY(Status status)
    {
        return zzX(status);
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/AclsImpl$2

/* anonymous class */
    class _cls2 extends LoadNotifyAclImpl
    {

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzf(this);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/AclsImpl$3

/* anonymous class */
    class _cls3 extends UpdateNotifyAclImpl
    {

        final String zzawY;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzn(this, zzawY);
        }
    }

}
