// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.ImageResource;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ImageResourceEntity extends RetailSearchEntity
    implements ImageResource
{

    private int displayHeight;
    private int displayWidth;
    private int height;
    private String id;
    private String url;
    private int width;

    public ImageResourceEntity()
    {
    }

    public int getDisplayHeight()
    {
        return displayHeight;
    }

    public int getDisplayWidth()
    {
        return displayWidth;
    }

    public int getHeight()
    {
        return height;
    }

    public String getId()
    {
        return id;
    }

    public String getUrl()
    {
        return url;
    }

    public int getWidth()
    {
        return width;
    }

    public void setDisplayHeight(int i)
    {
        displayHeight = i;
    }

    public void setDisplayWidth(int i)
    {
        displayWidth = i;
    }

    public void setHeight(int i)
    {
        height = i;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setWidth(int i)
    {
        width = i;
    }
}
