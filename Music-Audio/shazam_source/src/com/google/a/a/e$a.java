// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;


// Referenced classes of package com.google.a.a:
//            e, g

public static final class <init>
{
    private static final class a
    {

        String a;
        Object b;
        a c;

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }


    private final String a;
    private a b;
    private a c;
    private boolean d;

    private a a()
    {
        a a1 = new a((byte)0);
        c.c = a1;
        c = a1;
        return a1;
    }

    public final c a(Object obj)
    {
        a().b = obj;
        return this;
    }

    public final a.b a(String s, int i)
    {
        return a(s, String.valueOf(i));
    }

    public final lueOf a(String s, long l)
    {
        return a(s, String.valueOf(l));
    }

    public final lueOf a(String s, Object obj)
    {
        a a1 = a();
        a1.b = obj;
        a1.a = (String)g.a(s);
        return this;
    }

    public final String toString()
    {
        boolean flag = d;
        StringBuilder stringbuilder = (new StringBuilder(32)).append(a).append('{');
        a a1 = b.c;
        String s1;
        for (String s = ""; a1 != null; s = s1)
        {
label0:
            {
                if (flag)
                {
                    s1 = s;
                    if (a1.b == null)
                    {
                        break label0;
                    }
                }
                stringbuilder.append(s);
                s1 = ", ";
                if (a1.a != null)
                {
                    stringbuilder.append(a1.a).append('=');
                }
                stringbuilder.append(a1.b);
            }
            a1 = a1.c;
        }

        return stringbuilder.append('}').toString();
    }

    private a(String s)
    {
        b = new a((byte)0);
        c = b;
        d = false;
        a = (String)g.a(s);
    }

    a(String s, byte byte0)
    {
        this(s);
    }
}
