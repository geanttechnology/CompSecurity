// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto.engine;


public class ZipCryptoEngine
{

    private static final int CRC_TABLE[];
    private final int keys[] = new int[3];

    public ZipCryptoEngine()
    {
    }

    private int crc32(int i, byte byte0)
    {
        return i >>> 8 ^ CRC_TABLE[(i ^ byte0) & 0xff];
    }

    public byte decryptByte()
    {
        int i = keys[2] | 2;
        return (byte)((i ^ 1) * i >>> 8);
    }

    public void initKeys(char ac[])
    {
        keys[0] = 0x12345678;
        keys[1] = 0x23456789;
        keys[2] = 0x34567890;
        int i = 0;
        do
        {
            if (i >= ac.length)
            {
                return;
            }
            updateKeys((byte)(ac[i] & 0xff));
            i++;
        } while (true);
    }

    public void updateKeys(byte byte0)
    {
        keys[0] = crc32(keys[0], byte0);
        int ai[] = keys;
        ai[1] = ai[1] + (keys[0] & 0xff);
        keys[1] = keys[1] * 0x8088405 + 1;
        keys[2] = crc32(keys[2], (byte)(keys[1] >> 24));
    }

    static 
    {
        int i;
        CRC_TABLE = new int[256];
        i = 0;
_L2:
        if (i >= 256)
        {
            return;
        }
        int j = i;
        int k = 0;
        do
        {
label0:
            {
                if (k < 8)
                {
                    break label0;
                }
                CRC_TABLE[i] = j;
                i++;
            }
            if (true)
            {
                continue;
            }
            if ((j & 1) == 1)
            {
                j = j >>> 1 ^ 0xedb88320;
            } else
            {
                j >>>= 1;
            }
            k++;
        } while (true);
        if (true) goto _L2; else goto _L1
_L1:
    }
}
