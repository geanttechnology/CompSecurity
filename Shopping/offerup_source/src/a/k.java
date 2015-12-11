// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;


// Referenced classes of package a:
//            h, g, i

final class k
    implements h
{

    private g a;
    private h b;

    k(i j, g g1, h h1)
    {
        a = g1;
        b = h1;
        super();
    }

    public final Object then(i j)
    {
        if (a != null && a.a())
        {
            return i.f();
        }
        if (j.c())
        {
            return i.a(j.e());
        }
        if (j.b())
        {
            return i.f();
        } else
        {
            return j.a(b);
        }
    }
}
