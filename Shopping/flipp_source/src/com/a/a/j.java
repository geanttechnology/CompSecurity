// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.f;
import com.a.a.a.u;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

// Referenced classes of package com.a.a:
//            k, f

final class j extends CacheRequest
{

    final com.a.a.f a;
    private final f b;
    private OutputStream c;
    private boolean d;
    private OutputStream e;

    public j(com.a.a.f f1, f f2)
    {
        a = f1;
        super();
        b = f2;
        c = f2.a(1);
        e = new k(this, c, f1, f2);
    }

    static boolean a(j j1)
    {
        return j1.d;
    }

    static boolean b(j j1)
    {
        j1.d = true;
        return true;
    }

    public final void abort()
    {
label0:
        {
            synchronized (a)
            {
                if (!d)
                {
                    break label0;
                }
            }
            return;
        }
        d = true;
        f.c(a);
        obj;
        JVM INSTR monitorexit ;
        u.a(c);
        try
        {
            b.b();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final OutputStream getBody()
    {
        return e;
    }
}
