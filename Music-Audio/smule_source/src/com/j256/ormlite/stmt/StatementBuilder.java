// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import com.j256.ormlite.table.TableInfo;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.j256.ormlite.stmt:
//            Where, ArgumentHolder

public abstract class StatementBuilder
{

    private static Logger logger = LoggerFactory.getLogger(com/j256/ormlite/stmt/StatementBuilder);
    protected final DatabaseType databaseType;
    protected Integer limit;
    protected Integer offset;
    protected final TableInfo tableInfo;
    protected StatementType type;
    private Where where;

    public StatementBuilder(DatabaseType databasetype, TableInfo tableinfo, StatementType statementtype)
    {
        where = null;
        limit = null;
        offset = null;
        databaseType = databasetype;
        tableInfo = tableinfo;
        type = statementtype;
        if (!statementtype.isOkForStatementBuilder())
        {
            throw new IllegalStateException((new StringBuilder()).append("Building a statement from a ").append(statementtype).append(" statement is not allowed").toString());
        } else
        {
            return;
        }
    }

    private String buildStatementString(List list)
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        appendStatementString(stringbuilder, list);
        list = stringbuilder.toString();
        logger.debug("built statement {}", new Object[] {
            list
        });
        return list;
    }

    protected abstract void appendStatementEnd(StringBuilder stringbuilder);

    protected abstract void appendStatementStart(StringBuilder stringbuilder, List list);

    protected void appendStatementString(StringBuilder stringbuilder, List list)
    {
        appendStatementStart(stringbuilder, list);
        if (where != null)
        {
            stringbuilder.append("WHERE ");
            where.appendSql(stringbuilder, list);
        }
        appendStatementEnd(stringbuilder);
    }

    protected FieldType[] getResultFieldTypes()
    {
        return null;
    }

    StatementType getType()
    {
        return type;
    }

    protected MappedPreparedStmt prepareStatement()
    {
        Object obj = new ArrayList();
        String s = buildStatementString(((List) (obj)));
        ArgumentHolder aargumentholder[] = (ArgumentHolder[])((List) (obj)).toArray(new ArgumentHolder[((List) (obj)).size()]);
        FieldType afieldtype[] = getResultFieldTypes();
        FieldType afieldtype1[] = new FieldType[((List) (obj)).size()];
        for (int i = 0; i < aargumentholder.length; i++)
        {
            afieldtype1[i] = aargumentholder[i].getFieldType();
        }

        if (!type.isOkForStatementBuilder())
        {
            throw new IllegalStateException((new StringBuilder()).append("Building a statement from a ").append(type).append(" statement is not allowed").toString());
        }
        TableInfo tableinfo = tableInfo;
        if (databaseType.isLimitSqlSupported())
        {
            obj = null;
        } else
        {
            obj = limit;
        }
        return new MappedPreparedStmt(tableinfo, s, afieldtype1, afieldtype, aargumentholder, ((Integer) (obj)), type);
    }

    public String prepareStatementString()
    {
        return buildStatementString(new ArrayList());
    }

    public void setWhere(Where where1)
    {
        where = where1;
    }

    protected FieldType verifyColumnName(String s)
    {
        return tableInfo.getFieldTypeByColumnName(s);
    }

    public Where where()
    {
        where = new Where(tableInfo, this, databaseType);
        return where;
    }


    private class StatementType extends Enum
    {

        private static final StatementType $VALUES[];
        public static final StatementType DELETE;
        public static final StatementType EXECUTE;
        public static final StatementType SELECT;
        public static final StatementType SELECT_LONG;
        public static final StatementType SELECT_RAW;
        public static final StatementType UPDATE;
        private final boolean okForStatementBuilder;

        public static StatementType valueOf(String s)
        {
            return (StatementType)Enum.valueOf(com/j256/ormlite/stmt/StatementBuilder$StatementType, s);
        }

        public static StatementType[] values()
        {
            return (StatementType[])$VALUES.clone();
        }

        public boolean isOkForStatementBuilder()
        {
            return okForStatementBuilder;
        }

        static 
        {
            SELECT = new StatementType("SELECT", 0, true);
            SELECT_LONG = new StatementType("SELECT_LONG", 1, true);
            SELECT_RAW = new StatementType("SELECT_RAW", 2, true);
            UPDATE = new StatementType("UPDATE", 3, true);
            DELETE = new StatementType("DELETE", 4, true);
            EXECUTE = new StatementType("EXECUTE", 5, false);
            $VALUES = (new StatementType[] {
                SELECT, SELECT_LONG, SELECT_RAW, UPDATE, DELETE, EXECUTE
            });
        }

        private StatementType(String s, int i, boolean flag)
        {
            super(s, i);
            okForStatementBuilder = flag;
        }
    }

}
