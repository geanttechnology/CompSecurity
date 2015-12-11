// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.tapjoy.internal:
//            dh, df, cx

final class nit> extends dh
{

    final df a;

    protected final void a()
    {
        a.e().execute(new Runnable() {

            final df._cls1 a;

            public final void run()
            {
                dk.a a1;
                Throwable throwable;
                dk.a a2;
                boolean flag;
                try
                {
                    a.a.a();
                    a.c();
                    a1 = a.g();
                    a2 = dk.a.c;
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
                a.d();
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

            
            {
                a = df._cls1.this;
                super();
            }
        });
    }

    protected final void b()
    {
        a.d();
    }

    _cls1.a(df df1)
    {
        a = df1;
        super();
    }
}
