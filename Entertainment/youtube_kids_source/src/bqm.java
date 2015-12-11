// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class bqm
    implements bnj, bvz
{

    private final dev a;
    private final bvz b;
    private bug c;
    private boolean d;
    private List e;
    private List f;
    private List g;

    public bqm(dev dev1, bvz bvz1)
    {
        a = (dev)b.a(dev1);
        b = bvz1;
    }

    private void c()
    {
        e = new ArrayList();
        f = new ArrayList();
        ecr aecr[] = a.c;
        int l = aecr.length;
        for (int i = 0; i < l; i++)
        {
            Object obj = aecr[i];
            if (((ecr) (obj)).c != null)
            {
                obj = ((ecr) (obj)).c;
                byf.a(((ecz) (obj)).a);
                obj = ((ecz) (obj)).b;
                int i1 = obj.length;
                for (int j = 0; j < i1; j++)
                {
                    ecy ecy = obj[j];
                    e.add(new bul(ecy));
                }

                continue;
            }
            if (((ecr) (obj)).b == null)
            {
                continue;
            }
            obj = ((ecr) (obj)).b;
            byf.a(((ecm) (obj)).a);
            ecl aecl[] = ((ecm) (obj)).b;
            int j1 = aecl.length;
            for (int k = 0; k < j1; k++)
            {
                ecl ecl = aecl[k];
                f.add(new buf(ecl));
            }

        }

        d = true;
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        if (c == null)
        {
            c = new bug(a.a.a);
        }
        if (c != null)
        {
            bnk1.a();
        }
        if (!d)
        {
            c();
        }
        for (Iterator iterator = f.iterator(); iterator.hasNext(); bnk1.a())
        {
            buf buf1 = (buf)iterator.next();
        }

        if (!d)
        {
            c();
        }
        for (Iterator iterator1 = e.iterator(); iterator1.hasNext(); bnk1.a())
        {
            bul bul1 = (bul)iterator1.next();
        }

        if (g == null)
        {
            if (a.b != null)
            {
                ecv aecv[] = a.b.a;
                g = new ArrayList(aecv.length);
                int j = aecv.length;
                for (int i = 0; i < j; i++)
                {
                    ecv ecv = aecv[i];
                    g.add(new buk(ecv));
                }

            } else
            {
                g = Collections.emptyList();
            }
        }
        for (Iterator iterator2 = g.iterator(); iterator2.hasNext(); ((buk)iterator2.next()).a(bnk1)) { }
    }

    public final byte[] a()
    {
        return a.d;
    }

    public final bvz b()
    {
        return b;
    }
}
