// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.List;

// Referenced classes of package com.j256.ormlite.dao:
//            CloseableIterator, EagerForeignCollection, Dao

class offset
    implements CloseableIterator
{

    private int offset;
    final EagerForeignCollection this$0;

    public void close()
    {
    }

    public void closeQuietly()
    {
    }

    public Object current()
    {
        if (offset < 0)
        {
            offset = 0;
        }
        if (offset >= EagerForeignCollection.access$000(EagerForeignCollection.this).size())
        {
            return null;
        } else
        {
            return EagerForeignCollection.access$000(EagerForeignCollection.this).get(offset);
        }
    }

    public Object first()
    {
        offset = 0;
        if (offset >= EagerForeignCollection.access$000(EagerForeignCollection.this).size())
        {
            return null;
        } else
        {
            return EagerForeignCollection.access$000(EagerForeignCollection.this).get(0);
        }
    }

    public DatabaseResults getRawResults()
    {
        return null;
    }

    public boolean hasNext()
    {
        return offset + 1 < EagerForeignCollection.access$000(EagerForeignCollection.this).size();
    }

    public Object moveRelative(int i)
    {
        offset = offset + i;
        if (offset < 0 || offset >= EagerForeignCollection.access$000(EagerForeignCollection.this).size())
        {
            return null;
        } else
        {
            return EagerForeignCollection.access$000(EagerForeignCollection.this).get(offset);
        }
    }

    public void moveToNext()
    {
        offset = offset + 1;
    }

    public Object next()
    {
        offset = offset + 1;
        return EagerForeignCollection.access$000(EagerForeignCollection.this).get(offset);
    }

    public Object nextThrow()
    {
        offset = offset + 1;
        if (offset >= EagerForeignCollection.access$000(EagerForeignCollection.this).size())
        {
            return null;
        } else
        {
            return EagerForeignCollection.access$000(EagerForeignCollection.this).get(offset);
        }
    }

    public Object previous()
    {
        offset = offset - 1;
        if (offset < 0 || offset >= EagerForeignCollection.access$000(EagerForeignCollection.this).size())
        {
            return null;
        } else
        {
            return EagerForeignCollection.access$000(EagerForeignCollection.this).get(offset);
        }
    }

    public void remove()
    {
        Object obj;
        if (offset < 0)
        {
            throw new IllegalStateException("next() must be called before remove()");
        }
        if (offset >= EagerForeignCollection.access$000(EagerForeignCollection.this).size())
        {
            throw new IllegalStateException((new StringBuilder()).append("current results position (").append(offset).append(") is out of bounds").toString());
        }
        obj = EagerForeignCollection.access$000(EagerForeignCollection.this).remove(offset);
        offset = offset - 1;
        if (dao == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        dao.delete(obj);
        return;
        SQLException sqlexception;
        sqlexception;
        throw new RuntimeException(sqlexception);
    }

    ()
    {
        this$0 = EagerForeignCollection.this;
        super();
        offset = -1;
    }
}
