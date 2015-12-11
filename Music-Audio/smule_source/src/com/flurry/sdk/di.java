// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            db, dh

public class di
{

    private db a;
    private String b;
    private dh c;
    private List d;
    private List e;
    private List f;
    private List g;

    private di()
    {
    }


    static db a(di di1, db db)
    {
        di1.a = db;
        return db;
    }

    static dh a(di di1, dh dh)
    {
        di1.c = dh;
        return dh;
    }

    static String a(di di1, String s)
    {
        di1.b = s;
        return s;
    }

    static List a(di di1, List list)
    {
        di1.d = list;
        return list;
    }

    static List b(di di1, List list)
    {
        di1.e = list;
        return list;
    }

    static List c(di di1, List list)
    {
        di1.f = list;
        return list;
    }

    static List d(di di1, List list)
    {
        di1.g = list;
        return list;
    }

    public db a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public dh c()
    {
        return c;
    }

    public List d()
    {
        return d;
    }

    public List e()
    {
        return e;
    }

    public List f()
    {
        return f;
    }

    public List g()
    {
        return g;
    }
}
