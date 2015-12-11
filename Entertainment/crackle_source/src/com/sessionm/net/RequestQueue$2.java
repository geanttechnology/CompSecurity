// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;

import com.sessionm.core.f;

// Referenced classes of package com.sessionm.net:
//            RequestQueue, Request

class val.request
    implements Runnable
{

    final RequestQueue fP;
    final Request val$request;

    public void run()
    {
        synchronized (f.E())
        {
            RequestQueue.e(fP, val$request);
        }
        return;
        exception;
        f1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (Request request1)
    {
        fP = final_requestqueue;
        val$request = request1;
        super();
    }
}
