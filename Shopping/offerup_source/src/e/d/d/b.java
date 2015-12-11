// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d;

import e.c.a;
import java.util.Queue;

// Referenced classes of package e.d.d:
//            a

final class b
    implements a
{

    private int a;
    private int b;
    private e.d.d.a c;

    b(e.d.d.a a1, int i, int j)
    {
        c = a1;
        a = i;
        b = j;
        super();
    }

    public final void a()
    {
        int k = 0;
        int i = 0;
        int l = e.d.d.a.a(c).size();
        if (l < a)
        {
            for (k = b; i < k - l; i++)
            {
                e.d.d.a.a(c).add(c.b());
            }

        } else
        if (l > b)
        {
            int i1 = b;
            for (int j = k; j < l - i1; j++)
            {
                e.d.d.a.a(c).poll();
            }

        }
    }
}
