// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.e;
import com.google.android.gms.location.j;
import com.google.android.gms.location.k;
import com.google.android.gms.location.m;

// Referenced classes of package com.google.android.gms.location.internal:
//            j, LocationRequestInternal

public class d
    implements e
{
    private static abstract class a extends com.google.android.gms.location.m.a
    {

        public Status a(Status status)
        {
            return status;
        }

        public g b(Status status)
        {
            return a(status);
        }

        public a(c c1)
        {
            super(c1);
        }
    }


    public d()
    {
    }

    public Location a(c c1)
    {
        c1 = m.a(c1);
        try
        {
            c1 = c1.a();
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            return null;
        }
        return c1;
    }

    public com.google.android.gms.common.api.e a(c c1, LocationRequest locationrequest, j j1, Looper looper)
    {
        return c1.b(new a(c1, locationrequest, j1, looper) {

            final LocationRequest b;
            final j c;
            final Looper d;
            final d e;

            protected volatile void a(com.google.android.gms.common.api.a.c c2)
                throws RemoteException
            {
                a((com.google.android.gms.location.internal.j)c2);
            }

            protected void a(com.google.android.gms.location.internal.j j2)
                throws RemoteException
            {
                j2.a(LocationRequestInternal.a(b), c, d);
                a(((g) (Status.a)));
            }

            
            {
                e = d.this;
                b = locationrequest;
                c = j1;
                d = looper;
                super(c1);
            }
        });
    }

    public com.google.android.gms.common.api.e a(c c1, LocationRequest locationrequest, k k)
    {
        return c1.b(new a(c1, locationrequest, k) {

            final LocationRequest b;
            final k c;
            final d d;

            protected volatile void a(com.google.android.gms.common.api.a.c c2)
                throws RemoteException
            {
                a((com.google.android.gms.location.internal.j)c2);
            }

            protected void a(com.google.android.gms.location.internal.j j1)
                throws RemoteException
            {
                j1.a(b, c, null);
                a(((g) (Status.a)));
            }

            
            {
                d = d.this;
                b = locationrequest;
                c = k;
                super(c1);
            }
        });
    }

    public com.google.android.gms.common.api.e a(c c1, j j1)
    {
        return c1.b(new a(c1, j1) {

            final j b;
            final d c;

            protected volatile void a(com.google.android.gms.common.api.a.c c2)
                throws RemoteException
            {
                a((com.google.android.gms.location.internal.j)c2);
            }

            protected void a(com.google.android.gms.location.internal.j j2)
                throws RemoteException
            {
                j2.a(b);
                a(((g) (Status.a)));
            }

            
            {
                c = d.this;
                b = j1;
                super(c1);
            }
        });
    }

    public com.google.android.gms.common.api.e a(c c1, k k)
    {
        return c1.b(new a(c1, k) {

            final k b;
            final d c;

            protected volatile void a(com.google.android.gms.common.api.a.c c2)
                throws RemoteException
            {
                a((com.google.android.gms.location.internal.j)c2);
            }

            protected void a(com.google.android.gms.location.internal.j j1)
                throws RemoteException
            {
                j1.a(b);
                a(((g) (Status.a)));
            }

            
            {
                c = d.this;
                b = k;
                super(c1);
            }
        });
    }

    public LocationAvailability b(c c1)
    {
        c1 = m.a(c1);
        try
        {
            c1 = c1.b();
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            return null;
        }
        return c1;
    }
}
