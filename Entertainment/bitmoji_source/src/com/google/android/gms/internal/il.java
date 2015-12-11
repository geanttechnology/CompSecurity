// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class il
    implements People
{
    private static abstract class a extends com.google.android.gms.plus.Plus.a
    {

        public com.google.android.gms.plus.People.LoadPeopleResult N(Status status)
        {
            return new com.google.android.gms.plus.People.LoadPeopleResult(this, status) {

                final a RK;
                final Status vb;

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
                    return vb;
                }

                public void release()
                {
                }

            
            {
                RK = a1;
                vb = status;
                super();
            }
            };
        }

        public Result d(Status status)
        {
            return N(status);
        }

        a(com.google.android.gms.common.api.Api.b b)
        {
            super(b);
        }
    }


    private final com.google.android.gms.common.api.Api.b Rw;

    public il(com.google.android.gms.common.api.Api.b b)
    {
        Rw = b;
    }

    public Person getCurrentPerson(GoogleApiClient googleapiclient)
    {
        return Plus.a(googleapiclient, Rw).getCurrentPerson();
    }

    public PendingResult load(GoogleApiClient googleapiclient, Collection collection)
    {
        return googleapiclient.a(new a(Rw, collection) {

            final il RH;
            final Collection RI;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((e)a1);
            }

            protected void a(e e1)
            {
                e1.a(this, RI);
            }

            
            {
                RH = il.this;
                RI = collection;
                super(b);
            }
        });
    }

    public transient PendingResult load(GoogleApiClient googleapiclient, String as[])
    {
        return googleapiclient.a(new a(Rw, as) {

            final il RH;
            final String RJ[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((e)a1);
            }

            protected void a(e e1)
            {
                e1.c(this, RJ);
            }

            
            {
                RH = il.this;
                RJ = as;
                super(b);
            }
        });
    }

    public PendingResult loadConnected(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new a(Rw) {

            final il RH;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((e)a1);
            }

            protected void a(e e1)
            {
                e1.j(this);
            }

            
            {
                RH = il.this;
                super(b);
            }
        });
    }

    public PendingResult loadVisible(GoogleApiClient googleapiclient, int i, String s)
    {
        return googleapiclient.a(new a(Rw, i, s) {

            final int RG;
            final il RH;
            final String Rz;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((e)a1);
            }

            protected void a(e e1)
            {
                e1.a(this, RG, Rz);
            }

            
            {
                RH = il.this;
                RG = i;
                Rz = s;
                super(b);
            }
        });
    }

    public PendingResult loadVisible(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.a(new a(Rw, s) {

            final il RH;
            final String Rz;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((e)a1);
            }

            protected void a(e e1)
            {
                e1.i(this, Rz);
            }

            
            {
                RH = il.this;
                Rz = s;
                super(b);
            }
        });
    }
}
