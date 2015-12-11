// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.stmt.mapped:
//            MappedQueryForId

public class MappedRefresh extends MappedQueryForId
{

    private MappedRefresh(TableInfo tableinfo, String s, FieldType afieldtype[], FieldType afieldtype1[])
    {
        super(tableinfo, s, afieldtype, afieldtype1, "refresh");
    }

    public static MappedRefresh build(DatabaseType databasetype, TableInfo tableinfo)
        throws SQLException
    {
        FieldType fieldtype = tableinfo.getIdField();
        if (fieldtype == null)
        {
            throw new SQLException((new StringBuilder()).append("Cannot refresh ").append(tableinfo.getDataClass()).append(" because it doesn't have an id field").toString());
        } else
        {
            databasetype = buildStatement(databasetype, tableinfo, fieldtype);
            fieldtype = tableinfo.getIdField();
            FieldType afieldtype[] = tableinfo.getFieldTypes();
            return new MappedRefresh(tableinfo, databasetype, new FieldType[] {
                fieldtype
            }, afieldtype);
        }
    }

    public int executeRefresh(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
        throws SQLException
    {
        databaseconnection = ((DatabaseConnection) (super.execute(databaseconnection, idField.extractJavaFieldValue(obj), null)));
        if (databaseconnection == null)
        {
            return 0;
        }
        FieldType afieldtype[] = resultsFieldTypes;
        int j = afieldtype.length;
        for (int i = 0; i < j; i++)
        {
            FieldType fieldtype = afieldtype[i];
            if (fieldtype != idField)
            {
                fieldtype.assignField(obj, fieldtype.extractJavaFieldValue(databaseconnection), false, objectcache);
            }
        }

        return 1;
    }
}
