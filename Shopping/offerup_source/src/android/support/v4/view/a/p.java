// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;


// Referenced classes of package android.support.v4.view.a:
//            f, e

public final class p
{

    private final Object a;

    private p(Object obj)
    {
        a = obj;
    }

    public static p a(int i, int j, int k, int l, boolean flag, boolean flag1)
    {
        return new p(f.o().a(i, j, k, l, flag, false));
    }

    static Object a(p p1)
    {
        return p1.a;
    }
}
