// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.releasemgt;

import gu;
import java.io.Serializable;

public class ReleaseDialog
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String rate;
    private String skip;
    private String title;
    private String update;
    private String wbody;

    public ReleaseDialog()
    {
    }

    public String getRate()
    {
        return rate;
    }

    public String getSkip()
    {
        return skip;
    }

    public String getTitle()
    {
        return title;
    }

    public String getUpdate()
    {
        return update;
    }

    public String getWbody()
    {
        return wbody;
    }

    public void setRate(String s)
    {
        rate = s;
    }

    public void setSkip(String s)
    {
        skip = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setUpdate(String s)
    {
        update = s;
    }

    public void setWbody(String s)
    {
        wbody = s;
    }
}
