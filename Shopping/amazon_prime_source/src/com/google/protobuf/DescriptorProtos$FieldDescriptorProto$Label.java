// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            ProtocolMessageEnum, DescriptorProtos

public static final class value extends Enum
    implements ProtocolMessageEnum
{

    private static final LABEL_REPEATED $VALUES[];
    public static final LABEL_REPEATED LABEL_OPTIONAL;
    public static final LABEL_REPEATED LABEL_REPEATED;
    public static final LABEL_REPEATED LABEL_REQUIRED;
    private static final LABEL_REPEATED VALUES[] = values();
    private static values internalValueMap = new Internal.EnumLiteMap() {

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
            return LABEL_OPTIONAL;

        case 2: // '\002'
            return LABEL_REQUIRED;

        case 3: // '\003'
            return LABEL_REPEATED;
        }
    }

    public static LABEL_REPEATED valueOf(String s)
    {
        return (LABEL_REPEATED)Enum.valueOf(com/google/protobuf/DescriptorProtos$FieldDescriptorProto$Label, s);
    }

    public static LABEL_REPEATED[] values()
    {
        return (LABEL_REPEATED[])$VALUES.clone();
    }

    public final int getNumber()
    {
        return value;
    }

    static 
    {
        LABEL_OPTIONAL = new <init>("LABEL_OPTIONAL", 0, 0, 1);
        LABEL_REQUIRED = new <init>("LABEL_REQUIRED", 1, 1, 2);
        LABEL_REPEATED = new <init>("LABEL_REPEATED", 2, 2, 3);
        $VALUES = (new .VALUES[] {
            LABEL_OPTIONAL, LABEL_REQUIRED, LABEL_REPEATED
        });
    }

    private _cls1(String s, int i, int j, int k)
    {
        super(s, i);
        index = j;
        value = k;
    }
}
