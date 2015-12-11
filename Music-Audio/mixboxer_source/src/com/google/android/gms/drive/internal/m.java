// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataChangeSet;

// Referenced classes of package com.google.android.gms.drive.internal:
//            i, j, GetMetadataRequest, o, 
//            a, g, OnMetadataResponse, UpdateMetadataRequest

public class m
    implements DriveResource
{
    private abstract class a extends i
    {

        final m rp;

        public Result e(Status status)
        {
            return s(status);
        }

        public com.google.android.gms.drive.DriveResource.MetadataResult s(Status status)
        {
            return new c(status, null);
        }

        private a()
        {
            rp = m.this;
            super();
        }

    }

    private static class b extends com.google.android.gms.drive.internal.a
    {

        private final com.google.android.gms.common.api.a.c jW;

        public void a(OnMetadataResponse onmetadataresponse)
            throws RemoteException
        {
            jW.a(new c(Status.nA, new g(onmetadataresponse.cU())));
        }

        public void m(Status status)
            throws RemoteException
        {
            jW.a(new c(status, null));
        }

        public b(com.google.android.gms.common.api.a.c c1)
        {
            jW = c1;
        }
    }

    private static class c
        implements com.google.android.gms.drive.DriveResource.MetadataResult
    {

        private final Status jY;
        private final Metadata rq;

        public Metadata getMetadata()
        {
            return rq;
        }

        public Status getStatus()
        {
            return jY;
        }

        public c(Status status, Metadata metadata)
        {
            jY = status;
            rq = metadata;
        }
    }

    private abstract class d extends i
    {

        final m rp;

        public Result e(Status status)
        {
            return s(status);
        }

        public com.google.android.gms.drive.DriveResource.MetadataResult s(Status status)
        {
            return new c(status, null);
        }

        private d()
        {
            rp = m.this;
            super();
        }

    }


    private final DriveId qG;

    public m(DriveId driveid)
    {
        qG = driveid;
    }

    static DriveId a(m m1)
    {
        return m1.qG;
    }

    public DriveId getDriveId()
    {
        return qG;
    }

    public PendingResult getMetadata(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new a() {

            final m rp;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((j)a1);
            }

            protected void a(j j1)
            {
                try
                {
                    j1.cN().a(new GetMetadataRequest(m.a(rp)), new b(this));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (j j1)
                {
                    a(((Result) (new c(new Status(8, j1.getLocalizedMessage(), null), null))));
                }
            }

            
            {
                rp = m.this;
                super();
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
            return googleapiclient.b(new d(metadatachangeset) {

                final MetadataChangeSet rl;
                final m rp;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((j)a1);
                }

                protected void a(j j1)
                {
                    try
                    {
                        j1.cN().a(new UpdateMetadataRequest(m.a(rp), rl.cM()), new b(this));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (j j1)
                    {
                        a(((Result) (new c(new Status(8, j1.getLocalizedMessage(), null), null))));
                    }
                }

            
            {
                rp = m.this;
                rl = metadatachangeset;
                super();
            }
            });
        }
    }
}
