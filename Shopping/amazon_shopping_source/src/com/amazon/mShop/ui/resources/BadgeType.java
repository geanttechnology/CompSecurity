// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui.resources;


public final class BadgeType extends Enum
{

    private static final BadgeType $VALUES[];
    public static final BadgeType ADD_ON;
    public static final BadgeType PRIME;
    public static final BadgeType PRIME_FRESH;
    public static final BadgeType PRIME_PLUS;

    private BadgeType(String s, int i)
    {
        super(s, i);
    }

    public static BadgeType valueOf(String s)
    {
        return (BadgeType)Enum.valueOf(com/amazon/mShop/ui/resources/BadgeType, s);
    }

    public static BadgeType[] values()
    {
        return (BadgeType[])$VALUES.clone();
    }

    static 
    {
        PRIME_FRESH = new BadgeType("PRIME_FRESH", 0);
        PRIME_PLUS = new BadgeType("PRIME_PLUS", 1);
        PRIME = new BadgeType("PRIME", 2);
        ADD_ON = new BadgeType("ADD_ON", 3);
        $VALUES = (new BadgeType[] {
            PRIME_FRESH, PRIME_PLUS, PRIME, ADD_ON
        });
    }
}
