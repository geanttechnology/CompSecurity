// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            ProtocolMessageEnum, DescriptorProtos

public static final class value extends Enum
    implements ProtocolMessageEnum
{

    private static final LITE_RUNTIME $VALUES[];
    public static final LITE_RUNTIME CODE_SIZE;
    public static final LITE_RUNTIME LITE_RUNTIME;
    public static final LITE_RUNTIME SPEED;
    private static final LITE_RUNTIME VALUES[] = values();
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
            return SPEED;

        case 2: // '\002'
            return CODE_SIZE;

        case 3: // '\003'
            return LITE_RUNTIME;
        }
    }

    public static LITE_RUNTIME valueOf(String s)
    {
        return (LITE_RUNTIME)Enum.valueOf(com/google/protobuf/DescriptorProtos$FileOptions$OptimizeMode, s);
    }

    public static LITE_RUNTIME[] values()
    {
        return (LITE_RUNTIME[])$VALUES.clone();
    }

    public final int getNumber()
    {
        return value;
    }

    static 
    {
        SPEED = new <init>("SPEED", 0, 0, 1);
        CODE_SIZE = new <init>("CODE_SIZE", 1, 1, 2);
        LITE_RUNTIME = new <init>("LITE_RUNTIME", 2, 2, 3);
        $VALUES = (new .VALUES[] {
            SPEED, CODE_SIZE, LITE_RUNTIME
        });
    }

    private _cls1(String s, int i, int j, int k)
    {
        super(s, i);
        index = j;
        value = k;
    }
}
