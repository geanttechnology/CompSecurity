// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class RequestListItem
{

    private String asin;
    private String listId;
    private String listItemId;
    private String listType;
    private Integer subtype;

    public RequestListItem()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public String getListId()
    {
        return listId;
    }

    public String getListItemId()
    {
        return listItemId;
    }

    public String getListType()
    {
        return listType;
    }

    public Integer getSubtype()
    {
        return subtype;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setListId(String s)
    {
        listId = s;
    }

    public void setListItemId(String s)
    {
        listItemId = s;
    }

    public void setListType(String s)
    {
        listType = s;
    }
}
