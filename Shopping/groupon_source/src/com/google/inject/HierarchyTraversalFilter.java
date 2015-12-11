// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import java.util.HashSet;
import java.util.Set;

public class HierarchyTraversalFilter
{

    public HierarchyTraversalFilter()
    {
    }

    public Set getAllConstructors(String s, Class class1)
    {
        s = new HashSet();
        class1 = class1.getDeclaredConstructors();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            s.add(class1[i]);
        }

        return s;
    }

    public Set getAllFields(String s, Class class1)
    {
        s = new HashSet();
        class1 = class1.getDeclaredFields();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            s.add(class1[i]);
        }

        return s;
    }

    public Set getAllMethods(String s, Class class1)
    {
        s = new HashSet();
        class1 = class1.getDeclaredMethods();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            s.add(class1[i]);
        }

        return s;
    }

    public boolean isWorthScanning(Class class1)
    {
        return class1 != null && class1 != java/lang/Object;
    }

    public boolean isWorthScanningForConstructors(String s, Class class1)
    {
        return isWorthScanning(class1);
    }

    public boolean isWorthScanningForFields(String s, Class class1)
    {
        return isWorthScanning(class1);
    }

    public boolean isWorthScanningForMethods(String s, Class class1)
    {
        return isWorthScanning(class1);
    }

    public void reset()
    {
    }
}
