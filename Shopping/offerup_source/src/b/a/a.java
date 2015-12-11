// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package b.a:
//            b, d, i, c, 
//            e, l, f

public final class a
    implements Serializable, Comparable
{

    private static int k = 0x249f00;
    private String a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Integer e;
    private Integer f;
    private Integer g;
    private Integer h;
    private boolean i;
    private int j;

    public a(Integer integer, Integer integer1, Integer integer2, Integer integer3, Integer integer4, Integer integer5, Integer integer6)
    {
        i = true;
        b = integer;
        c = integer1;
        d = integer2;
        e = integer3;
        f = integer4;
        g = integer5;
        h = integer6;
        n();
    }

    public a(String s)
    {
        i = false;
        if (s == null)
        {
            throw new IllegalArgumentException("String passed to DateTime constructor is null. You can use an empty string, but not a null reference.");
        } else
        {
            a = s;
            return;
        }
    }

    public static a a(long l1, TimeZone timezone)
    {
        timezone = new GregorianCalendar(timezone);
        timezone.setTimeInMillis(l1);
        return new a(Integer.valueOf(timezone.get(1)), Integer.valueOf(timezone.get(2) + 1), Integer.valueOf(timezone.get(5)), Integer.valueOf(timezone.get(11)), Integer.valueOf(timezone.get(12)), Integer.valueOf(timezone.get(13)), Integer.valueOf(timezone.get(14) * 1000 * 1000));
    }

    private static Integer a(Integer integer, Integer integer1)
    {
label0:
        {
            Object obj = null;
            Integer integer2 = obj;
            if (integer != null)
            {
                integer2 = obj;
                if (integer1 != null)
                {
                    if (integer1.intValue() != 1)
                    {
                        break label0;
                    }
                    integer2 = Integer.valueOf(31);
                }
            }
            return integer2;
        }
        if (integer1.intValue() == 2)
        {
            byte byte0 = 0;
            if (integer.intValue() % 100 == 0)
            {
                if (integer.intValue() % 400 == 0)
                {
                    byte0 = 1;
                }
            } else
            if (integer.intValue() % 4 == 0)
            {
                byte0 = 1;
            }
            if (byte0 != 0)
            {
                byte0 = 29;
            } else
            {
                byte0 = 28;
            }
            return Integer.valueOf(byte0);
        } else
        {
            if (integer1.intValue() == 3)
            {
                return Integer.valueOf(31);
            }
            if (integer1.intValue() == 4)
            {
                return Integer.valueOf(30);
            }
            if (integer1.intValue() == 5)
            {
                return Integer.valueOf(31);
            }
            if (integer1.intValue() == 6)
            {
                return Integer.valueOf(30);
            }
            if (integer1.intValue() == 7)
            {
                return Integer.valueOf(31);
            }
            if (integer1.intValue() == 8)
            {
                return Integer.valueOf(31);
            }
            if (integer1.intValue() == 9)
            {
                return Integer.valueOf(30);
            }
            if (integer1.intValue() == 10)
            {
                return Integer.valueOf(31);
            }
            if (integer1.intValue() == 11)
            {
                return Integer.valueOf(30);
            }
            if (integer1.intValue() == 12)
            {
                return Integer.valueOf(31);
            } else
            {
                throw new AssertionError((new StringBuilder("Month is out of range 1..12:")).append(integer1).toString());
            }
        }
    }

    private static void a(Integer integer, int i1, int j1, String s)
    {
        if (integer != null && (integer.intValue() < i1 || integer.intValue() > j1))
        {
            throw new b((new StringBuilder()).append(s).append(" is not in the range ").append(i1).append("..").append(j1).append(". Value is:").append(integer).toString());
        } else
        {
            return;
        }
    }

    private static void a(String s, Object obj, StringBuilder stringbuilder)
    {
        stringbuilder.append((new StringBuilder()).append(s).append(":").append(String.valueOf(obj)).append(" ").toString());
    }

    private transient boolean a(int ai[])
    {
        k();
        int j1 = ai.length;
        int i1 = 0;
        boolean flag1 = true;
        while (i1 < j1) 
        {
            int k1 = ai[i1];
            boolean flag;
            if (d.g == k1)
            {
                if (flag1 && h != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (d.f == k1)
            {
                if (flag1 && g != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (d.e == k1)
            {
                if (flag1 && f != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (d.d == k1)
            {
                if (flag1 && e != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (d.c == k1)
            {
                if (flag1 && d != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (d.b == k1)
            {
                if (flag1 && c != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = flag1;
                if (d.a == k1)
                {
                    if (flag1 && b != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
            }
            i1++;
            flag1 = flag;
        }
        return flag1;
    }

    public static a b(TimeZone timezone)
    {
        return a(System.currentTimeMillis(), timezone);
    }

    private transient boolean b(int ai[])
    {
        k();
        int j1 = ai.length;
        int i1 = 0;
        boolean flag1 = true;
        while (i1 < j1) 
        {
            int k1 = ai[i1];
            boolean flag;
            if (d.g == k1)
            {
                if (flag1 && h == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (d.f == k1)
            {
                if (flag1 && g == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (d.e == k1)
            {
                if (flag1 && f == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (d.d == k1)
            {
                if (flag1 && e == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (d.c == k1)
            {
                if (flag1 && d == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (d.b == k1)
            {
                if (flag1 && c == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = flag1;
                if (d.a == k1)
                {
                    if (flag1 && b == null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
            }
            i1++;
            flag1 = flag;
        }
        return flag1;
    }

    private Integer j()
    {
        m();
        return Integer.valueOf(l() - 1 - k);
    }

    private void k()
    {
        if (!i)
        {
            a a1 = (new i()).a(a);
            b = a1.b;
            c = a1.c;
            d = a1.d;
            e = a1.e;
            f = a1.f;
            g = a1.g;
            h = a1.h;
            n();
        }
    }

    private int l()
    {
        int i1 = b.intValue();
        int j1 = c.intValue();
        int k1 = d.intValue();
        return (((((i1 + 4800 + (j1 - 14) / 12) * 1461) / 4 + ((j1 - 2 - ((j1 - 14) / 12) * 12) * 367) / 12) - (((i1 + 4900 + (j1 - 14) / 12) / 100) * 3) / 4) + k1) - 32075;
    }

    private void m()
    {
        k();
        if (!a(new int[] {
    d.a, d.b, d.c
}))
        {
            throw new c("DateTime does not include year/month/day.");
        } else
        {
            return;
        }
    }

    private void n()
    {
        Integer integer;
        Integer integer1;
        Integer integer2;
        int i1;
        boolean flag;
        flag = false;
        a(b, 1, 9999, "Year");
        a(c, 1, 12, "Month");
        a(d, 1, 31, "Day");
        a(e, 0, 23, "Hour");
        a(f, 0, 59, "Minute");
        a(g, 0, 59, "Second");
        a(h, 0, 0x3b9ac9ff, "Nanosecond");
        integer = b;
        integer1 = c;
        integer2 = d;
        i1 = 0;
_L3:
        if (i1 >= 3)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        if ((new Object[] {
            integer, integer1, integer2
        })[i1] != null) goto _L2; else goto _L1
_L1:
        i1 = ((flag) ? 1 : 0);
_L4:
        if (i1 != 0 && integer2.intValue() > a(integer, integer1).intValue())
        {
            throw new b((new StringBuilder("The day-of-the-month value '")).append(integer2).append("' exceeds the number of days in the month: ").append(a(integer, integer1)).toString());
        } else
        {
            return;
        }
_L2:
        i1++;
          goto _L3
        i1 = 1;
          goto _L4
    }

    private Object[] o()
    {
        return (new Object[] {
            b, c, d, e, f, g, h
        });
    }

    private String p()
    {
        Object obj = null;
        String s;
        if (a(new int[] {
    d.a
}) && b(new int[] {
    d.b, d.c, d.d, d.e, d.f, d.g
}))
        {
            s = "YYYY";
        } else
        {
            if (a(new int[] {
    d.a, d.b
}) && b(new int[] {
    d.c, d.d, d.e, d.f, d.g
}))
            {
                return "YYYY-MM";
            }
            if (a(new int[] {
    d.a, d.b, d.c
}) && b(new int[] {
    d.d, d.e, d.f, d.g
}))
            {
                return "YYYY-MM-DD";
            }
            if (a(new int[] {
    d.a, d.b, d.c, d.d
}) && b(new int[] {
    d.e, d.f, d.g
}))
            {
                return "YYYY-MM-DD hh";
            }
            if (a(new int[] {
    d.a, d.b, d.c, d.d, d.e
}) && b(new int[] {
    d.f, d.g
}))
            {
                return "YYYY-MM-DD hh:mm";
            }
            if (a(new int[] {
    d.a, d.b, d.c, d.d, d.e, d.f
}) && b(new int[] {
    d.g
}))
            {
                return "YYYY-MM-DD hh:mm:ss";
            }
            if (a(new int[] {
    d.a, d.b, d.c, d.d, d.e, d.f, d.g
}))
            {
                return "YYYY-MM-DD hh:mm:ss.fffffffff";
            }
            if (b(new int[] {
    d.a, d.b, d.c
}) && a(new int[] {
    d.d, d.e, d.f, d.g
}))
            {
                return "hh:mm:ss.fffffffff";
            }
            if (b(new int[] {
    d.a, d.b, d.c, d.g
}) && a(new int[] {
    d.d, d.e, d.f
}))
            {
                return "hh:mm:ss";
            }
            s = obj;
            if (b(new int[] {
    d.a, d.b, d.c, d.f, d.g
}))
            {
                s = obj;
                if (a(new int[] {
    d.d, d.e
}))
                {
                    return "hh:mm";
                }
            }
        }
        return s;
    }

    public final int a(a a1)
    {
        return a1.j().intValue() - j().intValue();
    }

    public final long a(TimeZone timezone)
    {
        int l1 = 0;
        Integer integer = b();
        Integer integer1 = c();
        Integer integer2 = d();
        int i1;
        int j1;
        int k1;
        if (e() == null)
        {
            i1 = 0;
        } else
        {
            i1 = e().intValue();
        }
        if (f() == null)
        {
            j1 = 0;
        } else
        {
            j1 = f().intValue();
        }
        if (g() == null)
        {
            k1 = 0;
        } else
        {
            k1 = g().intValue();
        }
        if (h() != null)
        {
            l1 = h().intValue();
        }
        timezone = new GregorianCalendar(timezone);
        timezone.set(1, integer.intValue());
        timezone.set(2, integer1.intValue() - 1);
        timezone.set(5, integer2.intValue());
        timezone.set(11, Integer.valueOf(i1).intValue());
        timezone.set(12, Integer.valueOf(j1).intValue());
        timezone.set(13, Integer.valueOf(k1).intValue());
        timezone.set(14, Integer.valueOf(l1).intValue() / 0xf4240);
        return timezone.getTimeInMillis();
    }

    public final String a()
    {
        return a;
    }

    public final String a(String s, Locale locale)
    {
        return (new e(s, locale)).a(this);
    }

    public final int b(a a1)
    {
        if (this != a1)
        {
            k();
            a1.k();
            int i1 = l.a;
            i1 = b.a.f.a(b, a1.b, 1);
            if (i1 != 0)
            {
                return i1;
            }
            i1 = b.a.f.a(c, a1.c, 1);
            if (i1 != 0)
            {
                return i1;
            }
            i1 = b.a.f.a(d, a1.d, 1);
            if (i1 != 0)
            {
                return i1;
            }
            i1 = b.a.f.a(e, a1.e, 1);
            if (i1 != 0)
            {
                return i1;
            }
            i1 = b.a.f.a(f, a1.f, 1);
            if (i1 != 0)
            {
                return i1;
            }
            i1 = b.a.f.a(g, a1.g, 1);
            if (i1 != 0)
            {
                return i1;
            }
            i1 = b.a.f.a(h, a1.h, 1);
            if (i1 != 0)
            {
                return i1;
            }
        }
        return 0;
    }

    public final Integer b()
    {
        k();
        return b;
    }

    public final Integer c()
    {
        k();
        return c;
    }

    public final int compareTo(Object obj)
    {
        return b((a)obj);
    }

    public final Integer d()
    {
        k();
        return d;
    }

    public final Integer e()
    {
        k();
        return e;
    }

    public final boolean equals(Object obj)
    {
        Object obj1;
        Boolean boolean1;
        boolean flag;
        flag = false;
        k();
        obj1 = null;
        if (this == obj)
        {
            obj1 = Boolean.TRUE;
        } else
        if (!getClass().isInstance(obj))
        {
            obj1 = Boolean.FALSE;
        }
        boolean1 = ((Boolean) (obj1));
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        int i1;
        obj1 = (a)obj;
        ((a) (obj1)).k();
        obj = ((Object) (o()));
        obj1 = ((Object) (((a) (obj1)).o()));
        if (obj.length != obj1.length)
        {
            throw new IllegalArgumentException((new StringBuilder("Array lengths do not match. 'This' length is ")).append(obj.length).append(", while 'That' length is ").append(obj1.length).append(".").toString());
        }
        i1 = 0;
_L5:
        if (i1 >= obj.length)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        if (b.a.f.a(obj[i1], obj1[i1])) goto _L4; else goto _L3
_L3:
        boolean1 = Boolean.valueOf(flag);
_L2:
        return boolean1.booleanValue();
_L4:
        i1++;
          goto _L5
        flag = true;
          goto _L3
    }

    public final Integer f()
    {
        k();
        return f;
    }

    public final Integer g()
    {
        k();
        return g;
    }

    public final Integer h()
    {
        k();
        return h;
    }

    public final int hashCode()
    {
        if (j == 0)
        {
            k();
            Object aobj[] = o();
            int j1 = 23;
            int k1 = aobj.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                j1 = b.a.f.a(j1, aobj[i1]);
            }

            j = j1;
        }
        return j;
    }

    public final Integer i()
    {
        m();
        return Integer.valueOf((l() + 1) % 7 + 1);
    }

    public final String toString()
    {
        if (b.a.f.a(a))
        {
            return a;
        }
        if (p() != null)
        {
            return (new e(p())).a(this);
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            a("Y", b, stringbuilder);
            a("M", c, stringbuilder);
            a("D", d, stringbuilder);
            a("h", e, stringbuilder);
            a("m", f, stringbuilder);
            a("s", g, stringbuilder);
            a("f", h, stringbuilder);
            return stringbuilder.toString().trim();
        }
    }

}
