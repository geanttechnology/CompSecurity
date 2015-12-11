// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

public final class day
    implements Iterator
{

    private final CharSequence a;
    private final int b = -1;
    private final boolean c = false;
    private final boolean d = true;
    private int e;
    private int f;
    private int g;

    private day(CharSequence charsequence, int i, boolean flag, boolean flag1)
    {
        a = charsequence;
        a();
    }

    public static day a(CharSequence charsequence)
    {
        return new day(charsequence, -1, false, true);
    }

    private void a()
    {
        boolean flag;
        if (e != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
        if (b == -1)
        {
            if (g == -1)
            {
                e = -1;
            } else
            {
                int i = a.length();
                if (d)
                {
                    e = a.b(a, g, i);
                    if (e != -1)
                    {
                        f = a.a(a, e + 1, i);
                        if (f != -1)
                        {
                            g = f + 1;
                            return;
                        } else
                        {
                            f = i;
                            g = -1;
                            return;
                        }
                    }
                } else
                {
                    e = g;
                    f = a.a(a, g, i);
                    if (f != -1)
                    {
                        g = f + 1;
                        return;
                    } else
                    {
                        f = i;
                        g = -1;
                        return;
                    }
                }
            }
            return;
        }
        char c1 = (char)b;
        int i1 = a.length();
        while (g != -1) 
        {
            int l = g;
            int j;
            for (j = g; j != i1 && a.charAt(j) != c1; j++) { }
            int k;
            if (j == i1)
            {
                k = -1;
            } else
            {
                k = j + 1;
            }
            g = k;
            if (c)
            {
                k = a.b(a, l, j);
                if (k != -1)
                {
                    e = k;
                    f = a.c(a, k, j) + 1;
                    return;
                }
                k = j;
            } else
            {
                k = l;
            }
            if (k != j || !d)
            {
                e = k;
                f = j;
                return;
            }
        }
        e = -1;
    }

    public final boolean hasNext()
    {
        return e != -1;
    }

    public final Object next()
    {
        String s = a.subSequence(e, f).toString();
        a();
        return s;
    }

    public final void remove()
    {
        throw new UnsupportedOperationException();
    }
}
