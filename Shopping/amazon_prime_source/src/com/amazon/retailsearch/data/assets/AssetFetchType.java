// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.assets;


public final class AssetFetchType extends Enum
{

    private static final AssetFetchType $VALUES[];
    public static final AssetFetchType APP_RESET;
    public static final AssetFetchType POST_SEARCH_PAGE_LOAD;
    public static final AssetFetchType STARTUP_SEQUENCE;

    private AssetFetchType(String s, int i)
    {
        super(s, i);
    }

    public static AssetFetchType valueOf(String s)
    {
        return (AssetFetchType)Enum.valueOf(com/amazon/retailsearch/data/assets/AssetFetchType, s);
    }

    public static AssetFetchType[] values()
    {
        return (AssetFetchType[])$VALUES.clone();
    }

    public String toLoggingString()
    {
        return name().toLowerCase();
    }

    static 
    {
        STARTUP_SEQUENCE = new AssetFetchType("STARTUP_SEQUENCE", 0);
        POST_SEARCH_PAGE_LOAD = new AssetFetchType("POST_SEARCH_PAGE_LOAD", 1);
        APP_RESET = new AssetFetchType("APP_RESET", 2);
        $VALUES = (new AssetFetchType[] {
            STARTUP_SEQUENCE, POST_SEARCH_PAGE_LOAD, APP_RESET
        });
    }
}
