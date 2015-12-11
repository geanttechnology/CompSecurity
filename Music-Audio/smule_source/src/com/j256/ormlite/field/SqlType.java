// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;


public final class SqlType extends Enum
{

    private static final SqlType $VALUES[];
    public static final SqlType BLOB;
    public static final SqlType BOOLEAN;
    public static final SqlType BYTE;
    public static final SqlType BYTE_ARRAY;
    public static final SqlType CHAR;
    public static final SqlType DATE;
    public static final SqlType DOUBLE;
    public static final SqlType FLOAT;
    public static final SqlType INTEGER;
    public static final SqlType LONG;
    public static final SqlType LONG_STRING;
    public static final SqlType SERIALIZABLE;
    public static final SqlType SHORT;
    public static final SqlType STRING;
    public static final SqlType UNKNOWN;

    private SqlType(String s, int i)
    {
        super(s, i);
    }

    public static SqlType valueOf(String s)
    {
        return (SqlType)Enum.valueOf(com/j256/ormlite/field/SqlType, s);
    }

    public static SqlType[] values()
    {
        return (SqlType[])$VALUES.clone();
    }

    static 
    {
        STRING = new SqlType("STRING", 0);
        LONG_STRING = new SqlType("LONG_STRING", 1);
        DATE = new SqlType("DATE", 2);
        BOOLEAN = new SqlType("BOOLEAN", 3);
        CHAR = new SqlType("CHAR", 4);
        BYTE = new SqlType("BYTE", 5);
        BYTE_ARRAY = new SqlType("BYTE_ARRAY", 6);
        SHORT = new SqlType("SHORT", 7);
        INTEGER = new SqlType("INTEGER", 8);
        LONG = new SqlType("LONG", 9);
        FLOAT = new SqlType("FLOAT", 10);
        DOUBLE = new SqlType("DOUBLE", 11);
        SERIALIZABLE = new SqlType("SERIALIZABLE", 12);
        BLOB = new SqlType("BLOB", 13);
        UNKNOWN = new SqlType("UNKNOWN", 14);
        $VALUES = (new SqlType[] {
            STRING, LONG_STRING, DATE, BOOLEAN, CHAR, BYTE, BYTE_ARRAY, SHORT, INTEGER, LONG, 
            FLOAT, DOUBLE, SERIALIZABLE, BLOB, UNKNOWN
        });
    }
}
