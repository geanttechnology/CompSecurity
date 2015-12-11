// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            ProtocolMessageEnum, DescriptorProtos

public static final class value extends Enum
    implements ProtocolMessageEnum
{

    private static final TYPE_SINT64 $VALUES[];
    public static final TYPE_SINT64 TYPE_BOOL;
    public static final TYPE_SINT64 TYPE_BYTES;
    public static final TYPE_SINT64 TYPE_DOUBLE;
    public static final TYPE_SINT64 TYPE_ENUM;
    public static final TYPE_SINT64 TYPE_FIXED32;
    public static final TYPE_SINT64 TYPE_FIXED64;
    public static final TYPE_SINT64 TYPE_FLOAT;
    public static final TYPE_SINT64 TYPE_GROUP;
    public static final TYPE_SINT64 TYPE_INT32;
    public static final TYPE_SINT64 TYPE_INT64;
    public static final TYPE_SINT64 TYPE_MESSAGE;
    public static final TYPE_SINT64 TYPE_SFIXED32;
    public static final TYPE_SINT64 TYPE_SFIXED64;
    public static final TYPE_SINT64 TYPE_SINT32;
    public static final TYPE_SINT64 TYPE_SINT64;
    public static final TYPE_SINT64 TYPE_STRING;
    public static final TYPE_SINT64 TYPE_UINT32;
    public static final TYPE_SINT64 TYPE_UINT64;
    private static final TYPE_SINT64 VALUES[];
    private static TYPE_SINT64 internalValueMap = new Internal.EnumLiteMap() {

    };
    private final int index;
    private final int value;

    public static value valueOf(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return TYPE_DOUBLE;

        case 2: // '\002'
            return TYPE_FLOAT;

        case 3: // '\003'
            return TYPE_INT64;

        case 4: // '\004'
            return TYPE_UINT64;

        case 5: // '\005'
            return TYPE_INT32;

        case 6: // '\006'
            return TYPE_FIXED64;

        case 7: // '\007'
            return TYPE_FIXED32;

        case 8: // '\b'
            return TYPE_BOOL;

        case 9: // '\t'
            return TYPE_STRING;

        case 10: // '\n'
            return TYPE_GROUP;

        case 11: // '\013'
            return TYPE_MESSAGE;

        case 12: // '\f'
            return TYPE_BYTES;

        case 13: // '\r'
            return TYPE_UINT32;

        case 14: // '\016'
            return TYPE_ENUM;

        case 15: // '\017'
            return TYPE_SFIXED32;

        case 16: // '\020'
            return TYPE_SFIXED64;

        case 17: // '\021'
            return TYPE_SINT32;

        case 18: // '\022'
            return TYPE_SINT64;
        }
    }

    public static TYPE_SINT64 valueOf(String s)
    {
        return (TYPE_SINT64)Enum.valueOf(com/google/protobuf/DescriptorProtos$FieldDescriptorProto$Type, s);
    }

    public static TYPE_SINT64[] values()
    {
        return (TYPE_SINT64[])$VALUES.clone();
    }

    public final int getNumber()
    {
        return value;
    }

    static 
    {
        TYPE_DOUBLE = new <init>("TYPE_DOUBLE", 0, 0, 1);
        TYPE_FLOAT = new <init>("TYPE_FLOAT", 1, 1, 2);
        TYPE_INT64 = new <init>("TYPE_INT64", 2, 2, 3);
        TYPE_UINT64 = new <init>("TYPE_UINT64", 3, 3, 4);
        TYPE_INT32 = new <init>("TYPE_INT32", 4, 4, 5);
        TYPE_FIXED64 = new <init>("TYPE_FIXED64", 5, 5, 6);
        TYPE_FIXED32 = new <init>("TYPE_FIXED32", 6, 6, 7);
        TYPE_BOOL = new <init>("TYPE_BOOL", 7, 7, 8);
        TYPE_STRING = new <init>("TYPE_STRING", 8, 8, 9);
        TYPE_GROUP = new <init>("TYPE_GROUP", 9, 9, 10);
        TYPE_MESSAGE = new <init>("TYPE_MESSAGE", 10, 10, 11);
        TYPE_BYTES = new <init>("TYPE_BYTES", 11, 11, 12);
        TYPE_UINT32 = new <init>("TYPE_UINT32", 12, 12, 13);
        TYPE_ENUM = new <init>("TYPE_ENUM", 13, 13, 14);
        TYPE_SFIXED32 = new <init>("TYPE_SFIXED32", 14, 14, 15);
        TYPE_SFIXED64 = new <init>("TYPE_SFIXED64", 15, 15, 16);
        TYPE_SINT32 = new <init>("TYPE_SINT32", 16, 16, 17);
        TYPE_SINT64 = new <init>("TYPE_SINT64", 17, 17, 18);
        $VALUES = (new .VALUES[] {
            TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, 
            TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64
        });
        VALUES = (new VALUES[] {
            TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, 
            TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64
        });
    }

    private _cls1(String s, int i, int j, int k)
    {
        super(s, i);
        index = j;
        value = k;
    }
}
