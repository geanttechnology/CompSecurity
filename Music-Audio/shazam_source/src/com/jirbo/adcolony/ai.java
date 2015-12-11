// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            aw, ap, a, ae, 
//            w, av, aj

final class ai
{

    static aw a = new aw();

    static a.g a(ae ae1)
    {
        ae1 = c(ae1);
        if (ae1 == null || !ae1.l())
        {
            return null;
        } else
        {
            return ae1.m();
        }
    }

    static a.g a(String s)
    {
        if (s == null)
        {
            s = null;
        } else
        {
            s = a(new ap(s));
        }
        if (s == null || !s.l())
        {
            return null;
        } else
        {
            return s.m();
        }
    }

    private static a.i a(ap ap1)
    {
        Object obj;
        Object obj1;
        char c2;
        boolean flag1 = true;
        boolean flag = true;
        obj1 = null;
        Object obj2;
        char c1;
        try
        {
            b(ap1);
            c2 = ap1.b();
        }
        // Misplaced declaration of an exception variable
        catch (ap ap1)
        {
            return null;
        }
        if (c2 != '{') goto _L2; else goto _L1
_L1:
        b(ap1);
        if (!ap1.a('{'))
        {
            return null;
        }
        b(ap1);
        obj2 = new a.g();
        if (ap1.a('}'))
        {
            return ((a.i) (obj2));
        }
_L3:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (!ap1.a(','))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        obj = d(ap1);
        b(ap1);
        if (ap1.a(':'))
        {
            break MISSING_BLOCK_LABEL_111;
        }
        ((a.g) (obj2)).b(((String) (obj)), true);
_L4:
        b(ap1);
        flag = false;
          goto _L3
        b(ap1);
        ((a.g) (obj2)).a(((String) (obj)), a(ap1));
          goto _L4
        obj = obj1;
        if (ap1.a('}'))
        {
            return ((a.i) (obj2));
        }
          goto _L5
_L2:
        if (c2 != '[') goto _L7; else goto _L6
_L6:
        b(ap1);
        obj = obj1;
        if (!ap1.a('[')) goto _L5; else goto _L8
_L8:
        b(ap1);
        obj2 = new a.c();
        flag = flag1;
        if (ap1.a(']'))
        {
            return ((a.i) (obj2));
        }
_L10:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        if (!ap1.a(','))
        {
            break; /* Loop/switch isn't completed */
        }
        ((a.c) (obj2)).a(a(ap1));
        b(ap1);
        flag = false;
        if (true) goto _L10; else goto _L9
_L9:
        obj = obj1;
        if (ap1.a(']'))
        {
            return ((a.i) (obj2));
        }
          goto _L5
_L7:
        if (c2 != '-')
        {
            break MISSING_BLOCK_LABEL_247;
        }
        return e(ap1);
        if (c2 < '0' || c2 > '9') goto _L12; else goto _L11
_L11:
        return e(ap1);
_L13:
        ap1 = c(ap1);
        if (ap1.length() == 0)
        {
            return new a.f("");
        }
        c1 = ap1.charAt(0);
        if (c1 != 't')
        {
            break MISSING_BLOCK_LABEL_315;
        }
        if (ap1.equals("true"))
        {
            return a.a;
        }
        if (c1 != 'f')
        {
            break MISSING_BLOCK_LABEL_335;
        }
        if (ap1.equals("false"))
        {
            return a.b;
        }
        if (c1 != 'n')
        {
            break MISSING_BLOCK_LABEL_355;
        }
        if (ap1.equals("null"))
        {
            return a.c;
        }
        return new a.f(ap1);
_L15:
        ap1 = d(ap1);
        if (ap1.length() == 0)
        {
            return new a.f("");
        }
        c1 = ap1.charAt(0);
        if (c1 != 't')
        {
            break MISSING_BLOCK_LABEL_413;
        }
        if (ap1.equals("true"))
        {
            return a.a;
        }
        if (c1 != 'f')
        {
            break MISSING_BLOCK_LABEL_433;
        }
        if (ap1.equals("false"))
        {
            return a.b;
        }
        if (c1 != 'n')
        {
            break MISSING_BLOCK_LABEL_453;
        }
        if (ap1.equals("null"))
        {
            return a.c;
        }
        obj = new a.f(ap1);
_L5:
        return ((a.i) (obj));
_L12:
        if (c2 != '"' && c2 != '\'') goto _L14; else goto _L13
_L14:
        if (c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 == '_')
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (c2 != '$') goto _L5; else goto _L15
    }

    static void a(ae ae1, a.c c1)
    {
        ae1 = ae1.a();
        if (c1 != null)
        {
            c1.a(ae1);
            ae1.b('\n');
        } else
        {
            aj.b.b("Saving empty property list.");
            ae1.b("[]");
        }
        ae1.c();
    }

    static void a(ae ae1, a.g g)
    {
        ae1 = ae1.a();
        g.a(ae1);
        ae1.b('\n');
        ae1.c();
    }

    static a.c b(ae ae1)
    {
        ae1 = c(ae1);
        if (ae1 == null || !ae1.f())
        {
            return null;
        } else
        {
            return ae1.h();
        }
    }

    private static void b(ap ap1)
    {
        for (char c1 = ap1.b(); ap1.a() && (c1 <= ' ' || c1 > '~'); c1 = ap1.b())
        {
            ap1.c();
        }

    }

    private static a.i c(ae ae1)
    {
        ae1 = ae1.b();
        if (ae1 == null)
        {
            return null;
        } else
        {
            return a(ae1);
        }
    }

    private static String c(ap ap1)
    {
        byte byte0;
        byte0 = 34;
        b(ap1);
        break MISSING_BLOCK_LABEL_8;
        if (!ap1.a('"') && ap1.a('\''))
        {
            byte0 = 39;
        }
        if (!ap1.a())
        {
            return "";
        }
        break MISSING_BLOCK_LABEL_43;
        a.c();
        char c1 = ap1.c();
        while (ap1.a() && c1 != byte0) 
        {
            if (c1 == '\\')
            {
                c1 = ap1.c();
                if (c1 == 'b')
                {
                    a.b('\b');
                } else
                if (c1 == 'f')
                {
                    a.b('\f');
                } else
                if (c1 == 'n')
                {
                    a.b('\n');
                } else
                if (c1 == 'r')
                {
                    a.b('\r');
                } else
                if (c1 == 't')
                {
                    a.b('\t');
                } else
                if (c1 == 'u')
                {
                    aw aw1 = a;
                    int j = 0;
                    int k = 0;
                    while (j < 4) 
                    {
                        int i = k;
                        if (ap1.a())
                        {
                            i = ap1.c();
                            if (i >= 48 && i <= 57)
                            {
                                i -= 48;
                            } else
                            if (i >= 97 && i <= 102)
                            {
                                i = (i - 97) + 10;
                            } else
                            if (i >= 65 && i <= 70)
                            {
                                i = (i - 65) + 10;
                            } else
                            {
                                i = 0;
                            }
                            i |= k << 4;
                        }
                        j++;
                        k = i;
                    }
                    aw1.b((char)k);
                } else
                {
                    a.b(c1);
                }
            } else
            {
                a.b(c1);
            }
            c1 = ap1.c();
        }
        return a.toString();
    }

    private static String d(ap ap1)
    {
        b(ap1);
        int i = ap1.b();
        if (i == 34 || i == 39)
        {
            return c(ap1);
        }
        a.c();
        for (boolean flag = false; !flag && ap1.a();)
        {
            if (i >= 97 && i <= 122 || i >= 65 && i <= 90 || i == 95 || i == 36)
            {
                ap1.c();
                a.b((char)i);
                i = ap1.b();
            } else
            {
                flag = true;
            }
        }

        return a.toString();
    }

    private static a.i e(ap ap1)
    {
        double d1;
label0:
        {
            b(ap1);
            double d3 = 1.0D;
            if (ap1.a('-'))
            {
                d3 = -1D;
                b(ap1);
            }
            d1 = 0.0D;
            for (char c1 = ap1.b(); ap1.a() && c1 >= '0' && c1 <= '9'; c1 = ap1.b())
            {
                ap1.c();
                d1 = d1 * 10D + (double)(c1 - 48);
            }

            char c2 = '\0';
            double d2 = d1;
            if (ap1.a('.'))
            {
                double d4 = 0.0D;
                d2 = 0.0D;
                for (c2 = ap1.b(); ap1.a() && c2 >= '0' && c2 <= '9'; c2 = ap1.b())
                {
                    ap1.c();
                    d4 = d4 * 10D + (double)(c2 - 48);
                    d2++;
                }

                d2 = d1 + d4 / Math.pow(10D, d2);
                c2 = '\001';
            }
            if (!ap1.a('e'))
            {
                d1 = d2;
                if (!ap1.a('E'))
                {
                    break label0;
                }
            }
            boolean flag1 = false;
            boolean flag = flag1;
            if (!ap1.a('+'))
            {
                flag = flag1;
                if (ap1.a('-'))
                {
                    flag = true;
                }
            }
            d1 = 0.0D;
            for (char c3 = ap1.b(); ap1.a() && c3 >= '0' && c3 <= '9'; c3 = ap1.b())
            {
                ap1.c();
                d1 = d1 * 10D + (double)(c3 - 48);
            }

            if (flag)
            {
                d1 = d2 / Math.pow(10D, d1);
            } else
            {
                d1 = d2 * Math.pow(10D, d1);
            }
        }
        d1 *= d3;
        if (c2 != 0 || d1 != (double)(int)d1)
        {
            return new a.e(d1);
        } else
        {
            return new a.b((int)d1);
        }
    }

}
