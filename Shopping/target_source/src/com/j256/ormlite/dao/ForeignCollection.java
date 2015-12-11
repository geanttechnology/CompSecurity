// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.Collection;

// Referenced classes of package com.j256.ormlite.dao:
//            CloseableIterable, CloseableIterator, CloseableWrappedIterable

public interface ForeignCollection
    extends CloseableIterable, Collection
{

    public abstract boolean add(Object obj);

    public abstract void closeLastIterator()
        throws SQLException;

    public abstract CloseableIterator closeableIterator(int i);

    public abstract CloseableWrappedIterable getWrappedIterable();

    public abstract CloseableWrappedIterable getWrappedIterable(int i);

    public abstract boolean isEager();

    public abstract CloseableIterator iterator(int i);

    public abstract CloseableIterator iteratorThrow()
        throws SQLException;

    public abstract CloseableIterator iteratorThrow(int i)
        throws SQLException;

    public abstract int refresh(Object obj)
        throws SQLException;

    public abstract int refreshAll()
        throws SQLException;

    public abstract int refreshCollection()
        throws SQLException;

    public abstract int update(Object obj)
        throws SQLException;

    public abstract int updateAll()
        throws SQLException;
}
