// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

public class PDPCategory
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String displayName;
    private String id;
    private String url;

    public PDPCategory()
    {
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getId()
    {
        return id;
    }

    public String getUrl()
    {
        return url;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
