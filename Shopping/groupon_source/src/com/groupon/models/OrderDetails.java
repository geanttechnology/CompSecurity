// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;


public class OrderDetails
{

    private String id;
    private String price;
    private int quantity;
    private String title;

    public OrderDetails(String s, String s1, int i, String s2)
    {
        id = s;
        title = s1;
        quantity = i;
        price = s2;
    }

    public String getId()
    {
        return id;
    }

    public String getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getTitle()
    {
        return title;
    }
}
