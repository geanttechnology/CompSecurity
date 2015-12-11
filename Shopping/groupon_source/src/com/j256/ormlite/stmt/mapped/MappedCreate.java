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
        stringbuilder.append('(');
        int j = 0;
        int i = -1;
        FieldType afieldtype[] = tableinfo.getFieldTypes();
        int i2 = afieldtype.length;
        for (int k = 0; k < i2;)
        {
            FieldType fieldtype = afieldtype[k];
            int k1 = i;
            int i1 = j;
            if (isFieldCreatable(databasetype, fieldtype))
            {
                if (fieldtype.isVersion())
                {
                    i = j;
                }
                i1 = j + 1;
                k1 = i;
            }
            k++;
            i = k1;
            j = i1;
        }

        afieldtype = new FieldType[j];
        boolean flag1 = true;
        FieldType afieldtype1[] = tableinfo.getFieldTypes();
        i2 = afieldtype1.length;
        int j1 = 0;
        j = 0;
        while (j1 < i2) 
        {
            FieldType fieldtype1 = afieldtype1[j1];
            if (isFieldCreatable(databasetype, fieldtype1))
            {
                int l1;
                if (flag1)
                {
                    flag1 = false;
                } else
                {
                    stringbuilder.append(",");
                }
                appendFieldColumnName(databasetype, stringbuilder, fieldtype1, null);
                l1 = j + 1;
                afieldtype[j] = fieldtype1;
                j = l1;
            }
            j1++;
        }
        stringbuilder.append(") VALUES (");
        boolean flag = true;
        afieldtype1 = tableinfo.getFieldTypes();
        j1 = afieldtype1.length;
        int l = 0;
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
        Object obj1;
        FieldType fieldtype;
        fieldtype = null;
        obj1 = fieldtype;
        if (idField == null) goto _L2; else goto _L1
_L1:
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
        obj1 = fieldtype;
        if (i != 0)
        {
            idField.assignField(obj, idField.generateId(), false, objectcache);
            obj1 = fieldtype;
        }
_L2:
        if (!tableInfo.isForeignAutoCreate()) goto _L6; else goto _L5
_L5:
        databasetype = tableInfo.getFieldTypes();
        j = databasetype.length;
        i = 0;
_L10:
        if (i >= j) goto _L6; else goto _L7
_L7:
        fieldtype = databasetype[i];
        Object obj2;
        boolean flag;
        try
        {
            flag = fieldtype.isForeignAutoCreate();
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseType databasetype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Unable to run insert stmt on object ").append(obj).append(": ").append(statement).toString(), databasetype);
        }
        if (flag) goto _L9; else goto _L8
_L8:
        i++;
          goto _L10
_L4:
        if (idField.isGeneratedIdSequence() && databasetype.isSelectSequenceBeforeInsert())
        {
            obj1 = fieldtype;
            if (i != 0)
            {
                assignSequenceId(databaseconnection, obj, objectcache);
                obj1 = fieldtype;
            }
        } else
        {
            obj1 = fieldtype;
            if (idField.isGeneratedId())
            {
                obj1 = fieldtype;
                if (i != 0)
                {
                    obj1 = new KeyHolder();
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L9:
        obj2 = fieldtype.extractRawJavaFieldValue(obj);
        if (obj2 == null) goto _L8; else goto _L11
_L11:
        if (!fieldtype.getForeignIdField().isObjectsFieldValueDefault(obj2)) goto _L8; else goto _L12
_L12:
        fieldtype.createWithForeignDao(obj2);
          goto _L8
_L6:
        Object aobj[] = getFieldObjects(obj);
        fieldtype = null;
        databasetype = fieldtype;
        if (versionFieldTypeIndex < 0)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        databasetype = fieldtype;
        if (aobj[versionFieldTypeIndex] == null)
        {
            FieldType fieldtype1 = argFieldTypes[versionFieldTypeIndex];
            databasetype = ((DatabaseType) (fieldtype1.moveToNextValue(null)));
            aobj[versionFieldTypeIndex] = fieldtype1.convertJavaFieldToSqlArgValue(databasetype);
        }
        i = databaseconnection.insert(statement, aobj, argFieldTypes, ((GeneratedKeyHolder) (obj1)));
        logger.debug("insert data with statement '{}' and {} args, changed {} rows", statement, Integer.valueOf(aobj.length), Integer.valueOf(i));
        if (aobj.length > 0)
        {
            logger.trace("insert arguments: {}", ((Object) (aobj)));
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_597;
        }
        if (databasetype == null)
        {
            break MISSING_BLOCK_LABEL_458;
        }
        argFieldTypes[versionFieldTypeIndex].assignField(obj, databasetype, false, null);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_555;
        }
        databasetype = ((KeyHolder) (obj1)).getKey();
        if (databasetype != null)
        {
            break MISSING_BLOCK_LABEL_524;
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
            break MISSING_BLOCK_LABEL_597;
        }
        if (foreignCollectionsAreAssigned(tableInfo.getForeignCollections(), obj))
        {
            databasetype = ((DatabaseType) (idField.extractJavaFieldValue(obj)));
            objectcache.put(clazz, databasetype, obj);
        }
        return i;
        if (true) goto _L2; else goto _L13
_L13:
    }
}
