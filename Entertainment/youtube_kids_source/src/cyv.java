// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public final class cyv
    implements Iterable
{

    TreeSet a;
    private TreeSet b;

    public cyv()
    {
        a = new TreeSet();
        b = new TreeSet();
    }

    public final Iterator a(long l)
    {
        return a.tailSet(cys.b(l)).iterator();
    }

    public final transient void a(cys acys[])
    {
        for (int i = 0; i <= 0; i++)
        {
            cys cys1 = acys[0];
            b.add(cys1);
            a.add(cys1.b);
            a.add(cys1.c);
        }

    }

    public final transient void b(cys acys[])
    {
        for (int i = 0; i <= 0; i++)
        {
            cys cys1 = acys[0];
            b.remove(cys1);
            a.remove(cys1.b);
            a.remove(cys1.c);
        }

    }

    public final Iterator iterator()
    {
        return b.iterator();
    }
}
