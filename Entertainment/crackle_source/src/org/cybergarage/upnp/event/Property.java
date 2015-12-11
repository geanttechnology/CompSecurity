// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.event;


public class Property
{

    private String name;
    private String value;

    public Property()
    {
        name = "";
        value = "";
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
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        name = s1;
    }

    public void setValue(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        value = s1;
    }
}
