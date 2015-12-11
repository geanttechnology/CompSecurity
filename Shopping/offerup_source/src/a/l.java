// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;

import java.util.concurrent.CancellationException;

// Referenced classes of package a:
//            g, p, h, i

final class l
    implements Runnable
{

    private g a;
    private p b;
    private h c;
    private i d;

    l(g g1, p p1, h h1, i i)
    {
        a = g1;
        b = p1;
        c = h1;
        d = i;
        super();
    }

    public final void run()
    {
        if (a != null && a.a())
        {
            b.b();
            return;
        }
        try
        {
            Object obj = c.then(d);
            b.a(obj);
            return;
        }
        catch (CancellationException cancellationexception)
        {
            b.b();
            return;
        }
        catch (Exception exception)
        {
            b.a(exception);
        }
    }
}
