// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.internal.w;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.common.api:
//            i, k, c, Status, 
//            g

public static abstract class .w.a extends i
    implements .w.a, .w.a
{

    final b b;
    private AtomicReference c;

    private void a(RemoteException remoteexception)
    {
        c(new Status(8, remoteexception.getLocalizedMessage(), null));
    }

    public abstract void a(dMessage dmessage);

    public final void a(dMessage dmessage)
    {
        c.set(dmessage);
    }

    public final void a(Object obj)
    {
        super.a((g)obj);
    }

    public final void b(rence.set set)
    {
        try
        {
            a(set);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (rence.set set)
        {
            a(set);
            throw set;
        }
        // Misplaced declaration of an exception variable
        catch (rence.set set)
        {
            a(set);
        }
    }

    protected final void c()
    {
        a a1 = (a)c.getAndSet(null);
        if (a1 != null)
        {
            a1.a(this);
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

    public final us d()
    {
        return b;
    }

    public us(us us, c c1)
    {
        super(((c)w.a(c1, "GoogleApiClient must not be null")).a());
        c = new AtomicReference();
        b = (b)w.a(us);
    }
}
