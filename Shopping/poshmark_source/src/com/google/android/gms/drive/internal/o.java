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
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

// Referenced classes of package com.google.android.gms.drive.internal:
//            r, m, n, OpenContentsRequest, 
//            u, c, OnContentsResponse, OnDownloadProgressResponse, 
//            CloseContentsRequest, ak, CloseContentsAndUpdateMetadataRequest

public class o extends r
    implements DriveFile
{
    private abstract class a extends m
    {

        final o DJ;

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        private a()
        {
            DJ = o.this;
            super();
        }

    }

    private abstract class b extends m
    {

        final o DJ;

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        private b()
        {
            DJ = o.this;
            super();
        }

    }

    private static class c extends com.google.android.gms.drive.internal.c
    {

        private final com.google.android.gms.drive.DriveFile.DownloadProgressListener DL;
        private final com.google.android.gms.common.api.a.c vj;

        public void a(OnContentsResponse oncontentsresponse)
            throws RemoteException
        {
            vj.b(new l.a(Status.zQ, oncontentsresponse.eX()));
        }

        public void a(OnDownloadProgressResponse ondownloadprogressresponse)
            throws RemoteException
        {
            if (DL != null)
            {
                DL.onProgress(ondownloadprogressresponse.eY(), ondownloadprogressresponse.eZ());
            }
        }

        public void l(Status status)
            throws RemoteException
        {
            vj.b(new l.a(status, null));
        }

        public c(com.google.android.gms.common.api.a.c c1, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
        {
            vj = c1;
            DL = downloadprogresslistener;
        }
    }

    private abstract class d extends m
    {

        final o DJ;

        public Result d(Status status)
        {
            return n(status);
        }

        public com.google.android.gms.drive.DriveApi.ContentsResult n(Status status)
        {
            return new l.a(status, null);
        }

        private d()
        {
            DJ = o.this;
            super();
        }

    }


    public o(DriveId driveid)
    {
        super(driveid);
    }

    public PendingResult commitAndCloseContents(GoogleApiClient googleapiclient, Contents contents)
    {
        if (contents == null)
        {
            throw new IllegalArgumentException("Contents must be provided.");
        } else
        {
            return googleapiclient.b(new b(contents) {

                final o DJ;
                final Contents Dw;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    throws RemoteException
                {
                    a((n)a1);
                }

                protected void a(n n1)
                    throws RemoteException
                {
                    Dw.close();
                    n1.eT().a(new CloseContentsRequest(Dw, true), new ak(this));
                }

            
            {
                DJ = o.this;
                Dw = contents;
                super();
            }
            });
        }
    }

    public PendingResult commitAndCloseContents(GoogleApiClient googleapiclient, Contents contents, MetadataChangeSet metadatachangeset)
    {
        if (contents == null)
        {
            throw new IllegalArgumentException("Contents must be provided.");
        } else
        {
            return googleapiclient.b(new a(contents, metadatachangeset) {

                final o DJ;
                final MetadataChangeSet DK;
                final Contents Dw;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    throws RemoteException
                {
                    a((n)a1);
                }

                protected void a(n n1)
                    throws RemoteException
                {
                    Dw.close();
                    n1.eT().a(new CloseContentsAndUpdateMetadataRequest(DJ.CS, DK.eS(), Dw), new ak(this));
                }

            
            {
                DJ = o.this;
                Dw = contents;
                DK = metadatachangeset;
                super();
            }
            });
        }
    }

    public PendingResult discardContents(GoogleApiClient googleapiclient, Contents contents)
    {
        return Drive.DriveApi.discardContents(googleapiclient, contents);
    }

    public PendingResult openContents(GoogleApiClient googleapiclient, int i, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
    {
        if (i != 0x10000000 && i != 0x20000000 && i != 0x30000000)
        {
            throw new IllegalArgumentException("Invalid mode provided.");
        } else
        {
            return googleapiclient.a(new d(i, downloadprogresslistener) {

                final int DH;
                final com.google.android.gms.drive.DriveFile.DownloadProgressListener DI;
                final o DJ;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    throws RemoteException
                {
                    a((n)a1);
                }

                protected void a(n n1)
                    throws RemoteException
                {
                    n1.eT().a(new OpenContentsRequest(DJ.getDriveId(), DH), new c(this, DI));
                }

            
            {
                DJ = o.this;
                DH = i;
                DI = downloadprogresslistener;
                super();
            }
            });
        }
    }
}
