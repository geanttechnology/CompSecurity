// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import java.util.HashMap;

// Referenced classes of package com.smule.android.console:
//            c, n, a

public class b
{

    static HashMap a = new HashMap();
    private n b;
    private c c;
    private String d;
    private String e[];
    private boolean f;

    public b(int i)
    {
        c = c.c;
        d = (new StringBuilder()).append("!").append(String.valueOf(i)).toString();
        f = true;
    }

    public b(c c1, String s, String as[])
    {
        c = c1;
        d = s;
        e = as;
    }

    public b(n n1, String s, String as[])
    {
        b = n1;
        d = s;
        e = as;
    }

    public static n a(String s)
    {
        return (n)a.get(s);
    }

    public static void a(n n1)
    {
        a.put(n1.a(), n1);
    }

    public static boolean a(c c1)
    {
        c1 = c1.name();
        return c1.startsWith("_") || c1.endsWith("_");
    }

    public static b b(String s)
    {
        String as[];
        as = s.split(" ");
        if (as == null || as.length <= 0)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        n n1 = a(as[0]);
        if (n1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        return new b(n1, s, as);
        s = new b((c)Enum.valueOf(com/smule/android/console/c, as[0]), s, as);
        return s;
        s;
        return null;
    }

    public n a()
    {
        return b;
    }

    public c b()
    {
        return c;
    }

    public String c()
    {
        return d;
    }

    public String[] d()
    {
        return e;
    }

    public int e()
    {
        return com.smule.android.console.a.a(d.substring(1));
    }

}
