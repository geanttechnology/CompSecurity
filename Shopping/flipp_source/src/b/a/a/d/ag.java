// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;


// Referenced classes of package b.a.a.d:
//            al, am, af, ai

final class ag
    implements al, am
{

    final int a;
    private final int b;
    private final int c;
    private final int d;
    private final boolean e;
    private final ag f[];
    private final ai g;
    private final ai h;

    ag(int i, int j, int k, boolean flag, int l, ag aag[], ai ai)
    {
        b = i;
        c = j;
        d = k;
        e = flag;
        a = l;
        f = aag;
        g = ai;
        h = null;
    }

    ag(ag ag1, ai ai)
    {
        b = ag1.b;
        c = ag1.c;
        d = ag1.d;
        e = ag1.e;
        a = ag1.a;
        f = ag1.f;
        g = ag1.g;
        Object obj = ai;
        if (ag1.h != null)
        {
            obj = new af(ag1.h, ai);
        }
        h = ((ai) (obj));
    }
}
