// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzab, zzv, zzs, zzd, 
//            zzw, OnDriveIdResponse, zzt, zzu, 
//            CreateFileRequest, zzam, CreateFolderRequest

public class zzy extends zzab
    implements DriveFolder
{
    private static class zza extends com.google.android.gms.drive.internal.zzd
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zza(OnDriveIdResponse ondriveidresponse)
            throws RemoteException
        {
            zzagy.zzp(new zzc(Status.zzabb, new zzw(ondriveidresponse.getDriveId())));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzagy.zzp(new zzc(status, null));
        }

        public zza(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = zzb1;
        }
    }

    private static class zzb extends com.google.android.gms.drive.internal.zzd
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zza(OnDriveIdResponse ondriveidresponse)
            throws RemoteException
        {
            zzagy.zzp(new zze(Status.zzabb, new zzy(ondriveidresponse.getDriveId())));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzagy.zzp(new zze(status, null));
        }

        public zzb(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = zzb1;
        }
    }

    private static class zzc
        implements com.google.android.gms.drive.DriveFolder.DriveFileResult
    {

        private final Status zzSC;
        private final DriveFile zzali;

        public DriveFile getDriveFile()
        {
            return zzali;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        public zzc(Status status, DriveFile drivefile)
        {
            zzSC = status;
            zzali = drivefile;
        }
    }

    static abstract class zzd extends zzt
    {

        public com.google.android.gms.drive.DriveFolder.DriveFileResult zzD(Status status)
        {
            return new zzc(status, null);
        }

        public Result zzb(Status status)
        {
            return zzD(status);
        }

        zzd(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static class zze
        implements com.google.android.gms.drive.DriveFolder.DriveFolderResult
    {

        private final Status zzSC;
        private final DriveFolder zzalj;

        public DriveFolder getDriveFolder()
        {
            return zzalj;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        public zze(Status status, DriveFolder drivefolder)
        {
            zzSC = status;
            zzalj = drivefolder;
        }
    }

    static abstract class zzf extends zzt
    {

        public com.google.android.gms.drive.DriveFolder.DriveFolderResult zzE(Status status)
        {
            return new zze(status, null);
        }

        public Result zzb(Status status)
        {
            return zzE(status);
        }

        zzf(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public zzy(DriveId driveid)
    {
        super(driveid);
    }

    private PendingResult zza(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset, int i, int j, ExecutionOptions executionoptions)
    {
        ExecutionOptions.zza(googleapiclient, executionoptions);
        return googleapiclient.zzb(new zzd(googleapiclient, metadatachangeset, i, j, executionoptions) {

            final MetadataChangeSet zzald;
            final int zzale;
            final int zzalf;
            final ExecutionOptions zzalg;
            final zzy zzalh;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzald.zzqW().setContext(zzu1.getContext());
                CreateFileRequest createfilerequest = new CreateFileRequest(zzalh.getDriveId(), zzald.zzqW(), zzale, zzalf, zzalg);
                zzu1.zzrm().zza(createfilerequest, new zza(this));
            }

            
            {
                zzalh = zzy.this;
                zzald = metadatachangeset;
                zzale = i;
                zzalf = j;
                zzalg = executionoptions;
                super(googleapiclient);
            }
        });
    }

    private PendingResult zza(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset, DriveContents drivecontents, ExecutionOptions executionoptions)
    {
        int i;
        if (drivecontents != null)
        {
            if (!(drivecontents instanceof zzv))
            {
                throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
            }
            if (drivecontents.getDriveId() != null)
            {
                throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
            }
            if (drivecontents.zzqQ())
            {
                throw new IllegalArgumentException("DriveContents are already closed.");
            }
            i = drivecontents.zzqO().getRequestId();
            drivecontents.zzqP();
        } else
        {
            i = 1;
        }
        if (metadatachangeset == null)
        {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        if ("application/vnd.google-apps.folder".equals(metadatachangeset.getMimeType()))
        {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        } else
        {
            return zza(googleapiclient, metadatachangeset, i, 0, executionoptions);
        }
    }

    private Query zza(Query query)
    {
        com.google.android.gms.drive.query.Query.Builder builder = (new com.google.android.gms.drive.query.Query.Builder()).addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null)
        {
            if (query.getFilter() != null)
            {
                builder.addFilter(query.getFilter());
            }
            builder.setPageToken(query.getPageToken());
            builder.setSortOrder(query.getSortOrder());
        }
        return builder.build();
    }

    public PendingResult createFile(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset, DriveContents drivecontents)
    {
        return createFile(googleapiclient, metadatachangeset, drivecontents, null);
    }

    public PendingResult createFile(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset, DriveContents drivecontents, ExecutionOptions executionoptions)
    {
        ExecutionOptions executionoptions1 = executionoptions;
        if (executionoptions == null)
        {
            executionoptions1 = (new com.google.android.gms.drive.ExecutionOptions.Builder()).build();
        }
        if (executionoptions1.zzqU() != 0)
        {
            throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
        } else
        {
            return zza(googleapiclient, metadatachangeset, drivecontents, executionoptions1);
        }
    }

    public PendingResult createFolder(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset)
    {
        if (metadatachangeset == null)
        {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        }
        if (metadatachangeset.getMimeType() != null && !metadatachangeset.getMimeType().equals("application/vnd.google-apps.folder"))
        {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        } else
        {
            return googleapiclient.zzb(new zzf(googleapiclient, metadatachangeset) {

                final MetadataChangeSet zzald;
                final zzy zzalh;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzu)zzb1);
                }

                protected void zza(zzu zzu1)
                    throws RemoteException
                {
                    zzald.zzqW().setContext(zzu1.getContext());
                    zzu1.zzrm().zza(new CreateFolderRequest(zzalh.getDriveId(), zzald.zzqW()), new zzb(this));
                }

            
            {
                zzalh = zzy.this;
                zzald = metadatachangeset;
                super(googleapiclient);
            }
            });
        }
    }

    public PendingResult listChildren(GoogleApiClient googleapiclient)
    {
        return queryChildren(googleapiclient, null);
    }

    public PendingResult queryChildren(GoogleApiClient googleapiclient, Query query)
    {
        return (new zzs()).query(googleapiclient, zza(query));
    }
}
