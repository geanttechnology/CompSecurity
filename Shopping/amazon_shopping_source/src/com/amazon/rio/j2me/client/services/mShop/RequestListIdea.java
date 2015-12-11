// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class RequestListIdea
{

    private String idea;
    private String listId;
    private Integer listSubtype;
    private String listType;
    private String vendorId;

    public RequestListIdea()
    {
    }

    public String getIdea()
    {
        return idea;
    }

    public String getListId()
    {
        return listId;
    }

    public Integer getListSubtype()
    {
        return listSubtype;
    }

    public String getListType()
    {
        return listType;
    }

    public String getVendorId()
    {
        return vendorId;
    }

    public void setIdea(String s)
    {
        idea = s;
    }

    public void setListId(String s)
    {
        listId = s;
    }

    public void setListType(String s)
    {
        listType = s;
    }

    public void setVendorId(String s)
    {
        vendorId = s;
    }
}
