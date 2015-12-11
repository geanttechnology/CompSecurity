// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.b;
import b.a.a.c;
import b.a.a.d;
import java.util.Map;

// Referenced classes of package b.a.a.d:
//            b, d, e, r, 
//            p, o, c

public final class a
{

    private static final Map a = new b.a.a.d.b();
    private static final b.a.a.d.d b[] = new b.a.a.d.d[25];

    public static b.a.a.d.d a()
    {
        return b();
    }

    public static b.a.a.d.d a(String s)
    {
        return c(s);
    }

    private static String a(String s, int ai[])
    {
        char c1;
        StringBuilder stringbuilder;
        int i;
        int l;
        stringbuilder = new StringBuilder();
        i = ai[0];
        l = s.length();
        c1 = s.charAt(i);
        if ((c1 < 'A' || c1 > 'Z') && (c1 < 'a' || c1 > 'z')) goto _L2; else goto _L1
_L1:
        int j;
        stringbuilder.append(c1);
        do
        {
            j = i;
            if (i + 1 >= l)
            {
                break;
            }
            j = i;
            if (s.charAt(i + 1) != c1)
            {
                break;
            }
            stringbuilder.append(c1);
            i++;
        } while (true);
          goto _L3
_L2:
        int k;
        stringbuilder.append('\'');
        k = 0;
_L7:
        j = i;
        if (i >= l) goto _L3; else goto _L4
_L4:
        c1 = s.charAt(i);
        if (c1 != '\'') goto _L6; else goto _L5
_L5:
        if (i + 1 < l && s.charAt(i + 1) == '\'')
        {
            i++;
            stringbuilder.append(c1);
            j = k;
        } else
        if (k == 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
_L8:
        i++;
        k = j;
          goto _L7
_L6:
        if (k != 0 || (c1 < 'A' || c1 > 'Z') && (c1 < 'a' || c1 > 'z'))
        {
            break MISSING_BLOCK_LABEL_247;
        }
        j = i - 1;
_L3:
        ai[0] = j;
        return stringbuilder.toString();
        stringbuilder.append(c1);
        j = k;
          goto _L8
    }

    private static void a(e e1, String s)
    {
        int ai[];
        int i;
        int i1;
        i1 = s.length();
        ai = new int[1];
        i = 0;
_L23:
        Object obj;
        int l;
        int j1;
        char c1;
        if (i >= i1)
        {
            break MISSING_BLOCK_LABEL_934;
        }
        ai[0] = i;
        obj = a(s, ai);
        j1 = ai[0];
        l = ((String) (obj)).length();
        if (l == 0)
        {
            break MISSING_BLOCK_LABEL_934;
        }
        c1 = ((String) (obj)).charAt(0);
        c1;
        JVM INSTR lookupswitch 22: default 244
    //                   39: 891
    //                   67: 285
    //                   68: 781
    //                   69: 753
    //                   71: 268
    //                   72: 673
    //                   75: 697
    //                   77: 594
    //                   83: 731
    //                   89: 300
    //                   90: 843
    //                   97: 648
    //                   100: 638
    //                   101: 743
    //                   104: 659
    //                   107: 683
    //                   109: 711
    //                   115: 721
    //                   119: 791
    //                   120: 300
    //                   121: 300
    //                   122: 801;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L11 _L11 _L21
_L2:
        break MISSING_BLOCK_LABEL_891;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder("Illegal pattern component: ")).append(((String) (obj))).toString());
_L6:
        e1.a(d.w());
_L24:
        i = j1 + 1;
        if (true) goto _L23; else goto _L22
_L22:
        e1.b(d.v(), l, l);
          goto _L24
_L11:
        if (l == 2)
        {
            boolean flag;
            if (j1 + 1 < i1)
            {
                ai[0] = ai[0] + 1;
                int j;
                int k;
                if (b(a(s, ai)))
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                ai[0] = ai[0] - 1;
            } else
            {
                flag = true;
            }
            switch (c1)
            {
            default:
                obj = new b();
                j = ((b.a.a.a.a) (obj)).b().E().a(((b.a.a.a.a) (obj)).a());
                e1.a(new r(d.s(), j - 30, flag));
                break;

            case 120: // 'x'
                obj = new b();
                j = ((b.a.a.a.a) (obj)).b().z().a(((b.a.a.a.a) (obj)).a());
                e1.a(new r(d.p(), j - 30, flag));
                break;
            }
        } else
        {
            j = 9;
            k = j;
            if (j1 + 1 < i1)
            {
                ai[0] = ai[0] + 1;
                if (b(a(s, ai)))
                {
                    j = l;
                }
                ai[0] = ai[0] - 1;
                k = j;
            }
            switch (c1)
            {
            case 89: // 'Y'
                e1.a(d.t(), l, k);
                break;

            case 120: // 'x'
                e1.b(l, k);
                break;

            case 121: // 'y'
                e1.c(l, k);
                break;
            }
        }
        if (true) goto _L24; else goto _L25
_L25:
_L9:
        if (l >= 3)
        {
            if (l >= 4)
            {
                e1.a(d.r());
            } else
            {
                e1.b(d.r());
            }
        } else
        {
            e1.h(l);
        }
          goto _L24
_L14:
        e1.e(l);
          goto _L24
_L13:
        e1.a(d.k());
          goto _L24
_L16:
        e1.a(d.j(), l, 2);
          goto _L24
_L7:
        e1.c(l);
          goto _L24
_L17:
        e1.a(d.h(), l, 2);
          goto _L24
_L8:
        e1.a(d.i(), l, 2);
          goto _L24
_L18:
        e1.b(l);
          goto _L24
_L19:
        e1.a(l);
          goto _L24
_L10:
        e1.a(l, l);
          goto _L24
_L15:
        e1.d(l);
          goto _L24
_L5:
        if (l >= 4)
        {
            e1.a(d.l());
        } else
        {
            e1.b(d.l());
        }
          goto _L24
_L4:
        e1.f(l);
          goto _L24
_L20:
        e1.g(l);
          goto _L24
_L21:
        if (l >= 4)
        {
            e1.a(new p(0), null);
        } else
        {
            obj = new p(1);
            e1.a(((x) (obj)), ((t) (obj)));
        }
          goto _L24
_L12:
        if (l == 1)
        {
            e1.a("Z", false);
        } else
        if (l == 2)
        {
            e1.a("Z", true);
        } else
        {
            e1.a(o.a, o.a);
        }
          goto _L24
        obj = ((String) (obj)).substring(1);
        if (((String) (obj)).length() == 1)
        {
            e1.a(((String) (obj)).charAt(0));
        } else
        {
            e1.a(new String(((String) (obj))));
        }
          goto _L24
    }

    private static b.a.a.d.d b()
    {
        if (19 >= b.length)
        {
            return c();
        }
        b.a.a.d.d ad[] = b;
        ad;
        JVM INSTR monitorenter ;
        b.a.a.d.d d2 = b[19];
        b.a.a.d.d d1;
        d1 = d2;
        if (d2 != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        d1 = c();
        b[19] = d1;
        ad;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        ad;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static boolean b(String s)
    {
        int i;
        boolean flag;
        flag = true;
        i = s.length();
        if (i <= 0) goto _L2; else goto _L1
_L1:
        s.charAt(0);
        JVM INSTR lookupswitch 19: default 180
    //                   67: 182
    //                   68: 182
    //                   70: 182
    //                   72: 182
    //                   75: 182
    //                   77: 184
    //                   83: 182
    //                   87: 182
    //                   89: 182
    //                   99: 182
    //                   100: 182
    //                   101: 182
    //                   104: 182
    //                   107: 182
    //                   109: 182
    //                   115: 182
    //                   119: 182
    //                   120: 182
    //                   121: 182;
           goto _L2 _L3 _L3 _L3 _L3 _L3 _L4 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3 _L3
_L2:
        flag = false;
_L3:
        return flag;
_L4:
        if (i <= 2)
        {
            return true;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private static b.a.a.d.d c()
    {
        b.a.a.d.c c1 = new b.a.a.d.c();
        return new b.a.a.d.d(c1, c1);
    }

    private static b.a.a.d.d c(String s)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("Invalid pattern specification");
        }
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        b.a.a.d.d d1 = (b.a.a.d.d)a.get(s);
        Object obj;
        obj = d1;
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        obj = new e();
        a(((e) (obj)), s);
        obj = ((e) (obj)).a();
        a.put(s, obj);
        map;
        JVM INSTR monitorexit ;
        return ((b.a.a.d.d) (obj));
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

}
