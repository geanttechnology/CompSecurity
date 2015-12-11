// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.BlockingQueue;

final class lu
    implements Runnable
{

    private me a;
    private lt b;

    lu(lt lt1, me me)
    {
        b = lt1;
        a = me;
        super();
    }

    public final void run()
    {
        try
        {
            lt.a(b).put(a);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }
}
