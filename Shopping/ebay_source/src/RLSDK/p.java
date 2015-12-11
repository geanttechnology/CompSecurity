// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            o, t, v, ah, 
//            ag

public final class p
{

    private final o a;
    private ah b;

    public p(o o1)
    {
        if (o1 == null)
        {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        } else
        {
            a = o1;
            b = null;
            return;
        }
    }

    public final int a()
    {
        return a.a().b();
    }

    public final ag a(int i, ag ag)
        throws v
    {
        return a.a(i, ag);
    }

    public final int b()
    {
        return a.a().c();
    }

    public final ah c()
        throws v
    {
        if (b == null)
        {
            b = a.b();
        }
        return b;
    }

    public final boolean d()
    {
        a.a();
        return false;
    }
}
