// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class Meta
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x2391b470b8c1a328L;
    private String description;
    private String keywords;
    private String title;

    public Meta()
    {
    }

    public String getDescription()
    {
        return description;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public String getTitle()
    {
        return title;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setKeywords(String s)
    {
        keywords = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
