// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class bue
    implements bnj, bvz
{

    private final ecw a;
    private final bvz b;
    private List c;
    private List d;
    private List e;

    public bue(ecw ecw1, bvz bvz1)
    {
        a = (ecw)b.a(ecw1);
        b = bvz1;
    }

    private List c()
    {
        boolean flag = false;
        if (c == null)
        {
            int i;
            if (a.b != null && a.b.c != null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                ecy aecy[] = a.b.c.b;
                c = new ArrayList(aecy.length);
                int j = aecy.length;
                for (i = ((flag) ? 1 : 0); i < j; i++)
                {
                    ecy ecy = aecy[i];
                    c.add(new bul(ecy));
                }

            } else
            {
                c = Collections.emptyList();
            }
        }
        return c;
    }

    private List d()
    {
        boolean flag = false;
        if (d == null)
        {
            int i;
            if (a.b != null && a.b.b != null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                ecl aecl[] = a.b.b.b;
                d = new ArrayList(aecl.length);
                int j = aecl.length;
                for (i = ((flag) ? 1 : 0); i < j; i++)
                {
                    ecl ecl = aecl[i];
                    d.add(new buf(ecl));
                }

            } else
            {
                d = Collections.emptyList();
            }
        }
        return d;
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        if (e == null)
        {
            if (a.a != null)
            {
                ecv aecv[] = a.a.a;
                e = new ArrayList(aecv.length);
                int j = aecv.length;
                for (int i = 0; i < j; i++)
                {
                    ecv ecv = aecv[i];
                    e.add(new buk(ecv));
                }

            } else
            {
                e = Collections.emptyList();
            }
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext(); ((buk)iterator.next()).a(bnk1)) { }
        for (Iterator iterator1 = c().iterator(); iterator1.hasNext(); ((bul)iterator1.next()).a(bnk1)) { }
        for (Iterator iterator2 = d().iterator(); iterator2.hasNext(); ((buf)iterator2.next()).a(bnk1)) { }
    }

    public final byte[] a()
    {
        return a.c;
    }

    public final bvz b()
    {
        return b;
    }
}
