// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.midtier.proto.containertag;


// Referenced classes of package com.google.analytics.midtier.proto.containertag:
//            TypeSystem

public static final class value extends Enum
    implements com.google.tagmanager.protobuf.ystem.Value.Type
{

    private static final BOOLEAN $VALUES[];
    public static final BOOLEAN BOOLEAN;
    public static final int BOOLEAN_VALUE = 8;
    public static final BOOLEAN FUNCTION_ID;
    public static final int FUNCTION_ID_VALUE = 5;
    public static final BOOLEAN INTEGER;
    public static final int INTEGER_VALUE = 6;
    public static final BOOLEAN LIST;
    public static final int LIST_VALUE = 2;
    public static final BOOLEAN MACRO_REFERENCE;
    public static final int MACRO_REFERENCE_VALUE = 4;
    public static final BOOLEAN MAP;
    public static final int MAP_VALUE = 3;
    public static final BOOLEAN STRING;
    public static final int STRING_VALUE = 1;
    public static final BOOLEAN TEMPLATE;
    public static final int TEMPLATE_VALUE = 7;
    private static com.google.tagmanager.protobuf.ystem.Value.Type internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

        public TypeSystem.Value.Type findValueByNumber(int i)
        {
            return TypeSystem.Value.Type.valueOf(i);
        }

        public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
        {
            return findValueByNumber(i);
        }

    };
    private final int value;

    public static com.google.tagmanager.protobuf.ystem.Value.Type internalGetValueMap()
    {
        return internalValueMap;
    }

    public static internalValueMap valueOf(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return STRING;

        case 2: // '\002'
            return LIST;

        case 3: // '\003'
            return MAP;

        case 4: // '\004'
            return MACRO_REFERENCE;

        case 5: // '\005'
            return FUNCTION_ID;

        case 6: // '\006'
            return INTEGER;

        case 7: // '\007'
            return TEMPLATE;

        case 8: // '\b'
            return BOOLEAN;
        }
    }

    public static BOOLEAN valueOf(String s)
    {
        return (BOOLEAN)Enum.valueOf(com/google/analytics/midtier/proto/containertag/TypeSystem$Value$Type, s);
    }

    public static BOOLEAN[] values()
    {
        return (BOOLEAN[])$VALUES.clone();
    }

    public final int getNumber()
    {
        return value;
    }

    static 
    {
        STRING = new <init>("STRING", 0, 0, 1);
        LIST = new <init>("LIST", 1, 1, 2);
        MAP = new <init>("MAP", 2, 2, 3);
        MACRO_REFERENCE = new <init>("MACRO_REFERENCE", 3, 3, 4);
        FUNCTION_ID = new <init>("FUNCTION_ID", 4, 4, 5);
        INTEGER = new <init>("INTEGER", 5, 5, 6);
        TEMPLATE = new <init>("TEMPLATE", 6, 6, 7);
        BOOLEAN = new <init>("BOOLEAN", 7, 7, 8);
        $VALUES = (new .VALUES[] {
            STRING, LIST, MAP, MACRO_REFERENCE, FUNCTION_ID, INTEGER, TEMPLATE, BOOLEAN
        });
    }

    private _cls1(String s, int i, int j, int k)
    {
        super(s, i);
        value = k;
    }
}
