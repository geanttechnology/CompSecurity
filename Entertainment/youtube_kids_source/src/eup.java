// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;

public final class eup
{

    public static final int a[] = new int[0];
    public static final long b[] = new long[0];
    public static final double c[] = new double[0];
    public static final String d[] = new String[0];
    public static final byte e[][] = new byte[0][];
    public static final byte f[] = new byte[0];

    static int a(int i)
    {
        return i & 7;
    }

    static int a(int i, int j)
    {
        return i << 3 | j;
    }

    public static final int a(eui eui1, int i)
    {
        int j = 1;
        int l = eui1.k();
        eui1.b(i);
        do
        {
            int k;
            if (eui1.d == 0x7fffffff)
            {
                k = -1;
            } else
            {
                k = eui1.c;
                k = eui1.d - k;
            }
            if (k > 0 && eui1.a() == i)
            {
                eui1.b(i);
                j++;
            } else
            {
                if (l > eui1.c - eui1.b)
                {
                    i = eui1.c;
                    j = eui1.b;
                    throw new IllegalArgumentException((new StringBuilder(50)).append("Position ").append(l).append(" is beyond current ").append(i - j).toString());
                }
                if (l < 0)
                {
                    throw new IllegalArgumentException((new StringBuilder(24)).append("Bad position ").append(l).toString());
                } else
                {
                    eui1.c = eui1.b + l;
                    return j;
                }
            }
        } while (true);
    }

    public static int a(List list)
    {
        if (list == null)
        {
            return 0;
        }
        list = list.iterator();
        euo euo1;
        int i;
        int j;
        for (i = 0; list.hasNext(); i = euo1.b.length + (i + j))
        {
            euo1 = (euo)list.next();
            j = euj.c(euo1.a);
        }

        return i;
    }

    public static void a(List list, euj euj1)
    {
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                euo euo1 = (euo)list.next();
                euj1.e(euo1.a >>> 3, euo1.a & 7);
                euj1.b(euo1.b);
            }
        }
    }

    public static boolean a(List list, eui eui1, int i)
    {
        int j = eui1.k();
        if (!eui1.b(i))
        {
            return false;
        }
        int k = eui1.k() - j;
        if (k == 0)
        {
            eui1 = f;
        } else
        {
            byte abyte0[] = new byte[k];
            int l = eui1.b;
            System.arraycopy(eui1.a, j + l, abyte0, 0, k);
            eui1 = abyte0;
        }
        list.add(new euo(i, eui1));
        return true;
    }

    public static int b(int i)
    {
        return i >>> 3;
    }

}
