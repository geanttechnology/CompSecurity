// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.stmt:
//            GenericRowMapper

public interface PreparedStmt
    extends GenericRowMapper
{

    public abstract CompiledStatement compile(DatabaseConnection databaseconnection, StatementBuilder.StatementType statementtype)
        throws SQLException;

    public abstract CompiledStatement compile(DatabaseConnection databaseconnection, StatementBuilder.StatementType statementtype, int i)
        throws SQLException;

    public abstract String getStatement()
        throws SQLException;

    public abstract StatementBuilder.StatementType getType();
}
