// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;


final class Util
{

    private Util()
    {
    }

    public static void checkOffsetAndCount(long l, long l1, long l2)
    {
        if ((l1 | l2) < 0L || l1 > l || l - l1 < l2)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            return;
        }
    }

    public static int reverseBytesInt(int i)
    {
        return (0xff000000 & i) >>> 24 | (0xff0000 & i) >>> 8 | (0xff00 & i) << 8 | (i & 0xff) << 24;
    }

    public static int reverseBytesShort(short word0)
    {
        word0 &= 0xffff;
        return (0xff00 & word0) >>> 8 | (word0 & 0xff) << 8;
    }

    public static void sneakyRethrow(Throwable throwable)
    {
        sneakyThrow2(throwable);
    }

    private static void sneakyThrow2(Throwable throwable)
        throws Throwable
    {
        throw throwable;
    }
}
