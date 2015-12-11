// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class GHPLarge
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x5bb4669e8b1d9481L;
    private String altText;
    private String path;
    private String refType;

    public GHPLarge()
    {
    }

    public String getAltText()
    {
        return altText;
    }

    public String getPath()
    {
        return path;
    }

    public String getRefType()
    {
        return refType;
    }

    public void setAltText(String s)
    {
        altText = s;
    }

    public void setPath(String s)
    {
        path = s;
    }

    public void setRefType(String s)
    {
        refType = s;
    }
}
