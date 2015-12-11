// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            ij, mu, g

class ik
    implements Runnable
{

    final boolean a;
    final boolean b;
    final boolean c;
    final boolean d;
    final boolean e;
    final boolean f;
    final ij g;

    ik(ij ij1, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5)
    {
        g = ij1;
        a = flag;
        b = flag1;
        c = flag2;
        d = flag3;
        e = flag4;
        f = flag5;
        super();
    }

    public void run()
    {
        if (g.j instanceof mu)
        {
            ((mu)g.j).a(a, b, c, d);
        }
        if (g.k != null)
        {
            g.k.b(e);
            if (f)
            {
                g.k.j();
            }
        }
    }
}
