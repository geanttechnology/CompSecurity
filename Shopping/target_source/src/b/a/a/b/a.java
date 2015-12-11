// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{

    public static final a a = new a(0, "NONE");
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final a l;
    public static final a m;
    public static final a n;
    public static final a o;
    public static final a p;
    public static final a q;
    public static final List r;
    private int s;
    private String t;

    public a(int i1, String s1)
    {
        s = i1;
        t = s1;
    }

    public static a a(int i1)
    {
        for (Iterator iterator = r.iterator(); iterator.hasNext();)
        {
            a a1 = (a)iterator.next();
            if (a1.a() == i1)
            {
                return a1;
            }
        }

        return a;
    }

    public int a()
    {
        return s;
    }

    static 
    {
        b = new a(1, "PARTIAL");
        c = new a(8, "EAN8");
        d = new a(9, "UPCE");
        e = new a(10, "ISBN10");
        f = new a(12, "UPCA");
        g = new a(13, "EAN13");
        h = new a(14, "ISBN13");
        i = new a(25, "I25");
        j = new a(34, "DATABAR");
        k = new a(35, "DATABAR_EXP");
        l = new a(38, "CODABAR");
        m = new a(39, "CODE39");
        n = new a(57, "PDF417");
        o = new a(64, "QRCODE");
        p = new a(93, "CODE93");
        q = new a(128, "CODE128");
        r = new ArrayList();
        r.add(b);
        r.add(c);
        r.add(d);
        r.add(e);
        r.add(f);
        r.add(g);
        r.add(h);
        r.add(i);
        r.add(j);
        r.add(k);
        r.add(l);
        r.add(m);
        r.add(n);
        r.add(o);
        r.add(p);
        r.add(q);
    }
}
