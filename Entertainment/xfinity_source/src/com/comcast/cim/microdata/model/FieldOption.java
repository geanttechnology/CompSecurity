// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.util.SimpleToStringBuilder;

public class FieldOption
{

    private final String label;
    private final int order;
    private final String value;

    public FieldOption(String s, String s1, int i)
    {
        value = s;
        label = s1;
        order = i;
    }

    public String getLabel()
    {
        return label;
    }

    public int getOrder()
    {
        return order;
    }

    public String getValue()
    {
        return value;
    }

    public String toString()
    {
        SimpleToStringBuilder simpletostringbuilder = new SimpleToStringBuilder(this);
        simpletostringbuilder.append("value", value);
        simpletostringbuilder.append("label", label);
        simpletostringbuilder.append("order", order);
        return simpletostringbuilder.toString();
    }
}
