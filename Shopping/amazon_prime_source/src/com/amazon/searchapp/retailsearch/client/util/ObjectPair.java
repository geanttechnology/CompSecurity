// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.util;


public final class ObjectPair
{

    private final Object first;
    private final Object second;

    public ObjectPair(Object obj, Object obj1)
    {
        first = obj;
        second = obj1;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ObjectPair)
        {
            obj = (ObjectPair)obj;
            Object obj1 = ((ObjectPair) (obj)).getFirst();
            if (first == null && obj1 == null || first != null && first.equals(obj1))
            {
                obj = ((ObjectPair) (obj)).getSecond();
                if (second == null && obj == null || second != null && second.equals(obj))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public Object getFirst()
    {
        return first;
    }

    public Object getSecond()
    {
        return second;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (first == null)
        {
            i = 0;
        } else
        {
            i = first.hashCode();
        }
        if (second != null)
        {
            j = second.hashCode();
        }
        return i ^ j;
    }

    public String toString()
    {
        return (new StringBuilder()).append(first).append(",").append(second).toString();
    }
}
