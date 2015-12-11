// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.util.ListIterator;

// Referenced classes of package com.google.tagmanager.protobuf:
//            UnmodifiableLazyStringList, LazyStringList

class val.index
    implements ListIterator
{

    ListIterator iter;
    final UnmodifiableLazyStringList this$0;
    final int val$index;

    public volatile void add(Object obj)
    {
        add((String)obj);
    }

    public void add(String s)
    {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext()
    {
        return iter.hasNext();
    }

    public boolean hasPrevious()
    {
        return iter.hasPrevious();
    }

    public volatile Object next()
    {
        return next();
    }

    public String next()
    {
        return (String)iter.next();
    }

    public int nextIndex()
    {
        return iter.nextIndex();
    }

    public volatile Object previous()
    {
        return previous();
    }

    public String previous()
    {
        return (String)iter.previous();
    }

    public int previousIndex()
    {
        return iter.previousIndex();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    public volatile void set(Object obj)
    {
        set((String)obj);
    }

    public void set(String s)
    {
        throw new UnsupportedOperationException();
    }

    A()
    {
        this$0 = final_unmodifiablelazystringlist;
        val$index = I.this;
        super();
        iter = UnmodifiableLazyStringList.access$000(UnmodifiableLazyStringList.this).listIterator(val$index);
    }
}
