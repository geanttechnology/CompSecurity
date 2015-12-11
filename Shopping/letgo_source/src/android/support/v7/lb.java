// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.internal.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            lg, wd

public class lb
{

    Map a;

    public lb()
    {
        a = new HashMap();
    }

    public lb a(double d1)
    {
        a("pr", Double.toString(d1));
        return this;
    }

    public lb a(int i)
    {
        a("ps", Integer.toString(i));
        return this;
    }

    public lb a(int i, int j)
    {
        a(lg.k(i), Integer.toString(j));
        return this;
    }

    public lb a(int i, String s)
    {
        a(lg.j(i), s);
        return this;
    }

    public lb a(String s)
    {
        a("id", s);
        return this;
    }

    void a(String s, String s1)
    {
        x.a(s, "Name should be non-null");
        a.put(s, s1);
    }

    public lb b(int i)
    {
        a("qt", Integer.toString(i));
        return this;
    }

    public lb b(String s)
    {
        a("nm", s);
        return this;
    }

    public lb c(String s)
    {
        a("br", s);
        return this;
    }

    public lb d(String s)
    {
        a("ca", s);
        return this;
    }

    public lb e(String s)
    {
        a("va", s);
        return this;
    }

    public lb f(String s)
    {
        a("cc", s);
        return this;
    }

    public Map g(String s)
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); hashmap.put((new StringBuilder()).append(s).append((String)entry.getKey()).toString(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return hashmap;
    }

    public String toString()
    {
        return wd.a(a);
    }
}
