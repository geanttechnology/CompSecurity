// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.database;


public class a
{

    public final String a;
    public String b;
    public boolean c;
    public boolean d;
    public boolean e;

    private a(String s)
    {
        b = null;
        c = false;
        d = false;
        e = false;
        a = s;
    }

    public static a c()
    {
        return new a("INTEGER");
    }

    public static a d()
    {
        return new a("TEXT");
    }

    public a a()
    {
        c = true;
        return this;
    }

    public String b()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(b).append(" ").append(a);
        if (c)
        {
            stringbuilder.append(" PRIMARY KEY");
        }
        if (d)
        {
            stringbuilder.append(" NOT NULL");
        }
        if (e)
        {
            stringbuilder.append(" UNIQUE");
        }
        return stringbuilder.toString();
    }
}
