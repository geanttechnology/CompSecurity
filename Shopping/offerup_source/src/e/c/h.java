// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.c;


// Referenced classes of package e.c:
//            f, e

final class h
    implements f
{

    private e a;

    h(e e1)
    {
        a = e1;
        super();
    }

    public final transient Object a(Object aobj[])
    {
        if (aobj.length != 2)
        {
            throw new RuntimeException("Func2 expecting 2 arguments.");
        } else
        {
            return a.a(aobj[0], aobj[1]);
        }
    }
}
