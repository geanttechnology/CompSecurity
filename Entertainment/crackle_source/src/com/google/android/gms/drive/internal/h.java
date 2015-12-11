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
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

// Referenced classes of package com.google.android.gms.drive.internal:
//            k, l, j, i, 
//            a, g, OnMetadataResponse, OnContentsResponse, 
//            OnListEntriesResponse, QueryRequest, o, CreateContentsRequest, 
//            CloseContentsRequest, z, GetMetadataRequest

public class com.google.android.gms.drive.internal.h
    implements DriveApi
{
    static class a
        implements com.google.android.gms.drive.DriveApi.ContentsResult
    {

        private final Status jY;
        private final Contents qK;

        public Contents getContents()
        {
            return qK;
        }

        public Status getStatus()
        {
            return jY;
        }

        public a(Status status, Contents contents)
        {
            jY = status;
            qK = contents;
        }
    }

    abstract class b extends com.google.android.gms.drive.internal.i
    {

        final com.google.android.gms.drive.internal.h rc;

        public Result e(Status status)
        {
            return g(status);
        }

        public Status g(Status status)
        {
            return status;
        }

        b()
        {
            rc = com.google.android.gms.drive.internal.h.this;
            super();
        }
    }

    private static class c extends com.google.android.gms.drive.internal.a
    {

        private final com.google.android.gms.common.api.a.c jW;

        public void a(OnMetadataResponse onmetadataresponse)
            throws RemoteException
        {
            jW.a(new d(Status.nA, (new com.google.android.gms.drive.internal.g(onmetadataresponse.cU())).getDriveId()));
        }

        public void m(Status status)
            throws RemoteException
        {
            jW.a(new d(status, null));
        }

        public c(com.google.android.gms.common.api.a.c c1)
        {
            jW = c1;
        }
    }

    static class d
        implements com.google.android.gms.drive.DriveApi.DriveIdResult
    {

        private final Status jY;
        private final DriveId qG;

        public DriveId getDriveId()
        {
            return qG;
        }

        public Status getStatus()
        {
            return jY;
        }

        public d(Status status, DriveId driveid)
        {
            jY = status;
            qG = driveid;
        }
    }

    abstract class e extends com.google.android.gms.drive.internal.i
    {

        final com.google.android.gms.drive.internal.h rc;

        public Result e(Status status)
        {
            return n(status);
        }

        public com.google.android.gms.drive.DriveApi.DriveIdResult n(Status status)
        {
            return new d(status, null);
        }

        e()
        {
            rc = com.google.android.gms.drive.internal.h.this;
            super();
        }
    }

    static class f
        implements com.google.android.gms.drive.DriveApi.MetadataBufferResult
    {

        private final Status jY;
        private final MetadataBuffer rf;

        public MetadataBuffer getMetadataBuffer()
        {
            return rf;
        }

        public Status getStatus()
        {
            return jY;
        }

        public f(Status status, MetadataBuffer metadatabuffer)
        {
            jY = status;
            rf = metadatabuffer;
        }
    }

    private static class g extends com.google.android.gms.drive.internal.a
    {

        private final com.google.android.gms.common.api.a.c jW;

        public void a(OnContentsResponse oncontentsresponse)
            throws RemoteException
        {
            jW.a(new a(Status.nA, oncontentsresponse.cQ()));
        }

        public void m(Status status)
            throws RemoteException
        {
            jW.a(new a(status, null));
        }

        public g(com.google.android.gms.common.api.a.c c1)
        {
            jW = c1;
        }
    }

    abstract class h extends com.google.android.gms.drive.internal.i
    {

        final com.google.android.gms.drive.internal.h rc;

        public Result e(Status status)
        {
            return o(status);
        }

        public com.google.android.gms.drive.DriveApi.ContentsResult o(Status status)
        {
            return new a(status, null);
        }

        h()
        {
            rc = com.google.android.gms.drive.internal.h.this;
            super();
        }
    }

    static class i extends com.google.android.gms.drive.internal.a
    {

        private final com.google.android.gms.common.api.a.c jW;

        public void a(OnListEntriesResponse onlistentriesresponse)
            throws RemoteException
        {
            onlistentriesresponse = new MetadataBuffer(onlistentriesresponse.cT(), null);
            jW.a(new f(Status.nA, onlistentriesresponse));
        }

        public void m(Status status)
            throws RemoteException
        {
            jW.a(new f(status, null));
        }

        public i(com.google.android.gms.common.api.a.c c1)
        {
            jW = c1;
        }
    }

    abstract class j extends com.google.android.gms.drive.internal.i
    {

        final com.google.android.gms.drive.internal.h rc;

        public Result e(Status status)
        {
            return p(status);
        }

        public com.google.android.gms.drive.DriveApi.MetadataBufferResult p(Status status)
        {
            return new f(status, null);
        }

        j()
        {
            rc = com.google.android.gms.drive.internal.h.this;
            super();
        }
    }

    abstract class k extends com.google.android.gms.drive.internal.i
    {

        final com.google.android.gms.drive.internal.h rc;

        public Result e(Status status)
        {
            return g(status);
        }

        public Status g(Status status)
        {
            return status;
        }

        k()
        {
            rc = com.google.android.gms.drive.internal.h.this;
            super();
        }
    }


    public com.google.android.gms.drive.internal.h()
    {
    }

    public PendingResult discardContents(GoogleApiClient googleapiclient, Contents contents)
    {
        return googleapiclient.b(new b(contents) {

            final com.google.android.gms.drive.internal.h rc;
            final Contents rd;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((com.google.android.gms.drive.internal.j)a1);
            }

            protected void a(com.google.android.gms.drive.internal.j j1)
            {
                try
                {
                    j1.cN().a(new CloseContentsRequest(rd, false), new z(this));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (com.google.android.gms.drive.internal.j j1)
                {
                    a(((Result) (new Status(8, j1.getLocalizedMessage(), null))));
                }
            }

            
            {
                rc = com.google.android.gms.drive.internal.h.this;
                rd = contents;
                super();
            }
        });
    }

    public PendingResult fetchDriveId(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.a(new e(s) {

            final com.google.android.gms.drive.internal.h rc;
            final String re;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((com.google.android.gms.drive.internal.j)a1);
            }

            protected void a(com.google.android.gms.drive.internal.j j1)
            {
                try
                {
                    j1.cN().a(new GetMetadataRequest(DriveId.ab(re)), new c(this));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (com.google.android.gms.drive.internal.j j1)
                {
                    a(((Result) (new d(new Status(8, j1.getLocalizedMessage(), null), null))));
                }
            }

            
            {
                rc = com.google.android.gms.drive.internal.h.this;
                re = s;
                super();
            }
        });
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
            return new com.google.android.gms.drive.internal.k(driveid);
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
            return new l(driveid);
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient googleapiclient)
    {
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        } else
        {
            return new l(((com.google.android.gms.drive.internal.j)googleapiclient.a(Drive.jO)).cO());
        }
    }

    public PendingResult newContents(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new h() {

            final com.google.android.gms.drive.internal.h rc;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((com.google.android.gms.drive.internal.j)a1);
            }

            protected void a(com.google.android.gms.drive.internal.j j1)
            {
                try
                {
                    j1.cN().a(new CreateContentsRequest(), new g(this));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (com.google.android.gms.drive.internal.j j1)
                {
                    a(((Result) (new a(new Status(8, j1.getLocalizedMessage(), null), null))));
                }
            }

            
            {
                rc = com.google.android.gms.drive.internal.h.this;
                super();
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder()
    {
        return new CreateFileActivityBuilder();
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
            return googleapiclient.a(new j(query1) {

                final Query rb;
                final com.google.android.gms.drive.internal.h rc;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((com.google.android.gms.drive.internal.j)a1);
                }

                protected void a(com.google.android.gms.drive.internal.j j1)
                {
                    try
                    {
                        j1.cN().a(new QueryRequest(rb), new i(this));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (com.google.android.gms.drive.internal.j j1)
                    {
                        a(((Result) (new f(new Status(8, j1.getLocalizedMessage(), null), null))));
                    }
                }

            
            {
                rc = com.google.android.gms.drive.internal.h.this;
                rb = query1;
                super();
            }
            });
        }
    }

    public PendingResult requestSync(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new k() {

            final com.google.android.gms.drive.internal.h rc;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((com.google.android.gms.drive.internal.j)a1);
            }

            protected void a(com.google.android.gms.drive.internal.j j1)
            {
                try
                {
                    j1.cN().a(new z(this));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (com.google.android.gms.drive.internal.j j1)
                {
                    a(((Result) (new Status(8, j1.getLocalizedMessage(), null))));
                }
            }

            
            {
                rc = com.google.android.gms.drive.internal.h.this;
                super();
            }
        });
    }
}
