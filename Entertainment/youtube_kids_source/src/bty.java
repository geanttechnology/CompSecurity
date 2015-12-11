// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bty extends btq
{

    private final eax a;
    private List b;

    public bty(dxz dxz1, bvz bvz)
    {
        super(dxz1, bvz);
        if (dxz1.b != null)
        {
            dxz1 = dxz1.b.b;
        } else
        {
            dxz1 = null;
        }
        a = dxz1;
    }

    public final List d()
    {
        if (b == null)
        {
            if (a != null && a.a.length > 0)
            {
                b = new ArrayList(a.a.length);
                eaz aeaz[] = a.a;
                int j = aeaz.length;
                int i = 0;
                while (i < j) 
                {
                    eaz eaz1 = aeaz[i];
                    if (eaz1.c != null)
                    {
                        b.add(new brd(eaz1.c, this));
                    } else
                    if (eaz1.b != null)
                    {
                        b.add(new brg(eaz1.b, this));
                    } else
                    if (eaz1.g != null)
                    {
                        b.add(new bre(eaz1.g, this));
                    } else
                    if (eaz1.d != null)
                    {
                        b.add(new bra(eaz1.d, this));
                    } else
                    if (eaz1.e != null)
                    {
                        b.add(new brf(eaz1.e, this));
                    } else
                    if (eaz1.f != null)
                    {
                        b.add(new bqs(eaz1.f, this));
                    } else
                    if (eaz1.h != null)
                    {
                        b.add(new bqq(eaz1.h, this));
                    } else
                    if (eaz1.i != null)
                    {
                        b.add(new bsa(eaz1.i, this));
                    }
                    i++;
                }
            } else
            {
                b = Collections.emptyList();
            }
        }
        return b;
    }
}
