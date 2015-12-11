// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.c;
import b.a.a.c.j;
import b.a.a.d;
import b.a.a.l;
import java.io.IOException;
import java.util.Locale;

// Referenced classes of package b.a.a.d:
//            t, x, e, u, 
//            v

final class i
    implements t, x
{

    protected int a;
    protected int b;
    private final d c;

    protected i(d d1, int k, int i1)
    {
        c = d1;
        int j1 = i1;
        if (i1 > 18)
        {
            j1 = 18;
        }
        a = k;
        b = j1;
    }

    private void a(StringBuffer stringbuffer, long l1, a a1)
    {
        int k;
        a1 = c.a(a1);
        k = a;
        long l2 = a1.i(l1);
        if (l2 != 0L) goto _L2; else goto _L1
_L1:
        int i1 = k;
        if (stringbuffer == null) goto _L4; else goto _L3
_L3:
        do
        {
            k--;
            if (k < 0)
            {
                break;
            }
            stringbuffer.append('0');
        } while (true);
          goto _L5
        a1;
        i1 = k;
        if (stringbuffer == null) goto _L7; else goto _L6
_L6:
        b.a.a.d.e.a(stringbuffer, k);
_L5:
        return;
_L7:
        k = i1 - 1;
        if (k < 0) goto _L5; else goto _L8
_L8:
        throw new NullPointerException();
_L4:
        k = i1 - 1;
        if (k < 0) goto _L5; else goto _L9
_L9:
        throw new NullPointerException();
_L2:
        long l3;
        l3 = a1.d().d();
        i1 = b;
_L31:
        i1;
        JVM INSTR tableswitch 1 18: default 220
    //                   1 243
    //                   2 250
    //                   3 257
    //                   4 264
    //                   5 271
    //                   6 278
    //                   7 285
    //                   8 292
    //                   9 299
    //                   10 306
    //                   11 313
    //                   12 320
    //                   13 327
    //                   14 334
    //                   15 341
    //                   16 348
    //                   17 355
    //                   18 362;
           goto _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28
_L10:
        l1 = 1L;
_L32:
        if ((l3 * l1) / l1 == l3) goto _L30; else goto _L29
_L29:
        i1--;
          goto _L31
_L11:
        l1 = 10L;
          goto _L32
_L12:
        l1 = 100L;
          goto _L32
_L13:
        l1 = 1000L;
          goto _L32
_L14:
        l1 = 10000L;
          goto _L32
_L15:
        l1 = 0x186a0L;
          goto _L32
_L16:
        l1 = 0xf4240L;
          goto _L32
_L17:
        l1 = 0x989680L;
          goto _L32
_L18:
        l1 = 0x5f5e100L;
          goto _L32
_L19:
        l1 = 0x3b9aca00L;
          goto _L32
_L20:
        l1 = 0x2540be400L;
          goto _L32
_L21:
        l1 = 0x174876e800L;
          goto _L32
_L22:
        l1 = 0xe8d4a51000L;
          goto _L32
_L23:
        l1 = 0x9184e72a000L;
          goto _L32
_L24:
        l1 = 0x5af3107a4000L;
          goto _L32
_L25:
        l1 = 0x38d7ea4c68000L;
          goto _L32
_L26:
        l1 = 0x2386f26fc10000L;
          goto _L32
_L27:
        l1 = 0x16345785d8a0000L;
          goto _L32
_L28:
        l1 = 0xde0b6b3a7640000L;
          goto _L32
_L30:
        int j2;
        a1 = new long[2];
        a1[0] = (l1 * l2) / l3;
        a1[1] = i1;
        l1 = a1[0];
        int k1 = (int)a1[1];
        if ((0x7fffffffL & l1) == l1)
        {
            a1 = Integer.toString((int)l1);
        } else
        {
            a1 = Long.toString(l1);
        }
        j2 = a1.length();
        i1 = k;
        for (k = k1; j2 < k;)
        {
            if (stringbuffer != null)
            {
                stringbuffer.append('0');
                k--;
                i1--;
            } else
            {
                throw new NullPointerException();
            }
        }

        if (i1 >= k) goto _L34; else goto _L33
_L33:
        int i2 = k;
        for (k = j2; i1 < i2 && k > 1 && a1.charAt(k - 1) == '0'; i2--)
        {
            k--;
        }

        if (k >= a1.length()) goto _L34; else goto _L35
_L35:
        if (stringbuffer == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        int j1 = 0;
        while (j1 < k) 
        {
            stringbuffer.append(a1.charAt(j1));
            j1++;
        }
          goto _L5
        if (k >= 0) goto _L5; else goto _L36
_L36:
        a1.charAt(0);
        throw new NullPointerException();
_L34:
        if (stringbuffer != null)
        {
            stringbuffer.append(a1);
            return;
        } else
        {
            throw new NullPointerException();
        }
    }

    public final int a()
    {
        return b;
    }

    public final int a(u u1, String s, int k)
    {
        c c1 = c.a(u1.a);
        int j1 = Math.min(b, s.length() - k);
        long l1 = 0L;
        long l2 = c1.d().d() * 10L;
        int i1 = 0;
        do
        {
            if (i1 >= j1)
            {
                break;
            }
            char c2 = s.charAt(k + i1);
            if (c2 < '0' || c2 > '9')
            {
                break;
            }
            i1++;
            l2 /= 10L;
            l1 += (long)(c2 - 48) * l2;
        } while (true);
        l1 /= 10L;
        if (i1 == 0)
        {
            return ~k;
        }
        if (l1 > 0x7fffffffL)
        {
            return ~k;
        } else
        {
            u1.a(new v(new b.a.a.c.l(d.a(), j.a, c1.d()), (int)l1));
            return i1 + k;
        }
    }

    public final void a(StringBuffer stringbuffer, long l1, a a1, int k, b.a.a.i i1, Locale locale)
    {
        try
        {
            a(stringbuffer, l1, a1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (StringBuffer stringbuffer)
        {
            return;
        }
    }

    public final void a(StringBuffer stringbuffer, aa aa1, Locale locale)
    {
        long l1 = aa1.a().a(aa1, 0L);
        try
        {
            a(stringbuffer, l1, aa1.a());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (StringBuffer stringbuffer)
        {
            return;
        }
    }

    public final int b()
    {
        return b;
    }
}
