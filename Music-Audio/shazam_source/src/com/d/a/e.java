// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import java.security.MessageDigest;
import java.util.zip.CRC32;

public final class e extends MessageDigest
{

    private CRC32 a;

    public e()
    {
        super("CRC");
        a = new CRC32();
    }

    public final byte[] a()
    {
        return engineDigest();
    }

    protected final byte[] engineDigest()
    {
        long l = a.getValue();
        return (new byte[] {
            (byte)(int)((0xffffffffff000000L & l) >> 24), (byte)(int)((0xff0000L & l) >> 16), (byte)(int)((65280L & l) >> 8), (byte)(int)(l & 255L)
        });
    }

    protected final void engineReset()
    {
        a.reset();
    }

    protected final void engineUpdate(byte byte0)
    {
        a.update(byte0);
    }

    protected final void engineUpdate(byte abyte0[], int i, int j)
    {
        a.update(abyte0, i, j);
    }
}
