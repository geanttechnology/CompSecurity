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
//            zzu, zzy, zzw, zzt, 
//            zzd, OnDriveIdResponse, zzp, OnMetadataResponse, 
//            zzv, OnContentsResponse, OnListEntriesResponse, QueryRequest, 
//            zzam, CreateContentsRequest, GetMetadataRequest, zzbt

public class zzs
    implements DriveApi
{
    static class zza
        implements Releasable, com.google.android.gms.drive.DriveApi.DriveContentsResult
    {

        private final Status zzSC;
        private final DriveContents zzaiD;

        public DriveContents getDriveContents()
        {
            return zzaiD;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        public void release()
        {
            if (zzaiD != null)
            {
                zzaiD.zzqP();
            }
        }

        public zza(Status status, DriveContents drivecontents)
        {
            zzSC = status;
            zzaiD = drivecontents;
        }
    }

    static abstract class zzb extends zzt
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

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zza(OnDriveIdResponse ondriveidresponse)
            throws RemoteException
        {
            zzagy.zzp(new zzd(Status.zzabb, ondriveidresponse.getDriveId()));
        }

        public void zza(OnMetadataResponse onmetadataresponse)
            throws RemoteException
        {
            zzagy.zzp(new zzd(Status.zzabb, (new zzp(onmetadataresponse.zzrE())).getDriveId()));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzagy.zzp(new zzd(status, null));
        }

        public zzc(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = zzb1;
        }
    }

    private static class zzd
        implements com.google.android.gms.drive.DriveApi.DriveIdResult
    {

        private final Status zzSC;
        private final DriveId zzaiA;

        public DriveId getDriveId()
        {
            return zzaiA;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        public zzd(Status status, DriveId driveid)
        {
            zzSC = status;
            zzaiA = driveid;
        }
    }

    static abstract class zze extends zzt
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

        private final Status zzSC;
        private final MetadataBuffer zzakA;
        private final boolean zzakB;

        public MetadataBuffer getMetadataBuffer()
        {
            return zzakA;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        public void release()
        {
            if (zzakA != null)
            {
                zzakA.release();
            }
        }

        public zzf(Status status, MetadataBuffer metadatabuffer, boolean flag)
        {
            zzSC = status;
            zzakA = metadatabuffer;
            zzakB = flag;
        }
    }

    static abstract class zzg extends zzt
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

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zza(OnContentsResponse oncontentsresponse)
            throws RemoteException
        {
            zzagy.zzp(new zza(Status.zzabb, new zzv(oncontentsresponse.zzrv())));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzagy.zzp(new zza(status, null));
        }

        public zzh(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = zzb1;
        }
    }

    private static class zzi extends com.google.android.gms.drive.internal.zzd
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zza(OnListEntriesResponse onlistentriesresponse)
            throws RemoteException
        {
            MetadataBuffer metadatabuffer = new MetadataBuffer(onlistentriesresponse.zzrB());
            zzagy.zzp(new zzf(Status.zzabb, metadatabuffer, onlistentriesresponse.zzrC()));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzagy.zzp(new zzf(status, null, false));
        }

        public zzi(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = zzb1;
        }
    }

    static class zzj extends zzt.zza
    {

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzu)zzb1);
        }

        protected void zza(zzu zzu1)
        {
        }

        zzj(GoogleApiClient googleapiclient, Status status)
        {
            super(googleapiclient);
            zzb(status);
        }
    }


    public zzs()
    {
    }

    public PendingResult cancelPendingActions(GoogleApiClient googleapiclient, List list)
    {
        return ((zzu)googleapiclient.zza(Drive.zzRk)).cancelPendingActions(googleapiclient, list);
    }

    public PendingResult fetchDriveId(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zze(googleapiclient, s) {

            final zzs zzakv;
            final String zzakx;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new GetMetadataRequest(DriveId.zzcB(zzakx), false), new zzc(this));
            }

            
            {
                zzakv = zzs.this;
                zzakx = s;
                super(googleapiclient);
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient googleapiclient)
    {
        googleapiclient = (zzu)googleapiclient.zza(Drive.zzRk);
        if (!googleapiclient.zzrp())
        {
            throw new IllegalStateException("Client is not yet connected");
        }
        googleapiclient = googleapiclient.zzro();
        if (googleapiclient != null)
        {
            return new zzy(googleapiclient);
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
            return new zzw(driveid);
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
            return new zzy(driveid);
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient googleapiclient)
    {
        googleapiclient = (zzu)googleapiclient.zza(Drive.zzRk);
        if (!googleapiclient.zzrp())
        {
            throw new IllegalStateException("Client is not yet connected");
        } else
        {
            return new zzy(googleapiclient.zzrn());
        }
    }

    public PendingResult isAutobackupEnabled(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzt(googleapiclient) {

            final zzs zzakv;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zze(new com.google.android.gms.drive.internal.zzd(this, this) {

                    final zzt zzaky;
                    final _cls5 zzakz;

                    public void zzab(boolean flag)
                    {
                        zzaky.zzb(new BooleanResult(Status.zzabb, flag));
                    }

            
            {
                zzakz = _pcls5;
                zzaky = zzt1;
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
                zzakv = zzs.this;
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

                final Query zzaku;
                final zzs zzakv;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzu)zzb1);
                }

                protected void zza(zzu zzu1)
                    throws RemoteException
                {
                    zzu1.zzrm().zza(new QueryRequest(zzaku), new zzi(this));
                }

            
            {
                zzakv = zzs.this;
                zzaku = query1;
                super(googleapiclient);
            }
            });
        }
    }

    public PendingResult requestSync(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzt.zza(googleapiclient) {

            final zzs zzakv;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new zzbt(this));
            }

            
            {
                zzakv = zzs.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult zza(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zza(new zzb(googleapiclient, i) {

            final zzs zzakv;
            final int zzakw;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zza(new CreateContentsRequest(zzakw), new zzh(this));
            }

            
            {
                zzakv = zzs.this;
                zzakw = i;
                super(googleapiclient);
            }
        });
    }
}
