// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.availability;

import gu;
import java.io.Serializable;

public class CheckStoresLink
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String url;

    public CheckStoresLink()
    {
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [url = ").append(url).append("]").toString();
    }
}
