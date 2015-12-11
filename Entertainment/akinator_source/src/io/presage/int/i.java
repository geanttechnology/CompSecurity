// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.int;


// Referenced classes of package io.presage.int:
//            f, a, e, k, 
//            h, m, c, l, 
//            j, g

public final class i
{

    private static i a = null;

    private i()
    {
    }

    public static g a(String s, String s1)
    {
        if (s.equals("id"))
        {
            return new f(s1);
        }
        if (s.equals("ad"))
        {
            return new a(s1);
        }
        if (s.equals("filters"))
        {
            return new e(s1);
        }
        if (s.equals("server_time"))
        {
            return new k(s1);
        }
        if (s.equals("kill_sdk"))
        {
            return new h(s1);
        }
        if (s.equals("timing"))
        {
            return new m(s1);
        }
        if (s.equals("error"))
        {
            return new c(s1);
        }
        if (s.equals("timeout"))
        {
            return new l(s1);
        }
        if (s.equals("predict"))
        {
            return new j(s1);
        } else
        {
            return null;
        }
    }

    public static i a()
    {
        if (a == null)
        {
            a = new i();
        }
        return a;
    }

}
