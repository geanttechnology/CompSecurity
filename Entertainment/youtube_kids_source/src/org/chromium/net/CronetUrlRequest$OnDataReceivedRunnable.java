// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import java.nio.ByteBuffer;

// Referenced classes of package org.chromium.net:
//            CronetUrlRequest, UrlRequestListener

final class b
    implements Runnable
{

    ByteBuffer a;
    private CronetUrlRequest b;

    public final void run()
    {
        if (b.c())
        {
            return;
        }
        synchronized (CronetUrlRequest.a(b))
        {
            if (CronetUrlRequest.b(b) != 0L)
            {
                break MISSING_BLOCK_LABEL_89;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (Exception exception1)
        {
            synchronized (CronetUrlRequest.a(b))
            {
                CronetUrlRequest.a(b, false);
                if (b.c())
                {
                    CronetUrlRequest.e(b);
                }
            }
            CronetUrlRequest.a(b, exception1);
            return;
        }
        CronetUrlRequest.a(b, true);
        obj;
        JVM INSTR monitorexit ;
        obj = CronetUrlRequest.d(b);
        CronetUrlRequest croneturlrequest = b;
        ((UrlRequestListener) (obj)).a(CronetUrlRequest.c(b), a);
        a = null;
        synchronized (CronetUrlRequest.a(b))
        {
            CronetUrlRequest.a(b, false);
            if (!b.c())
            {
                break MISSING_BLOCK_LABEL_179;
            }
            CronetUrlRequest.e(b);
        }
        return;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
        CronetUrlRequest.a(b, CronetUrlRequest.b(b));
        obj;
        JVM INSTR monitorexit ;
        return;
        exception3;
        obj;
        JVM INSTR monitorexit ;
        throw exception3;
    }

    (CronetUrlRequest croneturlrequest)
    {
        b = croneturlrequest;
        super();
    }
}
