// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.io.IOException;
import java.lang.reflect.Array;

// Referenced classes of package com.google.android.gms.d:
//            lg, lc, kv

public final class kx
{

    protected final int a;
    protected final Class b;
    public final int c;
    protected final boolean d;

    private int b(Object obj)
    {
        int i = lg.b(c);
        switch (a)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Unknown type ")).append(a).toString());

        case 10: // '\n'
            obj = (lc)obj;
            return kv.c(i) * 2 + ((lc) (obj)).f();

        case 11: // '\013'
            return kv.b(i, (lc)obj);
        }
    }

    private void b(Object obj, kv kv1)
    {
        kv1.d(c);
        a;
        JVM INSTR tableswitch 10 11: default 107
    //                   10 73
    //                   11 98;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown type ")).append(a).toString());
_L2:
        try
        {
            obj = (lc)obj;
            int i = lg.b(c);
            ((lc) (obj)).a(kv1);
            kv1.c(i, 4);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalStateException(((Throwable) (obj)));
        }
_L3:
        kv1.a((lc)obj);
        return;
    }

    final int a(Object obj)
    {
        int i = 0;
        int k;
        if (d)
        {
            int l = Array.getLength(obj);
            int j = 0;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                k = i;
                if (Array.get(obj, j) != null)
                {
                    k = i + b(Array.get(obj, j));
                }
                j++;
                i = k;
            } while (true);
        } else
        {
            k = b(obj);
        }
        return k;
    }

    final void a(Object obj, kv kv1)
    {
        if (d)
        {
            int j = Array.getLength(obj);
            for (int i = 0; i < j; i++)
            {
                Object obj1 = Array.get(obj, i);
                if (obj1 != null)
                {
                    b(obj1, kv1);
                }
            }

        } else
        {
            b(obj, kv1);
        }
    }
}
