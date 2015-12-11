// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.location.b;

// Referenced classes of package com.google.android.gms.location.internal:
//            j

public class com.google.android.gms.location.internal.a
    implements b
{
    private static abstract class a extends com.google.android.gms.location.a
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


    public com.google.android.gms.location.internal.a()
    {
    }

    public e a(c c1, long l, PendingIntent pendingintent)
    {
        return c1.b(new a(c1, l, pendingintent) {

            final long b;
            final PendingIntent c;
            final com.google.android.gms.location.internal.a d;

            protected volatile void a(com.google.android.gms.common.api.c c2)
                throws RemoteException
            {
                a((j)c2);
            }

            protected void a(j j1)
                throws RemoteException
            {
                j1.a(b, c);
                a(((g) (Status.a)));
            }

            
            {
                d = com.google.android.gms.location.internal.a.this;
                b = l;
                c = pendingintent;
                super(c1);
            }
        });
    }

    public e a(c c1, PendingIntent pendingintent)
    {
        return c1.b(new a(c1, pendingintent) {

            final PendingIntent b;
            final com.google.android.gms.location.internal.a c;

            protected volatile void a(com.google.android.gms.common.api.c c2)
                throws RemoteException
            {
                a((j)c2);
            }

            protected void a(j j1)
                throws RemoteException
            {
                j1.a(b);
                a(((g) (Status.a)));
            }

            
            {
                c = com.google.android.gms.location.internal.a.this;
                b = pendingintent;
                super(c1);
            }
        });
    }
}
