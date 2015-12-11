// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Date;

public class Pagination
{

    private String channel;
    private int count;
    private int currentOffset;
    private boolean hasMorePages;
    private Date modificationDate;
    private int nextOffset;
    private Long primaryKey;

    public Pagination()
    {
    }

    public String getChannel()
    {
        return channel;
    }

    public int getCount()
    {
        return count;
    }

    public int getCurrentOffset()
    {
        return currentOffset;
    }

    public Date getModificationDate()
    {
        return modificationDate;
    }

    public int getNextOffset()
    {
        return nextOffset;
    }

    public Long getPrimaryKey()
    {
        return primaryKey;
    }

    public boolean hasMorePages()
    {
        return hasMorePages;
    }

    public void setChannel(String s)
    {
        channel = s;
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setCurrentOffset(int i)
    {
        currentOffset = i;
    }

    public void setHasMorePages(boolean flag)
    {
        hasMorePages = flag;
    }

    public void setModificationDate(Date date)
    {
        modificationDate = date;
    }

    public void setNextOffset(int i)
    {
        nextOffset = i;
    }

    public void setPrimaryKey(Long long1)
    {
        primaryKey = long1;
    }
}
