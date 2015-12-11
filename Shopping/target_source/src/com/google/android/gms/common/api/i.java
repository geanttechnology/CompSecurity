// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.internal.u;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.common.api:
//            a, d, Status

public class i
{
    public static abstract class a extends com.google.android.gms.common.api.a
        implements m.e
    {

        private final b.c b;
        private AtomicReference c;

        private void a(RemoteException remoteexception)
        {
            c(new Status(8, remoteexception.getLocalizedMessage(), null));
        }

        public final void a(b.b b1)
            throws DeadObjectException
        {
            try
            {
                b(b1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (b.b b1)
            {
                a(((RemoteException) (b1)));
                throw b1;
            }
            // Misplaced declaration of an exception variable
            catch (b.b b1)
            {
                a(((RemoteException) (b1)));
            }
        }

        public void a(m.c c1)
        {
            c.set(c1);
        }

        protected abstract void b(b.b b1)
            throws RemoteException;

        public final void c(Status status)
        {
            boolean flag;
            if (!status.e())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            u.b(flag, "Failed result must not be success");
            a(b(status));
        }

        protected void d()
        {
            m.c c1 = (m.c)c.getAndSet(null);
            if (c1 != null)
            {
                c1.a(this);
            }
        }

        public final b.c e()
        {
            return b;
        }

        public int f()
        {
            return 0;
        }

        protected a(b.c c1, d d1)
        {
            super(((d)u.a(d1, "GoogleApiClient must not be null")).b());
            c = new AtomicReference();
            b = (b.c)u.a(c1);
        }
    }

}
