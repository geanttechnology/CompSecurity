// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.br;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public final class e
{

    public final List a;
    public int b;
    private final int c;

    public e(int i)
    {
        a = new ArrayList();
        b = -1;
        c = i;
    }

    public e(List list, Object obj)
    {
        a = new ArrayList();
        b = -1;
        a.addAll(list);
        b = a.indexOf(obj);
        c = 20;
    }

    public final Object a()
    {
        if (b < 0)
        {
            throw new EmptyStackException();
        } else
        {
            List list = a;
            int i = b;
            b = i - 1;
            return list.get(i);
        }
    }

    public final List a(Object obj)
    {
        LinkedList linkedlist = new LinkedList();
        for (int i = b + 1; i < a.size(); linkedlist.add(a.remove(i))) { }
        a.add(obj);
        b = b + 1;
        obj = linkedlist;
        if (b + 1 > c)
        {
            a.remove(0);
            b = b - 1;
            obj = null;
        }
        return ((List) (obj));
    }

    public final void b()
    {
        if (b == a.size() - 1)
        {
            throw new RuntimeException("No more saved items to restore");
        } else
        {
            b = b + 1;
            return;
        }
    }

    public final Object c()
    {
        if (b < 0)
        {
            throw new EmptyStackException();
        } else
        {
            return a.get(b);
        }
    }

    public final Object d()
    {
        if (a.size() <= 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder("Size is ")).append(a.size()).append(" but index is 0").toString());
        }
        if (b >= 0)
        {
            b = b - 1;
            return a.remove(0);
        } else
        {
            return a.remove(0);
        }
    }

    public final boolean e()
    {
        return b + 1 == 0;
    }

    public final List f()
    {
        if (b < 0)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.unmodifiableList(a.subList(0, b + 1));
        }
    }

    public final ArrayList g()
    {
        if (b < 0)
        {
            return new ArrayList();
        } else
        {
            return new ArrayList(a.subList(0, b + 1));
        }
    }
}
