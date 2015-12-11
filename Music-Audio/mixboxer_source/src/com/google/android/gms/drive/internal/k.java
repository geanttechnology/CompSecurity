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

// Referenced classes of package com.google.android.gms.drive.internal:
//            m, i, j, OpenContentsRequest, 
//            o, a, OnContentsResponse, OnDownloadProgressResponse, 
//            CloseContentsRequest, z

public class k extends m
    implements DriveFile
{
    private abstract class a extends i
    {

        final k rj;

        public Result e(Status status)
        {
            return g(status);
        }

        public Status g(Status status)
        {
            return status;
        }

        private a()
        {
            rj = k.this;
            super();
        }

    }

    private static class b extends com.google.android.gms.drive.internal.a
    {

        private final com.google.android.gms.common.api.a.c jW;
        private final com.google.android.gms.drive.DriveFile.DownloadProgressListener rk;

        public void a(OnContentsResponse oncontentsresponse)
            throws RemoteException
        {
            jW.a(new h.a(Status.nA, oncontentsresponse.cQ()));
        }

        public void a(OnDownloadProgressResponse ondownloadprogressresponse)
            throws RemoteException
        {
            if (rk != null)
            {
                rk.onProgress(ondownloadprogressresponse.cR(), ondownloadprogressresponse.cS());
            }
        }

        public void m(Status status)
            throws RemoteException
        {
            jW.a(new h.a(status, null));
        }

        public b(com.google.android.gms.common.api.a.c c1, com.google.android.gms.drive.DriveFile.DownloadProgressListener downloadprogresslistener)
        {
            jW = c1;
            rk = downloadprogresslistener;
        }
    }

    private abstract class c extends i
    {

        final k rj;

        public Result e(Status status)
        {
            return o(status);
        }

        public com.google.android.gms.drive.DriveApi.ContentsResult o(Status status)
        {
            return new h.a(status, null);
        }

        private c()
        {
            rj = k.this;
            super();
        }

    }


    public k(DriveId driveid)
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
            return googleapiclient.b(new a(contents) {

                final Contents rd;
                final k rj;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((j)a1);
                }

                protected void a(j j1)
                {
                    try
                    {
                        rd.close();
                        j1.cN().a(new CloseContentsRequest(rd, true), new z(this));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (j j1)
                    {
                        a(((Result) (new Status(8, j1.getLocalizedMessage(), null))));
                    }
                }

            
            {
                rj = k.this;
                rd = contents;
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
            return googleapiclient.a(new c(i, downloadprogresslistener) {

                final int rh;
                final com.google.android.gms.drive.DriveFile.DownloadProgressListener ri;
                final k rj;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((j)a1);
                }

                protected void a(j j1)
                {
                    try
                    {
                        j1.cN().a(new OpenContentsRequest(rj.getDriveId(), rh), new b(this, ri));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (j j1)
                    {
                        a(((Result) (new h.a(new Status(8, j1.getLocalizedMessage(), null), null))));
                    }
                }

            
            {
                rj = k.this;
                rh = i;
                ri = downloadprogresslistener;
                super();
            }
            });
        }
    }
}
