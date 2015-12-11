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
        boolean flag1 = true;
        int j = 0;
        FieldType fieldtype = null;
        int i = -1;
        FieldType afieldtype2[] = tableinfo.getFieldTypes();
        int i2 = afieldtype2.length;
        for (int k = 0; k < i2;)
        {
            FieldType fieldtype2 = afieldtype2[k];
            FieldType fieldtype1 = fieldtype;
            int k1 = i;
            int i1 = j;
            if (isFieldUpdatable(fieldtype2, fieldtype3))
            {
                if (fieldtype2.isVersion())
                {
                    fieldtype = fieldtype2;
                    i = j;
                }
                i1 = j + 1;
                k1 = i;
                fieldtype1 = fieldtype;
            }
            k++;
            fieldtype = fieldtype1;
            i = k1;
            j = i1;
        }

        int l = j + 1;
        j = l;
        if (fieldtype != null)
        {
            j = l + 1;
        }
        FieldType afieldtype[] = new FieldType[j];
        FieldType afieldtype1[] = tableinfo.getFieldTypes();
        i2 = afieldtype1.length;
        int j1 = 0;
        j = 0;
        boolean flag = flag1;
        while (j1 < i2) 
        {
            FieldType fieldtype4 = afieldtype1[j1];
            if (isFieldUpdatable(fieldtype4, fieldtype3))
            {
                int l1;
                if (flag)
                {
                    stringbuilder.append("SET ");
                    flag = false;
                } else
                {
                    stringbuilder.append(", ");
                }
                appendFieldColumnName(databasetype, stringbuilder, fieldtype4, null);
                l1 = j + 1;
                afieldtype[j] = fieldtype4;
                stringbuilder.append("= ?");
                j = l1;
            }
            j1++;
        }
        stringbuilder.append(' ');
        appendWhereFieldEq(databasetype, fieldtype3, stringbuilder, null);
        flag = j + 1;
        afieldtype[j] = fieldtype3;
        if (fieldtype != null)
        {
            stringbuilder.append(" AND ");
            appendFieldColumnName(databasetype, stringbuilder, fieldtype, null);
            stringbuilder.append("= ?");
            afieldtype[flag] = fieldtype;
        }
        return new MappedUpdate(tableinfo, stringbuilder.toString(), afieldtype, fieldtype, i);
    }

    private static boolean isFieldUpdatable(FieldType fieldtype, FieldType fieldtype1)
    {
        return fieldtype != fieldtype1 && !fieldtype.isForeignCollection() && !fieldtype.isReadOnly();
    }

    public int update(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
        throws SQLException
    {
        int i;
        int j;
        if (argFieldTypes.length <= 1)
        {
            return 0;
        }
        Object obj1;
        FieldType afieldtype[];
        Object aobj[];
        FieldType fieldtype;
        int k;
        try
        {
            aobj = getFieldObjects(obj);
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseConnection databaseconnection)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Unable to run update stmt on object ").append(obj).append(": ").append(statement).toString(), databaseconnection);
        }
        obj1 = null;
        if (versionFieldType != null)
        {
            obj1 = versionFieldType.extractJavaFieldValue(obj);
            obj1 = versionFieldType.moveToNextValue(obj1);
            aobj[versionFieldTypeIndex] = versionFieldType.convertJavaFieldToSqlArgValue(obj1);
        }
        j = databaseconnection.update(statement, aobj, argFieldTypes);
        if (j <= 0) goto _L2; else goto _L1
_L1:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        versionFieldType.assignField(obj, obj1, false, null);
        if (objectcache == null) goto _L2; else goto _L3
_L3:
        databaseconnection = ((DatabaseConnection) (idField.extractJavaFieldValue(obj)));
        databaseconnection = ((DatabaseConnection) (objectcache.get(clazz, databaseconnection)));
        if (databaseconnection == null || databaseconnection == obj) goto _L2; else goto _L4
_L4:
        afieldtype = tableInfo.getFieldTypes();
        k = afieldtype.length;
        i = 0;
_L8:
        if (i >= k) goto _L2; else goto _L5
_L5:
        fieldtype = afieldtype[i];
        if (fieldtype != idField)
        {
            fieldtype.assignField(databaseconnection, fieldtype.extractJavaFieldValue(obj), false, objectcache);
        }
          goto _L6
_L2:
        logger.debug("update data with statement '{}' and {} args, changed {} rows", statement, Integer.valueOf(aobj.length), Integer.valueOf(j));
        if (aobj.length <= 0)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        logger.trace("update arguments: {}", ((Object) (aobj)));
        return j;
        return j;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
