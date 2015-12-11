// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bse
    implements bnj, bvz
{

    private final doj a;
    private final bvz b;
    private List c;

    public bse(doj doj1, bvz bvz1)
    {
        a = (doj)b.a(doj1);
        b = bvz1;
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        if (c == null)
        {
            c = new ArrayList(a.a.length);
            dol adol[] = a.a;
            int j = adol.length;
            for (int i = 0; i < j; i++)
            {
                dol dol1 = adol[i];
                if (dol1.d != null)
                {
                    c.add(new bra(dol1.d, this));
                }
                if (dol1.c != null)
                {
                    c.add(new brd(dol1.c, this));
                }
                if (dol1.b != null)
                {
                    c.add(new brg(dol1.b, this));
                }
                if (dol1.f != null)
                {
                    c.add(new bre(dol1.f, this));
                }
                if (dol1.e != null)
                {
                    c.add(new brf(dol1.e, this));
                }
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
