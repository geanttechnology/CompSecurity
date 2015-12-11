// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;


// Referenced classes of package a:
//            g, h, o, j

final class i
    implements Runnable
{

    final g a;
    final h b;
    final o c;

    i(g g1, h h1, o o1)
    {
        a = g1;
        b = h1;
        c = o1;
        super();
    }

    public final void run()
    {
        h h1 = (h)a.then(b);
        if (h1 == null)
        {
            try
            {
                c.a(null);
                return;
            }
            catch (Exception exception)
            {
                c.a(exception);
            }
            break MISSING_BLOCK_LABEL_53;
        }
        h1.a(new j(this));
        return;
    }
}
