// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            Descriptors

public static final class javaType extends Enum
{

    private static final SINT64 $VALUES[];
    public static final SINT64 BOOL;
    public static final SINT64 BYTES;
    public static final SINT64 DOUBLE;
    public static final SINT64 ENUM;
    public static final SINT64 FIXED32;
    public static final SINT64 FIXED64;
    public static final SINT64 FLOAT;
    public static final SINT64 GROUP;
    public static final SINT64 INT32;
    public static final SINT64 INT64;
    public static final SINT64 MESSAGE;
    public static final SINT64 SFIXED32;
    public static final SINT64 SFIXED64;
    public static final SINT64 SINT32;
    public static final SINT64 SINT64;
    public static final SINT64 STRING;
    public static final SINT64 UINT32;
    public static final SINT64 UINT64;
    private ype javaType;

    public static roto.Type valueOf(roto.Type type)
    {
        return values()[type.getNumber() - 1];
    }

    public static roto.Type.getNumber valueOf(String s)
    {
        return (roto.Type.getNumber)Enum.valueOf(com/google/protobuf/Descriptors$FieldDescriptor$Type, s);
    }

    public static roto.Type.getNumber[] values()
    {
        return (roto.Type.getNumber[])$VALUES.clone();
    }

    public ype getJavaType()
    {
        return javaType;
    }

    static 
    {
        DOUBLE = new <init>("DOUBLE", 0, ype.DOUBLE);
        FLOAT = new <init>("FLOAT", 1, ype.FLOAT);
        INT64 = new <init>("INT64", 2, ype.LONG);
        UINT64 = new <init>("UINT64", 3, ype.LONG);
        INT32 = new <init>("INT32", 4, ype.INT);
        FIXED64 = new <init>("FIXED64", 5, ype.LONG);
        FIXED32 = new <init>("FIXED32", 6, ype.INT);
        BOOL = new <init>("BOOL", 7, ype.BOOLEAN);
        STRING = new <init>("STRING", 8, ype.STRING);
        GROUP = new <init>("GROUP", 9, ype.MESSAGE);
        MESSAGE = new <init>("MESSAGE", 10, ype.MESSAGE);
        BYTES = new <init>("BYTES", 11, ype.BYTE_STRING);
        UINT32 = new <init>("UINT32", 12, ype.INT);
        ENUM = new <init>("ENUM", 13, ype.ENUM);
        SFIXED32 = new <init>("SFIXED32", 14, ype.INT);
        SFIXED64 = new <init>("SFIXED64", 15, ype.LONG);
        SINT32 = new <init>("SINT32", 16, ype.INT);
        SINT64 = new <init>("SINT64", 17, ype.LONG);
        $VALUES = (new .VALUES[] {
            DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, 
            MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64
        });
    }

    private ype(String s, int i, ype ype)
    {
        super(s, i);
        javaType = ype;
    }
}
