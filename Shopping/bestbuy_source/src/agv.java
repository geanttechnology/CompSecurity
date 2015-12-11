// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.lang.reflect.Array;

public class agv
{

    protected final int a;
    protected final Class b;
    public final int c;
    protected final boolean d;

    int a(Object obj)
    {
        if (d)
        {
            return b(obj);
        } else
        {
            return c(obj);
        }
    }

    void a(Object obj, ags ags1)
    {
        if (d)
        {
            c(obj, ags1);
            return;
        } else
        {
            b(obj, ags1);
            return;
        }
    }

    protected int b(Object obj)
    {
        int j = 0;
        int l = Array.getLength(obj);
        for (int i = 0; i < l;)
        {
            int k = j;
            if (Array.get(obj, i) != null)
            {
                k = j + c(Array.get(obj, i));
            }
            i++;
            j = k;
        }

        return j;
    }

    protected void b(Object obj, ags ags1)
    {
        ags1.g(c);
        a;
        JVM INSTR tableswitch 10 11: default 110
    //                   10 76
    //                   11 101;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown type ").append(a).toString());
_L2:
        try
        {
            obj = (aha)obj;
            int i = ahd.b(c);
            ags1.a(((aha) (obj)));
            ags1.e(i, 4);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalStateException(((Throwable) (obj)));
        }
_L3:
        ags1.b((aha)obj);
        return;
    }

    protected int c(Object obj)
    {
        int i = ahd.b(c);
        switch (a)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown type ").append(a).toString());

        case 10: // '\n'
            return ags.b(i, (aha)obj);

        case 11: // '\013'
            return ags.c(i, (aha)obj);
        }
    }

    protected void c(Object obj, ags ags1)
    {
        int j = Array.getLength(obj);
        for (int i = 0; i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            if (obj1 != null)
            {
                b(obj1, ags1);
            }
        }

    }
}
