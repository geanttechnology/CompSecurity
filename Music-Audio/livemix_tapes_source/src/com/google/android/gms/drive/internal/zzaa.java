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
//            zzt, zzd, OnListParentsResponse, zzo, 
//            OnMetadataResponse, zzs, GetMetadataRequest, zzal, 
//            ListParentsRequest, SetResourceParentsRequest, zzbr, UpdateMetadataRequest, 
//            DeleteResourceRequest, TrashResourceRequest, UntrashResourceRequest

public class zzaa
    implements DriveResource
{
    private static class zza extends com.google.android.gms.drive.internal.zzd
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(OnListParentsResponse onlistparentsresponse)
            throws RemoteException
        {
            onlistparentsresponse = new MetadataBuffer(onlistparentsresponse.zzqV());
            zzQz.zzn(new zzr.zzf(Status.zzaaD, onlistparentsresponse, false));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzQz.zzn(new zzr.zzf(status, null, false));
        }

        public zza(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = zzb1;
        }
    }

    private static class zzb extends com.google.android.gms.drive.internal.zzd
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(OnMetadataResponse onmetadataresponse)
            throws RemoteException
        {
            zzQz.zzn(new zzc(Status.zzaaD, new zzo(onmetadataresponse.zzqW())));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzQz.zzn(new zzc(status, null));
        }

        public zzb(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = zzb1;
        }
    }

    private static class zzc
        implements com.google.android.gms.drive.DriveResource.MetadataResult
    {

        private final Status zzQA;
        private final Metadata zzajd;

        public Metadata getMetadata()
        {
            return zzajd;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public zzc(Status status, Metadata metadata)
        {
            zzQA = status;
            zzajd = metadata;
        }
    }

    private abstract class zzd extends zzs
    {

        final zzaa zzajb;

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
            zzajb = zzaa.this;
            super(googleapiclient);
        }

    }


    protected final DriveId zzags;

    protected zzaa(DriveId driveid)
    {
        zzags = driveid;
    }

    private PendingResult zza(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zza(new zzd(googleapiclient, flag) {

            final boolean zzaja;
            final zzaa zzajb;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new GetMetadataRequest(zzajb.zzags, zzaja), new zzb(this));
            }

            
            {
                zzajb = zzaa.this;
                zzaja = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult addChangeListener(GoogleApiClient googleapiclient, ChangeListener changelistener)
    {
        return ((zzt)googleapiclient.zza(Drive.zzQf)).zza(googleapiclient, zzags, changelistener);
    }

    public PendingResult addChangeSubscription(GoogleApiClient googleapiclient)
    {
        return ((zzt)googleapiclient.zza(Drive.zzQf)).zza(googleapiclient, zzags);
    }

    public PendingResult delete(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzs.zza(googleapiclient) {

            final zzaa zzajb;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new DeleteResourceRequest(zzajb.zzags), new zzbr(this));
            }

            
            {
                zzajb = zzaa.this;
                super(googleapiclient);
            }
        });
    }

    public DriveId getDriveId()
    {
        return zzags;
    }

    public PendingResult getMetadata(GoogleApiClient googleapiclient)
    {
        return zza(googleapiclient, false);
    }

    public PendingResult listParents(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzr.zzg(googleapiclient) {

            final zzaa zzajb;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new ListParentsRequest(zzajb.zzags), new zza(this));
            }

            
            {
                zzajb = zzaa.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult removeChangeListener(GoogleApiClient googleapiclient, ChangeListener changelistener)
    {
        return ((zzt)googleapiclient.zza(Drive.zzQf)).zzb(googleapiclient, zzags, changelistener);
    }

    public PendingResult removeChangeSubscription(GoogleApiClient googleapiclient)
    {
        return ((zzt)googleapiclient.zza(Drive.zzQf)).zzb(googleapiclient, zzags);
    }

    public PendingResult setParents(GoogleApiClient googleapiclient, Set set)
    {
        if (set == null)
        {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else
        {
            return googleapiclient.zzb(new zzs.zza(googleapiclient, new ArrayList(set)) {

                final zzaa zzajb;
                final List zzajc;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzt)zzb1);
                }

                protected void zza(zzt zzt1)
                    throws RemoteException
                {
                    zzt1.zzqF().zza(new SetResourceParentsRequest(zzajb.zzags, zzajc), new zzbr(this));
                }

            
            {
                zzajb = zzaa.this;
                zzajc = list;
                super(googleapiclient);
            }
            });
        }
    }

    public PendingResult trash(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzs.zza(googleapiclient) {

            final zzaa zzajb;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new TrashResourceRequest(zzajb.zzags), new zzbr(this));
            }

            
            {
                zzajb = zzaa.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult untrash(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzs.zza(googleapiclient) {

            final zzaa zzajb;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new UntrashResourceRequest(zzajb.zzags), new zzbr(this));
            }

            
            {
                zzajb = zzaa.this;
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

                final MetadataChangeSet zzaiP;
                final zzaa zzajb;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzt)zzb1);
                }

                protected void zza(zzt zzt1)
                    throws RemoteException
                {
                    zzaiP.zzqp().setContext(zzt1.getContext());
                    zzt1.zzqF().zza(new UpdateMetadataRequest(zzajb.zzags, zzaiP.zzqp()), new zzb(this));
                }

            
            {
                zzajb = zzaa.this;
                zzaiP = metadatachangeset;
                super(googleapiclient);
            }
            });
        }
    }
}
