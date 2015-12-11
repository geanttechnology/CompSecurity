// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

public final class bxo
{

    private final cpi a;
    private final bjp b;
    private final List c;
    private final List d;
    private final coe e;
    private final String f;
    private final String g;
    private final bjp h;

    public bxo(cpi cpi1, bjp bjp1, List list, List list1, coe coe1, String s, String s1)
    {
        this(cpi1, bjp1, list, list1, coe1, s, null, ((bjp) (new bxp())));
    }

    private bxo(cpi cpi1, bjp bjp1, List list, List list1, coe coe1, String s, String s1, 
            bjp bjp2)
    {
        a = (cpi)b.a(cpi1);
        b = bjp1;
        c = (List)b.a(list);
        d = (List)b.a(list1);
        e = (coe)b.a(coe1);
        h = (bjp)b.a(bjp2);
        f = s;
        g = s1;
    }

    public final bxn a(bxq bxq1, Class class1, mj mj)
    {
        class1 = new bxn(bxq1, class1, mj, a, c, d, e, f, g, (mg)h.b_());
        if (b != null)
        {
            class1.h = (mm)b.b_();
        }
        class1.e = bxq1.e();
        return class1;
    }
}
