// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.BlockingQueue;

// Referenced classes of package android.support.v7:
//            np, ve

class a
    implements Runnable
{

    final ve a;
    final np b;

    public void run()
    {
        try
        {
            np.a(b).put(a);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    eption(np np1, ve ve)
    {
        b = np1;
        a = ve;
        super();
    }
}
