// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;


// Referenced classes of package a:
//            g, h

public final class m
    implements g
{

    final g a;
    final h b;

    public m(h h1, g g1)
    {
        b = h1;
        a = g1;
        super();
    }

    public final Object then(h h1)
    {
        if (h1.c())
        {
            return h.a(h1.e());
        }
        if (h1.b())
        {
            return h.f();
        } else
        {
            return h1.a(a);
        }
    }
}
