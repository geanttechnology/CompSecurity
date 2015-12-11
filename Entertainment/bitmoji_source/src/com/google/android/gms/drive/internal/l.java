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
//            n, q, o, c, 
//            j, OnMetadataResponse, m, OnContentsResponse, 
//            OnListEntriesResponse, QueryRequest, u, CreateContentsRequest, 
//            CloseContentsRequest, ak, GetMetadataRequest

public class com.google.android.gms.drive.internal.l
    implements DriveApi
{
    static class a
        implements com.google.android.gms.drive.DriveApi.ContentsResult
    {

        private final Contents CW;
        private final Status vl;

        public Contents getContents()
        {
            return CW;
        }

        public Status getStatus()
        {
            return vl;
        }

        public a(Status status, Contents contents)
        {
            vl = status;
            CW = contents;
        }
    }

    private static class b extends com.google.android.gms.drive.internal.c
    {

        private final com.google.android.gms.common.api.a.c vj;

        public void a(OnMetadataResponse onmetadataresponse)
            throws RemoteException
        {
            vj.b(new c(Status.zQ, (new com.google.android.gms.drive.internal.j(onmetadataresponse.fe())).getDriveId()));
        }

        public void l(Status status)
            throws RemoteException
        {
            vj.b(new c(status, null));
        }

        public b(com.google.android.gms.common.api.a.c c1)
        {
            vj = c1;
        }
    }

    static class c
        implements com.google.android.gms.drive.DriveApi.DriveIdResult
    {

        private final DriveId CS;
        private final Status vl;

        public DriveId getDriveId()
        {
            return CS;
        }

        public Status getStatus()
        {
            return vl;
        }

        public c(Status status, DriveId driveid)
        {
            vl = status;
            CS = driveid;
        }
    }

    abstract class d extends m
    {

        final com.google.android.gms.drive.internal.l Dv;

        public Result d(Status status)
        {
            return m(status);
        }

        public com.google.android.gms.drive.DriveApi.DriveIdResult m(Status status)
        {
            return new c(status, null);
        }

        d()
        {
            Dv = com.google.android.gms.drive.internal.l.this;
            super();
        }
    }

    static class e
        implements com.google.android.gms.drive.DriveApi.MetadataBufferResult
    {

        private final MetadataBuffer Dy;
        private final Status vl;

        public MetadataBuffer getMetadataBuffer()
        {
            return Dy;
        }

        public Status getStatus()
        {
            return vl;
        }

        public e(Status status, MetadataBuffer metadatabuffer)
        {
            vl = status;
            Dy = metadatabuffer;
        }
    }

    private static class f extends com.google.android.gms.drive.internal.c
    {

        private final com.google.android.gms.common.api.a.c vj;

        public void a(OnContentsResponse oncontentsresponse)
            throws RemoteException
        {
            vj.b(new a(Status.zQ, oncontentsresponse.eX()));
        }

        public void l(Status status)
            throws RemoteException
        {
            vj.b(new a(status, null));
        }

        public f(com.google.android.gms.common.api.a.c c1)
        {
            vj = c1;
        }
    }

    abstract class g extends m
    {

        final com.google.android.gms.drive.internal.l Dv;

        public Result d(Status status)
        {
            return n(status);
        }

        public com.google.android.gms.drive.DriveApi.ContentsResult n(Status status)
        {
            return new a(status, null);
        }

        g()
        {
            Dv = com.google.android.gms.drive.internal.l.this;
            super();
        }
    }

    static class h extends com.google.android.gms.drive.internal.c
    {

        private final com.google.android.gms.common.api.a.c vj;

        public void a(OnListEntriesResponse onlistentriesresponse)
            throws RemoteException
        {
            onlistentriesresponse = new MetadataBuffer(onlistentriesresponse.fc(), null);
            vj.b(new e(Status.zQ, onlistentriesresponse));
        }

        public void l(Status status)
            throws RemoteException
        {
            vj.b(new e(status, null));
        }

        public h(com.google.android.gms.common.api.a.c c1)
        {
            vj = c1;
        }
    }

    abstract class i extends m
    {

        final com.google.android.gms.drive.internal.l Dv;

        public Result d(Status status)
        {
            return o(status);
        }

        public com.google.android.gms.drive.DriveApi.MetadataBufferResult o(Status status)
        {
            return new e(status, null);
        }

        i()
        {
            Dv = com.google.android.gms.drive.internal.l.this;
            super();
        }
    }

    static abstract class j extends m
    {

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        j()
        {
        }
    }

    static class k extends j
    {

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            throws RemoteException
        {
            a((n)a1);
        }

        protected void a(n n1)
        {
        }

        k(Status status)
        {
            a(status);
        }
    }

    abstract class l extends m
    {

        final com.google.android.gms.drive.internal.l Dv;

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        l()
        {
            Dv = com.google.android.gms.drive.internal.l.this;
            super();
        }
    }


    public com.google.android.gms.drive.internal.l()
    {
    }

    public PendingResult discardContents(GoogleApiClient googleapiclient, Contents contents)
    {
        return googleapiclient.b(new j(contents) {

            final com.google.android.gms.drive.internal.l Dv;
            final Contents Dw;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((n)a1);
            }

            protected void a(n n1)
                throws RemoteException
            {
                n1.eT().a(new CloseContentsRequest(Dw, false), new ak(this));
            }

            
            {
                Dv = com.google.android.gms.drive.internal.l.this;
                Dw = contents;
                super();
            }
        });
    }

    public PendingResult fetchDriveId(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.a(new d(s) {

            final com.google.android.gms.drive.internal.l Dv;
            final String Dx;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((n)a1);
            }

            protected void a(n n1)
                throws RemoteException
            {
                n1.eT().a(new GetMetadataRequest(DriveId.aq(Dx)), new b(this));
            }

            
            {
                Dv = com.google.android.gms.drive.internal.l.this;
                Dx = s;
                super();
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient googleapiclient)
    {
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        }
        googleapiclient = ((n)googleapiclient.a(Drive.va)).eV();
        if (googleapiclient != null)
        {
            return new q(googleapiclient);
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
            return new o(driveid);
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
            return new q(driveid);
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient googleapiclient)
    {
        if (!googleapiclient.isConnected())
        {
            throw new IllegalStateException("Client must be connected");
        } else
        {
            return new q(((n)googleapiclient.a(Drive.va)).eU());
        }
    }

    public PendingResult newContents(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new g() {

            final com.google.android.gms.drive.internal.l Dv;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((n)a1);
            }

            protected void a(n n1)
                throws RemoteException
            {
                n1.eT().a(new CreateContentsRequest(), new f(this));
            }

            
            {
                Dv = com.google.android.gms.drive.internal.l.this;
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
            return googleapiclient.a(new i(query1) {

                final Query Du;
                final com.google.android.gms.drive.internal.l Dv;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    throws RemoteException
                {
                    a((n)a1);
                }

                protected void a(n n1)
                    throws RemoteException
                {
                    n1.eT().a(new QueryRequest(Du), new h(this));
                }

            
            {
                Dv = com.google.android.gms.drive.internal.l.this;
                Du = query1;
                super();
            }
            });
        }
    }

    public PendingResult requestSync(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new l() {

            final com.google.android.gms.drive.internal.l Dv;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((n)a1);
            }

            protected void a(n n1)
                throws RemoteException
            {
                n1.eT().a(new ak(this));
            }

            
            {
                Dv = com.google.android.gms.drive.internal.l.this;
                super();
            }
        });
    }
}
