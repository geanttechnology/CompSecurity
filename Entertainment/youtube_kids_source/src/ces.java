// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.CountDownLatch;

final class ces extends Thread
{

    private CountDownLatch a;
    private ceq b;

    ces(ceq ceq1, String s, CountDownLatch countdownlatch)
    {
        b = ceq1;
        a = countdownlatch;
        super(s);
    }

    public final void run()
    {
        try
        {
            cfa cfa1 = ceq.e(b).a((new ceo()).a());
            ceq.d(b, cfa1.b());
            ceq.a(b, a);
            return;
        }
        catch (Exception exception)
        {
            ceq.f(b).a("Error testing for buffered proxy. Will assume buffered proxy)", exception);
        }
        ceq.d(b, true);
    }
}
