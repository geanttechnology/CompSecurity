// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.j256.ormlite.stmt:
//            StatementBuilder, ArgumentHolder, PreparedQuery

public class QueryBuilder extends StatementBuilder
{
    private class JoinInfo
    {

        FieldType localField;
        StatementBuilder.WhereOperation operation;
        final QueryBuilder queryBuilder;
        FieldType remoteField;
        final String type;
    }


    private boolean distinct;
    private List groupByList;
    private String groupByRaw;
    private String having;
    private final FieldType idField;
    private boolean isCountOfQuery;
    private boolean isInnerQuery;
    private List joinList;
    private Long limit;
    private Long offset;
    private ArgumentHolder orderByArgs[];
    private List orderByList;
    private String orderByRaw;
    private FieldType resultFieldTypes[];
    private List selectColumnList;
    private boolean selectIdColumn;
    private List selectRawList;

    public QueryBuilder(DatabaseType databasetype, TableInfo tableinfo, Dao dao)
    {
        super(databasetype, tableinfo, dao, StatementBuilder.StatementType.SELECT);
        selectIdColumn = true;
        idField = tableinfo.getIdField();
    }

    private void appendColumnName(StringBuilder stringbuilder, String s)
    {
        if (addTableName)
        {
            databaseType.appendEscapedEntityName(stringbuilder, tableName);
            stringbuilder.append('.');
        }
        databaseType.appendEscapedEntityName(stringbuilder, s);
    }

    private void appendColumns(StringBuilder stringbuilder)
    {
        if (selectColumnList == null)
        {
            if (addTableName)
            {
                databaseType.appendEscapedEntityName(stringbuilder, tableName);
                stringbuilder.append('.');
            }
            stringbuilder.append("* ");
            resultFieldTypes = tableInfo.getFieldTypes();
            return;
        }
        boolean flag1 = true;
        ArrayList arraylist;
        Iterator iterator1;
        boolean flag;
        if (isInnerQuery)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        arraylist = new ArrayList(selectColumnList.size() + 1);
        iterator1 = selectColumnList.iterator();
        do
        {
            if (iterator1.hasNext())
            {
                Object obj = (String)iterator1.next();
                obj = tableInfo.getFieldTypeByColumnName(((String) (obj)));
                if (((FieldType) (obj)).isForeignCollection())
                {
                    arraylist.add(obj);
                } else
                {
                    boolean flag2;
                    if (flag1)
                    {
                        flag2 = false;
                    } else
                    {
                        stringbuilder.append(',');
                        flag2 = flag1;
                    }
                    appendFieldColumnName(stringbuilder, ((FieldType) (obj)), arraylist);
                    flag1 = flag2;
                    if (obj == idField)
                    {
                        flag = true;
                        flag1 = flag2;
                    }
                }
            } else
            {
                if (!flag && selectIdColumn)
                {
                    if (!flag1)
                    {
                        stringbuilder.append(',');
                    }
                    appendFieldColumnName(stringbuilder, idField, arraylist);
                }
                stringbuilder.append(' ');
                resultFieldTypes = (FieldType[])arraylist.toArray(new FieldType[arraylist.size()]);
                return;
            }
        } while (true);
    }

    private void appendFieldColumnName(StringBuilder stringbuilder, FieldType fieldtype, List list)
    {
        appendColumnName(stringbuilder, fieldtype.getColumnName());
        if (list != null)
        {
            list.add(fieldtype);
        }
    }

    private void appendGroupBys(StringBuilder stringbuilder)
    {
        boolean flag = true;
        if (hasGroupStuff())
        {
            appendGroupBys(stringbuilder, true);
            flag = false;
        }
        if (joinList != null)
        {
            Iterator iterator1 = joinList.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                JoinInfo joininfo = (JoinInfo)iterator1.next();
                if (joininfo.queryBuilder != null && joininfo.queryBuilder.hasGroupStuff())
                {
                    joininfo.queryBuilder.appendGroupBys(stringbuilder, flag);
                }
            } while (true);
        }
    }

    private void appendGroupBys(StringBuilder stringbuilder, boolean flag)
    {
        if (flag)
        {
            stringbuilder.append("GROUP BY ");
        }
        if (groupByRaw != null)
        {
            if (!flag)
            {
                stringbuilder.append(',');
            }
            stringbuilder.append(groupByRaw);
        } else
        {
            Iterator iterator1 = groupByList.iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                if (flag)
                {
                    flag = false;
                } else
                {
                    stringbuilder.append(',');
                }
                appendColumnName(stringbuilder, s);
            }
        }
        stringbuilder.append(' ');
    }

    private void appendHaving(StringBuilder stringbuilder)
    {
        if (having != null)
        {
            stringbuilder.append("HAVING ").append(having).append(' ');
        }
    }

    private void appendJoinSql(StringBuilder stringbuilder)
    {
        Iterator iterator1 = joinList.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            JoinInfo joininfo = (JoinInfo)iterator1.next();
            stringbuilder.append(joininfo.type).append(" JOIN ");
            databaseType.appendEscapedEntityName(stringbuilder, joininfo.queryBuilder.tableName);
            stringbuilder.append(" ON ");
            databaseType.appendEscapedEntityName(stringbuilder, tableName);
            stringbuilder.append('.');
            databaseType.appendEscapedEntityName(stringbuilder, joininfo.localField.getColumnName());
            stringbuilder.append(" = ");
            databaseType.appendEscapedEntityName(stringbuilder, joininfo.queryBuilder.tableName);
            stringbuilder.append('.');
            databaseType.appendEscapedEntityName(stringbuilder, joininfo.remoteField.getColumnName());
            stringbuilder.append(' ');
            if (joininfo.queryBuilder.joinList != null)
            {
                joininfo.queryBuilder.appendJoinSql(stringbuilder);
            }
        } while (true);
    }

    private void appendLimit(StringBuilder stringbuilder)
    {
        if (limit != null && databaseType.isLimitSqlSupported())
        {
            databaseType.appendLimitValue(stringbuilder, limit.longValue(), offset);
        }
    }

    private void appendOffset(StringBuilder stringbuilder)
        throws SQLException
    {
        if (offset != null)
        {
            if (databaseType.isOffsetLimitArgument())
            {
                if (limit == null)
                {
                    throw new SQLException("If the offset is specified, limit must also be specified with this database");
                }
            } else
            {
                databaseType.appendOffsetValue(stringbuilder, offset.longValue());
                return;
            }
        }
    }

    private void appendOrderBys(StringBuilder stringbuilder, List list)
    {
        boolean flag = true;
        if (hasOrderStuff())
        {
            appendOrderBys(stringbuilder, true, list);
            flag = false;
        }
        if (joinList != null)
        {
            Iterator iterator1 = joinList.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                JoinInfo joininfo = (JoinInfo)iterator1.next();
                if (joininfo.queryBuilder != null && joininfo.queryBuilder.hasOrderStuff())
                {
                    joininfo.queryBuilder.appendOrderBys(stringbuilder, flag, list);
                }
            } while (true);
        }
    }

    private void appendOrderBys(StringBuilder stringbuilder, boolean flag, List list)
    {
        if (flag)
        {
            stringbuilder.append("ORDER BY ");
        }
        if (orderByRaw != null)
        {
            if (!flag)
            {
                stringbuilder.append(',');
            }
            stringbuilder.append(orderByRaw);
            if (orderByArgs != null)
            {
                ArgumentHolder aargumentholder[] = orderByArgs;
                int j = aargumentholder.length;
                for (int i = 0; i < j; i++)
                {
                    list.add(aargumentholder[i]);
                }

            }
        } else
        {
            list = orderByList.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                OrderBy orderby = (OrderBy)list.next();
                boolean flag1;
                if (flag)
                {
                    flag1 = false;
                } else
                {
                    stringbuilder.append(',');
                    flag1 = flag;
                }
                appendColumnName(stringbuilder, orderby.getColumnName());
                flag = flag1;
                if (!orderby.isAscending())
                {
                    stringbuilder.append(" DESC");
                    flag = flag1;
                }
            } while (true);
        }
        stringbuilder.append(' ');
    }

    private void appendSelectRaw(StringBuilder stringbuilder)
    {
        boolean flag = true;
        Iterator iterator1 = selectRawList.iterator();
        while (iterator1.hasNext()) 
        {
            String s = (String)iterator1.next();
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(s);
        }
        stringbuilder.append(' ');
    }

    private boolean hasGroupStuff()
    {
        return groupByList != null && !groupByList.isEmpty() || groupByRaw != null;
    }

    private boolean hasOrderStuff()
    {
        return orderByList != null && !orderByList.isEmpty() || orderByRaw != null;
    }

    private void setAddTableName(boolean flag)
    {
        addTableName = flag;
        if (joinList != null)
        {
            for (Iterator iterator1 = joinList.iterator(); iterator1.hasNext(); ((JoinInfo)iterator1.next()).queryBuilder.setAddTableName(flag)) { }
        }
    }

    protected void appendStatementEnd(StringBuilder stringbuilder, List list)
        throws SQLException
    {
        appendGroupBys(stringbuilder);
        appendHaving(stringbuilder);
        appendOrderBys(stringbuilder, list);
        if (!databaseType.isLimitAfterSelect())
        {
            appendLimit(stringbuilder);
        }
        appendOffset(stringbuilder);
        setAddTableName(false);
    }

    protected void appendStatementStart(StringBuilder stringbuilder, List list)
    {
        if (joinList == null)
        {
            setAddTableName(false);
        } else
        {
            setAddTableName(true);
        }
        stringbuilder.append("SELECT ");
        if (databaseType.isLimitAfterSelect())
        {
            appendLimit(stringbuilder);
        }
        if (distinct)
        {
            stringbuilder.append("DISTINCT ");
        }
        if (isCountOfQuery)
        {
            type = StatementBuilder.StatementType.SELECT_LONG;
            stringbuilder.append("COUNT(*) ");
        } else
        if (selectRawList != null && !selectRawList.isEmpty())
        {
            type = StatementBuilder.StatementType.SELECT_RAW;
            appendSelectRaw(stringbuilder);
        } else
        {
            type = StatementBuilder.StatementType.SELECT;
            appendColumns(stringbuilder);
        }
        stringbuilder.append("FROM ");
        databaseType.appendEscapedEntityName(stringbuilder, tableName);
        stringbuilder.append(' ');
        if (joinList != null)
        {
            appendJoinSql(stringbuilder);
        }
    }

    protected boolean appendWhereStatement(StringBuilder stringbuilder, List list, StatementBuilder.WhereOperation whereoperation)
        throws SQLException
    {
        boolean flag;
        boolean flag1;
        if (whereoperation == StatementBuilder.WhereOperation.FIRST)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (where != null)
        {
            flag = super.appendWhereStatement(stringbuilder, list, whereoperation);
        }
        flag1 = flag;
        if (joinList != null)
        {
            Iterator iterator1 = joinList.iterator();
            do
            {
                flag1 = flag;
                if (!iterator1.hasNext())
                {
                    break;
                }
                JoinInfo joininfo = (JoinInfo)iterator1.next();
                if (flag)
                {
                    whereoperation = StatementBuilder.WhereOperation.FIRST;
                } else
                {
                    whereoperation = joininfo.operation;
                }
                flag = joininfo.queryBuilder.appendWhereStatement(stringbuilder, list, whereoperation);
            } while (true);
        }
        return flag1;
    }

    protected FieldType[] getResultFieldTypes()
    {
        return resultFieldTypes;
    }

    public CloseableIterator iterator()
        throws SQLException
    {
        return dao.iterator(prepare());
    }

    public QueryBuilder limit(Long long1)
    {
        limit = long1;
        return this;
    }

    public QueryBuilder orderBy(String s, boolean flag)
    {
        if (verifyColumnName(s).isForeignCollection())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can't orderBy foreign colletion field: ").append(s).toString());
        }
        if (orderByList == null)
        {
            orderByList = new ArrayList();
        }
        orderByList.add(new OrderBy(s, flag));
        return this;
    }

    public PreparedQuery prepare()
        throws SQLException
    {
        return super.prepareStatement(limit);
    }

    public List query()
        throws SQLException
    {
        return dao.query(prepare());
    }

    public transient QueryBuilder selectRaw(String as[])
    {
        if (selectRawList == null)
        {
            selectRawList = new ArrayList();
        }
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            selectRawList.add(s);
        }

        return this;
    }
}
