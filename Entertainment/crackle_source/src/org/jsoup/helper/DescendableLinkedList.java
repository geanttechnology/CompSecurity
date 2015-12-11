// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.helper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DescendableLinkedList extends LinkedList
{
    private class DescendingIterator
        implements Iterator
    {

        private final ListIterator iter;
        final DescendableLinkedList this$0;

        public boolean hasNext()
        {
            return iter.hasPrevious();
        }

        public Object next()
        {
            return iter.previous();
        }

        public void remove()
        {
            iter.remove();
        }

        private DescendingIterator(int i)
        {
            this$0 = DescendableLinkedList.this;
            super();
            iter = listIterator(i);
        }

    }


    public DescendableLinkedList()
    {
    }

    public Iterator descendingIterator()
    {
        return new DescendingIterator(size());
    }

    public Object peekLast()
    {
        if (size() == 0)
        {
            return null;
        } else
        {
            return getLast();
        }
    }

    public Object pollLast()
    {
        if (size() == 0)
        {
            return null;
        } else
        {
            return removeLast();
        }
    }

    public void push(Object obj)
    {
        addFirst(obj);
    }
}
