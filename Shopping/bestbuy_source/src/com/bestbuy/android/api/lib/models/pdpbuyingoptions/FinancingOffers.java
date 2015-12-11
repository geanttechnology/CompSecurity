// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpbuyingoptions;

import gu;
import java.io.Serializable;

public class FinancingOffers
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String name;
    private String target;
    private String url;

    public FinancingOffers()
    {
    }

    public String getName()
    {
        return name;
    }

    public String getTarget()
    {
        return target;
    }

    public String getUrl()
    {
        return url;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setTarget(String s)
    {
        target = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
