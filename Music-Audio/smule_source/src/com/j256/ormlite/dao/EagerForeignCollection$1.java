// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.j256.ormlite.dao:
//            CloseableIterator, EagerForeignCollection, Dao

class last
    implements CloseableIterator
{

    private Iterator iterator;
    private Object last;
    final EagerForeignCollection this$0;

    public void close()
    {
    }

    public boolean hasNext()
    {
        return iterator.hasNext();
    }

    public Object next()
    {
        last = iterator.next();
        return last;
    }

    public void remove()
    {
        iterator.remove();
        if (dao == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        dao.delete(last);
        return;
        SQLException sqlexception;
        sqlexception;
        throw new RuntimeException(sqlexception);
    }

    ()
    {
        this$0 = EagerForeignCollection.this;
        super();
        iterator = EagerForeignCollection.access$000(EagerForeignCollection.this).iterator();
        last = null;
    }
}
