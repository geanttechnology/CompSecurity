// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import java.util.Iterator;
import java.util.ListIterator;

// Referenced classes of package com.amazon.client.framework.acf:
//            UIRegistrar

private static class mListIterator
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

    A(ListIterator listiterator)
    {
        mListIterator = listiterator;
    }
}
