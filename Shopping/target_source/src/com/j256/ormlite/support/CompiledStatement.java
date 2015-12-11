// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.support:
//            DatabaseResults

public interface CompiledStatement
{

    public abstract void cancel()
        throws SQLException;

    public abstract void close()
        throws SQLException;

    public abstract void closeQuietly();

    public abstract int getColumnCount()
        throws SQLException;

    public abstract String getColumnName(int i)
        throws SQLException;

    public abstract int runExecute()
        throws SQLException;

    public abstract DatabaseResults runQuery(ObjectCache objectcache)
        throws SQLException;

    public abstract int runUpdate()
        throws SQLException;

    public abstract void setMaxRows(int i)
        throws SQLException;

    public abstract void setObject(int i, Object obj, SqlType sqltype)
        throws SQLException;

    public abstract void setQueryTimeout(long l)
        throws SQLException;
}
