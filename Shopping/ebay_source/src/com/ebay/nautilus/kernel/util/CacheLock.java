// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;


public class CacheLock
{

    private volatile Object data;

    public CacheLock()
    {
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object obj)
    {
        data = obj;
    }
}
