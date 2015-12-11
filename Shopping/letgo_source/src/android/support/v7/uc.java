// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package android.support.v7:
//            ua, ud

public class uc
{
    public static interface a
    {

        public abstract Object a(Object obj);
    }


    public static ud a(ud ud1, a a1)
    {
        ua ua1 = new ua();
        ud1.a(new Runnable(ua1, a1, ud1) {

            final ua a;
            final a b;
            final ud c;

            public void run()
            {
                try
                {
                    a.b(b.a(c.get()));
                    return;
                }
                catch (CancellationException cancellationexception) { }
                catch (InterruptedException interruptedexception) { }
                catch (ExecutionException executionexception) { }
                a.cancel(true);
            }

            
            {
                a = ua1;
                b = a1;
                c = ud1;
                super();
            }
        });
        return ua1;
    }
}
