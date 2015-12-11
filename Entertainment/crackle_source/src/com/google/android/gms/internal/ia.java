// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.internal:
//            hs

public final class ia
    implements People
{
    private static abstract class a extends com.google.android.gms.plus.Plus.a
    {

        public com.google.android.gms.plus.People.LoadPeopleResult L(Status status)
        {
            return new com.google.android.gms.plus.People.LoadPeopleResult(this, status) {

                final a Eo;
                final Status jP;

                public String getNextPageToken()
                {
                    return null;
                }

                public PersonBuffer getPersonBuffer()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return jP;
                }

                public void release()
                {
                }

            
            {
                Eo = a1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return L(status);
        }

        a(com.google.android.gms.common.api.Api.b b)
        {
            super(b);
        }
    }


    private final com.google.android.gms.common.api.Api.b Ea;

    public ia(com.google.android.gms.common.api.Api.b b)
    {
        Ea = b;
    }

    public Person getCurrentPerson(GoogleApiClient googleapiclient)
    {
        return Plus.a(googleapiclient, Ea).getCurrentPerson();
    }

    public PendingResult load(GoogleApiClient googleapiclient, Collection collection)
    {
        return googleapiclient.a(new a(Ea, collection) {

            final ia El;
            final Collection Em;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hs)a1);
            }

            protected void a(hs hs1)
            {
                hs1.a(this, Em);
            }

            
            {
                El = ia.this;
                Em = collection;
                super(b);
            }
        });
    }

    public transient PendingResult load(GoogleApiClient googleapiclient, String as[])
    {
        return googleapiclient.a(new a(Ea, as) {

            final ia El;
            final String En[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hs)a1);
            }

            protected void a(hs hs1)
            {
                hs1.a(this, En);
            }

            
            {
                El = ia.this;
                En = as;
                super(b);
            }
        });
    }

    public PendingResult loadConnected(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new a(Ea) {

            final ia El;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hs)a1);
            }

            protected void a(hs hs1)
            {
                hs1.k(this);
            }

            
            {
                El = ia.this;
                super(b);
            }
        });
    }

    public PendingResult loadVisible(GoogleApiClient googleapiclient, int i, String s)
    {
        return googleapiclient.a(new a(Ea, i, s) {

            final String Ed;
            final int Ek;
            final ia El;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hs)a1);
            }

            protected void a(hs hs1)
            {
                hs1.a(this, Ek, Ed);
            }

            
            {
                El = ia.this;
                Ek = i;
                Ed = s;
                super(b);
            }
        });
    }

    public PendingResult loadVisible(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.a(new a(Ea, s) {

            final String Ed;
            final ia El;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((hs)a1);
            }

            protected void a(hs hs1)
            {
                hs1.i(this, Ed);
            }

            
            {
                El = ia.this;
                Ed = s;
                super(b);
            }
        });
    }
}
