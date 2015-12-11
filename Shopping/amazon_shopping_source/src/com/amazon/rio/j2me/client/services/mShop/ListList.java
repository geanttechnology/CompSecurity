// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class ListList
{

    private Boolean isDefault;
    private Boolean isPrivate;
    private Boolean isSearchable;
    private String lastModified;
    private String listId;
    private String listTitle;
    private Integer subtype;

    public ListList()
    {
    }

    public String getListId()
    {
        return listId;
    }

    public String getListTitle()
    {
        return listTitle;
    }

    public void setIsDefault(Boolean boolean1)
    {
        isDefault = boolean1;
    }

    public void setIsPrivate(Boolean boolean1)
    {
        isPrivate = boolean1;
    }

    public void setIsSearchable(Boolean boolean1)
    {
        isSearchable = boolean1;
    }

    public void setLastModified(String s)
    {
        lastModified = s;
    }

    public void setListId(String s)
    {
        listId = s;
    }

    public void setListTitle(String s)
    {
        listTitle = s;
    }

    public void setSubtype(Integer integer)
    {
        subtype = integer;
    }
}
