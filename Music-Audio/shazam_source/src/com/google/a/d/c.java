// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.d;

import com.google.a.a.g;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

// Referenced classes of package com.google.a.d:
//            e, i, f

public class c extends e
{

    private final ConcurrentLinkedQueue eventsToDispatch;
    private final Executor executor;

    public c(String s, Executor executor1)
    {
        super(s);
        eventsToDispatch = new ConcurrentLinkedQueue();
        executor = (Executor)g.a(executor1);
    }

    public c(Executor executor1)
    {
        super("default");
        eventsToDispatch = new ConcurrentLinkedQueue();
        executor = (Executor)g.a(executor1);
    }

    public c(Executor executor1, i i)
    {
        super(i);
        eventsToDispatch = new ConcurrentLinkedQueue();
        executor = (Executor)g.a(executor1);
    }

    void dispatch(Object obj, f f)
    {
        g.a(obj);
        g.a(f);
        executor.execute(new Runnable(obj, f) {

            final Object a;
            final f b;
            final c c;

            public final void run()
            {
                c.dispatch(a, b);
            }

            
            {
                c = c.this;
                a = obj;
                b = f;
                super();
            }
        });
    }

    protected void dispatchQueuedEvents()
    {
        do
        {
            e.a a = (e.a)eventsToDispatch.poll();
            if (a != null)
            {
                dispatch(a.a, a.b);
            } else
            {
                return;
            }
        } while (true);
    }

    void enqueueEvent(Object obj, f f)
    {
        eventsToDispatch.offer(new e.a(obj, f));
    }

}
