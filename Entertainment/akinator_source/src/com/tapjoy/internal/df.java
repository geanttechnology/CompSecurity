// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.tapjoy.internal:
//            dk, dj, dh, cx

public abstract class df
    implements dk
{

    private static final Logger a = Logger.getLogger(com/tapjoy/internal/df.getName());
    private final dk b = new dh() {

        final df a;

        protected final void a()
        {
            a.e().execute(new Runnable(this) {

                final _cls1 a;

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
                a = _pcls1;
                super();
            }
            });
        }

        protected final void b()
        {
            a.d();
        }

            
            {
                a = df.this;
                super();
            }
    };

    public df()
    {
    }

    static Logger i()
    {
        return a;
    }

    protected void a()
    {
    }

    protected abstract void b();

    protected void c()
    {
    }

    protected void d()
    {
    }

    protected final Executor e()
    {
        return new Executor() {

            final df a;

            public final void execute(Runnable runnable)
            {
                (new Thread(runnable, a.h())).start();
            }

            
            {
                a = df.this;
                super();
            }
        };
    }

    public final dj f()
    {
        return b.f();
    }

    public final dk.a g()
    {
        return b.g();
    }

    protected final String h()
    {
        return getClass().getSimpleName();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(" [").append(g()).append("]").toString();
    }

}
