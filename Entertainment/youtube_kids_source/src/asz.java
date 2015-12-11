// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;
import java.util.TreeSet;

public final class asz
    implements ast, Comparator
{

    private final long a;
    private final TreeSet b = new TreeSet(this);
    private long c;

    public asz(long l)
    {
        a = l;
    }

    private void b(ass ass1, long l)
    {
        while (c + l > a) 
        {
            ass1.b((asy)b.first());
        }
    }

    public final void a(ass ass1, long l)
    {
        b(ass1, l);
    }

    public final void a(ass ass1, asy asy1)
    {
        b.add(asy1);
        c = c + asy1.c;
        b(ass1, 0L);
    }

    public final void a(ass ass1, asy asy1, asy asy2)
    {
        a(asy1);
        a(ass1, asy2);
    }

    public final void a(asy asy1)
    {
        b.remove(asy1);
        c = c - asy1.c;
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (asy)obj;
        obj1 = (asy)obj1;
        if (((asy) (obj)).f - ((asy) (obj1)).f == 0L)
        {
            return ((asy) (obj)).a(((asy) (obj1)));
        }
        return ((asy) (obj)).f >= ((asy) (obj1)).f ? 1 : -1;
    }
}
