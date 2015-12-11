// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


public class ItemPair
{

    private Object item1;
    private Object item2;

    public ItemPair(Object obj, Object obj1)
    {
        item1 = obj;
        item2 = obj1;
    }

    public Object getLeftItem()
    {
        return item1;
    }

    public Object getRightItem()
    {
        return item2;
    }
}
