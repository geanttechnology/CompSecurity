// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.cache;

import java.io.Serializable;
import java.util.Date;

public class Data
    implements Serializable
{

    private Date accessTime;
    private Object key;
    private int ttl;
    private Object value;

    public Data()
    {
        ttl = -1;
    }

    public Date getAccessTime()
    {
        return accessTime;
    }

    public int getTtl()
    {
        return ttl;
    }

    public Object getValue()
    {
        return value;
    }

    public void setAccessTime(Date date)
    {
        accessTime = date;
    }

    public void setKey(Object obj)
    {
        key = obj;
    }

    public void setTtl(int i)
    {
        ttl = i;
    }

    public void setValue(Object obj)
    {
        value = obj;
    }
}
