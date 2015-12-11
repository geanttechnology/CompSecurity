// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class NavMenuItem
{

    private String itemId;
    private String parentId;
    private String refMarker;
    private String target;
    private String targetUrl;
    private String title;
    private int type;

    public NavMenuItem()
    {
    }

    public String getItemId()
    {
        return itemId;
    }

    public String getParentId()
    {
        return parentId;
    }

    public String getRefMarker()
    {
        return refMarker;
    }

    public String getTarget()
    {
        return target;
    }

    public String getTargetUrl()
    {
        return targetUrl;
    }

    public String getTitle()
    {
        return title;
    }

    public int getType()
    {
        return type;
    }

    public void setItemId(String s)
    {
        itemId = s;
    }

    public void setParentId(String s)
    {
        parentId = s;
    }

    public void setRefMarker(String s)
    {
        refMarker = s;
    }

    public void setTarget(String s)
    {
        target = s;
    }

    public void setTargetUrl(String s)
    {
        targetUrl = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setType(int i)
    {
        type = i;
    }
}
