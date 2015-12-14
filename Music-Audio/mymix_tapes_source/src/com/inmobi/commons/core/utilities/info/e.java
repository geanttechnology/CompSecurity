// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.info;

import android.location.Location;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.b.c;
import java.util.HashMap;
import java.util.Locale;

public class e
{

    private static c a;
    private static int b = 0x80000000;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static int i = 0x80000000;
    private static String j;
    private static String k;
    private static String l;
    private static String m;
    private static int n = 0x80000000;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static String s;
    private static Location t;

    public static String a()
    {
        return com.inmobi.commons.core.b.c.a("user_info_store");
    }

    private static String a(String s1, String s2, String s3)
    {
        String s5 = "";
        String s4 = s5;
        if (s1 != null)
        {
            s4 = s5;
            if (s1.trim().length() != 0)
            {
                s4 = s1.trim();
            }
        }
        s1 = s4;
        if (s2 != null)
        {
            s1 = s4;
            if (s2.trim().length() != 0)
            {
                s1 = (new StringBuilder()).append(s4).append("-").append(s2.trim()).toString();
            }
        }
        s2 = s1;
        if (s3 != null)
        {
            s2 = s1;
            if (s3.trim().length() != 0)
            {
                s2 = (new StringBuilder()).append(s1).append("-").append(s3.trim()).toString();
            }
        }
        return s2;
    }

    public static void a(int i1)
    {
        if (com.inmobi.commons.a.a.a() && i1 != 0x80000000)
        {
            a.a("user_age", i1);
            return;
        } else
        {
            b = i1;
            return;
        }
    }

    public static void a(Location location)
    {
        if (com.inmobi.commons.a.a.a() && location != null)
        {
            location = b(location);
            a.a("user_location", location);
            return;
        } else
        {
            t = location;
            return;
        }
    }

    public static void a(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_age_group", s1);
            return;
        } else
        {
            c = s1;
            return;
        }
    }

    private static String b(Location location)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(location.getLatitude());
        stringbuilder.append(",");
        stringbuilder.append(location.getLongitude());
        stringbuilder.append(",");
        stringbuilder.append((int)location.getAccuracy());
        stringbuilder.append(",");
        stringbuilder.append(location.getTime());
        return stringbuilder.toString();
    }

    public static void b()
    {
        a = com.inmobi.commons.core.b.c.b("user_info_store");
        a(b);
        a(c);
        b(d);
        c(e);
        d(f);
        e(g);
        f(h);
        b(i);
        g(j);
        h(k);
        i(l);
        j(m);
        c(n);
        k(o);
        l(p);
        m(q);
        n(r);
        e(s);
        a(t);
    }

    public static void b(int i1)
    {
        if (com.inmobi.commons.a.a.a() && i1 != 0x80000000)
        {
            a.a("user_yob", i1);
            return;
        } else
        {
            i = i1;
            return;
        }
    }

    public static void b(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_area_code", s1);
            return;
        } else
        {
            d = s1;
            return;
        }
    }

    public static String c()
    {
        if (e != null)
        {
            return e;
        } else
        {
            return a.b("user_post_code", null);
        }
    }

    public static void c(int i1)
    {
        if (com.inmobi.commons.a.a.a() && i1 != 0x80000000)
        {
            a.a("user_income", i1);
            return;
        } else
        {
            n = i1;
            return;
        }
    }

    public static void c(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_post_code", s1);
            return;
        } else
        {
            e = s1;
            return;
        }
    }

    public static String d()
    {
        if (r != null)
        {
            return r;
        } else
        {
            return a.b("user_login_id", null);
        }
    }

    public static void d(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_city_code", s1);
            return;
        } else
        {
            f = s1;
            return;
        }
    }

    public static String e()
    {
        if (s != null)
        {
            return s;
        } else
        {
            return a.b("user_session_id", null);
        }
    }

    public static void e(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_state_code", s1);
            return;
        } else
        {
            g = s1;
            return;
        }
    }

    public static Location f()
    {
        Location location = null;
        if (t != null)
        {
            location = t;
        } else
        {
            String s1 = a.b("user_location", null);
            if (s1 != null)
            {
                Location location1 = new Location("");
                try
                {
                    String as[] = s1.split(",");
                    location1.setLatitude(Double.parseDouble(as[0]));
                    location1.setLongitude(Double.parseDouble(as[1]));
                    location1.setAccuracy(Float.parseFloat(as[2]));
                    location1.setTime(Long.parseLong(as[3]));
                }
                catch (NumberFormatException numberformatexception)
                {
                    numberformatexception.printStackTrace();
                    numberformatexception = null;
                }
                catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
                {
                    arrayindexoutofboundsexception.printStackTrace();
                    arrayindexoutofboundsexception = null;
                }
                return location1;
            }
        }
        return location;
    }

    public static void f(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_country_code", s1);
            return;
        } else
        {
            h = s1;
            return;
        }
    }

    public static HashMap g()
    {
        HashMap hashmap = new HashMap();
        int i1 = h();
        if (i1 != 0x80000000 && i1 > 0)
        {
            hashmap.put("u-age", String.valueOf(i1));
        }
        i1 = n();
        if (i1 != 0x80000000 && i1 > 0)
        {
            hashmap.put("u-yearofbirth", String.valueOf(i1));
        }
        i1 = s();
        if (i1 != 0x80000000 && i1 > 0)
        {
            hashmap.put("u-income", String.valueOf(i1));
        }
        String s1 = a(k(), l(), m());
        if (s1 != null && s1.trim().length() != 0)
        {
            hashmap.put("u-location", s1);
        }
        s1 = i();
        if (s1 != null)
        {
            hashmap.put("u-agegroup", s1.toString().toLowerCase(Locale.ENGLISH));
        }
        s1 = j();
        if (s1 != null)
        {
            hashmap.put("u-areacode", s1);
        }
        s1 = c();
        if (s1 != null)
        {
            hashmap.put("u-postalcode", s1);
        }
        s1 = o();
        if (s1 != null)
        {
            hashmap.put("u-gender", s1);
        }
        s1 = p();
        if (s1 != null)
        {
            hashmap.put("u-ethnicity", s1);
        }
        s1 = q();
        if (s1 != null)
        {
            hashmap.put("u-education", s1);
        }
        s1 = r();
        if (s1 != null)
        {
            hashmap.put("u-language", s1);
        }
        s1 = t();
        if (s1 != null)
        {
            hashmap.put("u-householdincome", s1);
        }
        s1 = u();
        if (s1 != null)
        {
            hashmap.put("u-interests", s1);
        }
        s1 = v();
        if (s1 != null)
        {
            hashmap.put("u-nationality", s1);
        }
        return hashmap;
    }

    public static void g(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_gender", s1);
            return;
        } else
        {
            j = s1;
            return;
        }
    }

    private static int h()
    {
        if (b != 0x80000000)
        {
            return b;
        } else
        {
            return a.b("user_age", 0x80000000);
        }
    }

    public static void h(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_ethnicity", s1);
            return;
        } else
        {
            k = s1;
            return;
        }
    }

    private static String i()
    {
        if (c != null)
        {
            return c;
        } else
        {
            return a.b("user_age_group", null);
        }
    }

    public static void i(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_education", s1);
            return;
        } else
        {
            l = s1;
            return;
        }
    }

    private static String j()
    {
        if (d != null)
        {
            return d;
        } else
        {
            return a.b("user_area_code", null);
        }
    }

    public static void j(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_language", s1);
            return;
        } else
        {
            m = s1;
            return;
        }
    }

    private static String k()
    {
        if (f != null)
        {
            return f;
        } else
        {
            return a.b("user_city_code", null);
        }
    }

    public static void k(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_house_income", s1);
            return;
        } else
        {
            o = s1;
            return;
        }
    }

    private static String l()
    {
        if (g != null)
        {
            return g;
        } else
        {
            return a.b("user_state_code", null);
        }
    }

    public static void l(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_interest", s1);
            return;
        } else
        {
            p = s1;
            return;
        }
    }

    private static String m()
    {
        if (h != null)
        {
            return h;
        } else
        {
            return a.b("user_country_code", null);
        }
    }

    public static void m(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_nationality", s1);
            return;
        } else
        {
            q = s1;
            return;
        }
    }

    private static int n()
    {
        if (i != 0x80000000)
        {
            return i;
        } else
        {
            return a.b("user_yob", 0x80000000);
        }
    }

    public static void n(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_login_id", s1);
            return;
        } else
        {
            r = s1;
            return;
        }
    }

    private static String o()
    {
        if (j != null)
        {
            return j;
        } else
        {
            return a.b("user_gender", null);
        }
    }

    public static void o(String s1)
    {
        if (com.inmobi.commons.a.a.a() && s1 != null)
        {
            a.a("user_session_id", s1);
            return;
        } else
        {
            s = s1;
            return;
        }
    }

    private static String p()
    {
        if (k != null)
        {
            return k;
        } else
        {
            return a.b("user_ethnicity", null);
        }
    }

    private static String q()
    {
        if (l != null)
        {
            return l;
        } else
        {
            return a.b("user_education", null);
        }
    }

    private static String r()
    {
        if (m != null)
        {
            return m;
        } else
        {
            return a.b("user_language", null);
        }
    }

    private static int s()
    {
        if (n != 0x80000000)
        {
            return n;
        } else
        {
            return a.b("user_income", 0x80000000);
        }
    }

    private static String t()
    {
        if (o != null)
        {
            return o;
        } else
        {
            return a.b("user_house_income", null);
        }
    }

    private static String u()
    {
        if (p != null)
        {
            return p;
        } else
        {
            return a.b("user_interest", null);
        }
    }

    private static String v()
    {
        if (q != null)
        {
            return q;
        } else
        {
            return a.b("user_nationality", null);
        }
    }

}
