// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;


public abstract class K
{

    private final String a;
    public final String h;
    public final String i;
    public final int j;
    public boolean k;

    public K(String s, String s1, String s2, int l)
    {
        h = s;
        i = s1;
        a = s2;
        j = l;
    }

    public final int a()
    {
        int l;
        try
        {
            l = Integer.parseInt(h);
        }
        catch (Throwable throwable)
        {
            return -1;
        }
        return l;
    }
}
