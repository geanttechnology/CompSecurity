// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;


public final class PurchasedState extends Enum
{

    private static final PurchasedState $VALUES[];
    public static final PurchasedState FREE;
    public static final PurchasedState PURCHASED;
    public static final PurchasedState UNPURCHASED;
    private String state;

    private PurchasedState(String s, int i, String s1)
    {
        super(s, i);
        state = s1;
    }

    public static PurchasedState valueOf(String s)
    {
        return (PurchasedState)Enum.valueOf(com/bitstrips/imoji/models/PurchasedState, s);
    }

    public static PurchasedState[] values()
    {
        return (PurchasedState[])$VALUES.clone();
    }

    public String toString()
    {
        return state;
    }

    static 
    {
        FREE = new PurchasedState("FREE", 0, "free");
        PURCHASED = new PurchasedState("PURCHASED", 1, "purchased");
        UNPURCHASED = new PurchasedState("UNPURCHASED", 2, "unpurchased");
        $VALUES = (new PurchasedState[] {
            FREE, PURCHASED, UNPURCHASED
        });
    }
}
