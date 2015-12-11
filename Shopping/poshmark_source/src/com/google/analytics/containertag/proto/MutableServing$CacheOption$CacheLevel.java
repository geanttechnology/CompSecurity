// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;


// Referenced classes of package com.google.analytics.containertag.proto:
//            MutableServing

public static final class value extends Enum
    implements com.google.tagmanager.protobuf.cheLevel
{

    private static final PUBLIC $VALUES[];
    public static final PUBLIC NO_CACHE;
    public static final int NO_CACHE_VALUE = 1;
    public static final PUBLIC PRIVATE;
    public static final int PRIVATE_VALUE = 2;
    public static final PUBLIC PUBLIC;
    public static final int PUBLIC_VALUE = 3;
    private static com.google.tagmanager.protobuf.cheLevel internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

        public MutableServing.CacheOption.CacheLevel findValueByNumber(int i)
        {
            return MutableServing.CacheOption.CacheLevel.valueOf(i);
        }

        public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
        {
            return findValueByNumber(i);
        }

    };
    private final int value;

    public static com.google.tagmanager.protobuf.cheLevel internalGetValueMap()
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
            return NO_CACHE;

        case 2: // '\002'
            return PRIVATE;

        case 3: // '\003'
            return PUBLIC;
        }
    }

    public static PUBLIC valueOf(String s)
    {
        return (PUBLIC)Enum.valueOf(com/google/analytics/containertag/proto/MutableServing$CacheOption$CacheLevel, s);
    }

    public static PUBLIC[] values()
    {
        return (PUBLIC[])$VALUES.clone();
    }

    public final int getNumber()
    {
        return value;
    }

    static 
    {
        NO_CACHE = new <init>("NO_CACHE", 0, 0, 1);
        PRIVATE = new <init>("PRIVATE", 1, 1, 2);
        PUBLIC = new <init>("PUBLIC", 2, 2, 3);
        $VALUES = (new .VALUES[] {
            NO_CACHE, PRIVATE, PUBLIC
        });
    }

    private _cls1(String s, int i, int j, int k)
    {
        super(s, i);
        value = k;
    }
}
