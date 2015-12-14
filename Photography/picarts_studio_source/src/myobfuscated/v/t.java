// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import com.bumptech.glide.load.b;
import java.net.URL;
import java.security.MessageDigest;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.v:
//            u

public class t
    implements b
{

    public final u b;
    public final URL c;
    public final String d;
    public String e;
    public URL f;
    private volatile byte g[];

    public t(String s)
    {
        this(s, u.a);
    }

    public t(String s, u u1)
    {
        c = null;
        d = m.b(s);
        b = (u)m.a(u1, "Argument must not be null");
    }

    public t(URL url)
    {
        this(url, u.a);
    }

    private t(URL url, u u1)
    {
        c = (URL)m.a(url, "Argument must not be null");
        d = null;
        b = (u)m.a(u1, "Argument must not be null");
    }

    private String a()
    {
        if (d != null)
        {
            return d;
        } else
        {
            return c.toString();
        }
    }

    public final void a(MessageDigest messagedigest)
    {
        if (g == null)
        {
            g = a().getBytes(a);
        }
        messagedigest.update(g);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof t)
        {
            obj = (t)obj;
            flag = flag1;
            if (a().equals(((t) (obj)).a()))
            {
                flag = flag1;
                if (b.equals(((t) (obj)).b))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return a().hashCode() * 31 + b.hashCode();
    }

    public String toString()
    {
        return a();
    }
}
