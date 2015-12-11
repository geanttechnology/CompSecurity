// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import java.util.List;

// Referenced classes of package org.chromium.net:
//            CronetUrlRequest, UrlRequestListener

class b
    implements Runnable
{

    private tiveResponseInfo a;
    private String b;
    private CronetUrlRequest c;

    public void run()
    {
        if (c.c())
        {
            return;
        }
        UrlRequestListener urlrequestlistener = CronetUrlRequest.d(c);
        CronetUrlRequest croneturlrequest = c;
        urlrequestlistener.a(a, b);
        synchronized (CronetUrlRequest.a(c))
        {
            if (!c.c())
            {
                break MISSING_BLOCK_LABEL_76;
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
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            CronetUrlRequest.a(c, ((Exception) (obj)));
        }
        return;
        CronetUrlRequest.f(c).add(b);
        CronetUrlRequest.b(c, CronetUrlRequest.b(c));
        obj;
        JVM INSTR monitorexit ;
    }

    tiveResponseInfo(CronetUrlRequest croneturlrequest, tiveResponseInfo tiveresponseinfo, String s)
    {
        c = croneturlrequest;
        a = tiveresponseinfo;
        b = s;
        super();
    }
}
