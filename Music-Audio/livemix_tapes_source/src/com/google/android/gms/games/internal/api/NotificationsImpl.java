// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl
    implements Notifications
{
    private static abstract class ContactSettingLoadImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.Notifications.ContactSettingLoadResult zzan(Status status)
        {
            return new com.google.android.gms.games.Notifications.ContactSettingLoadResult(this, status) {

                final Status zzQs;
                final ContactSettingLoadImpl zzavn;

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzavn = contactsettingloadimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzan(status);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
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

    private static abstract class InboxCountImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.Notifications.InboxCountResult zzao(Status status)
        {
            return new com.google.android.gms.games.Notifications.InboxCountResult(this, status) {

                final Status zzQs;
                final InboxCountImpl zzavo;

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzavo = inboxcountimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzao(status);
        }
    }


    public NotificationsImpl()
    {
    }

    public void clear(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzfN(i);
        }
    }

    public void clearAll(GoogleApiClient googleapiclient)
    {
        clear(googleapiclient, 31);
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$1

/* anonymous class */
    class _cls1 extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
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
            return new com.google.android.gms.games.Notifications.GameMuteStatusChangeResult(this, status) {

                final Status zzQs;
                final _cls1 zzavi;

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzavi = _pcls1;
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


    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$2

/* anonymous class */
    class _cls2 extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
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
            gamesclientimpl.zzd(this, zzavh, false);
        }

        public com.google.android.gms.games.Notifications.GameMuteStatusChangeResult zzal(Status status)
        {
            return new com.google.android.gms.games.Notifications.GameMuteStatusChangeResult(this, status) {

                final Status zzQs;
                final _cls2 zzavj;

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzavj = _pcls2;
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


    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$3

/* anonymous class */
    class _cls3 extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
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
            gamesclientimpl.zzo(this, zzavh);
        }

        public com.google.android.gms.games.Notifications.GameMuteStatusLoadResult zzam(Status status)
        {
            return new com.google.android.gms.games.Notifications.GameMuteStatusLoadResult(this, status) {

                final Status zzQs;
                final _cls3 zzavk;

                public Status getStatus()
                {
                    return zzQs;
                }

            
            {
                zzavk = _pcls3;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzam(status);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$4

/* anonymous class */
    class _cls4 extends ContactSettingLoadImpl
    {

        final boolean zzaut;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzi(this, zzaut);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$5

/* anonymous class */
    class _cls5 extends ContactSettingUpdateImpl
    {

        final boolean zzavl;
        final Bundle zzavm;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzavl, zzavm);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$6

/* anonymous class */
    class _cls6 extends InboxCountImpl
    {

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzh(this);
        }
    }

}
