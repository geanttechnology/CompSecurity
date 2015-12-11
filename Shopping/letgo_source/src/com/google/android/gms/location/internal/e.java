// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.g;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.internal:
//            j

public class e
    implements g
{
    private static abstract class a extends com.google.android.gms.location.m.a
    {

        public Status a(Status status)
        {
            return status;
        }

        public com.google.android.gms.common.api.g b(Status status)
        {
            return a(status);
        }

        public a(c c1)
        {
            super(c1);
        }
    }


    public e()
    {
    }

    public com.google.android.gms.common.api.e a(c c1, GeofencingRequest geofencingrequest, PendingIntent pendingintent)
    {
        return c1.b(new a(c1, geofencingrequest, pendingintent) {

            final GeofencingRequest b;
            final PendingIntent c;
            final e d;

            protected volatile void a(com.google.android.gms.common.api.a.c c2)
                throws RemoteException
            {
                a((j)c2);
            }

            protected void a(j j1)
                throws RemoteException
            {
                j1.a(b, c, this);
            }

            
            {
                d = e.this;
                b = geofencingrequest;
                c = pendingintent;
                super(c1);
            }
        });
    }

    public com.google.android.gms.common.api.e a(c c1, List list)
    {
        return c1.b(new a(c1, list) {

            final List b;
            final e c;

            protected volatile void a(com.google.android.gms.common.api.a.c c2)
                throws RemoteException
            {
                a((j)c2);
            }

            protected void a(j j1)
                throws RemoteException
            {
                j1.a(b, this);
            }

            
            {
                c = e.this;
                b = list;
                super(c1);
            }
        });
    }

    public com.google.android.gms.common.api.e a(c c1, List list, PendingIntent pendingintent)
    {
        com.google.android.gms.location.GeofencingRequest.a a1 = new com.google.android.gms.location.GeofencingRequest.a();
        a1.a(list);
        a1.a(5);
        return a(c1, a1.a(), pendingintent);
    }
}
