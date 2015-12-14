// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;


public final class n
{

    public final int a;
    public final int b;
    public final int c;

    public n(int i, int j)
    {
        a = i;
        b = j;
        Math.max(i, j);
        c = i * j;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(Integer.toString(a)).append(" x ").append(b).toString();
    }
}
