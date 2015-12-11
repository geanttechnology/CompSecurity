// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;


final class x
{

    final byte a;
    final long b;

    x(byte byte0, long l)
    {
        a = byte0;
        b = l;
    }

    public final String toString()
    {
        return (new StringBuilder("[")).append(b).append("] ").append(a).toString();
    }
}
