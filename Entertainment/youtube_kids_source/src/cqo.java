// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.util.concurrent.Executor;

final class cqo
    implements bhv, Runnable
{

    private final Object a;
    private final Object b;
    private final bhv c;
    private Object d;
    private cqn e;

    public cqo(cqn cqn1, Object obj, Object obj1, bhv bhv1)
    {
        e = cqn1;
        super();
        a = obj;
        b = obj1;
        c = bhv1;
    }

    public final void a(Object obj, Exception exception)
    {
        c.a(a, exception);
    }

    public final void a(Object obj, Object obj1)
    {
        d = obj1;
        if (e.a != null)
        {
            if (e.b != null)
            {
                e.b.execute(this);
                return;
            } else
            {
                run();
                return;
            }
        } else
        {
            c.a(a, obj1);
            return;
        }
    }

    public final void run()
    {
        try
        {
            Object obj = e.a.a_(d);
            c.a(a, obj);
            return;
        }
        catch (IOException ioexception)
        {
            e.a(a, b, c, ioexception);
            return;
        }
        catch (bnn bnn1)
        {
            e.a(a, b, c, bnn1);
        }
    }
}
