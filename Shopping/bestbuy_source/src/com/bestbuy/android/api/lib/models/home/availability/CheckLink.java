// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.availability;

import gu;
import java.io.Serializable;

public class CheckLink
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String height;
    private String target;
    private String url;
    private String width;

    public CheckLink()
    {
    }

    public String getHeight()
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

    public String getWidth()
    {
        return width;
    }

    public void setHeight(String s)
    {
        height = s;
    }

    public void setTarget(String s)
    {
        target = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setWidth(String s)
    {
        width = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [height = ").append(height).append(", width = ").append(width).append(", target = ").append(target).append(", url = ").append(url).append("]").toString();
    }
}
