// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;


public class SortClause
{

    protected String column;
    protected SortOrder.Order order;

    public SortClause(String s, SortOrder.Order order1)
    {
        column = s;
        order = order1;
    }

    public String toString()
    {
        return (new StringBuilder()).append(column).append(" ").append(order.toString()).toString();
    }
}
