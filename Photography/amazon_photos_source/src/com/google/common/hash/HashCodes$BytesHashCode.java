// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import java.io.Serializable;

// Referenced classes of package com.google.common.hash:
//            HashCode, HashCodes

private static final class bytes extends HashCode
    implements Serializable
{

    final byte bytes[];

    public byte[] asBytes()
    {
        return (byte[])bytes.clone();
    }

    public int asInt()
    {
        return bytes[0] & 0xff | (bytes[1] & 0xff) << 8 | (bytes[2] & 0xff) << 16 | (bytes[3] & 0xff) << 24;
    }

    public long asLong()
    {
        if (bytes.length < 8)
        {
            throw new IllegalStateException("Not enough bytes");
        } else
        {
            return (long)bytes[0] & 255L | ((long)bytes[1] & 255L) << 8 | ((long)bytes[2] & 255L) << 16 | ((long)bytes[3] & 255L) << 24 | ((long)bytes[4] & 255L) << 32 | ((long)bytes[5] & 255L) << 40 | ((long)bytes[6] & 255L) << 48 | ((long)bytes[7] & 255L) << 56;
        }
    }

    (byte abyte0[])
    {
        bytes = abyte0;
    }
}
