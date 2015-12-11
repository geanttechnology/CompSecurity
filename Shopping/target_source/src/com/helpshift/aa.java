// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import java.util.Comparator;
import java.util.HashMap;

class aa
    implements Comparator
{

    HashMap a;

    public aa(HashMap hashmap)
    {
        a = hashmap;
    }

    public int a(String s, String s1)
    {
        s = (Double)a.get(s);
        s1 = (Double)a.get(s1);
        return s.doubleValue() < s1.doubleValue() ? 1 : -1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((String)obj, (String)obj1);
    }
}
