// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.util.LinkedList;

// Referenced classes of package com.tapjoy.internal:
//            j, hg, ba, bb, 
//            bd

public final class go
    implements Flushable
{

    private final File a;
    private final Object b = this;
    private bd c;

    public go(File file)
    {
        a = file;
        try
        {
            c = ba.a(new j(file, new hg(gt.c.b)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            c();
        }
    }

    private void c()
    {
        a.delete();
        if (c instanceof Closeable)
        {
            try
            {
                ((Closeable)c).close();
            }
            catch (Exception exception) { }
        }
        c = new bb(new LinkedList());
    }

    public final int a()
    {
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        int i;
        synchronized (b)
        {
            i = c.size();
        }
        return i;
        exception;
        c();
        obj;
        JVM INSTR monitorexit ;
        return 0;
    }

    public final void a(int i)
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        c.b(i);
_L1:
        return;
        Object obj1;
        obj1;
        c();
          goto _L1
        obj1;
        throw obj1;
    }

    public final void a(gt.c c1)
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        c.add(c1);
_L1:
        return;
        Exception exception;
        exception;
        c();
        try
        {
            c.add(c1);
        }
        // Misplaced declaration of an exception variable
        catch (gt.c c1) { }
          goto _L1
        c1;
        throw c1;
    }

    public final gt.c b(int i)
    {
        obj;
        JVM INSTR monitorenter ;
        gt.c c1;
        Exception exception;
        synchronized (b)
        {
            c1 = (gt.c)c.a(i);
        }
        return c1;
        exception;
        c();
        obj;
        JVM INSTR monitorexit ;
        return null;
    }

    public final boolean b()
    {
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        synchronized (b)
        {
            flag = c.isEmpty();
        }
        return flag;
        exception;
        c();
        obj;
        JVM INSTR monitorexit ;
        return true;
    }

    public final void flush()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = c instanceof Flushable;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        ((Flushable)c).flush();
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        c();
          goto _L1
        obj1;
        throw obj1;
    }
}
