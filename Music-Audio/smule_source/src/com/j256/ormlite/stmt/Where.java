// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.query.Between;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.Exists;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.stmt.query.InSubQuery;
import com.j256.ormlite.stmt.query.IsNotNull;
import com.j256.ormlite.stmt.query.IsNull;
import com.j256.ormlite.stmt.query.ManyClause;
import com.j256.ormlite.stmt.query.NeedsFutureClause;
import com.j256.ormlite.stmt.query.Not;
import com.j256.ormlite.stmt.query.Raw;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.j256.ormlite.stmt:
//            QueryBuilder, StatementBuilder, ArgumentHolder, PreparedQuery

public class Where
{

    private static final int START_CLAUSE_SIZE = 4;
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
            idColumnName = idFieldType.getDbColumnName();
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
        s = new Clause[awhere.length];
        int i = awhere.length - 1;
        do
        {
            awhere = s;
            if (i < 0)
            {
                continue;
            }
            s[i] = pop("AND");
            i--;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
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

    void appendSql(StringBuilder stringbuilder, List list)
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
            peek().appendSql(databaseType, stringbuilder, list);
            return;
        }
    }

    public Where between(String s, Object obj, Object obj1)
    {
        addClause(new Between(s, findColumnFieldType(s), obj, obj1));
        return this;
    }

    public void clear()
    {
        for (int i = 0; i < clauseStackLevel; i++)
        {
            clauseStack[i] = null;
        }

        clauseStackLevel = 0;
    }

    public Where eq(String s, Object obj)
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, "="));
        return this;
    }

    public Where exists(QueryBuilder querybuilder)
    {
        querybuilder.enableInnerQuery();
        addClause(new Exists(new QueryBuilder.InternalQueryBuilderWrapper(querybuilder)));
        return this;
    }

    public Where ge(String s, Object obj)
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, ">="));
        return this;
    }

    public String getStatement()
    {
        StringBuilder stringbuilder = new StringBuilder();
        appendSql(stringbuilder, new ArrayList());
        return stringbuilder.toString();
    }

    public Where gt(String s, Object obj)
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, ">"));
        return this;
    }

    public Where idEq(Dao dao, Object obj)
    {
        if (idColumnName == null)
        {
            throw new SQLException("Object has no id column specified");
        } else
        {
            addClause(new SimpleComparison(idColumnName, idFieldType, dao.extractId(obj), "="));
            return this;
        }
    }

    public Where idEq(Object obj)
    {
        if (idColumnName == null)
        {
            throw new SQLException("Object has no id column specified");
        } else
        {
            addClause(new SimpleComparison(idColumnName, idFieldType, obj, "="));
            return this;
        }
    }

    public Where in(String s, QueryBuilder querybuilder)
    {
        if (querybuilder.getSelectColumnCount() != 1)
        {
            throw new SQLException((new StringBuilder()).append("Inner query must have only 1 select column specified instead of ").append(querybuilder.getSelectColumnCount()).toString());
        } else
        {
            querybuilder.enableInnerQuery();
            addClause(new InSubQuery(s, findColumnFieldType(s), new QueryBuilder.InternalQueryBuilderWrapper(querybuilder)));
            return this;
        }
    }

    public Where in(String s, Iterable iterable)
    {
        addClause(new In(s, findColumnFieldType(s), iterable));
        return this;
    }

    public transient Where in(String s, Object aobj[])
    {
        if (aobj.length == 1)
        {
            if (aobj[0].getClass().isArray())
            {
                throw new IllegalArgumentException("Object argument to IN seems to be an array within an array");
            }
            if (aobj[0].getClass() == com/j256/ormlite/stmt/Where)
            {
                throw new IllegalArgumentException("Object argument to IN seems to be a Where.class instead of a QueryBuilder.class");
            }
        }
        addClause(new In(s, findColumnFieldType(s), aobj));
        return this;
    }

    public Where isNotNull(String s)
    {
        addClause(new IsNotNull(s, findColumnFieldType(s)));
        return this;
    }

    public Where isNull(String s)
    {
        addClause(new IsNull(s, findColumnFieldType(s)));
        return this;
    }

    public CloseableIterator iterator()
    {
        if (statementBuilder instanceof QueryBuilder)
        {
            return ((QueryBuilder)statementBuilder).iterator();
        } else
        {
            throw new SQLException((new StringBuilder()).append("Cannot call iterator on a statement of type ").append(statementBuilder.getType()).toString());
        }
    }

    public Where le(String s, Object obj)
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, "<="));
        return this;
    }

    public Where like(String s, Object obj)
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, "LIKE"));
        return this;
    }

    public Where lt(String s, Object obj)
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, "<"));
        return this;
    }

    public Where ne(String s, Object obj)
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, "<>"));
        return this;
    }

    public Where not()
    {
        addNeedsFuture(new Not());
        return this;
    }

    public Where not(Where where)
    {
        addClause(new Not(pop("NOT")));
        return this;
    }

    public Where or()
    {
        addNeedsFuture(new ManyClause(pop("OR"), "OR"));
        return this;
    }

    public Where or(int i)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Must have at least one clause in or(numClauses)");
        }
        Clause aclause[] = new Clause[i];
        for (i--; i >= 0; i--)
        {
            aclause[i] = pop("OR");
        }

        addClause(new ManyClause(aclause, "OR"));
        return this;
    }

    public transient Where or(Where where, Where where1, Where awhere[])
    {
        where = buildClauseArray(awhere, "OR");
        where1 = pop("OR");
        addClause(new ManyClause(pop("OR"), where1, where, "OR"));
        return this;
    }

    public PreparedQuery prepare()
    {
        return statementBuilder.prepareStatement();
    }

    public List query()
    {
        if (statementBuilder instanceof QueryBuilder)
        {
            return ((QueryBuilder)statementBuilder).query();
        } else
        {
            throw new SQLException((new StringBuilder()).append("Cannot call query on a statement of type ").append(statementBuilder.getType()).toString());
        }
    }

    public transient Where raw(String s, ArgumentHolder aargumentholder[])
    {
        int j = aargumentholder.length;
        for (int i = 0; i < j; i++)
        {
            ArgumentHolder argumentholder = aargumentholder[i];
            String s1 = argumentholder.getColumnName();
            if (s1 == null)
            {
                if (argumentholder.getSqlType() == null)
                {
                    throw new IllegalArgumentException("Either the column name or SqlType must be set on each argument");
                }
            } else
            {
                argumentholder.setMetaInfo(findColumnFieldType(s1));
            }
        }

        addClause(new Raw(s, aargumentholder));
        return this;
    }

    public Where rawComparison(String s, String s1, Object obj)
    {
        addClause(new SimpleComparison(s, findColumnFieldType(s), obj, s1));
        return this;
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
