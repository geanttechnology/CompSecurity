// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;


// Referenced classes of package a:
//            g, o, h

final class n
    implements Runnable
{

    final g a;
    final h b;
    final o c;

    n(g g1, h h, o o1)
    {
        a = g1;
        b = h;
        c = o1;
        super();
    }

    public final void run()
    {
        try
        {
            Object obj = a.then(b);
            c.a(obj);
            return;
        }
        catch (Exception exception)
        {
            c.a(exception);
        }
    }
}
