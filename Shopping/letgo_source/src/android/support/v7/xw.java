// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.lang.reflect.Array;

// Referenced classes of package android.support.v7:
//            xu, ya, ye

public class xw
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

    void a(Object obj, xu xu1)
        throws IOException
    {
        if (d)
        {
            c(obj, xu1);
            return;
        } else
        {
            b(obj, xu1);
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

    protected void b(Object obj, xu xu1)
    {
        xu1.e(c);
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
            obj = (ya)obj;
            int i = ye.a(c);
            xu1.a(((ya) (obj)));
            xu1.c(i, 4);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalStateException(((Throwable) (obj)));
        }
_L3:
        xu1.b((ya)obj);
        return;
    }

    protected int c(Object obj)
    {
        int i = ye.a(c);
        switch (a)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown type ").append(a).toString());

        case 10: // '\n'
            return xu.b(i, (ya)obj);

        case 11: // '\013'
            return xu.c(i, (ya)obj);
        }
    }

    protected void c(Object obj, xu xu1)
    {
        int j = Array.getLength(obj);
        for (int i = 0; i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            if (obj1 != null)
            {
                b(obj1, xu1);
            }
        }

    }
}
