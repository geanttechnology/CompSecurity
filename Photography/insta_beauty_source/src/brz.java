// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.weibo.other.tencent.beans.QParameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class brz
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private bry l;
    private String m;
    private Random n;

    public brz()
    {
        a = "d02185e9c6cb443d9a6791959b8241a3";
        b = "b77f03ed0a43373ec01e92dedc21ae42";
        c = "HMAC-SHA1";
        d = "";
        e = "";
        f = "null";
        g = "1.0";
        h = "";
        i = "";
        j = "";
        k = 0;
        l = new bry();
        m = "";
        n = new Random();
    }

    public brz(String s)
    {
        a = "d02185e9c6cb443d9a6791959b8241a3";
        b = "b77f03ed0a43373ec01e92dedc21ae42";
        c = "HMAC-SHA1";
        d = "";
        e = "";
        f = "null";
        g = "1.0";
        h = "";
        i = "";
        j = "";
        k = 0;
        l = new bry();
        m = "";
        n = new Random();
        f = s;
    }

    private String h()
    {
        return String.valueOf(System.currentTimeMillis() / 1000L);
    }

    private String i()
    {
        return String.valueOf(n.nextInt(0x96b477) + 0x1e208);
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList();
        d = h();
        e = i();
        if (a != null && !"".equals(a.trim()))
        {
            arraylist.add(new QParameter("oauth_consumer_key", a));
        }
        if (c != null && !"".equals(c.trim()))
        {
            arraylist.add(new QParameter("oauth_signature_method", c));
        }
        if (d != null && !"".equals(d.trim()))
        {
            arraylist.add(new QParameter("oauth_timestamp", d));
        }
        if (e != null && !"".equals(e.trim()))
        {
            arraylist.add(new QParameter("oauth_nonce", e));
        }
        if (f != null && !"".equals(f.trim()))
        {
            arraylist.add(new QParameter("oauth_callback", f));
        }
        if (g != null && !"".equals(g.trim()))
        {
            arraylist.add(new QParameter("oauth_version", g));
        }
        return arraylist;
    }

    public void a(int i1)
    {
        k = i1;
    }

    public void a(String s)
    {
        a = s;
    }

    public List b()
    {
        List list = c();
        if (j != null && !"".equals(j))
        {
            list.add(new QParameter("oauth_verifier", j));
        }
        return list;
    }

    public void b(String s)
    {
        b = s;
    }

    public List c()
    {
        ArrayList arraylist = new ArrayList();
        d = h();
        e = i();
        arraylist.add(new QParameter("oauth_consumer_key", a));
        arraylist.add(new QParameter("oauth_signature_method", c));
        arraylist.add(new QParameter("oauth_timestamp", d));
        arraylist.add(new QParameter("oauth_nonce", e));
        arraylist.add(new QParameter("oauth_token", h));
        arraylist.add(new QParameter("oauth_version", g));
        return arraylist;
    }

    public void c(String s)
    {
        h = s;
    }

    public String d()
    {
        return b;
    }

    public void d(String s)
    {
        i = s;
    }

    public String e()
    {
        return h;
    }

    public void e(String s)
    {
        j = s;
    }

    public String f()
    {
        return i;
    }

    public void f(String s)
    {
        m = s;
    }

    public int g()
    {
        return k;
    }
}
