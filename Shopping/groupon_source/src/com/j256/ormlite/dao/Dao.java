// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

// Referenced classes of package com.j256.ormlite.dao:
//            CloseableIterable, CloseableIterator

public interface Dao
    extends CloseableIterable
{
    public static class CreateOrUpdateStatus
    {

        private boolean created;
        private int numLinesChanged;
        private boolean updated;

        public CreateOrUpdateStatus(boolean flag, boolean flag1, int i)
        {
            created = flag;
            updated = flag1;
            numLinesChanged = i;
        }
    }


    public abstract int create(Object obj)
        throws SQLException;

    public abstract int delete(PreparedDelete prepareddelete)
        throws SQLException;

    public abstract int delete(Object obj)
        throws SQLException;

    public abstract DeleteBuilder deleteBuilder();

    public abstract Object extractId(Object obj)
        throws SQLException;

    public abstract Class getDataClass();

    public abstract CloseableIterator iterator();

    public abstract CloseableIterator iterator(PreparedQuery preparedquery)
        throws SQLException;

    public abstract CloseableIterator iterator(PreparedQuery preparedquery, int i)
        throws SQLException;

    public abstract List query(PreparedQuery preparedquery)
        throws SQLException;

    public abstract QueryBuilder queryBuilder();

    public abstract List queryForEq(String s, Object obj)
        throws SQLException;

    public abstract Object queryForFirst(PreparedQuery preparedquery)
        throws SQLException;

    public abstract int update(PreparedUpdate preparedupdate)
        throws SQLException;
}
