// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.i;
import java.util.Locale;

// Referenced classes of package b.a.a.d:
//            t, x, u, y

final class q
    implements t, x
{

    private final String a;
    private final String b;
    private final boolean c;
    private final int d;
    private final int e;

    q(String s, String s1, boolean flag, int i)
    {
        a = s;
        b = s1;
        c = flag;
        if (i < 2)
        {
            throw new IllegalArgumentException();
        } else
        {
            d = 2;
            e = i;
            return;
        }
    }

    private static int a(String s, int i, int j)
    {
        j = Math.min(s.length() - i, j);
        int k = 0;
        do
        {
            if (j <= 0)
            {
                break;
            }
            char c1 = s.charAt(i + k);
            if (c1 < '0' || c1 > '9')
            {
                break;
            }
            k++;
            j--;
        } while (true);
        return k;
    }

    public final int a()
    {
        int j = d + 1 << 1;
        int i = j;
        if (c)
        {
            i = j + (d - 1);
        }
        j = i;
        if (a != null)
        {
            j = i;
            if (a.length() > i)
            {
                j = a.length();
            }
        }
        return j;
    }

    public final int a(u u1, String s, int i)
    {
        int j;
        boolean flag;
        boolean flag1;
        int l1;
        int i2;
        int j2;
label0:
        {
            flag1 = false;
            j = s.length() - i;
            if (b == null)
            {
                break label0;
            }
            if (b.length() == 0)
            {
                if (j > 0)
                {
                    char c1 = s.charAt(i);
                    if (c1 == '-' || c1 == '+')
                    {
                        break label0;
                    }
                }
                u1.a(Integer.valueOf(0));
                return i;
            }
            if (s.regionMatches(true, i, b, 0, b.length()))
            {
                u1.a(Integer.valueOf(0));
                return i + b.length();
            }
        }
        if (j <= 1)
        {
            return ~i;
        }
        int k = s.charAt(i);
        if (k == '-')
        {
            flag = true;
        } else
        if (k == '+')
        {
            flag = false;
        } else
        {
            return ~i;
        }
        i++;
        if (a(s, i, 2) < 2)
        {
            return ~i;
        }
        k = b.a.a.d.y.a(s, i);
        if (k > 23)
        {
            return ~i;
        }
        j2 = k * 0x36ee80;
        l1 = j - 1 - 2;
        i2 = i + 2;
        i = i2;
        j = j2;
        if (l1 <= 0) goto _L2; else goto _L1
_L1:
        int k2 = s.charAt(i2);
        if (k2 != ':') goto _L4; else goto _L3
_L3:
        int l;
        l1--;
        l = i2 + 1;
        flag1 = true;
_L10:
        i2 = a(s, l, 2);
        if (i2 != 0) goto _L6; else goto _L5
_L5:
        i = l;
        j = j2;
        if (!flag1) goto _L2; else goto _L6
_L6:
        if (i2 < 2)
        {
            return ~l;
        }
        i = b.a.a.d.y.a(s, l);
        if (i > 59)
        {
            return ~l;
        }
        j2 += i * 60000;
        k2 = l1 - 2;
        i2 = l + 2;
        i = i2;
        j = j2;
          goto _L7
_L4:
        i = i2;
        j = j2;
        if (k2 < '0') goto _L2; else goto _L8
_L8:
        l = i2;
        if (k2 <= '9') goto _L10; else goto _L9
_L9:
        j = j2;
        i = i2;
_L2:
        l = j;
        j = i;
        i = l;
_L14:
        if (flag)
        {
            i = -i;
        }
        u1.a(Integer.valueOf(i));
        return j;
_L7:
        if (k2 <= 0) goto _L2; else goto _L11
_L11:
        l1 = k2;
        l = i2;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_437;
        }
        i = i2;
        j = j2;
        if (s.charAt(i2) != ':') goto _L2; else goto _L12
_L12:
        l1 = k2 - 1;
        l = i2 + 1;
        i2 = a(s, l, 2);
        if (i2 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = l;
        j = j2;
        if (!flag1) goto _L2; else goto _L13
_L13:
label1:
        {
            if (i2 < 2)
            {
                return ~l;
            }
            i = b.a.a.d.y.a(s, l);
            if (i > 59)
            {
                return ~l;
            }
            i2 = j2 + i * 1000;
            l += 2;
            i = l;
            if (l1 - 2 <= 0)
            {
                break label1;
            }
            j = l;
            if (flag1)
            {
                if (s.charAt(l) != '.')
                {
                    i = l;
                    if (s.charAt(l) != ',')
                    {
                        break label1;
                    }
                }
                j = l + 1;
            }
            l1 = a(s, j, 3);
            if (l1 == 0)
            {
                i = j;
                if (!flag1)
                {
                    break label1;
                }
            }
            if (l1 <= 0)
            {
                return ~j;
            }
            int k1 = j + 1;
            i = (s.charAt(j) - 48) * 100 + i2;
            if (l1 > 1)
            {
                int i1 = k1 + 1;
                k1 = (s.charAt(k1) - 48) * 10 + i;
                i = k1;
                j = i1;
                if (l1 > 2)
                {
                    i = k1 + (s.charAt(i1) - 48);
                    j = i1 + 1;
                }
            } else
            {
                j = k1;
            }
        }
          goto _L14
        j = i2;
        int j1 = i;
        i = j;
        j = j1;
          goto _L14
    }

    public final void a(StringBuffer stringbuffer, long l, a a1, int i, i j, Locale locale)
    {
        if (j != null)
        {
            if (i == 0 && a != null)
            {
                stringbuffer.append(a);
                return;
            }
            int k;
            if (i >= 0)
            {
                stringbuffer.append('+');
            } else
            {
                stringbuffer.append('-');
                i = -i;
            }
            k = i / 0x36ee80;
            b.a.a.d.y.a(stringbuffer, k, 2);
            if (e != 1)
            {
                i -= k * 0x36ee80;
                if (i != 0 || d > 1)
                {
                    int i1 = i / 60000;
                    if (c)
                    {
                        stringbuffer.append(':');
                    }
                    b.a.a.d.y.a(stringbuffer, i1, 2);
                    if (e != 2)
                    {
                        i -= i1 * 60000;
                        if (i != 0 || d > 2)
                        {
                            int j1 = i / 1000;
                            if (c)
                            {
                                stringbuffer.append(':');
                            }
                            b.a.a.d.y.a(stringbuffer, j1, 2);
                            if (e != 3)
                            {
                                i -= j1 * 1000;
                                if (i != 0 || d > 3)
                                {
                                    if (c)
                                    {
                                        stringbuffer.append('.');
                                    }
                                    b.a.a.d.y.a(stringbuffer, i, 3);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(StringBuffer stringbuffer, aa aa, Locale locale)
    {
    }

    public final int b()
    {
        return a();
    }
}
