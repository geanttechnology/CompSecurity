// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.j256.ormlite.stmt.mapped:
//            BaseMappedStatement

public abstract class BaseMappedQuery extends BaseMappedStatement
    implements GenericRowMapper
{

    private Map columnPositions;
    private Object parent;
    protected final FieldType resultsFieldTypes[];

    protected BaseMappedQuery(TableInfo tableinfo, String s, FieldType afieldtype[], FieldType afieldtype1[])
    {
        super(tableinfo, s, afieldtype);
        columnPositions = null;
        parent = null;
        resultsFieldTypes = afieldtype1;
    }

    public Object mapRow(DatabaseResults databaseresults)
    {
        Object obj;
        ObjectCache objectcache;
        if (columnPositions == null)
        {
            obj = new HashMap();
        } else
        {
            obj = columnPositions;
        }
        objectcache = databaseresults.getObjectCache();
        if (objectcache != null)
        {
            Object obj1 = idField.resultToJava(databaseresults, ((Map) (obj)));
            obj1 = objectcache.get(clazz, obj1);
            if (obj1 != null)
            {
                return obj1;
            }
        }
        Object obj4 = tableInfo.createObject();
        Object obj2 = null;
        FieldType afieldtype[] = resultsFieldTypes;
        int l = afieldtype.length;
        int i = 0;
        boolean flag = false;
        while (i < l) 
        {
            FieldType fieldtype1 = afieldtype[i];
            boolean flag1;
            if (fieldtype1.isForeignCollection())
            {
                flag1 = true;
            } else
            {
                Object obj3 = fieldtype1.resultToJava(databaseresults, ((Map) (obj)));
                if (parent != null && fieldtype1.getField().getType() == parent.getClass())
                {
                    fieldtype1.assignField(obj4, parent, true, objectcache);
                } else
                {
                    fieldtype1.assignField(obj4, obj3, false, objectcache);
                }
                flag1 = flag;
                if (fieldtype1 == idField)
                {
                    obj2 = obj3;
                    flag1 = flag;
                }
            }
            i++;
            flag = flag1;
        }
        if (flag)
        {
            databaseresults = resultsFieldTypes;
            int k = databaseresults.length;
            for (int j = 0; j < k; j++)
            {
                FieldType fieldtype = databaseresults[j];
                if (!fieldtype.isForeignCollection())
                {
                    continue;
                }
                com.j256.ormlite.dao.BaseForeignCollection baseforeigncollection = fieldtype.buildForeignCollection(obj4, obj2, false);
                if (baseforeigncollection != null)
                {
                    fieldtype.assignField(obj4, baseforeigncollection, false, objectcache);
                }
            }

        }
        if (columnPositions == null)
        {
            columnPositions = ((Map) (obj));
        }
        return obj4;
    }

    public void setParentObject(Object obj)
    {
        parent = obj;
    }
}
