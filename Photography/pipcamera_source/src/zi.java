// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class zi
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
    private String k;
    private String l;
    private String m;
    private String n;

    public zi()
    {
        a = "";
        b = "";
        c = "";
        d = "";
        e = "";
        f = "";
        g = "";
        h = "";
        i = "";
        j = "";
        k = "";
        l = "";
        m = "";
        n = "";
    }

    public void a(String s)
    {
        a = s;
    }

    public void b(String s)
    {
        b = s;
    }

    public void c(String s)
    {
        k = s;
    }

    public void d(String s)
    {
        l = s;
    }

    public void e(String s)
    {
        c = s;
    }

    public void f(String s)
    {
        d = s;
    }

    public void g(String s)
    {
        e = s;
    }

    public void h(String s)
    {
        f = s;
    }

    public void i(String s)
    {
        g = s;
    }

    public void j(String s)
    {
        h = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("{name:\"").append(a).append("\", nick:\"").append(b).append("\", head:\"").append(i).append("\", isvip:\"").append(j).append("\", sex:\"").append(k).append("\", fansnum:\"").append(l).append("\", idolnum:\"").append(m).append("\", tweetnum:\"").append(n).append("\"}").toString();
    }
}
