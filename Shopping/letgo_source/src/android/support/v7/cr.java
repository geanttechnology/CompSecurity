// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

// Referenced classes of package android.support.v7:
//            cq

public class cr
    implements Closeable
{

    private final Object a;
    private final List b;
    private ScheduledFuture c;
    private boolean d;
    private boolean e;

    private void b()
    {
        if (e)
        {
            throw new IllegalStateException("Object already closed");
        } else
        {
            return;
        }
    }

    private void c()
    {
        if (c != null)
        {
            c.cancel(true);
            c = null;
        }
    }

    void a(cq cq1)
    {
        synchronized (a)
        {
            b();
            b.remove(cq1);
        }
        return;
        cq1;
        obj;
        JVM INSTR monitorexit ;
        throw cq1;
    }

    public boolean a()
    {
        boolean flag;
        synchronized (a)
        {
            b();
            flag = d;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void close()
    {
label0:
        {
            synchronized (a)
            {
                if (!e)
                {
                    break label0;
                }
            }
            return;
        }
        c();
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((cq)iterator.next()).close()) { }
        break MISSING_BLOCK_LABEL_60;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        b.clear();
        e = true;
        obj;
        JVM INSTR monitorexit ;
    }

    public String toString()
    {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] {
            getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(a())
        });
    }
}
