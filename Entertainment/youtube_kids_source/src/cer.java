// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

final class cer extends Thread
{

    private ceq a;

    cer(ceq ceq1, String s)
    {
        a = ceq1;
        super(s);
    }

    public final void run()
    {
        Object obj;
        ceq.a(a).set(false);
        if (ceq.b(a))
        {
            ceq.a(a, false);
            ceq.b(a, false);
        }
        (new ces(a, "Testing for buffered proxy", null)).start();
        obj = a;
        obj.e = ((ceq) (obj)).b.a(((ceq) (obj)).f);
        ((ceq) (obj)).e.a(((ceq) (obj)).c);
        ((ceq) (obj)).e.a();
        ((ceq) (obj)).b(true);
        ((ceq) (obj)).d();
        obj.g = new cet(((ceq) (obj)), "HangingGetThread");
        ((ceq) (obj)).g.start();
_L3:
        if (a.h)
        {
            ceq.c(a);
        }
        ceq.c(a, false);
        ceq.d(a).countDown();
        return;
        Object obj1;
        obj1;
        chq chq1 = ((ceq) (obj)).d;
        int i = ((cfe) (obj1)).a;
        chq1.a((new StringBuilder(53)).append("Unexpected response when binding channel: ").append(i).toString(), ((Exception) (obj1)));
        ((cfe) (obj1)).a;
        JVM INSTR tableswitch 401 403: default 292
    //                   401 264
    //                   402 236
    //                   403 264;
           goto _L1 _L2 _L1 _L2
_L1:
        ((ceq) (obj)).b();
          goto _L3
        obj;
        ceq.c(a, false);
        ceq.d(a).countDown();
        throw obj;
_L2:
        ((ceq) (obj)).a(false);
          goto _L1
        obj1;
        ((ceq) (obj)).d.a("Error connecting to Remote Control server:", ((Exception) (obj1)));
        ((ceq) (obj)).b();
          goto _L3
    }
}
