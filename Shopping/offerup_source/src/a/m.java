// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;

import java.util.concurrent.CancellationException;

// Referenced classes of package a:
//            g, p, h, i, 
//            n

final class m
    implements Runnable
{

    final g a;
    final p b;
    private h c;
    private i d;

    m(g g1, p p1, h h1, i j)
    {
        a = g1;
        b = p1;
        c = h1;
        d = j;
        super();
    }

    public final void run()
    {
        if (a != null && a.a())
        {
            b.b();
            return;
        }
        Object obj = (i)c.then(d);
        if (obj == null)
        {
            try
            {
                b.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                b.b();
                return;
            }
            catch (Exception exception)
            {
                b.a(exception);
            }
            break MISSING_BLOCK_LABEL_87;
        }
        ((i) (obj)).a(new n(this));
        return;
    }
}
