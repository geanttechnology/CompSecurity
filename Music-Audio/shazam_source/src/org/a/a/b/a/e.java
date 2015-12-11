// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.b.a;

import java.io.Serializable;
import java.text.DateFormat;

public final class e
    implements Serializable, Comparable
{

    public final long a;
    DateFormat b;

    public e(long l)
    {
        a = l;
    }

    public static long a(long l)
    {
        long l1 = l >>> 32 & 0xffffffffL;
        l = Math.round(((double)(0xffffffffL & l) * 1000D) / 4294967296D);
        if ((0x80000000L & l1) == 0L)
        {
            return l1 * 1000L + 0x1e5ae01dc00L + l;
        } else
        {
            return (l1 * 1000L - 0x20251fe2400L) + l;
        }
    }

    public static e a()
    {
        long l = System.currentTimeMillis();
        boolean flag;
        long l1;
        long l2;
        if (l < 0x1e5ae01dc00L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            l += 0x20251fe2400L;
        } else
        {
            l -= 0x1e5ae01dc00L;
        }
        l1 = l / 1000L;
        l2 = ((l % 1000L) * 0x100000000L) / 1000L;
        if (flag)
        {
            l = 0x80000000L | l1;
        } else
        {
            l = l1;
        }
        return new e(l << 32 | l2);
    }

    private static void a(StringBuilder stringbuilder, long l)
    {
        String s = Long.toHexString(l);
        for (int i = s.length(); i < 8; i++)
        {
            stringbuilder.append('0');
        }

        stringbuilder.append(s);
    }

    public final volatile int compareTo(Object obj)
    {
        obj = (e)obj;
        long l = a;
        long l1 = ((e) (obj)).a;
        if (l < l1)
        {
            return -1;
        }
        return l != l1 ? 1 : 0;
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof e)
        {
            flag = flag1;
            if (a == ((e)obj).a)
            {
                flag = true;
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return (int)(a ^ a >>> 32);
    }

    public final String toString()
    {
        long l = a;
        StringBuilder stringbuilder = new StringBuilder();
        a(stringbuilder, l >>> 32 & 0xffffffffL);
        stringbuilder.append('.');
        a(stringbuilder, l & 0xffffffffL);
        return stringbuilder.toString();
    }
}
