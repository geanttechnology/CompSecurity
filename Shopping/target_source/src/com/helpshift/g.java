// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class g
{

    private long a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private Boolean i;
    private ArrayList j;
    private List k;

    public g()
    {
        c = "";
        d = "";
        e = "";
        g = "";
        f = "";
        h = 0;
        i = Boolean.valueOf(false);
        k = new ArrayList();
    }

    public g(long l, String s, String s1, String s2, String s3, String s4, 
            int i1, Boolean boolean1, List list)
    {
        a = l;
        b = s;
        c = s3;
        d = s1;
        e = "faq";
        f = s2;
        g = s4;
        h = i1;
        i = boolean1;
        k = list;
    }

    public g(String s, String s1, String s2)
    {
        c = s;
        d = s1;
        e = s2;
    }

    private static ArrayList a(ArrayList arraylist, ArrayList arraylist1)
    {
        HashSet hashset = new HashSet();
        if (arraylist != null)
        {
            hashset.addAll(arraylist);
        }
        if (arraylist1 != null)
        {
            hashset.addAll(arraylist1);
        }
        return new ArrayList(hashset);
    }

    public String a()
    {
        return b;
    }

    protected void a(ArrayList arraylist)
    {
        j = a(j, arraylist);
    }

    public String b()
    {
        return d;
    }

    public String c()
    {
        return f;
    }

    protected String d()
    {
        return e;
    }

    public String e()
    {
        return c;
    }

    public boolean equals(Object obj)
    {
        obj = (g)obj;
        return b.equals(((g) (obj)).b) && c.equals(((g) (obj)).c) && g.equals(((g) (obj)).g) && d.equals(((g) (obj)).d) && f.equals(((g) (obj)).f) && i == ((g) (obj)).i && h == h && k.equals(((g) (obj)).k);
    }

    public String f()
    {
        return g;
    }

    public int g()
    {
        return h;
    }

    public List h()
    {
        if (k == null)
        {
            return new ArrayList();
        } else
        {
            return k;
        }
    }

    public Boolean i()
    {
        return i;
    }

    public ArrayList j()
    {
        return j;
    }

    protected void k()
    {
        j = null;
    }

    public String toString()
    {
        return c;
    }
}
