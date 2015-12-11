// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package net.tsz.afinal.core:
//            ArrayDeque

private class <init>
    implements Iterator
{

    private int cursor;
    private int fence;
    private int lastRet;
    final ArrayDeque this$0;

    public boolean hasNext()
    {
        return cursor != fence;
    }

    public Object next()
    {
        if (cursor == fence)
        {
            throw new NoSuchElementException();
        }
        Object obj = ArrayDeque.access$3(ArrayDeque.this)[cursor];
        if (ArrayDeque.access$2(ArrayDeque.this) != fence || obj == null)
        {
            throw new ConcurrentModificationException();
        } else
        {
            lastRet = cursor;
            cursor = cursor + 1 & ArrayDeque.access$3(ArrayDeque.this).length - 1;
            return obj;
        }
    }

    public void remove()
    {
        if (lastRet < 0)
        {
            throw new IllegalStateException();
        }
        if (ArrayDeque.access$4(ArrayDeque.this, lastRet))
        {
            cursor = cursor - 1 & ArrayDeque.access$3(ArrayDeque.this).length - 1;
            fence = ArrayDeque.access$2(ArrayDeque.this);
        }
        lastRet = -1;
    }

    private ()
    {
        this$0 = ArrayDeque.this;
        super();
        cursor = ArrayDeque.access$1(ArrayDeque.this);
        fence = ArrayDeque.access$2(ArrayDeque.this);
        lastRet = -1;
    }

    lastRet(lastRet lastret)
    {
        this();
    }
}
