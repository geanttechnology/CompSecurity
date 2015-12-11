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

public class EnumIntegerType extends BaseEnumType
{

    private static final EnumIntegerType singleTon = new EnumIntegerType();

    private EnumIntegerType()
    {
        super(SqlType.INTEGER, new Class[0]);
    }

    public static EnumIntegerType getSingleton()
    {
        return singleTon;
    }

    public boolean isEscapedValue()
    {
        return false;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
    {
        return Integer.valueOf(((Enum)obj).ordinal());
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
            hashmap.put(Integer.valueOf(fieldtype.ordinal()), fieldtype);
        }

        return hashmap;
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
    {
        return Integer.valueOf(Integer.parseInt(s));
    }

    public Object resultToJava(FieldType fieldtype, DatabaseResults databaseresults, int i)
    {
        int j = databaseresults.getInt(i);
        if (fieldtype == null)
        {
            return Integer.valueOf(j);
        } else
        {
            return sqlArgToJava(fieldtype, Integer.valueOf(j), i);
        }
    }

    public Object sqlArgToJava(FieldType fieldtype, Object obj, int i)
    {
        obj = (Integer)obj;
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
