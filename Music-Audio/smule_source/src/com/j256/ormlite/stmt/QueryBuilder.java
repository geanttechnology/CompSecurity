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
//            StatementBuilder, PreparedQuery

public class QueryBuilder extends StatementBuilder
{

    private boolean countOf;
    private final Dao dao;
    private boolean distinct;
    private List groupByList;
    private String groupByRaw;
    private final FieldType idField;
    private boolean isInnerQuery;
    private List orderByList;
    private String orderByRaw;
    private FieldType resultFieldTypes[];
    private List selectColumnList;
    private boolean selectIdColumn;
    private List selectRawList;

    public QueryBuilder(DatabaseType databasetype, TableInfo tableinfo, Dao dao1)
    {
        super(databasetype, tableinfo, StatementBuilder.StatementType.SELECT);
        distinct = false;
        selectIdColumn = true;
        selectColumnList = null;
        selectRawList = null;
        orderByList = null;
        orderByRaw = null;
        groupByList = null;
        groupByRaw = null;
        isInnerQuery = false;
        countOf = false;
        idField = tableinfo.getIdField();
        dao = dao1;
    }

    private void addSelectColumnToList(String s)
    {
        if (verifyColumnName(s).isForeignCollection())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can't select from foreign colletion field: ").append(s).toString());
        } else
        {
            selectColumnList.add(s);
            return;
        }
    }

    private void appendColumns(StringBuilder stringbuilder)
    {
        if (selectColumnList == null)
        {
            stringbuilder.append("* ");
            resultFieldTypes = tableInfo.getFieldTypes();
            return;
        }
        ArrayList arraylist;
        Iterator iterator1;
        boolean flag;
        boolean flag1;
        if (isInnerQuery)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        arraylist = new ArrayList(selectColumnList.size() + 1);
        iterator1 = selectColumnList.iterator();
        flag1 = true;
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Object obj = (String)iterator1.next();
            if (flag1)
            {
                flag1 = false;
            } else
            {
                stringbuilder.append(',');
            }
            obj = tableInfo.getFieldTypeByColumnName(((String) (obj)));
            appendFieldColumnName(stringbuilder, ((FieldType) (obj)), arraylist);
            if (obj == idField)
            {
                flag = true;
            }
        } while (true);
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
    }

    private void appendFieldColumnName(StringBuilder stringbuilder, FieldType fieldtype, List list)
    {
        databaseType.appendEscapedEntityName(stringbuilder, fieldtype.getDbColumnName());
        if (list != null)
        {
            list.add(fieldtype);
        }
    }

    private void appendGroupBys(StringBuilder stringbuilder)
    {
        if ((groupByList == null || groupByList.isEmpty()) && groupByRaw == null)
        {
            return;
        }
        stringbuilder.append("GROUP BY ");
        if (groupByRaw != null)
        {
            stringbuilder.append(groupByRaw);
        } else
        {
            Iterator iterator1 = groupByList.iterator();
            boolean flag = true;
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
                databaseType.appendEscapedEntityName(stringbuilder, s);
            }
        }
        stringbuilder.append(' ');
    }

    private void appendLimit(StringBuilder stringbuilder)
    {
        if (limit != null && databaseType.isLimitSqlSupported())
        {
            databaseType.appendLimitValue(stringbuilder, limit.intValue(), offset);
        }
    }

    private void appendOffset(StringBuilder stringbuilder)
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
                databaseType.appendOffsetValue(stringbuilder, offset.intValue());
                return;
            }
        }
    }

    private void appendOrderBys(StringBuilder stringbuilder)
    {
        if ((orderByList == null || orderByList.isEmpty()) && orderByRaw == null)
        {
            return;
        }
        stringbuilder.append("ORDER BY ");
        if (orderByRaw != null)
        {
            stringbuilder.append(orderByRaw);
        } else
        {
            Iterator iterator1 = orderByList.iterator();
            boolean flag = true;
            while (iterator1.hasNext()) 
            {
                OrderBy orderby = (OrderBy)iterator1.next();
                String s;
                boolean flag1;
                if (flag)
                {
                    flag1 = false;
                } else
                {
                    stringbuilder.append(',');
                    flag1 = flag;
                }
                s = orderby.getColumnName();
                databaseType.appendEscapedEntityName(stringbuilder, s);
                flag = flag1;
                if (!orderby.isAscending())
                {
                    stringbuilder.append(" DESC");
                    flag = flag1;
                }
            }
        }
        stringbuilder.append(' ');
    }

    private void appendRawColumns(StringBuilder stringbuilder)
    {
        Iterator iterator1 = selectRawList.iterator();
        boolean flag = true;
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

    protected void appendStatementEnd(StringBuilder stringbuilder)
    {
        appendGroupBys(stringbuilder);
        appendOrderBys(stringbuilder);
        if (!databaseType.isLimitAfterSelect())
        {
            appendLimit(stringbuilder);
        }
        appendOffset(stringbuilder);
    }

    protected void appendStatementStart(StringBuilder stringbuilder, List list)
    {
        stringbuilder.append("SELECT ");
        if (databaseType.isLimitAfterSelect())
        {
            appendLimit(stringbuilder);
        }
        if (distinct)
        {
            stringbuilder.append("DISTINCT ");
        }
        if (countOf)
        {
            type = StatementBuilder.StatementType.SELECT_LONG;
            stringbuilder.append("COUNT(*) ");
        } else
        if (selectRawList != null && !selectRawList.isEmpty())
        {
            type = StatementBuilder.StatementType.SELECT_RAW;
            appendRawColumns(stringbuilder);
        } else
        {
            type = StatementBuilder.StatementType.SELECT;
            appendColumns(stringbuilder);
        }
        stringbuilder.append("FROM ");
        databaseType.appendEscapedEntityName(stringbuilder, tableInfo.getTableName());
        stringbuilder.append(' ');
    }

    public QueryBuilder distinct()
    {
        distinct = true;
        selectIdColumn = false;
        return this;
    }

    void enableInnerQuery()
    {
        isInnerQuery = true;
    }

    protected FieldType[] getResultFieldTypes()
    {
        return resultFieldTypes;
    }

    int getSelectColumnCount()
    {
        if (selectColumnList == null)
        {
            return 0;
        } else
        {
            return selectColumnList.size();
        }
    }

    public QueryBuilder groupBy(String s)
    {
        if (verifyColumnName(s).isForeignCollection())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can't groupBy foreign colletion field: ").append(s).toString());
        }
        if (groupByList == null)
        {
            groupByList = new ArrayList();
        }
        groupByList.add(s);
        selectIdColumn = false;
        return this;
    }

    public QueryBuilder groupByRaw(String s)
    {
        groupByRaw = s;
        return this;
    }

    public CloseableIterator iterator()
    {
        return dao.iterator(prepare());
    }

    public QueryBuilder limit(Integer integer)
    {
        limit = integer;
        return this;
    }

    public QueryBuilder offset(Integer integer)
    {
        if (databaseType.isOffsetSqlSupported())
        {
            offset = integer;
            return this;
        } else
        {
            throw new SQLException("Offset is not supported by this database");
        }
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

    public QueryBuilder orderByRaw(String s)
    {
        orderByRaw = s;
        return this;
    }

    public PreparedQuery prepare()
    {
        return super.prepareStatement();
    }

    public List query()
    {
        return dao.query(prepare());
    }

    public QueryBuilder selectColumns(Iterable iterable)
    {
        if (selectColumnList == null)
        {
            selectColumnList = new ArrayList();
        }
        for (iterable = iterable.iterator(); iterable.hasNext(); addSelectColumnToList((String)iterable.next())) { }
        return this;
    }

    public transient QueryBuilder selectColumns(String as[])
    {
        if (selectColumnList == null)
        {
            selectColumnList = new ArrayList();
        }
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            addSelectColumnToList(as[i]);
        }

        return this;
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

    public QueryBuilder setCountOf(boolean flag)
    {
        countOf = flag;
        return this;
    }

}
