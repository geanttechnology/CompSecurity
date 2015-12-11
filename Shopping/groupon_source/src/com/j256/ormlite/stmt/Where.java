// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.Between;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.stmt.query.ManyClause;
import com.j256.ormlite.stmt.query.NeedsFutureClause;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.List;

// Referenced classes of package com.j256.ormlite.stmt:
//            QueryBuilder, StatementBuilder, PreparedQuery

public class Where
{

    private Clause clauseStack[];
    private int clauseStackLevel;
    private final DatabaseType databaseType;
    private final String idColumnName;
    private final FieldType idFieldType;
    private NeedsFutureClause needsFuture;
    private final StatementBuilder statementBuilder;
    private final TableInfo tableInfo;

    Where(TableInfo tableinfo, StatementBuilder statementbuilder, DatabaseType databasetype)
    {
        clauseStack = new Clause[4];
        clauseStackLevel = 0;
        needsFuture = null;
        tableInfo = tableinfo;
        statementBuilder = statementbuilder;
        idFieldType = tableinfo.getIdField();
        if (idFieldType == null)
        {
            idColumnName = null;
        } else
        {
            idColumnName = idFieldType.getColumnName();
        }
        databaseType = databasetype;
    }

    private void addClause(Clause clause)
    {
        if (needsFuture == null)
        {
            push(clause);
            return;
        } else
        {
            needsFuture.setMissingClause(clause);
            needsFuture = null;
            return;
        }
    }

    private void addNeedsFuture(NeedsFutureClause needsfutureclause)
    {
        if (needsFuture != null)
        {
            throw new IllegalStateException((new StringBuilder()).append(needsFuture).append(" is already waiting for a future clause, can't add: ").append(needsfutureclause).toString());
        } else
        {
            needsFuture = needsfutureclause;
            push(needsfutureclause);
            return;
        }
    }

    private Clause[] buildClauseArray(Where awhere[], String s)
    {
        if (awhere.length != 0) goto _L2; else goto _L1
_L1:
        awhere = null;
_L4:
        return awhere;
_L2:
        Clause aclause[] = new Clause[awhere.length];
        int i = awhere.length - 1;
        do
        {
            awhere = aclause;
            if (i < 0)
            {
                continue;
            }
            aclause[i] = pop(s);
            i--;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private QueryBuilder checkQueryBuilderMethod(String s)
        throws SQLException
    {
        if (statementBuilder instanceof QueryBuilder)
        {
            return (QueryBuilder)statementBuilder;
        } else
        {
            throw new SQLException((new StringBuilder()).append("Cannot call ").append(s).append(" on a statement of type ").append(statementBuilder.getType()).toString());
        }
    }

    private FieldType findColumnFieldType(String s)
    {
        return tableInfo.getFieldTypeByColumnName(s);
    }

    private Clause peek()
    {
        return clauseStack[clauseStackLevel - 1];
    }

    private Clause pop(String s)
    {
        if (clauseStackLevel == 0)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expecting there to be a clause already defined for '").append(s).append("' operation").toString());
        } else
        {
            s = clauseStack;
            int i = clauseStackLevel - 1;
            clauseStackLevel = i;
            s = s[i];
            clauseStack[clauseStackLevel] = null;
            return s;
        }
    }

    private void push(Clause clause)
    {
        if (clauseStackLevel == clauseStack.length)
        {
            Clause aclause[] = new Clause[clauseStackLevel * 2];
            for (int i = 0; i < clauseStackLevel; i++)
            {
                aclause[i] = clauseStack[i];
                clauseStack[i] = null;
            }

            clauseStack = aclause;
        }
        Clause aclause1[] = clauseStack;
        int j = clauseStackLevel;
        clauseStackLevel = j + 1;
        aclause1[j] = clause;
    }

    public Where and()
    {
        addNeedsFuture(new ManyClause(pop("AND"), "AND"));
        return this;
    }

    public Where and(int i)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Must have at least one clause in and(numClauses)");
        }
        Clause aclause[] = new Clause[i];
        for (i--; i >= 0; i--)
        {
            aclause[i] = pop("AND");
        }

        addClause(new ManyClause(aclause, "AND"));
        return this;
    }

    public transient Where and(Where where, Where where1, Where awhere[])
    {
        where = buildClauseArray(awhere, "AND");
        where1 = pop("AND");
        addClause(new ManyClause(pop("AND"), where1, where, "AND"));
        return this;
    }

    void appendSql(String s, StringBuilder stringbuilder, List list)
        throws SQLException
    {
        if (clauseStackLevel == 0)
        {
            throw new IllegalStateException("No where clauses defined.  Did you miss a where operation?");
        }
        if (clauseStackLevel != 1)
        {
            throw new IllegalStateException("Both the \"left-hand\" and \"right-hand\" clauses have been defined.  Did you miss an AND or OR?");
        } else
        {
            peek().appendSql(databaseType, s, stringbuilder, list);
            return;
        }
    }

    public Where between(String s, Object obj, Object obj1)
        throws SQLException
    {
        addClause(new Between(s, findColumnFieldType(s), obj, obj1));
        return this;
    }

    public Where eq(String s, Object obj)
        throws SQLException
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, "="));
        return this;
    }

    public Where ge(String s, Object obj)
        throws SQLException
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, ">="));
        return this;
    }

    public Where gt(String s, Object obj)
        throws SQLException
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, ">"));
        return this;
    }

    public Where in(String s, Iterable iterable)
        throws SQLException
    {
        addClause(new In(s, findColumnFieldType(s), iterable, true));
        return this;
    }

    public CloseableIterator iterator()
        throws SQLException
    {
        return checkQueryBuilderMethod("iterator()").iterator();
    }

    public Where le(String s, Object obj)
        throws SQLException
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, "<="));
        return this;
    }

    public Where like(String s, Object obj)
        throws SQLException
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, "LIKE"));
        return this;
    }

    public Where lt(String s, Object obj)
        throws SQLException
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, "<"));
        return this;
    }

    public Where ne(String s, Object obj)
        throws SQLException
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, "<>"));
        return this;
    }

    public PreparedQuery prepare()
        throws SQLException
    {
        return statementBuilder.prepareStatement(null);
    }

    public List query()
        throws SQLException
    {
        return checkQueryBuilderMethod("query()").query();
    }

    public String toString()
    {
        if (clauseStackLevel == 0)
        {
            return "empty where clause";
        } else
        {
            Clause clause = peek();
            return (new StringBuilder()).append("where clause: ").append(clause).toString();
        }
    }
}
