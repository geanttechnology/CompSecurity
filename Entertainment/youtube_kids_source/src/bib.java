// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.LinkedBlockingQueue;

public abstract class bib
    implements bhv
{

    private static final LinkedBlockingQueue a = new LinkedBlockingQueue();
    private final bhv b;

    public bib(bhv bhv1)
    {
        b = (bhv)b.a(bhv1);
    }

    private static bic a()
    {
        bic bic1 = (bic)a.poll();
        if (bic1 != null)
        {
            return bic1;
        } else
        {
            return new bic();
        }
    }

    static void a(bic bic1)
    {
        try
        {
            a.put(bic1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (bic bic1)
        {
            bmo.b("Interrupted when releasing runnable to the queue", bic1);
        }
    }

    public final void a(Object obj, Exception exception)
    {
        bic bic1 = a();
        bic1.a = b;
        bic1.b = obj;
        bic1.d = exception;
        bic1.c = null;
        bic1.e = false;
        a(((Runnable) (bic1)));
    }

    public final void a(Object obj, Object obj1)
    {
        bic bic1 = a();
        bic1.a = b;
        bic1.b = obj;
        bic1.c = obj1;
        bic1.d = null;
        bic1.e = true;
        a(((Runnable) (bic1)));
    }

    protected abstract void a(Runnable runnable);

}
