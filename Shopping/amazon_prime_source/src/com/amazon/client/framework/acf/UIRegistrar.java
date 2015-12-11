// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.amazon.client.framework.acf:
//            Registrar

public class UIRegistrar
    implements Registrar
{
    private static class ReverseIterator
        implements Iterator
    {

        private final ListIterator mListIterator;

        public boolean hasNext()
        {
            return mListIterator.hasPrevious();
        }

        public Object next()
        {
            return mListIterator.previous();
        }

        public void remove()
        {
            mListIterator.remove();
        }

        ReverseIterator(ListIterator listiterator)
        {
            mListIterator = listiterator;
        }
    }


    private final List mRegistry = new CopyOnWriteArrayList();

    public UIRegistrar()
    {
    }

    public void add(Object obj)
    {
        while (obj == null || mRegistry.contains(obj)) 
        {
            return;
        }
        mRegistry.add(obj);
    }

    public void clear()
    {
        mRegistry.clear();
    }

    public Iterator iterator()
    {
        return mRegistry.iterator();
    }

    public Iterator rback()
    {
        return new ReverseIterator(mRegistry.listIterator(mRegistry.size()));
    }

    public boolean remove(Object obj)
    {
        return mRegistry.remove(obj);
    }

    public int size()
    {
        return mRegistry.size();
    }
}
