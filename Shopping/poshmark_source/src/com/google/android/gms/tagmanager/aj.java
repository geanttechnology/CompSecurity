// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj
{

    private final Set UW;
    private final String UX;

    public transient aj(String s, String as[])
    {
        UX = s;
        UW = new HashSet(as.length);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            s = as[i];
            UW.add(s);
        }

    }

    boolean a(Set set)
    {
        return set.containsAll(UW);
    }

    public abstract boolean iy();

    public String jc()
    {
        return UX;
    }

    public Set jd()
    {
        return UW;
    }

    public abstract com.google.android.gms.internal.d.a u(Map map);
}
