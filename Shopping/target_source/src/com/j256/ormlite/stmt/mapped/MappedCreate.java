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
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.stmt.mapped:
//            BaseMappedStatement

public class MappedCreate extends BaseMappedStatement
{
    private static class KeyHolder
        implements GeneratedKeyHolder
    {

        Number key;

        public void addKey(Number number)
            throws SQLException
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
        throws SQLException
    {
        idField.assignIdValue(obj, number, objectcache);
        if (logger.isLevelEnabled(com.j256.ormlite.logger.Log.Level.DEBUG))
        {
            logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[] {
                number, s, idField.getFieldName(), dataClassName
            });
        }
    }

    private void assignSequenceId(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
        throws SQLException
    {
        long l = databaseconnection.queryForLong(queryNextSequenceStmt);
        logger.debug("queried for sequence {} using stmt: {}", Long.valueOf(l), queryNextSequenceStmt);
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
        int i = -1;
        FieldType afieldtype[] = tableinfo.getFieldTypes();
        int i2 = afieldtype.length;
        int k = 0;
        int j = 0;
        while (k < i2) 
        {
            FieldType fieldtype = afieldtype[k];
            int k1 = j;
            int i1 = i;
            if (isFieldCreatable(databasetype, fieldtype))
            {
                if (fieldtype.isVersion())
                {
                    i = j;
                }
                k1 = j + 1;
                i1 = i;
            }
            k++;
            j = k1;
            i = i1;
        }
        afieldtype = new FieldType[j];
        if (j == 0)
        {
            databasetype.appendInsertNoColumns(stringbuilder);
        } else
        {
            stringbuilder.append('(');
            FieldType afieldtype1[] = tableinfo.getFieldTypes();
            int l1 = afieldtype1.length;
            int l = 0;
            boolean flag = true;
            int j1 = 0;
            while (l < l1) 
            {
                FieldType fieldtype1 = afieldtype1[l];
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
                    afieldtype[j1] = fieldtype1;
                    j1++;
                }
                l++;
            }
            stringbuilder.append(") VALUES (");
            afieldtype1 = tableinfo.getFieldTypes();
            j1 = afieldtype1.length;
            l = 0;
            flag = true;
            while (l < j1) 
            {
                if (isFieldCreatable(databasetype, afieldtype1[l]))
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
                l++;
            }
            stringbuilder.append(")");
        }
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

    private boolean foreignCollectionsAreAssigned(FieldType afieldtype[], Object obj)
        throws SQLException
    {
        int j = afieldtype.length;
        for (int i = 0; i < j; i++)
        {
            if (afieldtype[i].extractJavaFieldValue(obj) == null)
            {
                return false;
            }
        }

        return true;
    }

    private static boolean isFieldCreatable(DatabaseType databasetype, FieldType fieldtype)
    {
        if (!fieldtype.isForeignCollection() && !fieldtype.isReadOnly())
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
        throws SQLException
    {
        boolean flag = false;
        if (idField == null) goto _L2; else goto _L1
_L1:
        FieldType afieldtype[];
        int i;
        int j;
        if (idField.isAllowGeneratedIdInsert() && !idField.isObjectsFieldValueDefault(obj))
        {
            i = 0;
        } else
        {
            i = 1;
        }
        if (!idField.isSelfGeneratedId() || !idField.isGeneratedId()) goto _L4; else goto _L3
_L3:
        if (i == 0) goto _L2; else goto _L5
_L5:
        idField.assignField(obj, idField.generateId(), false, objectcache);
        databasetype = null;
_L18:
        if (!tableInfo.isForeignAutoCreate()) goto _L7; else goto _L6
_L6:
        afieldtype = tableInfo.getFieldTypes();
        j = afieldtype.length;
        i = ((flag) ? 1 : 0);
_L11:
        if (i >= j) goto _L7; else goto _L8
_L8:
        FieldType fieldtype = afieldtype[i];
        Object obj2;
        boolean flag1;
        try
        {
            flag1 = fieldtype.isForeignAutoCreate();
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseType databasetype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Unable to run insert stmt on object ").append(obj).append(": ").append(statement).toString(), databasetype);
        }
        if (flag1) goto _L10; else goto _L9
_L9:
        i++;
          goto _L11
_L4:
        if (idField.isGeneratedIdSequence() && databasetype.isSelectSequenceBeforeInsert())
        {
            if (i != 0)
            {
                assignSequenceId(databaseconnection, obj, objectcache);
                databasetype = null;
                continue; /* Loop/switch isn't completed */
            }
        } else
        if (idField.isGeneratedId() && i != 0)
        {
            databasetype = new KeyHolder();
            continue; /* Loop/switch isn't completed */
        }
          goto _L2
_L10:
        obj2 = fieldtype.extractRawJavaFieldValue(obj);
        if (obj2 == null) goto _L9; else goto _L12
_L12:
        if (!fieldtype.getForeignIdField().isObjectsFieldValueDefault(obj2)) goto _L9; else goto _L13
_L13:
        fieldtype.createWithForeignDao(obj2);
          goto _L9
_L7:
        Object aobj[] = getFieldObjects(obj);
        if (versionFieldTypeIndex < 0 || aobj[versionFieldTypeIndex] != null) goto _L15; else goto _L14
_L14:
        Object obj1;
        FieldType fieldtype1 = argFieldTypes[versionFieldTypeIndex];
        obj1 = fieldtype1.moveToNextValue(null);
        aobj[versionFieldTypeIndex] = fieldtype1.convertJavaFieldToSqlArgValue(obj1);
_L16:
        i = databaseconnection.insert(statement, aobj, argFieldTypes, databasetype);
        logger.debug("insert data with statement '{}' and {} args, changed {} rows", statement, Integer.valueOf(aobj.length), Integer.valueOf(i));
        if (aobj.length > 0)
        {
            logger.trace("insert arguments: {}", ((Object) (aobj)));
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_569;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_432;
        }
        argFieldTypes[versionFieldTypeIndex].assignField(obj, obj1, false, null);
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        databasetype = databasetype.getKey();
        if (databasetype != null)
        {
            break MISSING_BLOCK_LABEL_496;
        }
        throw new SQLException("generated-id key was not set by the update call");
        databasetype;
        logger.debug("insert data with statement '{}' and {} args, threw exception: {}", statement, Integer.valueOf(aobj.length), databasetype);
        if (aobj.length > 0)
        {
            logger.trace("insert arguments: {}", ((Object) (aobj)));
        }
        throw databasetype;
        if (databasetype.longValue() == 0L)
        {
            throw new SQLException("generated-id key must not be 0 value");
        }
        assignIdValue(obj, databasetype, "keyholder", objectcache);
        if (objectcache == null)
        {
            break MISSING_BLOCK_LABEL_569;
        }
        if (foreignCollectionsAreAssigned(tableInfo.getForeignCollections(), obj))
        {
            databasetype = ((DatabaseType) (idField.extractJavaFieldValue(obj)));
            objectcache.put(clazz, databasetype, obj);
        }
        return i;
_L15:
        obj1 = null;
        if (true) goto _L16; else goto _L2
_L2:
        databasetype = null;
        if (true) goto _L18; else goto _L17
_L17:
    }
}
