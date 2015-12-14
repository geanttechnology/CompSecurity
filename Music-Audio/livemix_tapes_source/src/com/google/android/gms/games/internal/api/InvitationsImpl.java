// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl
    implements Invitations
{
    private static abstract class LoadInvitationsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult zzag(Status status)
        {
            return new com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult(this, status) {

                final Status zzQs;
                final LoadInvitationsImpl zzauT;

                public InvitationBuffer getInvitations()
                {
                    return new InvitationBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus()
                {
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzauT = loadinvitationsimpl;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzag(status);
        }

        private LoadInvitationsImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public InvitationsImpl()
    {
    }

    public Intent getInvitationInboxIntent(GoogleApiClient googleapiclient)
    {
        return Games.zzd(googleapiclient).zztO();
    }

    public PendingResult loadInvitations(GoogleApiClient googleapiclient)
    {
        return loadInvitations(googleapiclient, 0);
    }

    public PendingResult loadInvitations(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zza(new LoadInvitationsImpl(googleapiclient, i) {

            final int zzauQ;
            final InvitationsImpl zzauR;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzc(this, zzauQ);
            }

            
            {
                zzauR = InvitationsImpl.this;
                zzauQ = i;
                super(googleapiclient);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient googleapiclient, OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        GamesClientImpl gamesclientimpl = Games.zzb(googleapiclient, false);
        if (gamesclientimpl != null)
        {
            gamesclientimpl.zza(googleapiclient.zzp(oninvitationreceivedlistener));
        }
    }

    public void unregisterInvitationListener(GoogleApiClient googleapiclient)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zztP();
        }
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/InvitationsImpl$2

/* anonymous class */
    class _cls2 extends LoadInvitationsImpl
    {

        final int zzauQ;
        final String zzauv;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zze(this, zzauv, zzauQ);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/InvitationsImpl$3

/* anonymous class */
    class _cls3 extends LoadInvitationsImpl
    {

        final String zzauS;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzm(this, zzauS);
        }
    }

}
