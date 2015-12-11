// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.internal.w;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.common.api:
//            i, c, Status, g

public final class k
{
    public static abstract class a extends i
        implements b, o.e
    {

        final a.c b;
        private AtomicReference c;

        private void a(RemoteException remoteexception)
        {
            c(new Status(8, remoteexception.getLocalizedMessage(), null));
        }

        public abstract void a(a.b b1);

        public final void a(o.d d1)
        {
            c.set(d1);
        }

        public final void a(Object obj)
        {
            super.a((g)obj);
        }

        public final void b(a.b b1)
        {
            try
            {
                a(b1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (a.b b1)
            {
                a(b1);
                throw b1;
            }
            // Misplaced declaration of an exception variable
            catch (a.b b1)
            {
                a(b1);
            }
        }

        protected final void c()
        {
            o.d d1 = (o.d)c.getAndSet(null);
            if (d1 != null)
            {
                d1.a(this);
            }
        }

        public final void c(Status status)
        {
            boolean flag;
            if (!status.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.b(flag, "Failed result must not be success");
            a(a(status));
        }

        public final a.c d()
        {
            return b;
        }

        public a(a.c c1, c c2)
        {
            super(((c)w.a(c2, "GoogleApiClient must not be null")).a());
            c = new AtomicReference();
            b = (a.c)w.a(c1);
        }
    }

    public static interface b
    {

        public abstract void a(Object obj);
    }

}
