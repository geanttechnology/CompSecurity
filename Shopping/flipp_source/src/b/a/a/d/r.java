// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.c;
import b.a.a.d;
import b.a.a.i;
import java.util.Locale;

// Referenced classes of package b.a.a.d:
//            t, x, u, y

final class r
    implements t, x
{

    private final d a;
    private final int b;
    private final boolean c;

    r(d d1, int i, boolean flag)
    {
        a = d1;
        b = i;
        c = flag;
    }

    private int a(long l, a a1)
    {
        int i;
        int j;
        try
        {
            j = a.a(a1).a(l);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            return -1;
        }
        i = j;
        if (j < 0)
        {
            i = -j;
        }
        return i % 100;
    }

    private int a(aa aa1)
    {
        if (!aa1.b(a))
        {
            break MISSING_BLOCK_LABEL_39;
        }
        int j = aa1.a(a);
        int i = j;
        if (j < 0)
        {
            i = -j;
        }
        return i % 100;
        aa1;
        return -1;
    }

    public final int a()
    {
        return 2;
    }

    public final int a(u u1, String s, int i)
    {
        int i1;
        int k1;
        k1 = 0;
        i1 = s.length() - i;
        if (c) goto _L2; else goto _L1
_L1:
        int l;
        l = i;
        if (Math.min(2, i1) < 2)
        {
            return ~i;
        }
          goto _L3
_L2:
        boolean flag;
        int k;
        k = 0;
        flag = false;
        l = 0;
        do
        {
            if (k >= i1)
            {
                break;
            }
            char c1 = s.charAt(i + k);
            if (k == 0 && (c1 == '-' || c1 == '+'))
            {
                if (c1 == '-')
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    k++;
                    l = 1;
                } else
                {
                    i++;
                    l = 1;
                    i1--;
                }
                continue;
            }
            if (c1 < '0' || c1 > '9')
            {
                break;
            }
            k++;
        } while (true);
        if (k == 0)
        {
            return ~i;
        }
        if (l != 0) goto _L5; else goto _L4
_L4:
        l = i;
        if (k == 2) goto _L3; else goto _L5
_L5:
        if (k < 9) goto _L7; else goto _L6
_L6:
        l = i + k;
        k = Integer.parseInt(s.substring(i, l));
_L8:
        u1.a(a, k);
        return l;
_L7:
        int j;
        int j1;
        if (flag)
        {
            l = i + 1;
        } else
        {
            l = i;
        }
        k1 = l + 1;
        try
        {
            l = s.charAt(l);
        }
        // Misplaced declaration of an exception variable
        catch (u u1)
        {
            return ~i;
        }
        l -= 48;
        j1 = i + k;
        k = k1;
        i = l;
        for (; k < j1; k++)
        {
            i = ((i << 1) + (i << 3) + s.charAt(k)) - 48;
        }

        k = i;
        l = j1;
        if (flag)
        {
            k = -i;
            l = j1;
        }
        if (true) goto _L8; else goto _L3
_L3:
        i = s.charAt(l);
        if (i < 48 || i > 57)
        {
            return ~l;
        }
        i -= 48;
        j = s.charAt(l + 1);
        if (j < '0' || j > '9')
        {
            return ~l;
        }
        k = ((i << 1) + (i << 3) + j) - 48;
        i = b;
        if (u1.e != null)
        {
            i = u1.e.intValue();
        }
        j1 = i - 50;
        if (j1 >= 0)
        {
            i = j1 % 100;
        } else
        {
            i = (j1 + 1) % 100 + 99;
        }
        j = k1;
        if (k < i)
        {
            j = 100;
        }
        u1.a(a, ((j + j1) - i) + k);
        return l + 2;
    }

    public final void a(StringBuffer stringbuffer, long l, a a1, int i, i j, Locale locale)
    {
        i = a(l, a1);
        if (i < 0)
        {
            stringbuffer.append('\uFFFD');
            stringbuffer.append('\uFFFD');
            return;
        } else
        {
            b.a.a.d.y.a(stringbuffer, i, 2);
            return;
        }
    }

    public final void a(StringBuffer stringbuffer, aa aa1, Locale locale)
    {
        int i = a(aa1);
        if (i < 0)
        {
            stringbuffer.append('\uFFFD');
            stringbuffer.append('\uFFFD');
            return;
        } else
        {
            b.a.a.d.y.a(stringbuffer, i, 2);
            return;
        }
    }

    public final int b()
    {
        return !c ? 2 : 4;
    }
}
