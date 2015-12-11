// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;


public class Parameter
{

    private String name;
    private String value;

    public Parameter()
    {
        name = new String();
        value = new String();
    }

    public Parameter(String s, String s1)
    {
        name = new String();
        value = new String();
        setName(s);
        setValue(s1);
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
