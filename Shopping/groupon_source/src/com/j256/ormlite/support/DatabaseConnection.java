// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import java.sql.SQLException;
import java.sql.Savepoint;

// Referenced classes of package com.j256.ormlite.support:
//            CompiledStatement, GeneratedKeyHolder

public interface DatabaseConnection
{

    public static final Object MORE_THAN_ONE = new Object();

    public abstract void commit(Savepoint savepoint)
        throws SQLException;

    public abstract CompiledStatement compileStatement(String s, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype, FieldType afieldtype[])
        throws SQLException;

    public abstract CompiledStatement compileStatement(String s, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype, FieldType afieldtype[], int i)
        throws SQLException;

    public abstract int delete(String s, Object aobj[], FieldType afieldtype[])
        throws SQLException;

    public abstract int executeStatement(String s, int i)
        throws SQLException;

    public abstract int insert(String s, Object aobj[], FieldType afieldtype[], GeneratedKeyHolder generatedkeyholder)
        throws SQLException;

    public abstract boolean isAutoCommit()
        throws SQLException;

    public abstract boolean isAutoCommitSupported()
        throws SQLException;

    public abstract boolean isTableExists(String s)
        throws SQLException;

    public abstract long queryForLong(String s)
        throws SQLException;

    public abstract long queryForLong(String s, Object aobj[], FieldType afieldtype[])
        throws SQLException;

    public abstract Object queryForOne(String s, Object aobj[], FieldType afieldtype[], GenericRowMapper genericrowmapper, ObjectCache objectcache)
        throws SQLException;

    public abstract void rollback(Savepoint savepoint)
        throws SQLException;

    public abstract void setAutoCommit(boolean flag)
        throws SQLException;

    public abstract Savepoint setSavePoint(String s)
        throws SQLException;

    public abstract int update(String s, Object aobj[], FieldType afieldtype[])
        throws SQLException;

}
