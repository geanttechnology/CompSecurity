// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.pageconfiguration;

import gu;
import java.io.Serializable;

public class Image
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String altText;
    private String path;
    private String reftype;

    public Image()
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

    public String getReftype()
    {
        return reftype;
    }

    public void setAltText(String s)
    {
        altText = s;
    }

    public void setPath(String s)
    {
        path = s;
    }

    public void setReftype(String s)
    {
        reftype = s;
    }
}
