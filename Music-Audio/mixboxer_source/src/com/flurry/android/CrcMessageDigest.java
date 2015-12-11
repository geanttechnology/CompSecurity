// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

public class CrcMessageDigest extends MessageDigest
{

    private CRC32 crc;

    public CrcMessageDigest()
    {
        super("CRC");
        crc = new CRC32();
    }

    protected byte[] engineDigest()
    {
        long l = crc.getValue();
        return (new byte[] {
            (byte)(int)((0xffffffffff000000L & l) >> 24), (byte)(int)((0xff0000L & l) >> 16), (byte)(int)((65280L & l) >> 8), (byte)(int)(l & 255L)
        });
    }

    protected void engineReset()
    {
        crc.reset();
    }

    protected void engineUpdate(byte byte0)
    {
        crc.update(byte0);
    }

    protected void engineUpdate(byte abyte0[], int i, int j)
    {
        crc.update(abyte0, i, j);
    }

    public int getChecksum()
    {
        return ByteBuffer.wrap(engineDigest()).getInt();
    }

    public byte[] getDigest()
    {
        return engineDigest();
    }
}
