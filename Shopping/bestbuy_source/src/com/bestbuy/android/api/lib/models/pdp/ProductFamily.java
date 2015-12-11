// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;
import java.util.List;

public class ProductFamily
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String attributeType;
    private List options;

    public ProductFamily()
    {
    }

    public String getAttributeType()
    {
        return attributeType;
    }

    public List getOptions()
    {
        return options;
    }

    public void setAttributeType(String s)
    {
        attributeType = s;
    }

    public void setOptions(List list)
    {
        options = list;
    }
}
