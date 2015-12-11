// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class brv extends btq
{

    private final dly a;
    private List b;

    public brv(dxz dxz1, bvz bvz)
    {
        super(dxz1, bvz);
        if (dxz1.b != null)
        {
            dxz1 = dxz1.b.a;
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
                dlz adlz[] = a.a;
                int j = adlz.length;
                int i = 0;
                while (i < j) 
                {
                    dlz dlz1 = adlz[i];
                    if (dlz1.e != null)
                    {
                        b.add(new bru(dlz1.e, this));
                    } else
                    if (dlz1.b != null)
                    {
                        b.add(new brq(dlz1.b, this));
                    } else
                    if (dlz1.c != null)
                    {
                        b.add(new brr(dlz1.c, this));
                    } else
                    if (dlz1.f != null)
                    {
                        b.add(new brs(dlz1.f, this));
                    } else
                    if (dlz1.d != null)
                    {
                        b.add(new brt(dlz1.d, this));
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
