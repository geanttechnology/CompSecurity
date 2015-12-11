// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.stmt.mapped:
//            BaseMappedQuery

public class MappedPreparedStmt extends BaseMappedQuery
    implements PreparedDelete, PreparedQuery, PreparedUpdate
{

    private final ArgumentHolder argHolders[];
    private final Long limit;
    private final com.j256.ormlite.stmt.StatementBuilder.StatementType type;

    public MappedPreparedStmt(TableInfo tableinfo, String s, FieldType afieldtype[], FieldType afieldtype1[], ArgumentHolder aargumentholder[], Long long1, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype)
    {
        super(tableinfo, s, afieldtype, afieldtype1);
        argHolders = aargumentholder;
        limit = long1;
        type = statementtype;
    }

    private CompiledStatement assignStatementArguments(CompiledStatement compiledstatement)
        throws SQLException
    {
        if (limit != null)
        {
            compiledstatement.setMaxRows(limit.intValue());
        }
        Object aobj[];
        Object obj;
        obj = null;
        aobj = ((Object []) (obj));
        if (!logger.isLevelEnabled(com.j256.ormlite.logger.Log.Level.TRACE)) goto _L2; else goto _L1
_L1:
        aobj = ((Object []) (obj));
        if (argHolders.length > 0)
        {
            aobj = new Object[argHolders.length];
        }
          goto _L2
_L5:
        Object obj1;
        int i;
        if (i >= argHolders.length)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        obj1 = argHolders[i].getSqlArgValue();
        obj = argFieldTypes[i];
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        obj = argHolders[i].getSqlType();
_L3:
        compiledstatement.setObject(i, obj1, ((com.j256.ormlite.field.SqlType) (obj)));
        Exception exception;
        if (aobj != null)
        {
            aobj[i] = obj1;
        }
        i++;
        continue; /* Loop/switch isn't completed */
        obj = ((FieldType) (obj)).getSqlType();
          goto _L3
        logger.debug("prepared statement '{}' with {} args", statement, Integer.valueOf(argHolders.length));
        if (aobj == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        logger.trace("prepared statement arguments: {}", ((Object) (aobj)));
        return compiledstatement;
        exception;
        compiledstatement.close();
        throw exception;
_L2:
        i = 0;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L5; else goto _L4
_L4:
    }

    public CompiledStatement compile(DatabaseConnection databaseconnection, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype)
        throws SQLException
    {
        return compile(databaseconnection, statementtype, -1);
    }

    public CompiledStatement compile(DatabaseConnection databaseconnection, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype, int i)
        throws SQLException
    {
        if (type != statementtype)
        {
            throw new SQLException((new StringBuilder()).append("Could not compile this ").append(type).append(" statement since the caller is expecting a ").append(statementtype).append(" statement.  Check your QueryBuilder methods.").toString());
        } else
        {
            return assignStatementArguments(databaseconnection.compileStatement(statement, statementtype, argFieldTypes, i));
        }
    }

    public String getStatement()
    {
        return statement;
    }

    public com.j256.ormlite.stmt.StatementBuilder.StatementType getType()
    {
        return type;
    }

    public void setArgumentHolderValue(int i, Object obj)
        throws SQLException
    {
        if (i < 0)
        {
            throw new SQLException((new StringBuilder()).append("argument holder index ").append(i).append(" must be >= 0").toString());
        }
        if (argHolders.length <= i)
        {
            throw new SQLException((new StringBuilder()).append("argument holder index ").append(i).append(" is not valid, only ").append(argHolders.length).append(" in statement (index starts at 0)").toString());
        } else
        {
            argHolders[i].setValue(obj);
            return;
        }
    }
}
