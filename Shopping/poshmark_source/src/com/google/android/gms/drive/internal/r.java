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

// Referenced classes of package com.google.android.gms.drive.internal:
//            n, m, GetMetadataRequest, u, 
//            c, OnListParentsResponse, j, OnMetadataResponse, 
//            ListParentsRequest, UpdateMetadataRequest

public class r
    implements DriveResource
{
    private abstract class a extends m
    {

        final r DP;

        public Result d(Status status)
        {
            return r(status);
        }

        public com.google.android.gms.drive.DriveResource.MetadataResult r(Status status)
        {
            return new e(status, null);
        }

        private a()
        {
            DP = r.this;
            super();
        }

    }

    private static class b extends com.google.android.gms.drive.internal.c
    {

        private final com.google.android.gms.common.api.a.c vj;

        public void a(OnListParentsResponse onlistparentsresponse)
            throws RemoteException
        {
            onlistparentsresponse = new MetadataBuffer(onlistparentsresponse.fd(), null);
            vj.b(new l.e(Status.zQ, onlistparentsresponse));
        }

        public void l(Status status)
            throws RemoteException
        {
            vj.b(new l.e(status, null));
        }

        public b(com.google.android.gms.common.api.a.c c1)
        {
            vj = c1;
        }
    }

    private abstract class c extends m
    {

        final r DP;

        public Result d(Status status)
        {
            return o(status);
        }

        public com.google.android.gms.drive.DriveApi.MetadataBufferResult o(Status status)
        {
            return new l.e(status, null);
        }

        private c()
        {
            DP = r.this;
            super();
        }

    }

    private static class d extends com.google.android.gms.drive.internal.c
    {

        private final com.google.android.gms.common.api.a.c vj;

        public void a(OnMetadataResponse onmetadataresponse)
            throws RemoteException
        {
            vj.b(new e(Status.zQ, new j(onmetadataresponse.fe())));
        }

        public void l(Status status)
            throws RemoteException
        {
            vj.b(new e(status, null));
        }

        public d(com.google.android.gms.common.api.a.c c1)
        {
            vj = c1;
        }
    }

    private static class e
        implements com.google.android.gms.drive.DriveResource.MetadataResult
    {

        private final Metadata DQ;
        private final Status vl;

        public Metadata getMetadata()
        {
            return DQ;
        }

        public Status getStatus()
        {
            return vl;
        }

        public e(Status status, Metadata metadata)
        {
            vl = status;
            DQ = metadata;
        }
    }

    private abstract class f extends m
    {

        final r DP;

        public Result d(Status status)
        {
            return r(status);
        }

        public com.google.android.gms.drive.DriveResource.MetadataResult r(Status status)
        {
            return new e(status, null);
        }

        private f()
        {
            DP = r.this;
            super();
        }

    }


    protected final DriveId CS;

    protected r(DriveId driveid)
    {
        CS = driveid;
    }

    public PendingResult addChangeListener(GoogleApiClient googleapiclient, com.google.android.gms.drive.events.DriveEvent.Listener listener)
    {
        return ((n)googleapiclient.a(Drive.va)).a(googleapiclient, CS, 1, listener);
    }

    public DriveId getDriveId()
    {
        return CS;
    }

    public PendingResult getMetadata(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new a() {

            final r DP;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((n)a1);
            }

            protected void a(n n1)
                throws RemoteException
            {
                n1.eT().a(new GetMetadataRequest(DP.CS), new d(this));
            }

            
            {
                DP = r.this;
                super();
            }
        });
    }

    public PendingResult listParents(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new c() {

            final r DP;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((n)a1);
            }

            protected void a(n n1)
                throws RemoteException
            {
                n1.eT().a(new ListParentsRequest(DP.CS), new b(this));
            }

            
            {
                DP = r.this;
                super();
            }
        });
    }

    public PendingResult removeChangeListener(GoogleApiClient googleapiclient, com.google.android.gms.drive.events.DriveEvent.Listener listener)
    {
        return ((n)googleapiclient.a(Drive.va)).b(googleapiclient, CS, 1, listener);
    }

    public PendingResult updateMetadata(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset)
    {
        if (metadatachangeset == null)
        {
            throw new IllegalArgumentException("ChangeSet must be provided.");
        } else
        {
            return googleapiclient.b(new f(metadatachangeset) {

                final MetadataChangeSet DK;
                final r DP;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    throws RemoteException
                {
                    a((n)a1);
                }

                protected void a(n n1)
                    throws RemoteException
                {
                    n1.eT().a(new UpdateMetadataRequest(DP.CS, DK.eS()), new d(this));
                }

            
            {
                DP = r.this;
                DK = metadatachangeset;
                super();
            }
            });
        }
    }
}
