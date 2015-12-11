// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;


// Referenced classes of package com.google.analytics.containertag.proto:
//            Serving

public static final class value extends Enum
    implements com.google.tagmanager.protobuf.rceState
{

    private static final LIVE $VALUES[];
    public static final LIVE LIVE;
    public static final int LIVE_VALUE = 2;
    public static final LIVE PREVIEW;
    public static final int PREVIEW_VALUE = 1;
    private static com.google.tagmanager.protobuf.rceState internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

        public Serving.ResourceState findValueByNumber(int i)
        {
            return Serving.ResourceState.valueOf(i);
        }

        public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
        {
            return findValueByNumber(i);
        }

    };
    private final int value;

    public static com.google.tagmanager.protobuf.rceState internalGetValueMap()
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
            return PREVIEW;

        case 2: // '\002'
            return LIVE;
        }
    }

    public static LIVE valueOf(String s)
    {
        return (LIVE)Enum.valueOf(com/google/analytics/containertag/proto/Serving$ResourceState, s);
    }

    public static LIVE[] values()
    {
        return (LIVE[])$VALUES.clone();
    }

    public final int getNumber()
    {
        return value;
    }

    static 
    {
        PREVIEW = new <init>("PREVIEW", 0, 0, 1);
        LIVE = new <init>("LIVE", 1, 1, 2);
        $VALUES = (new .VALUES[] {
            PREVIEW, LIVE
        });
    }

    private _cls1(String s, int i, int j, int k)
    {
        super(s, i);
        value = k;
    }
}
