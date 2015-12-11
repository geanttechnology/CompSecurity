// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            gn

public class cd extends gn
{

    private String a;
    private String b;
    private boolean c;

    private cd()
    {
    }


    public cd(String s, String s1, String s2, long l, boolean flag)
    {
        a(s2);
        a(l);
        a = s;
        b = s1;
        c = flag;
    }

    static String a(cd cd1)
    {
        return cd1.a;
    }

    static String a(cd cd1, String s)
    {
        cd1.a = s;
        return s;
    }

    static boolean a(cd cd1, boolean flag)
    {
        cd1.c = flag;
        return flag;
    }

    static String b(cd cd1)
    {
        return cd1.b;
    }

    static String b(cd cd1, String s)
    {
        cd1.b = s;
        return s;
    }

    static boolean c(cd cd1)
    {
        return cd1.c;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public boolean c()
    {
        return c;
    }
}
