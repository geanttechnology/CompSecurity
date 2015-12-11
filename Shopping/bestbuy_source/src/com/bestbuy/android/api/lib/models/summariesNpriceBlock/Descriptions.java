// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class Descriptions
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String longDesc;
    private String shortDesc;
    private String synopsis;

    public Descriptions()
    {
    }

    public String getLongDesc()
    {
        return longDesc;
    }

    public String getShortDesc()
    {
        return shortDesc;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public void setLongDesc(String s)
    {
        longDesc = s;
    }

    public void setShortDesc(String s)
    {
        shortDesc = s;
    }

    public void setSynopsis(String s)
    {
        synopsis = s;
    }
}
