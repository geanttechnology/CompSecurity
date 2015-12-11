// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.os.ConditionVariable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

// Referenced classes of package a.a:
//            ed, ai, aj, aa, 
//            eb, ay, en

final class nit> extends ed
{

    final ai a;
    final ai b;

    public final void a()
    {
        if (ai.a(a) != aj.c)
        {
            Object obj = new Runnable() {

                final ai._cls5 a;

                public final void run()
                {
                }

            
            {
                a = ai._cls5.this;
                super();
            }
            };
            java.util.concurrent.ExecutorService executorservice = b.a.s;
            obj = new FutureTask(((Runnable) (obj)), null);
            executorservice.execute(((Runnable) (obj)));
            try
            {
                ((FutureTask) (obj)).get();
            }
            catch (InterruptedException interruptedexception)
            {
                en.a(interruptedexception);
            }
            catch (ExecutionException executionexception)
            {
                en.a(executionexception);
            }
        }
        b.a.q.a.block();
        b.a.n.a(ai.c(b));
        b.a.o.a(a);
    }

    .Object(ai ai1, ai ai2)
    {
        b = ai1;
        a = ai2;
        super();
    }
}
