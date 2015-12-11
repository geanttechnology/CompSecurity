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

        public com.google.android.gms.games.Notifications.ContactSettingLoadResult zzam(Status status)
        {
            return new com.google.android.gms.games.Notifications.ContactSettingLoadResult(this, status) {

                final Status zzVb;
                final ContactSettingLoadImpl zzaxL;

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaxL = contactsettingloadimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzam(status);
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

        public com.google.android.gms.games.Notifications.InboxCountResult zzan(Status status)
        {
            return new com.google.android.gms.games.Notifications.InboxCountResult(this, status) {

                final Status zzVb;
                final InboxCountImpl zzaxM;

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaxM = inboxcountimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzan(status);
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
            googleapiclient.zzfW(i);
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

        final String zzaxF;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb1);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzd(this, zzaxF, true);
        }

        public com.google.android.gms.games.Notifications.GameMuteStatusChangeResult zzak(Status status)
        {
            return new com.google.android.gms.games.Notifications.GameMuteStatusChangeResult(this, status) {

                final Status zzVb;
                final _cls1 zzaxG;

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaxG = _pcls1;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzak(status);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$2

/* anonymous class */
    class _cls2 extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
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
            gamesclientimpl.zzd(this, zzaxF, false);
        }

        public com.google.android.gms.games.Notifications.GameMuteStatusChangeResult zzak(Status status)
        {
            return new com.google.android.gms.games.Notifications.GameMuteStatusChangeResult(this, status) {

                final Status zzVb;
                final _cls2 zzaxH;

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaxH = _pcls2;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzak(status);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$3

/* anonymous class */
    class _cls3 extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
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
            return new com.google.android.gms.games.Notifications.GameMuteStatusLoadResult(this, status) {

                final Status zzVb;
                final _cls3 zzaxI;

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzaxI = _pcls3;
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


    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$4

/* anonymous class */
    class _cls4 extends ContactSettingLoadImpl
    {

        final boolean zzawR;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzi(this, zzawR);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/NotificationsImpl$5

/* anonymous class */
    class _cls5 extends ContactSettingUpdateImpl
    {

        final boolean zzaxJ;
        final Bundle zzaxK;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zza(this, zzaxJ, zzaxK);
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
            gamesclientimpl.zzg(this);
        }
    }

}
