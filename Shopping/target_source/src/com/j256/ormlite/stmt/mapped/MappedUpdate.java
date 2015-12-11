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

public class MappedUpdate extends BaseMappedStatement
{

    private final FieldType versionFieldType;
    private final int versionFieldTypeIndex;

    private MappedUpdate(TableInfo tableinfo, String s, FieldType afieldtype[], FieldType fieldtype, int i)
    {
        super(tableinfo, s, afieldtype);
        versionFieldType = fieldtype;
        versionFieldTypeIndex = i;
    }

    public static MappedUpdate build(DatabaseType databasetype, TableInfo tableinfo)
        throws SQLException
    {
        FieldType fieldtype3 = tableinfo.getIdField();
        if (fieldtype3 == null)
        {
            throw new SQLException((new StringBuilder()).append("Cannot update ").append(tableinfo.getDataClass()).append(" because it doesn't have an id field").toString());
        }
        StringBuilder stringbuilder = new StringBuilder(64);
        appendTableName(databasetype, stringbuilder, "UPDATE ", tableinfo.getTableName());
        FieldType fieldtype = null;
        int j = -1;
        FieldType afieldtype2[] = tableinfo.getFieldTypes();
        int i2 = afieldtype2.length;
        int k = 0;
        int i = 0;
        while (k < i2) 
        {
            FieldType fieldtype2 = afieldtype2[k];
            int j1 = i;
            FieldType fieldtype1 = fieldtype;
            int l = j;
            if (isFieldUpdatable(fieldtype2, fieldtype3))
            {
                if (fieldtype2.isVersion())
                {
                    j = i;
                    fieldtype = fieldtype2;
                }
                j1 = i + 1;
                l = j;
                fieldtype1 = fieldtype;
            }
            k++;
            i = j1;
            fieldtype = fieldtype1;
            j = l;
        }
        k = i + 1;
        i = k;
        if (fieldtype != null)
        {
            i = k + 1;
        }
        FieldType afieldtype[] = new FieldType[i];
        k = 0;
        FieldType afieldtype1[] = tableinfo.getFieldTypes();
        i2 = afieldtype1.length;
        int i1 = 0;
        i = 1;
        while (i1 < i2) 
        {
            FieldType fieldtype4 = afieldtype1[i1];
            int l1;
            if (!isFieldUpdatable(fieldtype4, fieldtype3))
            {
                int k1 = k;
                k = i;
                i = k1;
            } else
            {
                boolean flag;
                if (i != 0)
                {
                    stringbuilder.append("SET ");
                    i = 0;
                } else
                {
                    stringbuilder.append(", ");
                }
                appendFieldColumnName(databasetype, stringbuilder, fieldtype4, null);
                afieldtype[k] = fieldtype4;
                stringbuilder.append("= ?");
                flag = i;
                i = k + 1;
                k = ((flag) ? 1 : 0);
            }
            l1 = i1 + 1;
            i1 = i;
            i = k;
            k = i1;
            i1 = l1;
        }
        stringbuilder.append(' ');
        appendWhereFieldEq(databasetype, fieldtype3, stringbuilder, null);
        i = k + 1;
        afieldtype[k] = fieldtype3;
        if (fieldtype != null)
        {
            stringbuilder.append(" AND ");
            appendFieldColumnName(databasetype, stringbuilder, fieldtype, null);
            stringbuilder.append("= ?");
            afieldtype[i] = fieldtype;
        }
        return new MappedUpdate(tableinfo, stringbuilder.toString(), afieldtype, fieldtype, j);
    }

    private static boolean isFieldUpdatable(FieldType fieldtype, FieldType fieldtype1)
    {
        return fieldtype != fieldtype1 && !fieldtype.isForeignCollection() && !fieldtype.isReadOnly();
    }

    public int update(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
        throws SQLException
    {
        int i = 0;
        if (argFieldTypes.length <= 1)
        {
            return 0;
        }
        Object aobj[] = getFieldObjects(obj);
        if (versionFieldType == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = versionFieldType.extractJavaFieldValue(obj);
        obj1 = versionFieldType.moveToNextValue(obj1);
        aobj[versionFieldTypeIndex] = versionFieldType.convertJavaFieldToSqlArgValue(obj1);
_L8:
        int j = databaseconnection.update(statement, aobj, argFieldTypes);
        if (j <= 0) goto _L4; else goto _L3
_L3:
        FieldType fieldtype;
        int k;
        if (obj1 != null)
        {
            try
            {
                versionFieldType.assignField(obj, obj1, false, null);
            }
            // Misplaced declaration of an exception variable
            catch (DatabaseConnection databaseconnection)
            {
                throw SqlExceptionUtil.create((new StringBuilder()).append("Unable to run update stmt on object ").append(obj).append(": ").append(statement).toString(), databaseconnection);
            }
        }
        if (objectcache == null) goto _L4; else goto _L5
_L5:
        databaseconnection = ((DatabaseConnection) (idField.extractJavaFieldValue(obj)));
        databaseconnection = ((DatabaseConnection) (objectcache.get(clazz, databaseconnection)));
        if (databaseconnection == null || databaseconnection == obj) goto _L4; else goto _L6
_L6:
        obj1 = tableInfo.getFieldTypes();
        k = obj1.length;
_L9:
        if (i >= k) goto _L4; else goto _L7
_L7:
        fieldtype = obj1[i];
        if (fieldtype != idField)
        {
            fieldtype.assignField(databaseconnection, fieldtype.extractJavaFieldValue(obj), false, objectcache);
        }
        break MISSING_BLOCK_LABEL_278;
_L4:
        logger.debug("update data with statement '{}' and {} args, changed {} rows", statement, Integer.valueOf(aobj.length), Integer.valueOf(j));
        if (aobj.length > 0)
        {
            logger.trace("update arguments: {}", ((Object) (aobj)));
        }
        return j;
_L2:
        obj1 = null;
          goto _L8
        i++;
          goto _L9
    }
}
