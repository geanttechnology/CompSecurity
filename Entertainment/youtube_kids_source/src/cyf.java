// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class cyf
    implements cpu
{

    public final List a = new ArrayList();
    public final List b = new ArrayList();
    private final List c = new ArrayList();

    public cyf()
    {
    }

    public final cye a()
    {
        return new cye(c, a, b);
    }

    public final cyf a(String s, int i, int j)
    {
        if (!c.isEmpty() && i < ((Integer)c.get(c.size() - 1)).intValue())
        {
            bmo.c("subtitles are not given in non-decreasing start time order");
        }
        c.add(Integer.valueOf(i));
        a.add(Integer.valueOf(j));
        b.add(s);
        return this;
    }

    public final Object b()
    {
        return a();
    }
}
