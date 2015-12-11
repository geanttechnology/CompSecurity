// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.g.a.a;
import com.google.api.a.g.a.b;
import com.google.api.a.g.a.c;
import com.google.api.a.g.l;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.api.a.d:
//            ad

public class h extends l
{

    private static final b c = new c("=&-_.!~*'()@:$,;/?:", false);
    List a;
    public String b;
    private String d;
    private String e;
    private String f;
    private int g;

    public h()
    {
        g = -1;
    }

    public h(String s)
    {
        this(a(s));
    }

    private h(String s, String s1, int i, String s2, String s3, String s4, String s5)
    {
        Object obj = null;
        super();
        g = -1;
        d = s.toLowerCase();
        e = s1;
        g = i;
        a = h(s2);
        if (s3 != null)
        {
            s = com.google.api.a.g.a.a.b(s3);
        } else
        {
            s = null;
        }
        b = s;
        if (s4 != null)
        {
            com.google.api.a.d.ad.a(s4, this);
        }
        s = obj;
        if (s5 != null)
        {
            s = com.google.api.a.g.a.a.b(s5);
        }
        f = s;
    }

    public h(URL url)
    {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
    }

    private static URL a(String s)
    {
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException(s);
        }
        return s;
    }

    private void a(StringBuilder stringbuilder)
    {
        int j = a.size();
        for (int i = 0; i < j; i++)
        {
            String s = (String)a.get(i);
            if (i != 0)
            {
                stringbuilder.append('/');
            }
            if (s.length() != 0)
            {
                stringbuilder.append(com.google.api.a.g.a.a.c(s));
            }
        }

    }

    static void a(Set set1, StringBuilder stringbuilder)
    {
        set1 = set1.iterator();
        boolean flag = true;
        do
        {
            if (!set1.hasNext())
            {
                break;
            }
            Object obj1 = (java.util.Map.Entry)set1.next();
            Object obj = ((java.util.Map.Entry) (obj1)).getValue();
            if (obj != null)
            {
                obj1 = com.google.api.a.g.a.a.f((String)((java.util.Map.Entry) (obj1)).getKey());
                if (obj instanceof Collection)
                {
                    obj = ((Collection)obj).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        flag = a(flag, stringbuilder, ((String) (obj1)), ((Iterator) (obj)).next());
                    }
                } else
                {
                    flag = a(flag, stringbuilder, ((String) (obj1)), obj);
                }
            }
        } while (true);
    }

    private static boolean a(boolean flag, StringBuilder stringbuilder, String s, Object obj)
    {
        if (flag)
        {
            flag = false;
            stringbuilder.append('?');
        } else
        {
            stringbuilder.append('&');
        }
        stringbuilder.append(s);
        s = com.google.api.a.g.a.a.f(obj.toString());
        if (s.length() != 0)
        {
            stringbuilder.append('=').append(s);
        }
        return flag;
    }

    public static List h(String s)
    {
        if (s == null || s.length() == 0)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        boolean flag = true;
        int i = 0;
        while (flag) 
        {
            int j = s.indexOf('/', i);
            String s1;
            if (j != -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                s1 = s.substring(i, j);
            } else
            {
                s1 = s.substring(i);
            }
            arraylist.add(com.google.api.a.g.a.a.b(s1));
            i = j + 1;
        }
        return arraylist;
    }

    public h c()
    {
        h h1 = (h)super.clone();
        if (a != null)
        {
            h1.a = new ArrayList(a);
        }
        return h1;
    }

    public h c(String s, Object obj)
    {
        return (h)super.set(s, obj);
    }

    public l clone()
    {
        return c();
    }

    public Object clone()
    {
        return c();
    }

    public final String d()
    {
        Object obj = new StringBuilder();
        ((StringBuilder) (obj)).append((String)com.google.api.a.f.a.a.a.a.c.a(d));
        ((StringBuilder) (obj)).append("://");
        if (f != null)
        {
            ((StringBuilder) (obj)).append(com.google.api.a.g.a.a.e(f)).append('@');
        }
        ((StringBuilder) (obj)).append((String)com.google.api.a.f.a.a.a.a.c.a(e));
        int i = g;
        if (i != -1)
        {
            ((StringBuilder) (obj)).append(':').append(i);
        }
        obj = String.valueOf(((StringBuilder) (obj)).toString());
        Object obj1 = new StringBuilder();
        if (a != null)
        {
            a(((StringBuilder) (obj1)));
        }
        a(entrySet(), ((StringBuilder) (obj1)));
        String s = b;
        if (s != null)
        {
            ((StringBuilder) (obj1)).append('#').append(c.a(s));
        }
        obj1 = String.valueOf(((StringBuilder) (obj1)).toString());
        if (((String) (obj1)).length() != 0)
        {
            return ((String) (obj)).concat(((String) (obj1)));
        } else
        {
            return new String(((String) (obj)));
        }
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof h))
        {
            return false;
        } else
        {
            obj = (h)obj;
            return d().equals(((h) (obj)).toString());
        }
    }

    public final URL g(String s)
    {
        try
        {
            s = new URL(a(d()), s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException(s);
        }
        return s;
    }

    public int hashCode()
    {
        return d().hashCode();
    }

    public l set(String s, Object obj)
    {
        return c(s, obj);
    }

    public String toString()
    {
        return d();
    }

}
