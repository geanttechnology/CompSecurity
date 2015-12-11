// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.net.Uri;

public class ItemList
    implements Comparable
{

    private String description;
    private int id;
    private long image_medium_height;
    private Uri image_medium_url;
    private long image_medium_width;
    private String name;
    private long sort;
    private int user_required;

    public ItemList()
    {
    }

    public int compareTo(ItemList itemlist)
    {
        if (sort < itemlist.getSort())
        {
            return -1;
        }
        return sort <= itemlist.getSort() ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ItemList)obj);
    }

    public String getDescription()
    {
        return description;
    }

    public int getId()
    {
        return id;
    }

    public long getImage_medium_height()
    {
        return image_medium_height;
    }

    public Uri getImage_medium_url()
    {
        return image_medium_url;
    }

    public long getImage_medium_width()
    {
        return image_medium_width;
    }

    public String getName()
    {
        return name;
    }

    public long getSort()
    {
        return sort;
    }

    public int getUser_required()
    {
        return user_required;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setSort(long l)
    {
        sort = l;
    }
}
