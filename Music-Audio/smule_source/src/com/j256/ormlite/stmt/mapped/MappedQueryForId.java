// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.stmt.mapped:
//            BaseMappedQuery

public class MappedQueryForId extends BaseMappedQuery
{

    private final String label;

    protected MappedQueryForId(TableInfo tableinfo, String s, FieldType afieldtype[], FieldType afieldtype1[], String s1)
    {
        super(tableinfo, s, afieldtype, afieldtype1);
        label = s1;
    }

    public static MappedQueryForId build(DatabaseType databasetype, TableInfo tableinfo)
    {
        databasetype = buildStatement(databasetype, tableinfo);
        FieldType fieldtype = tableinfo.getIdField();
        FieldType afieldtype[] = tableinfo.getFieldTypes();
        return new MappedQueryForId(tableinfo, databasetype, new FieldType[] {
            fieldtype
        }, afieldtype, "query-for-id");
    }

    protected static String buildStatement(DatabaseType databasetype, TableInfo tableinfo)
    {
        FieldType fieldtype = tableinfo.getIdField();
        if (fieldtype == null)
        {
            throw new SQLException((new StringBuilder()).append("Cannot query-for-id with ").append(tableinfo.getDataClass()).append(" because it doesn't have an id field").toString());
        } else
        {
            StringBuilder stringbuilder = new StringBuilder(64);
            appendTableName(databasetype, stringbuilder, "SELECT * FROM ", tableinfo.getTableName());
            appendWhereId(databasetype, fieldtype, stringbuilder, null);
            return stringbuilder.toString();
        }
    }

    private void logArgs(Object aobj[])
    {
        if (aobj.length > 0)
        {
            logger.trace("{} arguments: {}", new Object[] {
                label, aobj
            });
        }
    }

    public Object execute(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
    {
        if (objectcache == null) goto _L2; else goto _L1
_L1:
        Object obj1 = objectcache.get(clazz, obj);
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        databaseconnection = ((DatabaseConnection) (obj1));
_L5:
        return databaseconnection;
_L2:
        Object aobj[] = new Object[1];
        aobj[0] = convertIdToFieldObject(obj);
        Object obj2 = databaseconnection.queryForOne(statement, aobj, new FieldType[] {
            idField
        }, this, objectcache);
        if (obj2 == null)
        {
            logger.debug("{} using '{}' and {} args, got no results", new Object[] {
                label, statement, Integer.valueOf(aobj.length)
            });
        } else
        {
            if (obj2 == DatabaseConnection.MORE_THAN_ONE)
            {
                logger.error("{} using '{}' and {} args, got >1 results", new Object[] {
                    label, statement, Integer.valueOf(aobj.length)
                });
                logArgs(aobj);
                throw new SQLException((new StringBuilder()).append(label).append(" got more than 1 result: ").append(statement).toString());
            }
            logger.debug("{} using '{}' and {} args, got 1 result", new Object[] {
                label, statement, Integer.valueOf(aobj.length)
            });
        }
        logArgs(aobj);
        if (obj2 == null)
        {
            return null;
        }
        databaseconnection = ((DatabaseConnection) (obj2));
        if (objectcache != null)
        {
            objectcache.put(clazz, obj, obj2);
            return obj2;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }
}
