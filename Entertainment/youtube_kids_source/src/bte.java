// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bte
    implements bnj, bvz
{

    private final duy a;
    private final bvz b;
    private List c;

    public bte(duy duy1, bvz bvz1)
    {
        a = (duy)b.a(duy1);
        b = bvz1;
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        if (c == null)
        {
            c = new ArrayList(a.a.length);
            dva adva[] = a.a;
            int j = adva.length;
            int i = 0;
            while (i < j) 
            {
                dva dva1 = adva[i];
                if (dva1.b != null)
                {
                    c.add(new btd(dva1.b, a.b, a.c, this));
                } else
                if (dva1.c != null)
                {
                    c.add(new bqs(dva1.c, this));
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
