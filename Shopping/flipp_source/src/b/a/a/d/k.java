// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.d;

// Referenced classes of package b.a.a.d:
//            t, x, u

abstract class k
    implements t, x
{

    protected final d a;
    protected final int b;
    protected final boolean c;

    k(d d, int i, boolean flag)
    {
        a = d;
        b = i;
        c = flag;
    }

    public int a(u u1, String s, int i)
    {
        int j;
        int l;
        int i1;
        int j1 = Math.min(b, s.length() - i);
        l = 0;
        j = i;
        i1 = 0;
        i = l;
        l = i1;
        do
        {
            i1 = i;
            if (l >= j1)
            {
                break;
            }
            char c1 = s.charAt(j + l);
            if (l == 0 && (c1 == '-' || c1 == '+') && c)
            {
                if (c1 == '-')
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                i1 = i;
                if (l + 1 >= j1)
                {
                    break;
                }
                c1 = s.charAt(j + l + 1);
                i1 = i;
                if (c1 < '0')
                {
                    break;
                }
                i1 = i;
                if (c1 > '9')
                {
                    break;
                }
                if (i != 0)
                {
                    l++;
                } else
                {
                    j++;
                }
                j1 = Math.min(j1 + 1, s.length() - j);
                continue;
            }
            i1 = i;
            if (c1 < '0')
            {
                break;
            }
            i1 = i;
            if (c1 > '9')
            {
                break;
            }
            l++;
        } while (true);
        if (l == 0)
        {
            return ~j;
        }
        if (l < 9) goto _L2; else goto _L1
_L1:
        l = j + l;
        j = Integer.parseInt(s.substring(j, l));
_L4:
        u1.a(a, j);
        return l;
_L2:
        int k1;
        char c2;
        if (i1 != 0)
        {
            i = j + 1;
        } else
        {
            i = j;
        }
        try
        {
            c2 = s.charAt(i);
        }
        // Misplaced declaration of an exception variable
        catch (u u1)
        {
            return ~j;
        }
        k1 = j + l;
        l = c2 - 48;
        j = i + 1;
        i = l;
        for (; j < k1; j++)
        {
            i = ((i << 1) + (i << 3) + s.charAt(j)) - 48;
        }

        j = i;
        l = k1;
        if (i1 != 0)
        {
            j = -i;
            l = k1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final int b()
    {
        return b;
    }
}
