// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;

public abstract class c
{
    public abstract class a
    {

        private final Iterator a;

        public final boolean a()
        {
            return a.hasNext();
        }

        public final Object b()
        {
            return a.next();
        }

        public a()
        {
            a = c.a(c.this).iterator();
        }
    }


    private final ArrayList a;

    public c(int i)
    {
        a = new ArrayList(i);
    }

    static ArrayList a(c c1)
    {
        return c1.a;
    }

    public final Object a()
    {
        return a.remove(0);
    }

    public final Object a(int i)
    {
        return a.get(i);
    }

    public final void a(Object obj)
    {
        a.add(obj);
    }

    public final void b()
    {
        a.clear();
    }

    public final void b(Object obj)
    {
        a.remove(obj);
    }

    public final int c()
    {
        return a.size();
    }

    public final boolean c(Object obj)
    {
        return a.contains(obj);
    }
}
