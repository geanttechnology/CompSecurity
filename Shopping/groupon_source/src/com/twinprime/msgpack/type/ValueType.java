// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;


public final class ValueType extends Enum
{

    private static final ValueType $VALUES[];
    public static final ValueType ARRAY;
    public static final ValueType BOOLEAN;
    public static final ValueType FLOAT;
    public static final ValueType INTEGER;
    public static final ValueType MAP;
    public static final ValueType NIL;
    public static final ValueType RAW;

    private ValueType(String s, int i)
    {
        super(s, i);
    }

    public static ValueType valueOf(String s)
    {
        return (ValueType)Enum.valueOf(com/twinprime/msgpack/type/ValueType, s);
    }

    public static ValueType[] values()
    {
        return (ValueType[])$VALUES.clone();
    }

    static 
    {
        NIL = new ValueType("NIL", 0);
        BOOLEAN = new ValueType("BOOLEAN", 1);
        INTEGER = new ValueType("INTEGER", 2);
        FLOAT = new ValueType("FLOAT", 3);
        ARRAY = new ValueType("ARRAY", 4);
        MAP = new ValueType("MAP", 5);
        RAW = new ValueType("RAW", 6);
        $VALUES = (new ValueType[] {
            NIL, BOOLEAN, INTEGER, FLOAT, ARRAY, MAP, RAW
        });
    }
}
