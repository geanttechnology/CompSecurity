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
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

// Referenced classes of package com.google.android.gms.drive.internal:
//            m, h, a, k, 
//            OnDriveIdResponse, i, j, CreateFileRequest, 
//            o, CreateFolderRequest

public class l extends m
    implements DriveFolder
{
    private static class a extends com.google.android.gms.drive.internal.a
    {

        private final com.google.android.gms.common.api.a.c jW;

        public void a(OnDriveIdResponse ondriveidresponse)
            throws RemoteException
        {
            jW.a(new d(Status.nA, new k(ondriveidresponse.getDriveId())));
        }

        public void m(Status status)
            throws RemoteException
        {
            jW.a(new d(status, null));
        }

        public a(com.google.android.gms.common.api.a.c c1)
        {
            jW = c1;
        }
    }

    private static class b extends com.google.android.gms.drive.internal.a
    {

        private final com.google.android.gms.common.api.a.c jW;

        public void a(OnDriveIdResponse ondriveidresponse)
            throws RemoteException
        {
            jW.a(new e(Status.nA, new l(ondriveidresponse.getDriveId())));
        }

        public void m(Status status)
            throws RemoteException
        {
            jW.a(new e(status, null));
        }

        public b(com.google.android.gms.common.api.a.c c1)
        {
            jW = c1;
        }
    }

    private abstract class c extends i
    {

        final l rm;

        public Result e(Status status)
        {
            return r(status);
        }

        public com.google.android.gms.drive.DriveFolder.DriveFolderResult r(Status status)
        {
            return new e(status, null);
        }

        private c()
        {
            rm = l.this;
            super();
        }

    }

    private static class d
        implements com.google.android.gms.drive.DriveFolder.DriveFileResult
    {

        private final Status jY;
        private final DriveFile rn;

        public DriveFile getDriveFile()
        {
            return rn;
        }

        public Status getStatus()
        {
            return jY;
        }

        public d(Status status, DriveFile drivefile)
        {
            jY = status;
            rn = drivefile;
        }
    }

    private static class e
        implements com.google.android.gms.drive.DriveFolder.DriveFolderResult
    {

        private final Status jY;
        private final DriveFolder ro;

        public DriveFolder getDriveFolder()
        {
            return ro;
        }

        public Status getStatus()
        {
            return jY;
        }

        public e(Status status, DriveFolder drivefolder)
        {
            jY = status;
            ro = drivefolder;
        }
    }


    public l(DriveId driveid)
    {
        super(driveid);
    }

    public PendingResult createFile(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset, Contents contents)
    {
        if (metadatachangeset == null)
        {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        }
        if (contents == null)
        {
            throw new IllegalArgumentException("Contents must be provided.");
        }
        if ("application/vnd.google-apps.folder".equals(metadatachangeset.getMimeType()))
        {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        } else
        {
            return googleapiclient.b(new i(contents, metadatachangeset) {

                final Contents rd;
                final MetadataChangeSet rl;
                final l rm;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((j)a1);
                }

                protected void a(j j1)
                {
                    try
                    {
                        rd.close();
                        j1.cN().a(new CreateFileRequest(rm.getDriveId(), rl.cM(), rd), new a(this));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (j j1)
                    {
                        a(((Result) (new d(new Status(8, j1.getLocalizedMessage(), null), null))));
                    }
                }

                public Result e(Status status)
                {
                    return q(status);
                }

                public com.google.android.gms.drive.DriveFolder.DriveFileResult q(Status status)
                {
                    return new d(status, null);
                }

            
            {
                rm = l.this;
                rd = contents;
                rl = metadatachangeset;
                super();
            }
            });
        }
    }

    public PendingResult createFolder(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset)
    {
        if (metadatachangeset == null)
        {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        }
        if (metadatachangeset.getMimeType() != null && !metadatachangeset.getMimeType().equals("application/vnd.google-apps.folder"))
        {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        } else
        {
            return googleapiclient.b(new c(metadatachangeset) {

                final MetadataChangeSet rl;
                final l rm;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((j)a1);
                }

                protected void a(j j1)
                {
                    try
                    {
                        j1.cN().a(new CreateFolderRequest(rm.getDriveId(), rl.cM()), new b(this));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (j j1)
                    {
                        a(((Result) (new e(new Status(8, j1.getLocalizedMessage(), null), null))));
                    }
                }

            
            {
                rm = l.this;
                rl = metadatachangeset;
                super();
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
        com.google.android.gms.drive.query.Query.Builder builder = (new com.google.android.gms.drive.query.Query.Builder()).addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null)
        {
            if (query.getFilter() != null)
            {
                builder.addFilter(query.getFilter());
            }
            builder.setPageToken(query.getPageToken());
        }
        return (new h()).query(googleapiclient, builder.build());
    }
}
