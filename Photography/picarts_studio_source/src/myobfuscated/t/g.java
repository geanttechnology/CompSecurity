// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.t;

import java.util.ArrayDeque;
import java.util.Queue;

// Referenced classes of package myobfuscated.t:
//            f

final class g
{

    final Queue a;

    private g()
    {
        a = new ArrayDeque();
    }

    g(byte byte0)
    {
        this();
    }

    final f a()
    {
        f f1;
        synchronized (a)
        {
            f1 = (f)a.poll();
        }
        obj = f1;
        if (f1 == null)
        {
            obj = new f((byte)0);
        }
        return ((f) (obj));
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
