// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class CheckShipLink
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private long height;
    private String target;
    private String url;
    private long width;

    public CheckShipLink()
    {
    }

    public long getHeight()
    {
        return height;
    }

    public String getTarget()
    {
        return target;
    }

    public String getUrl()
    {
        return url;
    }

    public long getWidth()
    {
        return width;
    }

    public void setHeight(long l)
    {
        height = l;
    }

    public void setTarget(String s)
    {
        target = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setWidth(long l)
    {
        width = l;
    }
}
