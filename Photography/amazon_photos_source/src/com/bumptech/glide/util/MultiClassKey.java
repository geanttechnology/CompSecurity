// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.util;


public class MultiClassKey
{

    private Class first;
    private Class second;

    public MultiClassKey()
    {
    }

    public MultiClassKey(Class class1, Class class2)
    {
        set(class1, class2);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (MultiClassKey)obj;
            if (!first.equals(((MultiClassKey) (obj)).first))
            {
                return false;
            }
            if (!second.equals(((MultiClassKey) (obj)).second))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return first.hashCode() * 31 + second.hashCode();
    }

    public void set(Class class1, Class class2)
    {
        first = class1;
        second = class2;
    }

    public String toString()
    {
        return (new StringBuilder()).append("MultiClassKey{first=").append(first).append(", second=").append(second).append('}').toString();
    }
}
