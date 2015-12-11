// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.SetValue;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.j256.ormlite.stmt:
//            StatementBuilder, PreparedUpdate

public class UpdateBuilder extends StatementBuilder
{

    private List updateClauseList;

    public UpdateBuilder(DatabaseType databasetype, TableInfo tableinfo, Dao dao)
    {
        super(databasetype, tableinfo, dao, StatementBuilder.StatementType.UPDATE);
        updateClauseList = null;
    }

    private void addUpdateColumnToList(String s, Clause clause)
    {
        if (updateClauseList == null)
        {
            updateClauseList = new ArrayList();
        }
        updateClauseList.add(clause);
    }

    protected void appendStatementEnd(StringBuilder stringbuilder, List list)
    {
    }

    protected void appendStatementStart(StringBuilder stringbuilder, List list)
        throws SQLException
    {
        if (updateClauseList == null || updateClauseList.isEmpty())
        {
            throw new IllegalArgumentException("UPDATE statements must have at least one SET column");
        }
        stringbuilder.append("UPDATE ");
        databaseType.appendEscapedEntityName(stringbuilder, tableInfo.getTableName());
        stringbuilder.append(" SET ");
        boolean flag = true;
        Iterator iterator = updateClauseList.iterator();
        while (iterator.hasNext()) 
        {
            Clause clause = (Clause)iterator.next();
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append(',');
            }
            clause.appendSql(databaseType, null, stringbuilder, list);
        }
    }

    public PreparedUpdate prepare()
        throws SQLException
    {
        return super.prepareStatement(null);
    }

    public int update()
        throws SQLException
    {
        return dao.update(prepare());
    }

    public StatementBuilder updateColumnValue(String s, Object obj)
        throws SQLException
    {
        FieldType fieldtype = verifyColumnName(s);
        if (fieldtype.isForeignCollection())
        {
            throw new SQLException((new StringBuilder()).append("Can't update foreign colletion field: ").append(s).toString());
        } else
        {
            addUpdateColumnToList(s, new SetValue(s, fieldtype, obj));
            return this;
        }
    }
}
