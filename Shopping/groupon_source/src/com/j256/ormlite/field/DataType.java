// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import com.j256.ormlite.field.types.BigDecimalNumericType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import com.j256.ormlite.field.types.BigIntegerType;
import com.j256.ormlite.field.types.BooleanObjectType;
import com.j256.ormlite.field.types.BooleanType;
import com.j256.ormlite.field.types.ByteArrayType;
import com.j256.ormlite.field.types.ByteObjectType;
import com.j256.ormlite.field.types.ByteType;
import com.j256.ormlite.field.types.CharType;
import com.j256.ormlite.field.types.CharacterObjectType;
import com.j256.ormlite.field.types.DateLongType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.field.types.DateTimeType;
import com.j256.ormlite.field.types.DateType;
import com.j256.ormlite.field.types.DoubleObjectType;
import com.j256.ormlite.field.types.DoubleType;
import com.j256.ormlite.field.types.EnumIntegerType;
import com.j256.ormlite.field.types.EnumStringType;
import com.j256.ormlite.field.types.FloatObjectType;
import com.j256.ormlite.field.types.FloatType;
import com.j256.ormlite.field.types.IntType;
import com.j256.ormlite.field.types.IntegerObjectType;
import com.j256.ormlite.field.types.LongObjectType;
import com.j256.ormlite.field.types.LongStringType;
import com.j256.ormlite.field.types.LongType;
import com.j256.ormlite.field.types.SerializableType;
import com.j256.ormlite.field.types.ShortObjectType;
import com.j256.ormlite.field.types.ShortType;
import com.j256.ormlite.field.types.SqlDateType;
import com.j256.ormlite.field.types.StringBytesType;
import com.j256.ormlite.field.types.StringType;
import com.j256.ormlite.field.types.TimeStampType;
import com.j256.ormlite.field.types.UuidType;

// Referenced classes of package com.j256.ormlite.field:
//            DataPersister

public final class DataType extends Enum
{

    private static final DataType $VALUES[];
    public static final DataType BIG_DECIMAL;
    public static final DataType BIG_DECIMAL_NUMERIC;
    public static final DataType BIG_INTEGER;
    public static final DataType BOOLEAN;
    public static final DataType BOOLEAN_OBJ;
    public static final DataType BYTE;
    public static final DataType BYTE_ARRAY;
    public static final DataType BYTE_OBJ;
    public static final DataType CHAR;
    public static final DataType CHAR_OBJ;
    public static final DataType DATE;
    public static final DataType DATE_LONG;
    public static final DataType DATE_STRING;
    public static final DataType DATE_TIME;
    public static final DataType DOUBLE;
    public static final DataType DOUBLE_OBJ;
    public static final DataType ENUM_INTEGER;
    public static final DataType ENUM_STRING;
    public static final DataType FLOAT;
    public static final DataType FLOAT_OBJ;
    public static final DataType INTEGER;
    public static final DataType INTEGER_OBJ;
    public static final DataType LONG;
    public static final DataType LONG_OBJ;
    public static final DataType LONG_STRING;
    public static final DataType SERIALIZABLE;
    public static final DataType SHORT;
    public static final DataType SHORT_OBJ;
    public static final DataType SQL_DATE;
    public static final DataType STRING;
    public static final DataType STRING_BYTES;
    public static final DataType TIME_STAMP;
    public static final DataType UNKNOWN;
    public static final DataType UUID;
    private final DataPersister dataPersister;

    private DataType(String s, int i, DataPersister datapersister)
    {
        super(s, i);
        dataPersister = datapersister;
    }

    public static DataType valueOf(String s)
    {
        return (DataType)Enum.valueOf(com/j256/ormlite/field/DataType, s);
    }

    public static DataType[] values()
    {
        return (DataType[])$VALUES.clone();
    }

    public DataPersister getDataPersister()
    {
        return dataPersister;
    }

    static 
    {
        STRING = new DataType("STRING", 0, StringType.getSingleton());
        LONG_STRING = new DataType("LONG_STRING", 1, LongStringType.getSingleton());
        STRING_BYTES = new DataType("STRING_BYTES", 2, StringBytesType.getSingleton());
        BOOLEAN = new DataType("BOOLEAN", 3, BooleanType.getSingleton());
        BOOLEAN_OBJ = new DataType("BOOLEAN_OBJ", 4, BooleanObjectType.getSingleton());
        DATE = new DataType("DATE", 5, DateType.getSingleton());
        DATE_LONG = new DataType("DATE_LONG", 6, DateLongType.getSingleton());
        DATE_STRING = new DataType("DATE_STRING", 7, DateStringType.getSingleton());
        CHAR = new DataType("CHAR", 8, CharType.getSingleton());
        CHAR_OBJ = new DataType("CHAR_OBJ", 9, CharacterObjectType.getSingleton());
        BYTE = new DataType("BYTE", 10, ByteType.getSingleton());
        BYTE_ARRAY = new DataType("BYTE_ARRAY", 11, ByteArrayType.getSingleton());
        BYTE_OBJ = new DataType("BYTE_OBJ", 12, ByteObjectType.getSingleton());
        SHORT = new DataType("SHORT", 13, ShortType.getSingleton());
        SHORT_OBJ = new DataType("SHORT_OBJ", 14, ShortObjectType.getSingleton());
        INTEGER = new DataType("INTEGER", 15, IntType.getSingleton());
        INTEGER_OBJ = new DataType("INTEGER_OBJ", 16, IntegerObjectType.getSingleton());
        LONG = new DataType("LONG", 17, LongType.getSingleton());
        LONG_OBJ = new DataType("LONG_OBJ", 18, LongObjectType.getSingleton());
        FLOAT = new DataType("FLOAT", 19, FloatType.getSingleton());
        FLOAT_OBJ = new DataType("FLOAT_OBJ", 20, FloatObjectType.getSingleton());
        DOUBLE = new DataType("DOUBLE", 21, DoubleType.getSingleton());
        DOUBLE_OBJ = new DataType("DOUBLE_OBJ", 22, DoubleObjectType.getSingleton());
        SERIALIZABLE = new DataType("SERIALIZABLE", 23, SerializableType.getSingleton());
        ENUM_STRING = new DataType("ENUM_STRING", 24, EnumStringType.getSingleton());
        ENUM_INTEGER = new DataType("ENUM_INTEGER", 25, EnumIntegerType.getSingleton());
        UUID = new DataType("UUID", 26, UuidType.getSingleton());
        BIG_INTEGER = new DataType("BIG_INTEGER", 27, BigIntegerType.getSingleton());
        BIG_DECIMAL = new DataType("BIG_DECIMAL", 28, BigDecimalStringType.getSingleton());
        BIG_DECIMAL_NUMERIC = new DataType("BIG_DECIMAL_NUMERIC", 29, BigDecimalNumericType.getSingleton());
        DATE_TIME = new DataType("DATE_TIME", 30, DateTimeType.getSingleton());
        SQL_DATE = new DataType("SQL_DATE", 31, SqlDateType.getSingleton());
        TIME_STAMP = new DataType("TIME_STAMP", 32, TimeStampType.getSingleton());
        UNKNOWN = new DataType("UNKNOWN", 33, null);
        $VALUES = (new DataType[] {
            STRING, LONG_STRING, STRING_BYTES, BOOLEAN, BOOLEAN_OBJ, DATE, DATE_LONG, DATE_STRING, CHAR, CHAR_OBJ, 
            BYTE, BYTE_ARRAY, BYTE_OBJ, SHORT, SHORT_OBJ, INTEGER, INTEGER_OBJ, LONG, LONG_OBJ, FLOAT, 
            FLOAT_OBJ, DOUBLE, DOUBLE_OBJ, SERIALIZABLE, ENUM_STRING, ENUM_INTEGER, UUID, BIG_INTEGER, BIG_DECIMAL, BIG_DECIMAL_NUMERIC, 
            DATE_TIME, SQL_DATE, TIME_STAMP, UNKNOWN
        });
    }
}
