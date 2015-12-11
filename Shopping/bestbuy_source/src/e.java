// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e
{

    private URL a;
    private int b;
    private int c;
    private Map d;
    private String e;

    public e()
    {
        d = new HashMap();
    }

    public URL a()
    {
        return a;
    }

    public void a(int i)
    {
        b = i;
    }

    public void a(String s)
    {
        e = s;
    }

    public void a(String s, String s1)
    {
        if (!d.containsKey(s))
        {
            d.put(s, new ArrayList());
        }
        ((List)d.get(s)).add(s1);
    }

    public void a(URL url)
    {
        a = url;
    }

    public int b()
    {
        return b;
    }

    public void b(int i)
    {
        c = i;
    }

    public int c()
    {
        return c;
    }

    public Map d()
    {
        return Collections.unmodifiableMap(d);
    }

    public String e()
    {
        return e;
    }

    public abstract OutputStream f();

    public abstract InputStream g();

    public abstract int h();
}
