// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


public final class hq
{

    final String a;
    final String b;

    hq(String s, String s1)
    {
        a = s;
        b = s1;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(a);
        stringbuilder.append(": ");
        stringbuilder.append(b);
        return stringbuilder.toString();
    }
}
