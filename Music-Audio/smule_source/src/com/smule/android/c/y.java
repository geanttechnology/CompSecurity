// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            x, b

public class y
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
    private boolean l;

    public y()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = false;
    }

    static String a(y y1)
    {
        return y1.a;
    }

    static String b(y y1)
    {
        return y1.b;
    }

    static String c(y y1)
    {
        return y1.c;
    }

    static String d(y y1)
    {
        return y1.d;
    }

    static String e(y y1)
    {
        return y1.e;
    }

    static String f(y y1)
    {
        return y1.f;
    }

    static String g(y y1)
    {
        return y1.g;
    }

    static String h(y y1)
    {
        return y1.h;
    }

    static String i(y y1)
    {
        return y1.i;
    }

    static String j(y y1)
    {
        return y1.j;
    }

    static String k(y y1)
    {
        return y1.k;
    }

    static boolean l(y y1)
    {
        return y1.l;
    }

    public x a()
    {
        return new x(this);
    }

    public y a(int i1)
    {
        f = String.valueOf(i1);
        return this;
    }

    public y a(b b1)
    {
        if (b1 != null)
        {
            b1 = b1.a();
        } else
        {
            b1 = null;
        }
        b = b1;
        return this;
    }

    public y a(Number number)
    {
        if (number != null)
        {
            number = number.toString();
        } else
        {
            number = null;
        }
        c = number;
        return this;
    }

    public y a(String s)
    {
        a = s;
        return this;
    }

    public y a(boolean flag)
    {
        l = flag;
        return this;
    }

    public y b(int i1)
    {
        g = String.valueOf(i1);
        return this;
    }

    public y b(b b1)
    {
        if (b1 != null)
        {
            b1 = b1.a();
        } else
        {
            b1 = null;
        }
        d = b1;
        return this;
    }

    public y b(String s)
    {
        b = s;
        return this;
    }

    public y c(b b1)
    {
        if (b1 != null)
        {
            b1 = b1.a();
        } else
        {
            b1 = null;
        }
        e = b1;
        return this;
    }

    public y c(String s)
    {
        d = s;
        return this;
    }

    public y d(b b1)
    {
        if (b1 != null)
        {
            b1 = b1.a();
        } else
        {
            b1 = null;
        }
        f = b1;
        return this;
    }

    public y d(String s)
    {
        e = s;
        return this;
    }

    public y e(b b1)
    {
        if (b1 != null)
        {
            b1 = b1.a();
        } else
        {
            b1 = null;
        }
        g = b1;
        return this;
    }

    public y e(String s)
    {
        f = s;
        return this;
    }

    public y f(b b1)
    {
        if (b1 != null)
        {
            b1 = b1.a();
        } else
        {
            b1 = null;
        }
        j = b1;
        return this;
    }

    public y f(String s)
    {
        g = s;
        return this;
    }

    public y g(String s)
    {
        h = s;
        return this;
    }

    public y h(String s)
    {
        i = s;
        return this;
    }
}
