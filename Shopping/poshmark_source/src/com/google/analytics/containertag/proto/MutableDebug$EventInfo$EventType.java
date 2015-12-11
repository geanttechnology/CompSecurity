// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;


// Referenced classes of package com.google.analytics.containertag.proto:
//            MutableDebug

public static final class value extends Enum
    implements com.google.tagmanager.protobuf.ventType
{

    private static final MACRO_REFERENCE $VALUES[];
    public static final MACRO_REFERENCE DATA_LAYER_EVENT;
    public static final int DATA_LAYER_EVENT_VALUE = 1;
    public static final MACRO_REFERENCE MACRO_REFERENCE;
    public static final int MACRO_REFERENCE_VALUE = 2;
    private static com.google.tagmanager.protobuf.ventType internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

        public MutableDebug.EventInfo.EventType findValueByNumber(int i)
        {
            return MutableDebug.EventInfo.EventType.valueOf(i);
        }

        public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
        {
            return findValueByNumber(i);
        }

    };
    private final int value;

    public static com.google.tagmanager.protobuf.ventType internalGetValueMap()
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
            return DATA_LAYER_EVENT;

        case 2: // '\002'
            return MACRO_REFERENCE;
        }
    }

    public static MACRO_REFERENCE valueOf(String s)
    {
        return (MACRO_REFERENCE)Enum.valueOf(com/google/analytics/containertag/proto/MutableDebug$EventInfo$EventType, s);
    }

    public static MACRO_REFERENCE[] values()
    {
        return (MACRO_REFERENCE[])$VALUES.clone();
    }

    public final int getNumber()
    {
        return value;
    }

    static 
    {
        DATA_LAYER_EVENT = new <init>("DATA_LAYER_EVENT", 0, 0, 1);
        MACRO_REFERENCE = new <init>("MACRO_REFERENCE", 1, 1, 2);
        $VALUES = (new .VALUES[] {
            DATA_LAYER_EVENT, MACRO_REFERENCE
        });
    }

    private _cls1(String s, int i, int j, int k)
    {
        super(s, i);
        value = k;
    }
}
