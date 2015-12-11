// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.data;

import java.io.Serializable;

public class Attribute
    implements Serializable, Comparable
{

    private String a;
    private String b;

    public Attribute()
    {
    }

    public Attribute(String s, String s1)
    {
        a = s;
        b = s1;
    }

    public int a(Attribute attribute)
    {
        if (a == null || attribute == null || attribute.a == null)
        {
            return 0;
        } else
        {
            return a.compareToIgnoreCase(attribute.a);
        }
    }

    public int compareTo(Object obj)
    {
        return a((Attribute)obj);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Attribute))
        {
            return false;
        }
        obj = (Attribute)obj;
        if (a == null && ((Attribute) (obj)).a == null)
        {
            return true;
        } else
        {
            return a.equalsIgnoreCase(((Attribute) (obj)).a);
        }
    }

    public String getKey()
    {
        return a;
    }

    public String getValue()
    {
        return b;
    }

    public int hashCode()
    {
        if (a == null)
        {
            return 0;
        } else
        {
            return a.hashCode();
        }
    }

    public void setKey(String s)
    {
        a = s;
    }

    public void setValue(String s)
    {
        b = s;
    }
}
