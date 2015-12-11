// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bsz
    implements bnj, bvz
{

    public final List a = new ArrayList();
    private final duq b;
    private final int c;

    public bsz(duq duq1)
    {
        b = (duq)b.a(duq1);
        c = duq1.b.length;
        int i = 0;
        while (i < c) 
        {
            Object obj = duq1.b[i].b;
            if (obj != null)
            {
                boolean flag = duq1.f;
                int j = c;
                float f;
                if (flag)
                {
                    f = Math.max(Math.min(1.0F, (float)(j - i) / 5F), 0.0F);
                } else
                {
                    f = 1.0F;
                }
                obj = new bta(((duu) (obj)), f, this);
                a.add(obj);
            }
            i++;
        }
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); bnk1.a())
        {
            bta bta1 = (bta)iterator.next();
        }

    }

    public final byte[] a()
    {
        return b.i;
    }

    public final bvz b()
    {
        return null;
    }
}
