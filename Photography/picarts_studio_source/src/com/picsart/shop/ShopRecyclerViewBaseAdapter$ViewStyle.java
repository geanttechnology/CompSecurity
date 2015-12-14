// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;


public final class  extends Enum
{

    private static final LIST $VALUES[];
    public static final LIST GRID;
    public static final LIST LIST;
    public static final LIST STAGGERED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/shop/ShopRecyclerViewBaseAdapter$ViewStyle, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STAGGERED = new <init>("STAGGERED", 0);
        GRID = new <init>("GRID", 1);
        LIST = new <init>("LIST", 2);
        $VALUES = (new .VALUES[] {
            STAGGERED, GRID, LIST
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
