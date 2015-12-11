// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.e;

import e.b.g;
import e.b.h;
import e.f.d;
import e.j;
import java.io.PrintStream;
import java.util.Arrays;

public final class a extends j
{

    private final j a;
    private boolean b;

    public a(j j1)
    {
        super(j1);
        b = false;
        a = j1;
    }

    private void b(Throwable throwable)
    {
        try
        {
            d.a().b();
        }
        catch (Throwable throwable1)
        {
            c(throwable1);
        }
        try
        {
            a.a(throwable);
        }
        catch (Throwable throwable2)
        {
            if (throwable2 instanceof h)
            {
                try
                {
                    b();
                }
                // Misplaced declaration of an exception variable
                catch (Throwable throwable2)
                {
                    try
                    {
                        d.a().b();
                    }
                    catch (Throwable throwable4)
                    {
                        c(throwable4);
                    }
                    throw new RuntimeException("Observer.onError not implemented and error while unsubscribing.", new e.b.a(Arrays.asList(new Throwable[] {
                        throwable, throwable2
                    }), (byte)0));
                }
                throw (h)throwable2;
            }
            try
            {
                d.a().b();
            }
            catch (Throwable throwable5)
            {
                c(throwable5);
            }
            try
            {
                b();
            }
            catch (Throwable throwable6)
            {
                try
                {
                    d.a().b();
                }
                catch (Throwable throwable7)
                {
                    c(throwable7);
                }
                throw new g("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new e.b.a(Arrays.asList(new Throwable[] {
                    throwable, throwable2, throwable6
                }), (byte)0));
            }
            throw new g("Error occurred when trying to propagate error to Observer.onError", new e.b.a(Arrays.asList(new Throwable[] {
                throwable, throwable2
            }), (byte)0));
        }
        try
        {
            b();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable) { }
        try
        {
            d.a().b();
        }
        catch (Throwable throwable3)
        {
            c(throwable3);
        }
        throw new g(throwable);
    }

    private static void c(Throwable throwable)
    {
        System.err.println((new StringBuilder("RxJavaErrorHandler threw an Exception. It shouldn't. => ")).append(throwable.getMessage()).toString());
        throwable.printStackTrace();
    }

    public final void a()
    {
        if (b)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        b = true;
        a.a();
        b();
        return;
        Object obj;
        obj;
        android.support.v4.e.a.a(((Throwable) (obj)));
        b(((Throwable) (obj)));
        b();
        return;
        obj;
        b();
        throw obj;
    }

    public final void a(Object obj)
    {
        try
        {
            if (!b)
            {
                a.a(obj);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            android.support.v4.e.a.a(((Throwable) (obj)));
        }
        a(((Throwable) (obj)));
    }

    public final void a(Throwable throwable)
    {
        android.support.v4.e.a.a(throwable);
        if (!b)
        {
            b = true;
            b(throwable);
        }
    }
}
