// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseEnumType

public class EnumStringType extends BaseEnumType
{

    public static int DEFAULT_WIDTH = 100;
    private static final EnumStringType singleTon = new EnumStringType();

    private EnumStringType()
    {
        super(SqlType.STRING, new Class[] {
            java/lang/Enum
        });
    }

    public static EnumStringType getSingleton()
    {
        return singleTon;
    }

    public int getDefaultWidth()
    {
        return DEFAULT_WIDTH;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
    {
        return ((Enum)obj).name();
    }

    public Object makeConfigObject(FieldType fieldtype)
    {
        HashMap hashmap = new HashMap();
        Enum aenum[] = (Enum[])(Enum[])fieldtype.getFieldType().getEnumConstants();
        if (aenum == null)
        {
            throw new SQLException((new StringBuilder()).append("Field ").append(fieldtype).append(" improperly configured as type ").append(this).toString());
        }
        int j = aenum.length;
        for (int i = 0; i < j; i++)
        {
            fieldtype = aenum[i];
            hashmap.put(fieldtype.name(), fieldtype);
        }

        return hashmap;
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
    {
        return s;
    }

    public Object resultToJava(FieldType fieldtype, DatabaseResults databaseresults, int i)
    {
        databaseresults = databaseresults.getString(i);
        if (fieldtype == null)
        {
            return databaseresults;
        }
        if (databaseresults == null)
        {
            return null;
        } else
        {
            return sqlArgToJava(fieldtype, databaseresults, i);
        }
    }

    public Object sqlArgToJava(FieldType fieldtype, Object obj, int i)
    {
        obj = (String)obj;
        Map map = (Map)fieldtype.getDataTypeConfigObj();
        if (map == null)
        {
            return enumVal(fieldtype, obj, null, fieldtype.getUnknownEnumVal());
        } else
        {
            return enumVal(fieldtype, obj, (Enum)map.get(obj), fieldtype.getUnknownEnumVal());
        }
    }

}
