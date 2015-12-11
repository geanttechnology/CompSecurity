// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import java.util.Collection;

// Referenced classes of package com.j256.ormlite.dao:
//            CloseableIterable, CloseableWrappedIterable, CloseableIterator

public interface ForeignCollection
    extends CloseableIterable, Collection
{

    public abstract void closeLastIterator();

    public abstract CloseableWrappedIterable getWrappedIterable();

    public abstract boolean isEager();

    public abstract CloseableIterator iteratorThrow();
}
