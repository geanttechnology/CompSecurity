// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.nio.CharBuffer;

public final class dd
{

    private static long a(Readable readable, Appendable appendable)
    {
        CharBuffer charbuffer = CharBuffer.allocate(2048);
        long l = 0L;
        do
        {
            int i = readable.read(charbuffer);
            if (i != -1)
            {
                charbuffer.flip();
                appendable.append(charbuffer, 0, i);
                l += i;
            } else
            {
                return l;
            }
        } while (true);
    }

    public static String a(Readable readable)
    {
        StringBuilder stringbuilder = new StringBuilder();
        a(readable, ((Appendable) (stringbuilder)));
        return stringbuilder.toString();
    }
}
