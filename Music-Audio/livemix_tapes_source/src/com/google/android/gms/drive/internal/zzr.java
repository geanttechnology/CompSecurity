// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzt, zzx, zzv, zzs, 
//            zzd, OnDriveIdResponse, zzo, OnMetadataResponse, 
//            zzu, OnContentsResponse, OnListEntriesResponse, QueryRequest, 
//            zzal, CreateContentsRequest, GetMetadataRequest, zzbr

public class zzr
    implements DriveApi
{
    static class zza
        implements Releasable, com.google.android.gms.drive.DriveApi.DriveContentsResult
    {

        private final Status zzQA;
        private final DriveContents zzagv;

        public DriveContents getDriveContents()
        {
            return zzagv;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public void release()
        {
            if (zzagv != null)
            {
                zzagv.zzqi();
            }
        }

        public zza(Status status, DriveContents drivecontents)
        {
            zzQA = status;
            zzagv = drivecontents;
        }
    }

    static abstract class zzb extends zzs
    {

        public com.google.android.gms.drive.DriveApi.DriveContentsResult zzA(Status status)
        {
            return new zza(status, null);
        }

        public Result zzb(Status status)
        {
            return zzA(status);
        }

        zzb(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    static class zzc extends com.google.android.gms.drive.internal.zzd
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(OnDriveIdResponse ondriveidresponse)
            throws RemoteException
        {
            zzQz.zzn(new zzd(Status.zzaaD, ondriveidresponse.getDriveId()));
        }

        public void zza(OnMetadataResponse onmetadataresponse)
            throws RemoteException
        {
            zzQz.zzn(new zzd(Status.zzaaD, (new zzo(onmetadataresponse.zzqW())).getDriveId()));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzQz.zzn(new zzd(status, null));
        }

        public zzc(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = zzb1;
        }
    }

    private static class zzd
        implements com.google.android.gms.drive.DriveApi.DriveIdResult
    {

        private final Status zzQA;
        private final DriveId zzags;

        public DriveId getDriveId()
        {
            return zzags;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public zzd(Status status, DriveId driveid)
        {
            zzQA = status;
            zzags = driveid;
        }
    }

    static abstract class zze extends zzs
    {

        public com.google.android.gms.drive.DriveApi.DriveIdResult zzB(Status status)
        {
            return new zzd(status, null);
        }

        public Result zzb(Status status)
        {
            return zzB(status);
        }

        zze(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    static class zzf
        implements com.google.android.gms.drive.DriveApi.MetadataBufferResult
    {

        private final Status zzQA;
        private final MetadataBuffer zzain;
        private final boolean zzaio;

        public MetadataBuffer getMetadataBuffer()
        {
            return zzain;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public void release()
        {
            if (zzain != null)
            {
                zzain.release();
            }
        }

        public zzf(Status status, MetadataBuffer metadatabuffer, boolean flag)
        {
            zzQA = status;
            zzain = metadatabuffer;
            zzaio = flag;
        }
    }

    static abstract class zzg extends zzs
    {

        public com.google.android.gms.drive.DriveApi.MetadataBufferResult zzC(Status status)
        {
            return new zzf(status, null, false);
        }

        public Result zzb(Status status)
        {
            return zzC(status);
        }

        zzg(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static class zzh extends com.google.android.gms.drive.internal.zzd
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(OnContentsResponse oncontentsresponse)
            throws RemoteException
        {
            zzQz.zzn(new zza(Status.zzaaD, new zzu(oncontentsresponse.zzqN())));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzQz.zzn(new zza(status, null));
        }

        public zzh(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = zzb1;
        }
    }

    private static class zzi extends com.google.android.gms.drive.internal.zzd
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(OnListEntriesResponse onlistentriesresponse)
            throws RemoteException
        {
            MetadataBuffer metadatabuffer = new MetadataBuffer(onlistentriesresponse.zzqT());
            zzQz.zzn(new zzf(Status.zzaaD, metadatabuffer, onlistentriesresponse.zzqU()));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzQz.zzn(new zzf(status, null, false));
        }

        public zzi(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = zzb1;
        }
    }

    static class zzj extends zzs.zza
    {

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzt)zzb1);
        }

        protected void zza(zzt zzt1)
        {
        }

        zzj(GoogleApiClient googleapiclient, Status status)
        {
            super(googleapiclient);
            zza(status);
        }
    }


    public zzr()
    {
    }

    public PendingResult cancelPendingActions(GoogleApiClient googleapiclient, List list)
    {
        return ((zzt)googleapiclient.zza(Drive.zzQf)).cancelPendingActions(googleapiclient, list);
    }

    public PendingResult fetchDriveId(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zze(googleapiclient, s) {

            final zzr zzaii;
            final String zzaik;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new GetMetadataRequest(DriveId.zzcC(zzaik), false), new zzc(this));
            }

            
            {
                zzaii = zzr.this;
                zzaik = s;
                super(googleapiclient);
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient googleapiclient)
    {
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        }
        googleapiclient = ((zzt)googleapiclient.zza(Drive.zzQf)).zzqH();
        if (googleapiclient != null)
        {
            return new zzx(googleapiclient);
        } else
        {
            return null;
        }
    }

    public DriveFile getFile(GoogleApiClient googleapiclient, DriveId driveid)
    {
        if (driveid == null)
        {
            throw new IllegalArgumentException("Id must be provided.");
        }
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        } else
        {
            return new zzv(driveid);
        }
    }

    public DriveFolder getFolder(GoogleApiClient googleapiclient, DriveId driveid)
    {
        if (driveid == null)
        {
            throw new IllegalArgumentException("Id must be provided.");
        }
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        } else
        {
            return new zzx(driveid);
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient googleapiclient)
    {
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        } else
        {
            return new zzx(((zzt)googleapiclient.zza(Drive.zzQf)).zzqG());
        }
    }

    public PendingResult isAutobackupEnabled(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzs(googleapiclient) {

            final zzr zzaii;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zze(new com.google.android.gms.drive.internal.zzd(this, this) {

                    final zzs zzail;
                    final _cls5 zzaim;

                    public void zzaa(boolean flag)
                    {
                        zzail.zza(new BooleanResult(Status.zzaaD, flag));
                    }

            
            {
                zzaim = _pcls5;
                zzail = zzs1;
                super();
            }
                });
            }

            protected Result zzb(Status status)
            {
                return zzz(status);
            }

            protected BooleanResult zzz(Status status)
            {
                return new BooleanResult(status, false);
            }

            
            {
                zzaii = zzr.this;
                super(googleapiclient);
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder()
    {
        return new CreateFileActivityBuilder();
    }

    public PendingResult newDriveContents(GoogleApiClient googleapiclient)
    {
        return zza(googleapiclient, 0x20000000);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder()
    {
        return new OpenFileActivityBuilder();
    }

    public PendingResult query(GoogleApiClient googleapiclient, Query query1)
    {
        if (query1 == null)
        {
            throw new IllegalArgumentException("Query must be provided.");
        } else
        {
            return googleapiclient.zza(new zzg(googleapiclient, query1) {

                final Query zzaih;
                final zzr zzaii;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzt)zzb1);
                }

                protected void zza(zzt zzt1)
                    throws RemoteException
                {
                    zzt1.zzqF().zza(new QueryRequest(zzaih), new zzi(this));
                }

            
            {
                zzaii = zzr.this;
                zzaih = query1;
                super(googleapiclient);
            }
            });
        }
    }

    public PendingResult requestSync(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzs.zza(googleapiclient) {

            final zzr zzaii;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new zzbr(this));
            }

            
            {
                zzaii = zzr.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult zza(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zza(new zzb(googleapiclient, i) {

            final zzr zzaii;
            final int zzaij;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zza(new CreateContentsRequest(zzaij), new zzh(this));
            }

            
            {
                zzaii = zzr.this;
                zzaij = i;
                super(googleapiclient);
            }
        });
    }
}
