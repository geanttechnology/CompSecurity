// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;


public class a
{

    private boolean L;
    private int count;
    private String name;

    a(String s, int i)
    {
        name = s;
        count = i;
        L = false;
    }

    void b(int i)
    {
        count = count + i;
    }

    void b(boolean flag)
    {
        L = flag;
    }

    boolean g()
    {
        return L;
    }

    int getCount()
    {
        return count;
    }

    String getName()
    {
        return name;
    }
}
