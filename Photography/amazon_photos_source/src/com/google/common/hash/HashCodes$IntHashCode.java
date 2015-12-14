// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import java.io.Serializable;

// Referenced classes of package com.google.common.hash:
//            HashCode, HashCodes

private static final class hash extends HashCode
    implements Serializable
{

    final int hash;

    public byte[] asBytes()
    {
        return (new byte[] {
            (byte)hash, (byte)(hash >> 8), (byte)(hash >> 16), (byte)(hash >> 24)
        });
    }

    public int asInt()
    {
        return hash;
    }

    public long asLong()
    {
        throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
    }

    (int i)
    {
        hash = i;
    }
}
