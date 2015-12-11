// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.helper;

import java.util.Iterator;
import java.util.ListIterator;

// Referenced classes of package org.jsoup.helper:
//            DescendableLinkedList

private class <init>
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

    private (int i)
    {
        this$0 = DescendableLinkedList.this;
        super();
        iter = listIterator(i);
    }

    iter(int i, iter iter1)
    {
        this(i);
    }
}
