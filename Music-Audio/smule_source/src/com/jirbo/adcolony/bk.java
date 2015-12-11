// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            dh, bg, cy, g, 
//            a, d, dg, bl, 
//            h, j, f, c

class bk
{

    static dh a = new dh();

    static int a(int i)
    {
        if (i >= 48 && i <= 57)
        {
            return i - 48;
        }
        if (i >= 97 && i <= 102)
        {
            return (i - 97) + 10;
        }
        if (i >= 65 && i <= 70)
        {
            return (i - 65) + 10;
        } else
        {
            return 0;
        }
    }

    static j a(bg bg1)
    {
        bg1 = bg1.b();
        if (bg1 == null)
        {
            return null;
        } else
        {
            return a(((cy) (bg1)));
        }
    }

    static j a(cy cy1)
    {
        char c1;
        try
        {
            b(cy1);
            c1 = cy1.b();
        }
        // Misplaced declaration of an exception variable
        catch (cy cy1)
        {
            return null;
        }
        if (c1 != '{')
        {
            break MISSING_BLOCK_LABEL_20;
        }
        return c(cy1);
        if (c1 != '[')
        {
            break MISSING_BLOCK_LABEL_31;
        }
        return d(cy1);
        if (c1 != '-')
        {
            break MISSING_BLOCK_LABEL_42;
        }
        return h(cy1);
        if (c1 < '0' || c1 > '9') goto _L2; else goto _L1
_L1:
        return h(cy1);
_L3:
        cy1 = e(cy1);
        if (cy1.length() == 0)
        {
            return new g("");
        }
        c1 = cy1.charAt(0);
        if (c1 != 't')
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (cy1.equals("true"))
        {
            return a.a;
        }
        if (c1 != 'f')
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (cy1.equals("false"))
        {
            return a.b;
        }
        if (c1 != 'n')
        {
            break MISSING_BLOCK_LABEL_144;
        }
        if (cy1.equals("null"))
        {
            return a.c;
        }
        return new g(cy1);
_L5:
        cy1 = g(cy1);
        if (cy1.length() == 0)
        {
            return new g("");
        }
        c1 = cy1.charAt(0);
        if (c1 != 't')
        {
            break MISSING_BLOCK_LABEL_200;
        }
        if (cy1.equals("true"))
        {
            return a.a;
        }
        if (c1 != 'f')
        {
            break MISSING_BLOCK_LABEL_219;
        }
        if (cy1.equals("false"))
        {
            return a.b;
        }
        if (c1 != 'n')
        {
            break MISSING_BLOCK_LABEL_238;
        }
        if (cy1.equals("null"))
        {
            return a.c;
        }
        cy1 = new g(cy1);
        return cy1;
_L6:
        return null;
_L2:
        if (c1 != '"' && c1 != '\'') goto _L4; else goto _L3
_L4:
        if ((c1 < 'a' || c1 > 'z') && (c1 < 'A' || c1 > 'Z') && c1 != '_' && c1 != '$') goto _L6; else goto _L5
    }

    static j a(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return a(new cy(s));
        }
    }

    static void a(bg bg1, d d1)
    {
        bg1 = bg1.a();
        if (d1 != null)
        {
            d1.a(bg1);
            bg1.b();
        } else
        {
            bl.b.b("Saving empty property list.");
            bg1.b("[]");
        }
        bg1.d();
    }

    static void a(bg bg1, h h1)
    {
        bg1 = bg1.a();
        if (h1 != null)
        {
            h1.a(bg1);
            bg1.b();
        } else
        {
            bl.b.b("Saving empty property table.");
            bg1.b("{}");
        }
        bg1.d();
    }

    static h b(bg bg1)
    {
        bg1 = a(bg1);
        if (bg1 == null || !bg1.l())
        {
            return null;
        } else
        {
            return bg1.m();
        }
    }

    static h b(String s)
    {
        s = a(s);
        if (s == null || !s.l())
        {
            return null;
        } else
        {
            return s.m();
        }
    }

    static void b(cy cy1)
    {
        for (char c1 = cy1.b(); cy1.a() && (c1 <= ' ' || c1 > '~'); c1 = cy1.b())
        {
            cy1.c();
        }

    }

    static d c(bg bg1)
    {
        bg1 = a(bg1);
        if (bg1 == null || !bg1.f())
        {
            return null;
        } else
        {
            return bg1.h();
        }
    }

    static h c(cy cy1)
    {
        b(cy1);
        if (cy1.a('{'))
        {
            b(cy1);
            h h1 = new h();
            if (cy1.a('}'))
            {
                return h1;
            }
            boolean flag = true;
            while (flag || cy1.a(',')) 
            {
                flag = false;
                String s = g(cy1);
                b(cy1);
                if (!cy1.a(':'))
                {
                    h1.b(s, true);
                } else
                {
                    b(cy1);
                    h1.a(s, a(cy1));
                }
                b(cy1);
            }
            if (cy1.a('}'))
            {
                return h1;
            }
        }
        return null;
    }

    static d d(cy cy1)
    {
        b(cy1);
        if (cy1.a('['))
        {
            b(cy1);
            d d1 = new d();
            if (cy1.a(']'))
            {
                return d1;
            }
            for (boolean flag = true; flag || cy1.a(','); b(cy1))
            {
                flag = false;
                d1.a(a(cy1));
            }

            if (cy1.a(']'))
            {
                return d1;
            }
        }
        return null;
    }

    static String e(cy cy1)
    {
        byte byte0;
        byte0 = 34;
        b(cy1);
        break MISSING_BLOCK_LABEL_7;
        if (!cy1.a('"') && cy1.a('\''))
        {
            byte0 = 39;
        }
        if (!cy1.a())
        {
            return "";
        }
        break MISSING_BLOCK_LABEL_41;
        a.c();
        char c1 = cy1.c();
        while (cy1.a() && c1 != byte0) 
        {
            if (c1 == '\\')
            {
                c1 = cy1.c();
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
                    a.b(f(cy1));
                } else
                {
                    a.b(c1);
                }
            } else
            {
                a.b(c1);
            }
            c1 = cy1.c();
        }
        return a.toString();
    }

    static char f(cy cy1)
    {
        int k = 0;
        for (int i = 0; i < 4;)
        {
            int l = k;
            if (cy1.a())
            {
                l = k << 4 | a(cy1.c());
            }
            i++;
            k = l;
        }

        return (char)k;
    }

    static String g(cy cy1)
    {
        b(cy1);
        int i = cy1.b();
        if (i == 34 || i == 39)
        {
            return e(cy1);
        }
        a.c();
        for (boolean flag = false; !flag && cy1.a();)
        {
            if (i >= 97 && i <= 122 || i >= 65 && i <= 90 || i == 95 || i == 36)
            {
                cy1.c();
                a.b((char)i);
                i = cy1.b();
            } else
            {
                flag = true;
            }
        }

        return a.toString();
    }

    static j h(cy cy1)
    {
        double d1;
label0:
        {
            b(cy1);
            double d3 = 1.0D;
            if (cy1.a('-'))
            {
                d3 = -1D;
                b(cy1);
            }
            d1 = 0.0D;
            for (char c1 = cy1.b(); cy1.a() && c1 >= '0' && c1 <= '9'; c1 = cy1.b())
            {
                cy1.c();
                d1 = d1 * 10D + (double)(c1 - 48);
            }

            char c2 = '\0';
            double d2 = d1;
            if (cy1.a('.'))
            {
                double d4 = 0.0D;
                d2 = 0.0D;
                for (c2 = cy1.b(); cy1.a() && c2 >= '0' && c2 <= '9'; c2 = cy1.b())
                {
                    cy1.c();
                    d4 = d4 * 10D + (double)(c2 - 48);
                    d2++;
                }

                d2 = d1 + d4 / Math.pow(10D, d2);
                c2 = '\001';
            }
            if (!cy1.a('e'))
            {
                d1 = d2;
                if (!cy1.a('E'))
                {
                    break label0;
                }
            }
            boolean flag1 = false;
            boolean flag = flag1;
            if (!cy1.a('+'))
            {
                flag = flag1;
                if (cy1.a('-'))
                {
                    flag = true;
                }
            }
            d1 = 0.0D;
            for (char c3 = cy1.b(); cy1.a() && c3 >= '0' && c3 <= '9'; c3 = cy1.b())
            {
                cy1.c();
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
            return new f(d1);
        } else
        {
            return new c((int)d1);
        }
    }

}
