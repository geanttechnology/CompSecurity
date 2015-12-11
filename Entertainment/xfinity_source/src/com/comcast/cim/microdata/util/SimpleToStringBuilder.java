// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.util;


public class SimpleToStringBuilder
{

    private StringBuilder builder;
    private boolean firstProperty;

    public SimpleToStringBuilder(Object obj)
    {
        firstProperty = true;
        builder = new StringBuilder();
        builder.append(obj.getClass().getSimpleName());
        builder.append("{");
    }

    private SimpleToStringBuilder addProperty(String s, String s1)
    {
        if (!firstProperty)
        {
            builder.append(", ");
        } else
        {
            firstProperty = false;
        }
        builder.append(s);
        builder.append(": ");
        builder.append(s1);
        return this;
    }

    public SimpleToStringBuilder append(String s, int i)
    {
        return addProperty(s, String.valueOf(i));
    }

    public SimpleToStringBuilder append(String s, Object obj)
    {
        return addProperty(s, String.valueOf(obj));
    }

    public SimpleToStringBuilder append(String s, boolean flag)
    {
        return addProperty(s, String.valueOf(flag));
    }

    public String toString()
    {
        builder.append("}");
        return builder.toString();
    }
}
