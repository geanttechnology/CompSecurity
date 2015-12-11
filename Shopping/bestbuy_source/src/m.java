// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

final class m
{

    final am a;
    final URL b;
    final URL c;
    private URL d;
    private URL e;
    private f f;

    private m(URL url, URL url1, URL url2, URL url3, am am1, f f1)
    {
        b = url;
        c = url1;
        d = url2;
        e = url3;
        f = f1;
        a = am1;
    }

    private e a(e e1)
    {
        e1.a(30000);
        e1.b(30000);
        a.a(e1);
        return e1;
    }

    private static String a(String s)
    {
        try
        {
            s = URLEncoder.encode(s, "utf-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    static m a(String s, String s1, am am1, f f1)
    {
        s = new URL(s);
        s1 = new URL(s1);
        return new m(new URL(s, "/eumcollector/mobileMetrics?version=2"), new URL(s, "/eumcollector/mobileAgentCount"), new URL(s1, "/dexgen/infopoint"), new URL(s1, "/dexgen/infopoint/dex"), am1, f1);
    }

    public final e a()
    {
        e e1 = f.a();
        e1.a(c);
        e1.a("POST");
        return a(e1);
    }

    public final e b()
    {
        e e1 = f.a();
        e1.a(b);
        e1.a("POST");
        return a(e1);
    }

    public final e c()
    {
        e e1 = f.a();
        e1.a(new URL(e, (new StringBuilder("?av=")).append(a(a.a())).toString()));
        e1.a("GET");
        return a(e1);
    }

    public final e d()
    {
        e e1 = f.a();
        e1.a(new URL(d, (new StringBuilder("?av=")).append(a(a.a())).toString()));
        e1.a("GET");
        return a(e1);
    }
}
