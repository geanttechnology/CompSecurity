// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.model;


public class Parameter
{

    private String name;
    private Object value;

    public Parameter(String s, Object obj)
    {
        name = s;
        value = obj;
    }

    public Object get()
    {
        return value;
    }

    public Object get(Class class1)
    {
        return value;
    }

    public Boolean getAsBoolean()
    {
        return (Boolean)value;
    }

    public Integer getAsInt()
    {
        return (Integer)value;
    }

    public String getAsString()
    {
        return String.valueOf(value);
    }

    public String getName()
    {
        return name;
    }
}
