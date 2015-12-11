// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.nio.ByteBuffer;

public final class dt
{
    public static interface a
    {

        public abstract int a();
    }

    public static interface b
    {
    }


    public static final byte a[];
    public static final ByteBuffer b;

    public static int a(long l)
    {
        return (int)(l >>> 32 ^ l);
    }

    public static int a(a a1)
    {
        return a1.a();
    }

    public static int a(boolean flag)
    {
        return !flag ? 1237 : 1231;
    }

    static 
    {
        byte abyte0[] = new byte[0];
        a = abyte0;
        b = ByteBuffer.wrap(abyte0);
    }
}
