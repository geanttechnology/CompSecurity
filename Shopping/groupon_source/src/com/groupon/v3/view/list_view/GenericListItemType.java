// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;


public abstract class GenericListItemType
{

    Object listItemType;

    public GenericListItemType(Object obj)
    {
        listItemType = obj;
    }

    public Object getType()
    {
        return listItemType;
    }

    public boolean isType(Object obj)
    {
        return obj == getType();
    }

    public void setListItemType(Object obj)
    {
        listItemType = obj;
    }
}
