// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.g;

import e.c.a;

// Referenced classes of package e.g:
//            k

final class n
    implements Comparable
{

    final a a;
    private Long b;
    private int c;

    private n(a a1, Long long1, int i)
    {
        a = a1;
        b = long1;
        c = i;
    }

    n(a a1, Long long1, int i, byte byte0)
    {
        this(a1, long1, i);
    }

    public final int compareTo(Object obj)
    {
        obj = (n)obj;
        int j = b.compareTo(((n) (obj)).b);
        int i = j;
        if (j == 0)
        {
            i = e.g.k.a(c, ((n) (obj)).c);
        }
        return i;
    }
}
