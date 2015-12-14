// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;


// Referenced classes of package com.cyberlink.you.chat:
//            o, ab

class a
    implements o
{

    final ab a;

    public void a(boolean flag)
    {
        if (flag)
        {
            synchronized (ab.a(a))
            {
                ab.a(a).notify();
            }
            return;
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (ab ab1)
    {
        a = ab1;
        super();
    }
}
