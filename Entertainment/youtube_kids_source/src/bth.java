// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class bth
    implements bnj, bvz
{

    private final dvp a;
    private final bvz b;
    private List c;

    public bth(dvp dvp1, bvz bvz1)
    {
        a = (dvp)b.a(dvp1);
        b = bvz1;
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        Iterator iterator;
        if (c == null)
        {
            if (a.a.length == 0)
            {
                c = Collections.emptyList();
            } else
            {
                c = new ArrayList();
                dvq advq[] = a.a;
                int j = advq.length;
                int i = 0;
                while (i < j) 
                {
                    dvo dvo1 = advq[i].b;
                    if (dvo1 != null && dvo1.a != null && dvo1.b != null)
                    {
                        c.add(new btg(dvo1));
                    }
                    i++;
                }
            }
        }
        for (iterator = c.iterator(); iterator.hasNext(); ((btg)iterator.next()).a(bnk1)) { }
    }

    public final byte[] a()
    {
        return a.b;
    }

    public final bvz b()
    {
        return b;
    }
}
