// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.container;


public class Option
{

    private final Object value;

    public Option(Object obj)
    {
        value = obj;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Option)obj;
            if (value == null ? ((Option) (obj)).value != null : !value.equals(((Option) (obj)).value))
            {
                return false;
            }
        }
        return true;
    }

    public Object getValue()
    {
        return value;
    }

    public int hashCode()
    {
        if (value != null)
        {
            return value.hashCode();
        } else
        {
            return 0;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append("[").append(value.getClass().getName()).append("=").append(value).append("]").toString();
    }
}
