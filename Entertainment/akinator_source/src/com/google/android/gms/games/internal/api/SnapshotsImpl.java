// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

public final class SnapshotsImpl
    implements Snapshots
{
    private static abstract class CommitImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult zzaz(Status status)
        {
            return new com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult(this, status) {

                final Status zzVb;
                final CommitImpl zzayD;

                public SnapshotMetadata getSnapshotMetadata()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzayD = commitimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaz(status);
        }

        private CommitImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class DeleteImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult zzaA(Status status)
        {
            return new com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult(this, status) {

                final Status zzVb;
                final DeleteImpl zzayE;

                public String getSnapshotId()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzayE = deleteimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaA(status);
        }

        private DeleteImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class LoadImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult zzaB(Status status)
        {
            return new com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult(this, status) {

                final Status zzVb;
                final LoadImpl zzayF;

                public SnapshotMetadataBuffer getSnapshots()
                {
                    return new SnapshotMetadataBuffer(DataHolder.zzbu(14));
                }

                public Status getStatus()
                {
                    return zzVb;
                }

                public void release()
                {
                }

            
            {
                zzayF = loadimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaB(status);
        }

        private LoadImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class OpenImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult zzaC(Status status)
        {
            return new com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult(this, status) {

                final Status zzVb;
                final OpenImpl zzayG;

                public String getConflictId()
                {
                    return null;
                }

                public Snapshot getConflictingSnapshot()
                {
                    return null;
                }

                public SnapshotContents getResolutionSnapshotContents()
                {
                    return null;
                }

                public Snapshot getSnapshot()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzVb;
                }

            
            {
                zzayG = openimpl;
                zzVb = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaC(status);
        }

        private OpenImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public SnapshotsImpl()
    {
    }

    public PendingResult commitAndClose(GoogleApiClient googleapiclient, Snapshot snapshot, SnapshotMetadataChange snapshotmetadatachange)
    {
        return googleapiclient.zzb(new CommitImpl(googleapiclient, snapshot, snapshotmetadatachange) {

            final SnapshotsImpl zzayt;
            final Snapshot zzayx;
            final SnapshotMetadataChange zzayy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzayx, zzayy);
            }

            
            {
                zzayt = SnapshotsImpl.this;
                zzayx = snapshot;
                zzayy = snapshotmetadatachange;
                super(googleapiclient);
            }
        });
    }

    public PendingResult delete(GoogleApiClient googleapiclient, SnapshotMetadata snapshotmetadata)
    {
        return googleapiclient.zzb(new DeleteImpl(googleapiclient, snapshotmetadata) {

            final SnapshotsImpl zzayt;
            final SnapshotMetadata zzayz;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzi(this, zzayz.getSnapshotId());
            }

            
            {
                zzayt = SnapshotsImpl.this;
                zzayz = snapshotmetadata;
                super(googleapiclient);
            }
        });
    }

    public void discardAndClose(GoogleApiClient googleapiclient, Snapshot snapshot)
    {
        Games.zzc(googleapiclient).zza(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuS();
    }

    public int getMaxDataSize(GoogleApiClient googleapiclient)
    {
        return Games.zzc(googleapiclient).zzuR();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient googleapiclient, String s, boolean flag, boolean flag1, int i)
    {
        return Games.zzc(googleapiclient).zza(s, flag, flag1, i);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle bundle)
    {
        if (bundle == null || !bundle.containsKey("com.google.android.gms.games.SNAPSHOT_METADATA"))
        {
            return null;
        } else
        {
            return (SnapshotMetadata)bundle.getParcelable("com.google.android.gms.games.SNAPSHOT_METADATA");
        }
    }

    public PendingResult load(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new LoadImpl(googleapiclient, flag) {

            final boolean zzawR;
            final SnapshotsImpl zzayt;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzf(this, zzawR);
            }

            
            {
                zzayt = SnapshotsImpl.this;
                zzawR = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult open(GoogleApiClient googleapiclient, SnapshotMetadata snapshotmetadata)
    {
        return open(googleapiclient, snapshotmetadata.getUniqueName(), false);
    }

    public PendingResult open(GoogleApiClient googleapiclient, SnapshotMetadata snapshotmetadata, int i)
    {
        return open(googleapiclient, snapshotmetadata.getUniqueName(), false, i);
    }

    public PendingResult open(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return open(googleapiclient, s, flag, -1);
    }

    public PendingResult open(GoogleApiClient googleapiclient, String s, boolean flag, int i)
    {
        return googleapiclient.zzb(new OpenImpl(googleapiclient, s, flag, i) {

            final SnapshotsImpl zzayt;
            final String zzayu;
            final boolean zzayv;
            final int zzayw;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzayu, zzayv, zzayw);
            }

            
            {
                zzayt = SnapshotsImpl.this;
                zzayu = s;
                zzayv = flag;
                zzayw = i;
                super(googleapiclient);
            }
        });
    }

    public PendingResult resolveConflict(GoogleApiClient googleapiclient, String s, Snapshot snapshot)
    {
        SnapshotMetadata snapshotmetadata = snapshot.getMetadata();
        SnapshotMetadataChange snapshotmetadatachange = (new com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder()).fromMetadata(snapshotmetadata).build();
        return resolveConflict(googleapiclient, s, snapshotmetadata.getSnapshotId(), snapshotmetadatachange, snapshot.getSnapshotContents());
    }

    public PendingResult resolveConflict(GoogleApiClient googleapiclient, String s, String s1, SnapshotMetadataChange snapshotmetadatachange, SnapshotContents snapshotcontents)
    {
        return googleapiclient.zzb(new OpenImpl(googleapiclient, s, s1, snapshotmetadatachange, snapshotcontents) {

            final String zzayA;
            final String zzayB;
            final SnapshotContents zzayC;
            final SnapshotsImpl zzayt;
            final SnapshotMetadataChange zzayy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zza(this, zzayA, zzayB, zzayy, zzayC);
            }

            
            {
                zzayt = SnapshotsImpl.this;
                zzayA = s;
                zzayB = s1;
                zzayy = snapshotmetadatachange;
                zzayC = snapshotcontents;
                super(googleapiclient);
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/SnapshotsImpl$6

/* anonymous class */
    class _cls6 extends LoadImpl
    {

        final String zzXY;
        final boolean zzawR;
        final String zzawT;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
            throws RemoteException
        {
            zza((GamesClientImpl)zzb);
        }

        protected void zza(GamesClientImpl gamesclientimpl)
            throws RemoteException
        {
            gamesclientimpl.zzc(this, zzXY, zzawT, zzawR);
        }
    }

}
