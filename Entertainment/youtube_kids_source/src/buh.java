// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class buh
    implements bnj, bvz
{

    private final ecq a;
    private final bvz b;
    private List c;
    private List d;

    public buh(ecq ecq1, bvz bvz1)
    {
        a = (ecq)b.a(ecq1);
        b = bvz1;
    }

    private List c()
    {
        if (d == null)
        {
            if (a.b != null)
            {
                ecv aecv[] = a.b.a;
                d = new ArrayList(aecv.length);
                int j = aecv.length;
                for (int i = 0; i < j; i++)
                {
                    ecv ecv = aecv[i];
                    d.add(new buk(ecv));
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
        if (c == null)
        {
            c = new ArrayList(a.a.length);
            ecp aecp[] = a.a;
            int j = aecp.length;
            int i = 0;
            while (i < j) 
            {
                ecp ecp1 = aecp[i];
                if (ecp1.b != null)
                {
                    c.add(new buj(ecp1.b));
                } else
                if (ecp1.c != null)
                {
                    c.add(new bui(ecp1.c));
                }
                i++;
            }
        }
        Iterator iterator = c.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (obj instanceof bnj)
            {
                ((bnj)obj).a(bnk1);
            }
        } while (true);
        for (Iterator iterator1 = c().iterator(); iterator1.hasNext(); ((buk)iterator1.next()).a(bnk1)) { }
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
