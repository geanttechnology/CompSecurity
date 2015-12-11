// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;


// Referenced classes of package com.flurry.org.apache.avro:
//            Schema

public static final class name extends Enum
{

    private static final NULL $VALUES[];
    public static final NULL ARRAY;
    public static final NULL BOOLEAN;
    public static final NULL BYTES;
    public static final NULL DOUBLE;
    public static final NULL ENUM;
    public static final NULL FIXED;
    public static final NULL FLOAT;
    public static final NULL INT;
    public static final NULL LONG;
    public static final NULL MAP;
    public static final NULL NULL;
    public static final NULL RECORD;
    public static final NULL STRING;
    public static final NULL UNION;
    private String name;

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/flurry/org/apache/avro/Schema$Type, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        RECORD = new <init>("RECORD", 0);
        ENUM = new <init>("ENUM", 1);
        ARRAY = new <init>("ARRAY", 2);
        MAP = new <init>("MAP", 3);
        UNION = new <init>("UNION", 4);
        FIXED = new <init>("FIXED", 5);
        STRING = new <init>("STRING", 6);
        BYTES = new <init>("BYTES", 7);
        INT = new <init>("INT", 8);
        LONG = new <init>("LONG", 9);
        FLOAT = new <init>("FLOAT", 10);
        DOUBLE = new <init>("DOUBLE", 11);
        BOOLEAN = new <init>("BOOLEAN", 12);
        NULL = new <init>("NULL", 13);
        $VALUES = (new .VALUES[] {
            RECORD, ENUM, ARRAY, MAP, UNION, FIXED, STRING, BYTES, INT, LONG, 
            FLOAT, DOUBLE, BOOLEAN, NULL
        });
    }


    private (String s, int i)
    {
        super(s, i);
        name = name().toLowerCase();
    }
}
