// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzu, zzd, OnListParentsResponse, zzp, 
//            OnMetadataResponse, zzt, GetMetadataRequest, zzam, 
//            ListParentsRequest, SetResourceParentsRequest, zzbt, UpdateMetadataRequest, 
//            DeleteResourceRequest, TrashResourceRequest, UntrashResourceRequest

public class zzab
    implements DriveResource
{
    private static class zza extends com.google.android.gms.drive.internal.zzd
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zza(OnListParentsResponse onlistparentsresponse)
            throws RemoteException
        {
            onlistparentsresponse = new MetadataBuffer(onlistparentsresponse.zzrD());
            zzagy.zzp(new zzs.zzf(Status.zzabb, onlistparentsresponse, false));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzagy.zzp(new zzs.zzf(status, null, false));
        }

        public zza(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = zzb1;
        }
    }

    private static class zzb extends com.google.android.gms.drive.internal.zzd
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zza(OnMetadataResponse onmetadataresponse)
            throws RemoteException
        {
            zzagy.zzp(new zzc(Status.zzabb, new zzp(onmetadataresponse.zzrE())));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzagy.zzp(new zzc(status, null));
        }

        public zzb(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = zzb1;
        }
    }

    private static class zzc
        implements com.google.android.gms.drive.DriveResource.MetadataResult
    {

        private final Status zzSC;
        private final Metadata zzalr;

        public Metadata getMetadata()
        {
            return zzalr;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        public zzc(Status status, Metadata metadata)
        {
            zzSC = status;
            zzalr = metadata;
        }
    }

    private abstract class zzd extends zzt
    {

        final zzab zzalp;

        public com.google.android.gms.drive.DriveResource.MetadataResult zzG(Status status)
        {
            return new zzc(status, null);
        }

        public Result zzb(Status status)
        {
            return zzG(status);
        }

        private zzd(GoogleApiClient googleapiclient)
        {
            zzalp = zzab.this;
            super(googleapiclient);
        }

    }


    protected final DriveId zzaiA;

    public zzab(DriveId driveid)
    {
        zzaiA = driveid;
    }

    private PendingResult zza(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new zzd(googleapiclient, flag) {

            final boolean zzalo;
            final zzab zzalp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new GetMetadataRequest(zzalp.zzaiA, zzalo), new zzb(this));
            }

            
            {
                zzalp = zzab.this;
                zzalo = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult addChangeListener(GoogleApiClient googleapiclient, ChangeListener changelistener)
    {
        return ((zzu)googleapiclient.zza(Drive.zzRk)).zza(googleapiclient, zzaiA, changelistener);
    }

    public PendingResult addChangeSubscription(GoogleApiClient googleapiclient)
    {
        return ((zzu)googleapiclient.zza(Drive.zzRk)).zza(googleapiclient, zzaiA);
    }

    public PendingResult delete(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzt.zza(googleapiclient) {

            final zzab zzalp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new DeleteResourceRequest(zzalp.zzaiA), new zzbt(this));
            }

            
            {
                zzalp = zzab.this;
                super(googleapiclient);
            }
        });
    }

    public DriveId getDriveId()
    {
        return zzaiA;
    }

    public PendingResult getMetadata(GoogleApiClient googleapiclient)
    {
        return zza(googleapiclient, false);
    }

    public PendingResult listParents(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzs.zzg(googleapiclient) {

            final zzab zzalp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new ListParentsRequest(zzalp.zzaiA), new zza(this));
            }

            
            {
                zzalp = zzab.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult removeChangeListener(GoogleApiClient googleapiclient, ChangeListener changelistener)
    {
        return ((zzu)googleapiclient.zza(Drive.zzRk)).zzb(googleapiclient, zzaiA, changelistener);
    }

    public PendingResult removeChangeSubscription(GoogleApiClient googleapiclient)
    {
        return ((zzu)googleapiclient.zza(Drive.zzRk)).zzb(googleapiclient, zzaiA);
    }

    public PendingResult setParents(GoogleApiClient googleapiclient, Set set)
    {
        if (set == null)
        {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else
        {
            return googleapiclient.zzb(new zzt.zza(googleapiclient, new ArrayList(set)) {

                final zzab zzalp;
                final List zzalq;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzu)zzb1);
                }

                protected void zza(zzu zzu1)
                    throws RemoteException
                {
                    zzu1.zzrm().zza(new SetResourceParentsRequest(zzalp.zzaiA, zzalq), new zzbt(this));
                }

            
            {
                zzalp = zzab.this;
                zzalq = list;
                super(googleapiclient);
            }
            });
        }
    }

    public PendingResult trash(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzt.zza(googleapiclient) {

            final zzab zzalp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new TrashResourceRequest(zzalp.zzaiA), new zzbt(this));
            }

            
            {
                zzalp = zzab.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult untrash(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzt.zza(googleapiclient) {

            final zzab zzalp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new UntrashResourceRequest(zzalp.zzaiA), new zzbt(this));
            }

            
            {
                zzalp = zzab.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult updateMetadata(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset)
    {
        if (metadatachangeset == null)
        {
            throw new IllegalArgumentException("ChangeSet must be provided.");
        } else
        {
            return googleapiclient.zzb(new zzd(googleapiclient, metadatachangeset) {

                final MetadataChangeSet zzald;
                final zzab zzalp;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzu)zzb1);
                }

                protected void zza(zzu zzu1)
                    throws RemoteException
                {
                    zzald.zzqW().setContext(zzu1.getContext());
                    zzu1.zzrm().zza(new UpdateMetadataRequest(zzalp.zzaiA, zzald.zzqW()), new zzb(this));
                }

            
            {
                zzalp = zzab.this;
                zzald = metadatachangeset;
                super(googleapiclient);
            }
            });
        }
    }
}
