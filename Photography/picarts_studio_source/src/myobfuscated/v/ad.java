// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import java.util.Queue;
import myobfuscated.aj.j;

final class ad
{

    private static final Queue a = j.a(0);
    private int b;
    private int c;
    private Object d;

    private ad()
    {
    }

    static ad a(Object obj, int i, int k)
    {
        ad ad1;
        synchronized (a)
        {
            ad1 = (ad)a.poll();
        }
        obj1 = ad1;
        if (ad1 == null)
        {
            obj1 = new ad();
        }
        obj1.d = obj;
        obj1.c = i;
        obj1.b = k;
        return ((ad) (obj1));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public final void a()
    {
        synchronized (a)
        {
            a.offer(this);
        }
        return;
        exception;
        queue;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof ad)
        {
            obj = (ad)obj;
            flag = flag1;
            if (c == ((ad) (obj)).c)
            {
                flag = flag1;
                if (b == ((ad) (obj)).b)
                {
                    flag = flag1;
                    if (d.equals(((ad) (obj)).d))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return (b * 31 + c) * 31 + d.hashCode();
    }

}
