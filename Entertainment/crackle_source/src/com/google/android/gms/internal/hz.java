// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

// Referenced classes of package com.google.android.gms.internal:
//            hs

public final class hz
    implements Moments
{
    private static abstract class a extends com.google.android.gms.plus.Plus.a
    {

        public com.google.android.gms.plus.Moments.LoadMomentsResult K(Status status)
        {
            return new com.google.android.gms.plus.Moments.LoadMomentsResult(this, status) {

                final a Ej;
                final Status jP;

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
                    return jP;
                }

                public String getUpdated()
                {
                    return null;
                }

                public void release()
                {
                }

            
            {
                Ej = a1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return K(status);
        }

        a(com.google.android.gms.common.api.Api.b b1)
        {
            super(b1);
        }
    }

    private static abstract class b extends com.google.android.gms.plus.Plus.a
    {

        public Result e(Status status)
        {
            return g(status);
        }

        public Status g(Status status)
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

        public Result e(Status status)
        {
            return g(status);
        }

        public Status g(Status status)
        {
            return status;
        }

        c(com.google.android.gms.common.api.Api.b b1)
        {
            super(b1);
        }
    }


    private final com.google.android.gms.common.api.Api.b Ea;

    public hz(com.google.android.gms.common.api.Api.b b1)
    {
        Ea = b1;
    }

    public PendingResult load(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new a(Ea) {

            final hz Ec;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hs)a1);
            }

            protected void a(hs hs1)
            {
                hs1.j(this);
            }

            
            {
                Ec = hz.this;
                super(b1);
            }
        });
    }

    public PendingResult load(GoogleApiClient googleapiclient, int i, String s, Uri uri, String s1, String s2)
    {
        return googleapiclient.a(new a(Ea, i, s, uri, s1, s2) {

            final hz Ec;
            final String Ed;
            final Uri Ee;
            final String Ef;
            final String Eg;
            final int vc;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hs)a1);
            }

            protected void a(hs hs1)
            {
                hs1.a(this, vc, Ed, Ee, Ef, Eg);
            }

            
            {
                Ec = hz.this;
                vc = i;
                Ed = s;
                Ee = uri;
                Ef = s1;
                Eg = s2;
                super(b1);
            }
        });
    }

    public PendingResult remove(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new b(Ea, s) {

            final hz Ec;
            final String Ei;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hs)a1);
            }

            protected void a(hs hs1)
            {
                hs1.removeMoment(Ei);
                a(((Result) (Status.nA)));
            }

            
            {
                Ec = hz.this;
                Ei = s;
                super(b1);
            }
        });
    }

    public PendingResult write(GoogleApiClient googleapiclient, Moment moment)
    {
        return googleapiclient.b(new c(Ea, moment) {

            final hz Ec;
            final Moment Eh;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hs)a1);
            }

            protected void a(hs hs1)
            {
                hs1.writeMoment(Eh);
                a(((Result) (Status.nA)));
            }

            
            {
                Ec = hz.this;
                Eh = moment;
                super(b1);
            }
        });
    }
}
