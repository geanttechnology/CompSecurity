// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class ik
    implements Moments
{
    private static abstract class a extends com.google.android.gms.plus.Plus.a
    {

        public com.google.android.gms.plus.Moments.LoadMomentsResult M(Status status)
        {
            return new com.google.android.gms.plus.Moments.LoadMomentsResult(this, status) {

                final a RF;
                final Status vb;

                public MomentBuffer getMomentBuffer()
                {
                    return null;
                }

                public String getNextPageToken()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return vb;
                }

                public String getUpdated()
                {
                    return null;
                }

                public void release()
                {
                }

            
            {
                RF = a1;
                vb = status;
                super();
            }
            };
        }

        public Result d(Status status)
        {
            return M(status);
        }

        a(com.google.android.gms.common.api.Api.b b1)
        {
            super(b1);
        }
    }

    private static abstract class b extends com.google.android.gms.plus.Plus.a
    {

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        b(com.google.android.gms.common.api.Api.b b1)
        {
            super(b1);
        }
    }

    private static abstract class c extends com.google.android.gms.plus.Plus.a
    {

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        c(com.google.android.gms.common.api.Api.b b1)
        {
            super(b1);
        }
    }


    private final com.google.android.gms.common.api.Api.b Rw;

    public ik(com.google.android.gms.common.api.Api.b b1)
    {
        Rw = b1;
    }

    public PendingResult load(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new a(Rw) {

            final ik Ry;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((e)a1);
            }

            protected void a(e e1)
            {
                e1.i(this);
            }

            
            {
                Ry = ik.this;
                super(b1);
            }
        });
    }

    public PendingResult load(GoogleApiClient googleapiclient, int i, String s, Uri uri, String s1, String s2)
    {
        return googleapiclient.a(new a(Rw, i, s, uri, s1, s2) {

            final int HW;
            final Uri RA;
            final String RB;
            final String RC;
            final ik Ry;
            final String Rz;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((e)a1);
            }

            protected void a(e e1)
            {
                e1.a(this, HW, Rz, RA, RB, RC);
            }

            
            {
                Ry = ik.this;
                HW = i;
                Rz = s;
                RA = uri;
                RB = s1;
                RC = s2;
                super(b1);
            }
        });
    }

    public PendingResult remove(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new b(Rw, s) {

            final String RE;
            final ik Ry;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((e)a1);
            }

            protected void a(e e1)
            {
                e1.removeMoment(RE);
                a(((Result) (Status.zQ)));
            }

            
            {
                Ry = ik.this;
                RE = s;
                super(b1);
            }
        });
    }

    public PendingResult write(GoogleApiClient googleapiclient, Moment moment)
    {
        return googleapiclient.b(new c(Rw, moment) {

            final Moment RD;
            final ik Ry;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((e)a1);
            }

            protected void a(e e1)
            {
                e1.a(this, RD);
            }

            
            {
                Ry = ik.this;
                RD = moment;
                super(b1);
            }
        });
    }
}
