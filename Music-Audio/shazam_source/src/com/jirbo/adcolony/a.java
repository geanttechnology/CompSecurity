// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            w, aw

public final class com.jirbo.adcolony.a
{
    static final class a extends i
    {

        final void a(w w1)
        {
            w1.a("false");
        }

        final boolean a()
        {
            return true;
        }

        final String b()
        {
            return "false";
        }

        a()
        {
        }
    }

    static final class b extends i
    {

        int a;

        final void a(w w1)
        {
            w1.a(a);
        }

        final boolean c()
        {
            return true;
        }

        final double d()
        {
            return (double)a;
        }

        final int e()
        {
            return a;
        }

        b(int j)
        {
            a = j;
        }
    }

    static final class c extends i
    {

        ArrayList a;

        final c a(i j)
        {
            a.add(j);
            return this;
        }

        final g a(int j)
        {
            g g1 = a(j, null);
            if (g1 != null)
            {
                return g1;
            } else
            {
                return new g();
            }
        }

        final g a(int j, g g1)
        {
            i k = (i)a.get(j);
            g g2 = g1;
            if (k != null)
            {
                g2 = g1;
                if (k.l())
                {
                    g2 = k.m();
                }
            }
            return g2;
        }

        final void a(w w1)
        {
            int k = a.size();
            if (k == 0)
            {
                w1.a("[]");
                return;
            }
            if (k == 1 && ((i)a.get(0)).g())
            {
                w1.a("[");
                ((i)a.get(0)).a(w1);
                w1.a("]");
                return;
            }
            w1.b("[");
            w1.b = w1.b + 2;
            int j = 0;
            boolean flag = true;
            while (j < k) 
            {
                if (flag)
                {
                    flag = false;
                } else
                {
                    w1.b();
                }
                ((i)a.get(j)).a(w1);
                j++;
            }
            w1.b('\n');
            w1.b = w1.b - 2;
            w1.a("]");
        }

        final boolean f()
        {
            return true;
        }

        final boolean g()
        {
            return a.size() == 0 || a.size() == 1 && ((i)a.get(0)).g();
        }

        final c h()
        {
            return this;
        }

        c()
        {
            a = new ArrayList();
        }
    }

    static final class d extends i
    {

        final void a(w w1)
        {
            w1.a("null");
        }

        final String b()
        {
            return "null";
        }

        d()
        {
        }
    }

    static final class e extends i
    {

        double a;

        final void a(w w1)
        {
            double d2;
            d2 = a;
            if (w1.a)
            {
                w1.a();
            }
            if (!Double.isNaN(d2) && !Double.isInfinite(d2)) goto _L2; else goto _L1
_L1:
            w1.a("0.0");
_L4:
            return;
_L2:
            long l2;
            long l3;
            double d1 = d2;
            if (d2 < 0.0D)
            {
                d1 = -d2;
                w1.a('-');
            }
            l2 = (long)Math.pow(10D, 4D);
            long l = Math.round(d1 * (double)l2);
            w1.a(l / l2);
            w1.a('.');
            l3 = l % l2;
            if (l3 != 0L)
            {
                break; /* Loop/switch isn't completed */
            }
            int j = 0;
            while (j < 4) 
            {
                w1.a('0');
                j++;
            }
            if (true) goto _L4; else goto _L3
_L3:
            for (long l1 = l3 * 10L; l1 < l2; l1 *= 10L)
            {
                w1.a('0');
            }

            w1.a(l3);
            return;
        }

        final double d()
        {
            return a;
        }

        final int e()
        {
            return (int)a;
        }

        final boolean i()
        {
            return true;
        }

        e(double d1)
        {
            a = d1;
        }
    }

    static final class f extends i
        implements Serializable
    {

        String a;

        final void a(w w)
        {
            a(w, a);
        }

        final String b()
        {
            return a;
        }

        final double d()
        {
            double d1;
            try
            {
                d1 = Double.parseDouble(a);
            }
            catch (NumberFormatException numberformatexception)
            {
                return 0.0D;
            }
            return d1;
        }

        final int e()
        {
            return (int)d();
        }

        final boolean j()
        {
            return true;
        }

        final boolean k()
        {
            String s = a.toLowerCase();
            return s.equals("true") || s.equals("yes");
        }

        f(String s)
        {
            a = s;
        }
    }

    static final class g extends i
        implements Serializable
    {

        HashMap a;
        ArrayList b;

        final g a(String s)
        {
            s = (i)a.get(s);
            if (s != null && s.l())
            {
                s = s.m();
            } else
            {
                s = null;
            }
            if (s != null)
            {
                return s;
            } else
            {
                return new g();
            }
        }

        final String a(int j)
        {
            return (String)b.get(j);
        }

        final String a(String s, String s1)
        {
            i j = (i)a.get(s);
            s = s1;
            if (j != null)
            {
                s = s1;
                if (j.j())
                {
                    s = j.b();
                }
            }
            return s;
        }

        final void a(w w1)
        {
            int j1 = b.size();
            if (j1 == 0)
            {
                w1.a("{}");
                return;
            }
            if (j1 == 1 && ((i)a.get(b.get(0))).g())
            {
                w1.a("{");
                String s = (String)b.get(0);
                i j = (i)a.get(s);
                a(w1, s);
                w1.b(':');
                j.a(w1);
                w1.a("}");
                return;
            }
            w1.b("{");
            w1.b = w1.b + 2;
            int i1 = 0;
            boolean flag = true;
            while (i1 < j1) 
            {
                String s1;
                i k;
                if (flag)
                {
                    flag = false;
                } else
                {
                    w1.b();
                }
                s1 = (String)b.get(i1);
                k = (i)a.get(s1);
                a(w1, s1);
                w1.b(':');
                if (!k.g())
                {
                    w1.b('\n');
                }
                k.a(w1);
                i1++;
            }
            w1.b('\n');
            w1.b = w1.b - 2;
            w1.a("}");
        }

        final void a(String s, double d1)
        {
            a(s, ((i) (new e(d1))));
        }

        final void a(String s, int j)
        {
            a(s, ((i) (new b(j))));
        }

        final void a(String s, i j)
        {
            if (!a.containsKey(s))
            {
                b.add(s);
            }
            a.put(s, j);
        }

        final boolean a(String s, boolean flag)
        {
            boolean flag1;
label0:
            {
                s = (i)a.get(s);
                flag1 = flag;
                if (s == null)
                {
                    break label0;
                }
                if (!s.a())
                {
                    flag1 = flag;
                    if (!s.j())
                    {
                        break label0;
                    }
                }
                flag1 = s.k();
            }
            return flag1;
        }

        final c b(String s)
        {
            s = (i)a.get(s);
            if (s != null && s.f())
            {
                s = s.h();
            } else
            {
                s = null;
            }
            if (s != null)
            {
                return s;
            } else
            {
                return new c();
            }
        }

        final void b(String s, String s1)
        {
            a(s, new f(s1));
        }

        final void b(String s, boolean flag)
        {
            i j;
            if (flag)
            {
                j = com.jirbo.adcolony.a.a;
            } else
            {
                j = com.jirbo.adcolony.a.b;
            }
            a(s, j);
        }

        final ArrayList c(String s)
        {
            c c1 = b(s);
            Object obj;
            if (c1 == null)
            {
                s = null;
            } else
            {
                ArrayList arraylist = new ArrayList();
                int j = 0;
                while (j < c1.a.size()) 
                {
                    s = (i)c1.a.get(j);
                    if (s != null && s.j())
                    {
                        s = s.b();
                    } else
                    {
                        s = "";
                    }
                    if (s != null)
                    {
                        arraylist.add(s);
                    }
                    j++;
                }
                s = arraylist;
            }
            obj = s;
            if (s == null)
            {
                obj = new ArrayList();
            }
            return ((ArrayList) (obj));
        }

        final double d(String s)
        {
            s = (i)a.get(s);
            if (s != null && s.n())
            {
                return s.d();
            } else
            {
                return 0.0D;
            }
        }

        final int e(String s)
        {
            s = (i)a.get(s);
            if (s != null && s.n())
            {
                return s.e();
            } else
            {
                return 0;
            }
        }

        final boolean g()
        {
            return a.size() < 0 || a.size() == 1 && ((i)a.get(b.get(0))).g();
        }

        final boolean l()
        {
            return true;
        }

        final g m()
        {
            return this;
        }

        g()
        {
            a = new HashMap();
            b = new ArrayList();
        }
    }

    static final class h extends i
    {

        final void a(w w1)
        {
            w1.a("true");
        }

        final boolean a()
        {
            return true;
        }

        final String b()
        {
            return "true";
        }

        final double d()
        {
            return 1.0D;
        }

        final int e()
        {
            return 1;
        }

        final boolean k()
        {
            return true;
        }

        h()
        {
        }
    }

    static class i
    {

        static void a(w w1, String s)
        {
label0:
            {
label1:
                {
label2:
                    {
label3:
                        {
label4:
                            {
label5:
                                {
label6:
                                    {
label7:
                                        {
                                            if (s == null)
                                            {
                                                return;
                                            }
                                            w1.b('"');
                                            int l1 = s.length();
                                            int i1 = 0;
label8:
                                            do
                                            {
                                                {
                                                    if (i1 >= l1)
                                                    {
                                                        break label0;
                                                    }
                                                    char c1 = s.charAt(i1);
                                                    switch (c1)
                                                    {
                                                    default:
                                                        if (c1 >= ' ' && c1 <= '~')
                                                        {
                                                            w1.b(c1);
                                                        } else
                                                        {
                                                            w1.a("\\u");
                                                            int k1 = c1;
                                                            int j1 = 0;
                                                            while (j1 < 4) 
                                                            {
                                                                int i2 = k1 >> 12 & 0xf;
                                                                k1 <<= 4;
                                                                if (i2 <= 9)
                                                                {
                                                                    w1.a(i2);
                                                                } else
                                                                {
                                                                    w1.b((char)((i2 - 10) + 97));
                                                                }
                                                                j1++;
                                                            }
                                                        }
                                                        break;

                                                    case 8: // '\b'
                                                        break label5;

                                                    case 9: // '\t'
                                                        break label1;

                                                    case 10: // '\n'
                                                        break label3;

                                                    case 12: // '\f'
                                                        break label4;

                                                    case 13: // '\r'
                                                        break label2;

                                                    case 34: // '"'
                                                        break label8;

                                                    case 47: // '/'
                                                        break label6;

                                                    case 92: // '\\'
                                                        break label7;
                                                    }
                                                }
                                                i1++;
                                            } while (true);
                                            w1.a("\\\"");
                                            break MISSING_BLOCK_LABEL_125;
                                        }
                                        w1.a("\\\\");
                                        break MISSING_BLOCK_LABEL_125;
                                    }
                                    w1.a("\\/");
                                    break MISSING_BLOCK_LABEL_125;
                                }
                                w1.a("\\b");
                                break MISSING_BLOCK_LABEL_125;
                            }
                            w1.a("\\f");
                            break MISSING_BLOCK_LABEL_125;
                        }
                        w1.a("\\n");
                        break MISSING_BLOCK_LABEL_125;
                    }
                    w1.a("\\r");
                    break MISSING_BLOCK_LABEL_125;
                }
                w1.a("\\t");
                break MISSING_BLOCK_LABEL_125;
            }
            w1.b('"');
        }

        void a(w w1)
        {
        }

        boolean a()
        {
            return false;
        }

        String b()
        {
            return o();
        }

        boolean c()
        {
            return false;
        }

        double d()
        {
            return 0.0D;
        }

        int e()
        {
            return 0;
        }

        boolean f()
        {
            return false;
        }

        boolean g()
        {
            return true;
        }

        c h()
        {
            return null;
        }

        boolean i()
        {
            return false;
        }

        boolean j()
        {
            return false;
        }

        boolean k()
        {
            return false;
        }

        boolean l()
        {
            return false;
        }

        g m()
        {
            return null;
        }

        final boolean n()
        {
            return i() || c();
        }

        final String o()
        {
            aw aw1 = new aw();
            a(aw1);
            return aw1.toString();
        }

        public String toString()
        {
            return o();
        }

        i()
        {
        }
    }


    static i a = new h();
    static i b = new a();
    static i c = new d();

}
