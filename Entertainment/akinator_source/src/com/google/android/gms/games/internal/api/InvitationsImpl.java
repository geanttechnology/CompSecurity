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

        public com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult zzaf(Status status)
        {
            return new com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult(this, status) {

                final Status zzVb;
                final LoadInvitationsImpl zzaxr;

                public InvitationBuffer getInvitations()
                {
                    return new InvitationBuffer(DataHolder.zzbu(14));
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzaxr = loadinvitationsimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaf(status);
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
        return Games.zzc(googleapiclient).zzuE();
    }

    public PendingResult loadInvitations(GoogleApiClient googleapiclient)
    {
        return loadInvitations(googleapiclient, 0);
    }

    public PendingResult loadInvitations(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zza(new LoadInvitationsImpl(googleapiclient, i) {

            final int zzaxo;
            final InvitationsImpl zzaxp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzaxo);
            }

            
            {
                zzaxp = InvitationsImpl.this;
                zzaxo = i;
                super(googleapiclient);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient googleapiclient, OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        GamesClientImpl gamesclientimpl = Games.zzb(googleapiclient, false);
        if (gamesclientimpl != null)
        {
            gamesclientimpl.zza(googleapiclient.zzo(oninvitationreceivedlistener));
        }
    }

    public void unregisterInvitationListener(GoogleApiClient googleapiclient)
    {
        googleapiclient = Games.zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzuF();
        }
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/InvitationsImpl$2

/* anonymous class */
    class _cls2 extends LoadInvitationsImpl
    {

        final String zzawT;
        final int zzaxo;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zze(this, zzawT, zzaxo);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/InvitationsImpl$3

/* anonymous class */
    class _cls3 extends LoadInvitationsImpl
    {

        final String zzaxq;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzm(this, zzaxq);
        }
    }

}
