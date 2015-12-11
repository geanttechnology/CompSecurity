// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;


// Referenced classes of package a:
//            g, h, i, o

final class j
    implements g
{

    final i a;

    j(i k)
    {
        a = k;
        super();
    }

    public final Object then(h h1)
    {
        if (h1.b())
        {
            a.c.a();
        } else
        if (h1.c())
        {
            a.c.a(h1.e());
        } else
        {
            a.c.a(h1.d());
        }
        return null;
    }
}
