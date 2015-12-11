// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class bqw
    implements bvz
{

    final dga a;
    btk b;
    private final bvz c;
    private List d;

    public bqw(dga dga1, bvz bvz1)
    {
        a = (dga)b.a(dga1);
        c = bvz1;
    }

    public final byte[] a()
    {
        return a.b;
    }

    public final bvz b()
    {
        return c;
    }

    public final List c()
    {
        if (d == null)
        {
            d = new ArrayList(a.a.length);
            dgb adgb[] = a.a;
            int j = adgb.length;
            for (int i = 0; i < j; i++)
            {
                dgb dgb1 = adgb[i];
                if (dgb1.b != null)
                {
                    d.add(new bti(dgb1.b, this));
                }
            }

        }
        return d;
    }
}
