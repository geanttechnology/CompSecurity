// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


public final class ChannelEnum extends Enum
{

    private static final ChannelEnum $VALUES[];
    public static final ChannelEnum ACTIVITY;
    public static final ChannelEnum DEALS;
    public static final ChannelEnum DEPARTMENT;
    public static final ChannelEnum HIGHLIGHT;
    public static final ChannelEnum SELL;
    public static final ChannelEnum SHOP;

    private ChannelEnum(String s, int i)
    {
        super(s, i);
    }

    public static ChannelEnum valueOf(String s)
    {
        return (ChannelEnum)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/ChannelEnum, s);
    }

    public static ChannelEnum[] values()
    {
        return (ChannelEnum[])$VALUES.clone();
    }

    static 
    {
        DEPARTMENT = new ChannelEnum("DEPARTMENT", 0);
        HIGHLIGHT = new ChannelEnum("HIGHLIGHT", 1);
        DEALS = new ChannelEnum("DEALS", 2);
        ACTIVITY = new ChannelEnum("ACTIVITY", 3);
        SHOP = new ChannelEnum("SHOP", 4);
        SELL = new ChannelEnum("SELL", 5);
        $VALUES = (new ChannelEnum[] {
            DEPARTMENT, HIGHLIGHT, DEALS, ACTIVITY, SHOP, SELL
        });
    }
}
