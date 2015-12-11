// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class Dimension
{

    private String displayLabel;
    private Boolean preselect;
    private List swatchUrls;
    private List swatches;
    private List values;

    public Dimension()
    {
    }

    public String getDisplayLabel()
    {
        return displayLabel;
    }

    public Boolean getPreselect()
    {
        return preselect;
    }

    public List getSwatchUrls()
    {
        return swatchUrls;
    }

    public List getSwatches()
    {
        return swatches;
    }

    public List getValues()
    {
        return values;
    }

    public void setDisplayLabel(String s)
    {
        displayLabel = s;
    }

    public void setPreselect(Boolean boolean1)
    {
        preselect = boolean1;
    }

    public void setSwatchUrls(List list)
    {
        swatchUrls = list;
    }

    public void setSwatches(List list)
    {
        swatches = list;
    }

    public void setValues(List list)
    {
        values = list;
    }
}
