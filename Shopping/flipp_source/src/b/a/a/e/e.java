// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.e;

import b.a.a.a;
import b.a.a.c;

final class e
{

    final char a;
    final int b;
    final int c;
    final int d;
    final boolean e;
    final int f;

    e(char c1, int i, int j, int k, boolean flag, int l)
    {
        if (c1 != 'u' && c1 != 'w' && c1 != 's')
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown mode: ")).append(c1).toString());
        } else
        {
            a = c1;
            b = i;
            c = j;
            d = k;
            e = flag;
            f = l;
            return;
        }
    }

    private long d(a a1, long l)
    {
        if (c >= 0)
        {
            return a1.u().b(l, c);
        } else
        {
            l = a1.u().b(l, 1);
            l = a1.C().a(l, 1);
            return a1.u().a(l, c);
        }
    }

    final long a(a a1, long l)
    {
        long l1;
        try
        {
            l1 = d(a1, l);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            if (b == 2 && c == 29)
            {
                for (; !a1.E().b(l); l = a1.E().a(l, 1)) { }
                return d(a1, l);
            } else
            {
                throw illegalargumentexception;
            }
        }
        return l1;
    }

    final long b(a a1, long l)
    {
        long l1;
        try
        {
            l1 = d(a1, l);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            if (b == 2 && c == 29)
            {
                for (; !a1.E().b(l); l = a1.E().a(l, -1)) { }
                return d(a1, l);
            } else
            {
                throw illegalargumentexception;
            }
        }
        return l1;
    }

    final long c(a a1, long l)
    {
        int k;
        long l1;
        int i = a1.t().a(l);
        k = d - i;
        l1 = l;
        if (k == 0) goto _L2; else goto _L1
_L1:
        if (!e) goto _L4; else goto _L3
_L3:
        int j;
        j = k;
        if (k < 0)
        {
            j = k + 7;
        }
_L6:
        l1 = a1.t().a(l, j);
_L2:
        return l1;
_L4:
        j = k;
        if (k > 0)
        {
            j = k - 7;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof e)
            {
                if (a != ((e) (obj = (e)obj)).a || b != ((e) (obj)).b || c != ((e) (obj)).c || d != ((e) (obj)).d || e != ((e) (obj)).e || f != ((e) (obj)).f)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }
}
