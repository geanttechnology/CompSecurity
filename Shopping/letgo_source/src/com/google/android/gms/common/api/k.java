// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.internal.x;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.common.api:
//            i, c, Status, g

public class k
{
    public static abstract class a extends i
        implements b, o.e
    {

        private final a.d b;
        private AtomicReference c;

        private void a(RemoteException remoteexception)
        {
            d(new Status(8, remoteexception.getLocalizedMessage(), null));
        }

        protected abstract void a(a.c c1)
            throws RemoteException;

        public void a(o.d d1)
        {
            c.set(d1);
        }

        public void a(Object obj)
        {
            super.a((g)obj);
        }

        public final void b(a.c c1)
            throws DeadObjectException
        {
            try
            {
                a(c1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (a.c c1)
            {
                a(c1);
                throw c1;
            }
            // Misplaced declaration of an exception variable
            catch (a.c c1)
            {
                a(c1);
            }
        }

        protected void d()
        {
            o.d d1 = (o.d)c.getAndSet(null);
            if (d1 != null)
            {
                d1.a(this);
            }
        }

        public final void d(Status status)
        {
            boolean flag;
            if (!status.f())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            x.b(flag, "Failed result must not be success");
            a(b(status));
        }

        public final a.d e()
        {
            return b;
        }

        public int f()
        {
            return 0;
        }

        protected a(a.d d1, c c1)
        {
            super(((c)x.a(c1, "GoogleApiClient must not be null")).a());
            c = new AtomicReference();
            b = (a.d)x.a(d1);
        }
    }

    public static interface b
    {

        public abstract void a(Object obj);
    }

}
