// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;


public class MaxQuantityException extends Exception
{

    public final int maxItems;

    public MaxQuantityException(int i)
    {
        maxItems = i;
    }
}
