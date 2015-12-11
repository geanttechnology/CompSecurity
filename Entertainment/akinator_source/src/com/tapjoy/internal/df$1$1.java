// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.tapjoy.internal:
//            df, dh, cx

final class a
    implements Runnable
{

    final NING a;

    public final void run()
    {
        a a1;
        Throwable throwable;
        a a2;
        boolean flag;
        try
        {
            a.a.a();
            a.a();
            a1 = a.g();
            a2 = a;
        }
        catch (Throwable throwable1)
        {
            a.a(throwable1);
            throw cx.a(throwable1);
        }
        if (a1 == a2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        a.a.b();
        a.a.c();
        a.a();
        return;
        throwable;
        a.a.c();
_L1:
        throw throwable;
        Exception exception;
        exception;
        df.i().log(Level.WARNING, "Error while attempting to shut down the service after failure.", exception);
          goto _L1
    }

    t>(t> t>)
    {
        a = t>;
        super();
    }

    // Unreferenced inner class com/tapjoy/internal/df$1

/* anonymous class */
    final class df._cls1 extends dh
    {

        final df a;

        protected final void a()
        {
            a.e().execute(new df._cls1._cls1(this));
        }

        protected final void b()
        {
            a.d();
        }

            
            {
                a = df1;
                super();
            }
    }

}
