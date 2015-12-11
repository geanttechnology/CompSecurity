// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            ProtocolMessageEnum, DescriptorProtos

public static final class value extends Enum
    implements ProtocolMessageEnum
{

    private static final STRING_PIECE $VALUES[];
    public static final STRING_PIECE CORD;
    public static final STRING_PIECE STRING;
    public static final STRING_PIECE STRING_PIECE;
    private static final STRING_PIECE VALUES[];
    private static STRING_PIECE internalValueMap = new Internal.EnumLiteMap() {

    };
    private final int index;
    private final int value;

    public static value valueOf(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return STRING;

        case 1: // '\001'
            return CORD;

        case 2: // '\002'
            return STRING_PIECE;
        }
    }

    public static STRING_PIECE valueOf(String s)
    {
        return (STRING_PIECE)Enum.valueOf(com/google/protobuf/DescriptorProtos$FieldOptions$CType, s);
    }

    public static STRING_PIECE[] values()
    {
        return (STRING_PIECE[])$VALUES.clone();
    }

    public final int getNumber()
    {
        return value;
    }

    static 
    {
        STRING = new <init>("STRING", 0, 0, 0);
        CORD = new <init>("CORD", 1, 1, 1);
        STRING_PIECE = new <init>("STRING_PIECE", 2, 2, 2);
        $VALUES = (new .VALUES[] {
            STRING, CORD, STRING_PIECE
        });
        VALUES = (new VALUES[] {
            STRING, CORD, STRING_PIECE
        });
    }

    private _cls1(String s, int i, int j, int k)
    {
        super(s, i);
        index = j;
        value = k;
    }
}
