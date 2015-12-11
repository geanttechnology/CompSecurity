// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseQuery

public static final class  extends Enum
{

    private static final CACHE_THEN_NETWORK $VALUES[];
    public static final CACHE_THEN_NETWORK CACHE_ELSE_NETWORK;
    public static final CACHE_THEN_NETWORK CACHE_ONLY;
    public static final CACHE_THEN_NETWORK CACHE_THEN_NETWORK;
    public static final CACHE_THEN_NETWORK IGNORE_CACHE;
    public static final CACHE_THEN_NETWORK NETWORK_ELSE_CACHE;
    public static final CACHE_THEN_NETWORK NETWORK_ONLY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/parse/ParseQuery$CachePolicy, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IGNORE_CACHE = new <init>("IGNORE_CACHE", 0);
        CACHE_ONLY = new <init>("CACHE_ONLY", 1);
        NETWORK_ONLY = new <init>("NETWORK_ONLY", 2);
        CACHE_ELSE_NETWORK = new <init>("CACHE_ELSE_NETWORK", 3);
        NETWORK_ELSE_CACHE = new <init>("NETWORK_ELSE_CACHE", 4);
        CACHE_THEN_NETWORK = new <init>("CACHE_THEN_NETWORK", 5);
        $VALUES = (new .VALUES[] {
            IGNORE_CACHE, CACHE_ONLY, NETWORK_ONLY, CACHE_ELSE_NETWORK, NETWORK_ELSE_CACHE, CACHE_THEN_NETWORK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
