// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.event;


public class ShoppingCartItemQuantitySelectedEvent
{

    public final String dealUuid;
    public final String optionUuid;
    public final int position;
    public final int quantity;

    public ShoppingCartItemQuantitySelectedEvent(String s, String s1, int i, int j)
    {
        dealUuid = s;
        optionUuid = s1;
        quantity = i;
        position = j;
    }
}
