// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.util.Iterator;

// Referenced classes of package com.google.tagmanager.protobuf:
//            UnmodifiableLazyStringList, LazyStringList

class this._cls0
    implements Iterator
{

    Iterator iter;
    final UnmodifiableLazyStringList this$0;

    public boolean hasNext()
    {
        return iter.hasNext();
    }

    public volatile Object next()
    {
        return next();
    }

    public String next()
    {
        return (String)iter.next();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    A()
    {
        this$0 = UnmodifiableLazyStringList.this;
        super();
        iter = UnmodifiableLazyStringList.access$000(UnmodifiableLazyStringList.this).iterator();
    }
}
