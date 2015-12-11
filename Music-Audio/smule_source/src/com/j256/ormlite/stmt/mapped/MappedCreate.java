// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.stmt.mapped:
//            BaseMappedStatement

public class MappedCreate extends BaseMappedStatement
{

    private String dataClassName;
    private final String queryNextSequenceStmt;
    private int versionFieldTypeIndex;

    private MappedCreate(TableInfo tableinfo, String s, FieldType afieldtype[], String s1, int i)
    {
        super(tableinfo, s, afieldtype);
        dataClassName = tableinfo.getDataClass().getSimpleName();
        queryNextSequenceStmt = s1;
        versionFieldTypeIndex = i;
    }

    private void assignIdValue(Object obj, Number number, String s, ObjectCache objectcache)
    {
        idField.assignIdValue(obj, number, objectcache);
        logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[] {
            number, s, idField.getFieldName(), dataClassName
        });
    }

    private void assignSequenceId(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
    {
        long l = databaseconnection.queryForLong(queryNextSequenceStmt);
        logger.debug("queried for sequence {} using stmt: {}", new Object[] {
            Long.valueOf(l), queryNextSequenceStmt
        });
        if (l == 0L)
        {
            throw new SQLException((new StringBuilder()).append("Should not have returned 0 for stmt: ").append(queryNextSequenceStmt).toString());
        } else
        {
            assignIdValue(obj, Long.valueOf(l), "sequence", objectcache);
            return;
        }
    }

    public static MappedCreate build(DatabaseType databasetype, TableInfo tableinfo)
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        appendTableName(databasetype, stringbuilder, "INSERT INTO ", tableinfo.getTableName());
        stringbuilder.append('(');
        int i = -1;
        FieldType afieldtype[] = tableinfo.getFieldTypes();
        int l1 = afieldtype.length;
        int k = 0;
        int j = 0;
        while (k < l1) 
        {
            FieldType fieldtype = afieldtype[k];
            int j1 = j;
            int l = i;
            if (isFieldCreatable(databasetype, fieldtype))
            {
                if (fieldtype.isVersion())
                {
                    i = j;
                }
                j1 = j + 1;
                l = i;
            }
            k++;
            j = j1;
            i = l;
        }
        afieldtype = new FieldType[j];
        FieldType afieldtype1[] = tableinfo.getFieldTypes();
        int k1 = afieldtype1.length;
        k = 0;
        boolean flag = true;
        int i1 = 0;
        while (k < k1) 
        {
            FieldType fieldtype1 = afieldtype1[k];
            if (isFieldCreatable(databasetype, fieldtype1))
            {
                if (flag)
                {
                    flag = false;
                } else
                {
                    stringbuilder.append(",");
                }
                appendFieldColumnName(databasetype, stringbuilder, fieldtype1, null);
                afieldtype[i1] = fieldtype1;
                i1++;
            }
            k++;
        }
        stringbuilder.append(") VALUES (");
        afieldtype1 = tableinfo.getFieldTypes();
        i1 = afieldtype1.length;
        k = 0;
        flag = true;
        while (k < i1) 
        {
            if (isFieldCreatable(databasetype, afieldtype1[k]))
            {
                if (flag)
                {
                    flag = false;
                } else
                {
                    stringbuilder.append(",");
                }
                stringbuilder.append("?");
            }
            k++;
        }
        stringbuilder.append(")");
        databasetype = buildQueryNextSequence(databasetype, tableinfo.getIdField());
        return new MappedCreate(tableinfo, stringbuilder.toString(), afieldtype, databasetype, i);
    }

    private static String buildQueryNextSequence(DatabaseType databasetype, FieldType fieldtype)
    {
        if (fieldtype != null)
        {
            if ((fieldtype = fieldtype.getGeneratedIdSequence()) != null)
            {
                StringBuilder stringbuilder = new StringBuilder(64);
                databasetype.appendSelectNextValFromSequence(stringbuilder, fieldtype);
                return stringbuilder.toString();
            }
        }
        return null;
    }

    private static boolean isFieldCreatable(DatabaseType databasetype, FieldType fieldtype)
    {
        if (!fieldtype.isForeignCollection())
        {
            if (databasetype.isIdSequenceNeeded() && databasetype.isSelectSequenceBeforeInsert())
            {
                return true;
            }
            if (!fieldtype.isGeneratedId() || fieldtype.isSelfGeneratedId() || fieldtype.isAllowGeneratedIdInsert())
            {
                return true;
            }
        }
        return false;
    }

    public int insert(DatabaseType databasetype, DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
    {
        boolean flag;
        int j;
        j = 1;
        flag = false;
        if (idField == null) goto _L2; else goto _L1
_L1:
        int i;
        i = j;
        if (idField.isAllowGeneratedIdInsert())
        {
            i = j;
            if (!idField.isObjectsFieldValueDefault(obj))
            {
                i = 0;
            }
        }
        if (!idField.isSelfGeneratedId() || !idField.isGeneratedId()) goto _L4; else goto _L3
_L3:
        if (!i) goto _L2; else goto _L5
_L5:
        idField.assignField(obj, idField.generateId(), false, objectcache);
        databasetype = null;
_L17:
        Object aobj[] = getFieldObjects(obj);
        if (versionFieldTypeIndex < 0 || aobj[versionFieldTypeIndex] != null) goto _L7; else goto _L6
_L6:
        Object obj1;
        FieldType fieldtype = argFieldTypes[versionFieldTypeIndex];
        obj1 = fieldtype.moveToNextValue(null);
        aobj[versionFieldTypeIndex] = fieldtype.convertJavaFieldToSqlArgValue(obj1);
_L23:
        j = databaseconnection.insert(statement, aobj, argFieldTypes, databasetype);
        if (j <= 0) goto _L9; else goto _L8
_L8:
        if (obj1 != null)
        {
            try
            {
                argFieldTypes[versionFieldTypeIndex].assignField(obj, obj1, false, null);
            }
            // Misplaced declaration of an exception variable
            catch (DatabaseType databasetype)
            {
                throw SqlExceptionUtil.create((new StringBuilder()).append("Unable to run insert stmt on object ").append(obj).append(": ").append(statement).toString(), databasetype);
            }
        }
        if (databasetype == null) goto _L11; else goto _L10
_L10:
        databasetype = databasetype.getKey();
        if (databasetype != null) goto _L13; else goto _L12
_L12:
        throw new SQLException("generated-id key was not set by the update call");
_L4:
        if (!idField.isGeneratedIdSequence() || !databasetype.isSelectSequenceBeforeInsert()) goto _L15; else goto _L14
_L14:
        if (!i) goto _L2; else goto _L16
_L16:
        assignSequenceId(databaseconnection, obj, objectcache);
        databasetype = null;
          goto _L17
_L15:
        if (!idField.isGeneratedId() || !i) goto _L2; else goto _L18
_L18:
        databasetype = new KeyHolder();
          goto _L17
_L13:
        if (databasetype.longValue() == 0L)
        {
            throw new SQLException("generated-id key must not be 0 value");
        }
        assignIdValue(obj, databasetype, "keyholder", objectcache);
_L11:
        if (objectcache == null) goto _L9; else goto _L19
_L19:
        databasetype = ((DatabaseType) (idField.extractJavaFieldValue(obj)));
        objectcache.put(clazz, databasetype, obj);
_L9:
        logger.debug("insert data with statement '{}' and {} args, changed {} rows", new Object[] {
            statement, Integer.valueOf(aobj.length), Integer.valueOf(j)
        });
        if (aobj.length > 0)
        {
            logger.trace("insert arguments: {}", new Object[] {
                aobj
            });
        }
        if (!tableInfo.isForeignAutoCreate()) goto _L21; else goto _L20
_L20:
        int k;
        databasetype = tableInfo.getFieldTypes();
        k = databasetype.length;
        i = ((flag) ? 1 : 0);
_L24:
        if (i >= k) goto _L21; else goto _L22
_L22:
        databaseconnection = databasetype[i];
        if (!databaseconnection.isForeignAutoCreate())
        {
            break MISSING_BLOCK_LABEL_532;
        }
        objectcache = ((ObjectCache) (databaseconnection.extractRawJavaFieldValue(obj)));
        if (objectcache == null)
        {
            break MISSING_BLOCK_LABEL_532;
        }
        if (databaseconnection.getForeignIdField().isObjectsFieldValueDefault(objectcache))
        {
            databaseconnection.createWithForeignDao(objectcache);
        }
        break MISSING_BLOCK_LABEL_532;
_L21:
        return j;
_L7:
        obj1 = null;
          goto _L23
_L2:
        databasetype = null;
          goto _L17
        i++;
          goto _L24
    }

    private class KeyHolder
        implements GeneratedKeyHolder
    {

        Number key;

        public void addKey(Number number)
        {
            if (key == null)
            {
                key = number;
                return;
            } else
            {
                throw new SQLException((new StringBuilder()).append("generated key has already been set to ").append(key).append(", now set to ").append(number).toString());
            }
        }

        public Number getKey()
        {
            return key;
        }

        private KeyHolder()
        {
        }

    }

}
