// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;


// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            n

class a
    implements Runnable
{

    final String a;
    final n b;

    public void run()
    {
        synchronized (a)
        {
            a.notify();
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (n n1, String s)
    {
        b = n1;
        a = s;
        super();
    }
}
