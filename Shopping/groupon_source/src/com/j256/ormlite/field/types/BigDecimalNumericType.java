// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigDecimal;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDataType

public class BigDecimalNumericType extends BaseDataType
{

    private static final BigDecimalNumericType singleTon = new BigDecimalNumericType();

    private BigDecimalNumericType()
    {
        super(SqlType.BIG_DECIMAL, new Class[0]);
    }

    public static BigDecimalNumericType getSingleton()
    {
        return singleTon;
    }

    public Class getPrimaryClass()
    {
        return java/math/BigDecimal;
    }

    public boolean isAppropriateId()
    {
        return false;
    }

    public boolean isEscapedValue()
    {
        return false;
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
        throws SQLException
    {
        BigDecimal bigdecimal;
        try
        {
            bigdecimal = new BigDecimal(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems with field ").append(fieldtype).append(" parsing default BigDecimal string '").append(s).append("'").toString(), illegalargumentexception);
        }
        return bigdecimal;
    }

    public Object resultToSqlArg(FieldType fieldtype, DatabaseResults databaseresults, int i)
        throws SQLException
    {
        return databaseresults.getBigDecimal(i);
    }

}
