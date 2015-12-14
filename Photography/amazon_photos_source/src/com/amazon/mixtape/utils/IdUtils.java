// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.utils;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.UUID;

public class IdUtils
{

    public static UUID nodeIdToUUID(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("The nodeId must not be null.");
        }
        byte abyte0[] = Base64.decode(s, 11);
        if (abyte0.length != 16)
        {
            throw new IllegalStateException((new StringBuilder()).append("Invalid ID: ").append(s).toString());
        } else
        {
            s = ByteBuffer.allocate(8);
            s.put(abyte0, 0, 8).rewind();
            long l = s.asLongBuffer().get();
            s.clear();
            s.put(abyte0, 8, 8).rewind();
            return new UUID(l, s.getLong());
        }
    }

    public static String objectIdToNodeId(long l, long l1)
    {
        ByteBuffer bytebuffer = ByteBuffer.wrap(new byte[16]);
        bytebuffer.putLong(l);
        bytebuffer.putLong(l1);
        return Base64.encodeToString(bytebuffer.array(), 11);
    }
}
