// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            g, s

class h
    implements Runnable
{

    final boolean a;
    final g b;

    h(g g1, boolean flag)
    {
        b = g1;
        a = flag;
        super();
    }

    public void run()
    {
        g.e(b).a(a);
    }
}
