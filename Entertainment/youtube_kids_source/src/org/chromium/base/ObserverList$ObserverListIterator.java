// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import java.util.NoSuchElementException;

// Referenced classes of package org.chromium.base:
//            ObserverList

class a
    implements a
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

    _cls9(ObserverList observerlist)
    {
        d = observerlist;
        super();
        b = 0;
        c = false;
        ObserverList.a(observerlist);
        a = ObserverList.b(observerlist);
    }
}
