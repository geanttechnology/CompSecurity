// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;


public final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN COINS;
    public static final UNKNOWN PRODUCT;
    public static final UNKNOWN UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/smule/pianoandroid/data/model/GameReward$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        COINS = new <init>("COINS", 0);
        PRODUCT = new <init>("PRODUCT", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        $VALUES = (new .VALUES[] {
            COINS, PRODUCT, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
