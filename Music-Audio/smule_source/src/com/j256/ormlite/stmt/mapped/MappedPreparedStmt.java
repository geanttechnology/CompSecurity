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
    private final Integer limit;
    private final com.j256.ormlite.stmt.StatementBuilder.StatementType type;

    public MappedPreparedStmt(TableInfo tableinfo, String s, FieldType afieldtype[], FieldType afieldtype1[], ArgumentHolder aargumentholder[], Integer integer, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype)
    {
        super(tableinfo, s, afieldtype, afieldtype1);
        argHolders = aargumentholder;
        limit = integer;
        type = statementtype;
    }

    public CompiledStatement compile(DatabaseConnection databaseconnection, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype)
    {
        CompiledStatement compiledstatement;
        if (type != statementtype)
        {
            throw new SQLException((new StringBuilder()).append("Could not compile this ").append(type).append(" statement since the caller is expecting a ").append(statementtype).append(" statement.  Check your QueryBuilder methods.").toString());
        }
        compiledstatement = databaseconnection.compileStatement(statement, statementtype, argFieldTypes);
        if (limit != null)
        {
            compiledstatement.setMaxRows(limit.intValue());
        }
        statementtype = null;
        databaseconnection = statementtype;
        if (!logger.isLevelEnabled(com.j256.ormlite.logger.Log.Level.TRACE)) goto _L2; else goto _L1
_L1:
        databaseconnection = statementtype;
        if (argHolders.length > 0)
        {
            databaseconnection = ((DatabaseConnection) (new Object[argHolders.length]));
        }
          goto _L2
_L12:
        int i;
        if (i >= argHolders.length) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = argHolders[i].getSqlArgValue();
        statementtype = argFieldTypes[i];
        if (statementtype != null) goto _L6; else goto _L5
_L5:
        statementtype = argHolders[i].getSqlType();
_L10:
        if (obj != null) goto _L8; else goto _L7
_L7:
        compiledstatement.setNull(i, statementtype);
          goto _L9
_L6:
        statementtype = statementtype.getSqlType();
          goto _L10
_L8:
        compiledstatement.setObject(i, obj, statementtype);
          goto _L9
        databaseconnection;
        compiledstatement.close();
        throw databaseconnection;
_L4:
        logger.debug("prepared statement '{}' with {} args", new Object[] {
            statement, Integer.valueOf(argHolders.length)
        });
        if (databaseconnection == null)
        {
            break MISSING_BLOCK_LABEL_273;
        }
        logger.trace("prepared statement arguments: {}", new Object[] {
            databaseconnection
        });
        return compiledstatement;
_L2:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L9:
        if (databaseconnection != null)
        {
            databaseconnection[i] = obj;
        }
        i++;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public String getStatement()
    {
        return statement;
    }

    public com.j256.ormlite.stmt.StatementBuilder.StatementType getType()
    {
        return type;
    }
}
