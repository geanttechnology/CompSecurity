// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.internal.u;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.common.api:
//            a, i, d, Status

public static abstract class .u.a extends a
    implements .u.a
{

    private final b b;
    private AtomicReference c;

    private void a(RemoteException remoteexception)
    {
        c(new Status(8, remoteexception.getLocalizedMessage(), null));
    }

    public final void a(dMessage dmessage)
        throws DeadObjectException
    {
        try
        {
            b(dmessage);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (dMessage dmessage)
        {
            a(((RemoteException) (dmessage)));
            throw dmessage;
        }
        // Misplaced declaration of an exception variable
        catch (dMessage dmessage)
        {
            a(((RemoteException) (dmessage)));
        }
    }

    public void a(a a1)
    {
        c.set(a1);
    }

    protected abstract void b(rence.set set)
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
        us us = (us)c.getAndSet(null);
        if (us != null)
        {
            us.a(this);
        }
    }

    public final a e()
    {
        return b;
    }

    public int f()
    {
        return 0;
    }

    protected us(us us, d d1)
    {
        super(((d)u.a(d1, "GoogleApiClient must not be null")).b());
        c = new AtomicReference();
        b = (b)u.a(us);
    }
}
