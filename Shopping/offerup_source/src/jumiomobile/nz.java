// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.enums.NVGender;
import java.util.Date;

// Referenced classes of package jumiomobile:
//            ny

public class nz
{

    private Date a;
    private Date b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Date j;
    private NVGender k;
    private ny l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private StringBuilder t;

    public nz()
    {
        a = null;
        b = null;
        c = "";
        d = "";
        e = "";
        f = "";
        g = "";
        h = "";
        i = "";
        j = null;
        k = null;
        l = null;
        m = "";
        n = "";
        o = "";
        p = "";
        q = "";
        r = "";
        s = "";
        t = new StringBuilder();
    }

    public String a()
    {
        return s;
    }

    public void a(NVGender nvgender)
    {
        if (nvgender != null)
        {
            k = nvgender;
        }
    }

    public void a(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            s = s1;
        }
    }

    public void a(String s1, String s2)
    {
        t.append(s1).append(s2);
    }

    public void a(Date date)
    {
        a = date;
    }

    public void a(ny ny)
    {
        if (ny != null)
        {
            l = ny;
        }
    }

    public Date b()
    {
        return a;
    }

    public void b(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            c = s1;
        }
    }

    public void b(Date date)
    {
        b = date;
    }

    public Date c()
    {
        return b;
    }

    public void c(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            d = s1;
        }
    }

    public void c(Date date)
    {
        j = date;
    }

    public String d()
    {
        return c;
    }

    public void d(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            e = s1;
        }
    }

    public String e()
    {
        return d;
    }

    public void e(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            f = s1;
        }
    }

    public String f()
    {
        return e;
    }

    public void f(String s1)
    {
        if (s1 != null && !s1.trim().equals("") && !s1.equalsIgnoreCase("NONE"))
        {
            g = s1;
        }
    }

    public String g()
    {
        return f;
    }

    public void g(String s1)
    {
        if (s1 != null && !s1.trim().equals("") && !s1.equalsIgnoreCase("NONE"))
        {
            h = s1;
        }
    }

    public String h()
    {
        return g;
    }

    public void h(String s1)
    {
        if (s1 != null && !s1.trim().equals("") && !s1.equalsIgnoreCase("NONE"))
        {
            i = s1;
        }
    }

    public String i()
    {
        return h;
    }

    public void i(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            m = s1;
        }
    }

    public String j()
    {
        return i;
    }

    public void j(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            n = s1;
        }
    }

    public Date k()
    {
        return j;
    }

    public void k(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            o = s1;
        }
    }

    public NVGender l()
    {
        return k;
    }

    public void l(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            p = s1;
        }
    }

    public ny m()
    {
        return l;
    }

    public void m(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            q = s1;
        }
    }

    public String n()
    {
        return m;
    }

    public void n(String s1)
    {
        if (s1 != null && !s1.trim().equals(""))
        {
            r = s1;
        }
    }

    public String o()
    {
        return n;
    }

    public String o(String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (a != null)
        {
            stringbuilder.append("issueDate: ");
            stringbuilder.append(a.toString());
            stringbuilder.append(s1);
        }
        if (b != null)
        {
            stringbuilder.append("expiryDate: ");
            stringbuilder.append(b.toString());
            stringbuilder.append(s1);
        }
        if (c != null && !c.equals(""))
        {
            stringbuilder.append("issuingCountry: ");
            stringbuilder.append(c);
            stringbuilder.append(s1);
        }
        if (d != null && !d.equals(""))
        {
            stringbuilder.append("vehicleClass: ");
            stringbuilder.append(d);
            stringbuilder.append(s1);
        }
        if (e != null && !e.equals(""))
        {
            stringbuilder.append("restrictionCodes: ");
            stringbuilder.append(e);
            stringbuilder.append(s1);
        }
        if (f != null && !f.equals(""))
        {
            stringbuilder.append("endorsementCodes: ");
            stringbuilder.append(f);
            stringbuilder.append(s1);
        }
        if (g != null && !g.equals(""))
        {
            stringbuilder.append("firstName: ");
            stringbuilder.append(g);
            stringbuilder.append(s1);
        }
        if (h != null && !h.equals(""))
        {
            stringbuilder.append("lastName: ");
            stringbuilder.append(h);
            stringbuilder.append(s1);
        }
        if (i != null && !i.equals(""))
        {
            stringbuilder.append("middleName: ");
            stringbuilder.append(i);
            stringbuilder.append(s1);
        }
        if (j != null)
        {
            stringbuilder.append("dateOfBirth: ");
            stringbuilder.append(j);
            stringbuilder.append(s1);
        }
        if (k != null)
        {
            stringbuilder.append("sex: ");
            stringbuilder.append(k.name());
            stringbuilder.append(s1);
        }
        if (l != null)
        {
            stringbuilder.append("eyeColor: ");
            stringbuilder.append(l);
            stringbuilder.append(s1);
        }
        if (m != null && !m.equals(""))
        {
            stringbuilder.append("height: ");
            stringbuilder.append(m);
            stringbuilder.append(s1);
        }
        if (n != null && !n.equals(""))
        {
            stringbuilder.append("addressStreet1: ");
            stringbuilder.append(n);
            stringbuilder.append(s1);
        }
        if (o != null && !o.equals(""))
        {
            stringbuilder.append("addressStreet2: ");
            stringbuilder.append(o);
            stringbuilder.append(s1);
        }
        if (p != null && !p.equals(""))
        {
            stringbuilder.append("addressCity: ");
            stringbuilder.append(p);
            stringbuilder.append(s1);
        }
        if (q != null && !q.equals(""))
        {
            stringbuilder.append("addressState: ");
            stringbuilder.append(q);
            stringbuilder.append(s1);
        }
        if (r != null && !r.equals(""))
        {
            stringbuilder.append("addressZip: ");
            stringbuilder.append(r);
            stringbuilder.append(s1);
        }
        if (s != null && !s.equals(""))
        {
            stringbuilder.append("idNumber: ");
            stringbuilder.append(s);
        }
        return stringbuilder.toString();
    }

    public String p()
    {
        return o;
    }

    public String q()
    {
        return p;
    }

    public String r()
    {
        return q;
    }

    public String s()
    {
        return r;
    }

    public StringBuilder t()
    {
        return t;
    }

    public String toString()
    {
        return o(", ");
    }
}
