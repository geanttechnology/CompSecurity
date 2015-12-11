// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObserverList
    implements Iterable
{

    private static boolean d;
    private List a;
    private int b;
    private int c;

    public ObserverList()
    {
        a = new ArrayList();
        b = 0;
        c = 0;
    }

    static Object a(ObserverList observerlist, int i)
    {
        return observerlist.a.get(i);
    }

    private void a()
    {
        if (!d && b != 0)
        {
            throw new AssertionError();
        }
        for (int i = a.size() - 1; i >= 0; i--)
        {
            if (a.get(i) == null)
            {
                a.remove(i);
            }
        }

    }

    static void a(ObserverList observerlist)
    {
        observerlist.b = observerlist.b + 1;
    }

    static int b(ObserverList observerlist)
    {
        return observerlist.a.size();
    }

    static void c(ObserverList observerlist)
    {
        observerlist.b = observerlist.b - 1;
        if (!d && observerlist.b < 0)
        {
            throw new AssertionError();
        }
        if (observerlist.b == 0)
        {
            observerlist.a();
        }
    }

    public final boolean a(Object obj)
    {
        if (obj == null || a.contains(obj))
        {
            return false;
        }
        boolean flag = a.add(obj);
        if (!d && !flag)
        {
            throw new AssertionError();
        } else
        {
            c = c + 1;
            return true;
        }
    }

    public Iterator iterator()
    {
        return new ObserverListIterator();
    }

    static 
    {
        boolean flag;
        if (!org/chromium/base/ObserverList.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
    }

    private class ObserverListIterator
        implements RewindableIterator
    {

        private int a;
        private int b;
        private boolean c;
        private ObserverList d;

        private void a()
        {
            if (!c)
            {
                c = true;
                ObserverList.c(d);
            }
        }

        public boolean hasNext()
        {
            int i;
            for (i = b; i < a && ObserverList.a(d, i) == null; i++) { }
            if (i < a)
            {
                return true;
            } else
            {
                a();
                return false;
            }
        }

        public Object next()
        {
            for (; b < a && ObserverList.a(d, b) == null; b = b + 1) { }
            if (b < a)
            {
                ObserverList observerlist = d;
                int i = b;
                b = i + 1;
                return ObserverList.a(observerlist, i);
            } else
            {
                a();
                throw new NoSuchElementException();
            }
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        ObserverListIterator()
        {
            d = ObserverList.this;
            super();
            b = 0;
            c = false;
            ObserverList.a(ObserverList.this);
            a = ObserverList.b(ObserverList.this);
        }
    }

}
