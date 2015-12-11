// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.util.SimpleToStringBuilder;

public class NameValuePair
{

    private final String name;
    private final String value;

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public String toString()
    {
        SimpleToStringBuilder simpletostringbuilder = new SimpleToStringBuilder(this);
        simpletostringbuilder.append("name", name);
        simpletostringbuilder.append("value", value);
        return simpletostringbuilder.toString();
    }
}
