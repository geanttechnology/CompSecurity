// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpbuyingoptions;

import gu;
import java.io.Serializable;

public class CheckLink
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private int height;
    private String target;
    private String url;
    private int width;

    public CheckLink()
    {
    }

    public int getHeight()
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

    public int getWidth()
    {
        return width;
    }

    public void setHeight(int i)
    {
        height = i;
    }

    public void setTarget(String s)
    {
        target = s;
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
