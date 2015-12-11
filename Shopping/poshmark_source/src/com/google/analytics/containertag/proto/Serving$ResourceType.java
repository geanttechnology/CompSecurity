// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;


// Referenced classes of package com.google.analytics.containertag.proto:
//            Serving

public static final class value extends Enum
    implements com.google.tagmanager.protobuf.urceType
{

    private static final RAW_PROTO $VALUES[];
    public static final RAW_PROTO CLEAR_CACHE;
    public static final int CLEAR_CACHE_VALUE = 6;
    public static final RAW_PROTO GET_COOKIE;
    public static final int GET_COOKIE_VALUE = 5;
    public static final RAW_PROTO JS_RESOURCE;
    public static final int JS_RESOURCE_VALUE = 1;
    public static final RAW_PROTO NS_RESOURCE;
    public static final int NS_RESOURCE_VALUE = 2;
    public static final RAW_PROTO PIXEL_COLLECTION;
    public static final int PIXEL_COLLECTION_VALUE = 3;
    public static final RAW_PROTO RAW_PROTO;
    public static final int RAW_PROTO_VALUE = 7;
    public static final RAW_PROTO SET_COOKIE;
    public static final int SET_COOKIE_VALUE = 4;
    private static com.google.tagmanager.protobuf.urceType internalValueMap = new com.google.tagmanager.protobuf.Internal.EnumLiteMap() {

        public Serving.ResourceType findValueByNumber(int i)
        {
            return Serving.ResourceType.valueOf(i);
        }

        public volatile com.google.tagmanager.protobuf.Internal.EnumLite findValueByNumber(int i)
        {
            return findValueByNumber(i);
        }

    };
    private final int value;

    public static com.google.tagmanager.protobuf.urceType internalGetValueMap()
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
            return JS_RESOURCE;

        case 2: // '\002'
            return NS_RESOURCE;

        case 3: // '\003'
            return PIXEL_COLLECTION;

        case 4: // '\004'
            return SET_COOKIE;

        case 5: // '\005'
            return GET_COOKIE;

        case 6: // '\006'
            return CLEAR_CACHE;

        case 7: // '\007'
            return RAW_PROTO;
        }
    }

    public static RAW_PROTO valueOf(String s)
    {
        return (RAW_PROTO)Enum.valueOf(com/google/analytics/containertag/proto/Serving$ResourceType, s);
    }

    public static RAW_PROTO[] values()
    {
        return (RAW_PROTO[])$VALUES.clone();
    }

    public final int getNumber()
    {
        return value;
    }

    static 
    {
        JS_RESOURCE = new <init>("JS_RESOURCE", 0, 0, 1);
        NS_RESOURCE = new <init>("NS_RESOURCE", 1, 1, 2);
        PIXEL_COLLECTION = new <init>("PIXEL_COLLECTION", 2, 2, 3);
        SET_COOKIE = new <init>("SET_COOKIE", 3, 3, 4);
        GET_COOKIE = new <init>("GET_COOKIE", 4, 4, 5);
        CLEAR_CACHE = new <init>("CLEAR_CACHE", 5, 5, 6);
        RAW_PROTO = new <init>("RAW_PROTO", 6, 6, 7);
        $VALUES = (new .VALUES[] {
            JS_RESOURCE, NS_RESOURCE, PIXEL_COLLECTION, SET_COOKIE, GET_COOKIE, CLEAR_CACHE, RAW_PROTO
        });
    }

    private _cls1(String s, int i, int j, int k)
    {
        super(s, i);
        value = k;
    }
}
