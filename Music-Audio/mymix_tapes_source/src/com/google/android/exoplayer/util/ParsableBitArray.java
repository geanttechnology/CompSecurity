// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;


// Referenced classes of package com.google.android.exoplayer.util:
//            Assertions

public final class ParsableBitArray
{

    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte data[];

    public ParsableBitArray()
    {
    }

    public ParsableBitArray(byte abyte0[])
    {
        this(abyte0, abyte0.length);
    }

    public ParsableBitArray(byte abyte0[], int i)
    {
        data = abyte0;
        byteLimit = i;
    }

    private void assertValidOffset()
    {
        boolean flag;
        if (byteOffset >= 0 && bitOffset >= 0 && bitOffset < 8 && (byteOffset < byteLimit || byteOffset == byteLimit && bitOffset == 0))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
    }

    private int readExpGolombCodeNum()
    {
        int i;
        for (i = 0; !readBit(); i++) { }
        int j;
        if (i > 0)
        {
            j = readBits(i);
        } else
        {
            j = 0;
        }
        return j + ((1 << i) - 1);
    }

    public int bitsLeft()
    {
        return (byteLimit - byteOffset) * 8 - bitOffset;
    }

    public int getPosition()
    {
        return byteOffset * 8 + bitOffset;
    }

    public int peekExpGolombCodedNumLength()
    {
        int j = byteOffset;
        int k = bitOffset;
        int i;
        for (i = 0; byteOffset < byteLimit && !readBit(); i++) { }
        boolean flag;
        if (byteOffset == byteLimit)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        byteOffset = j;
        bitOffset = k;
        if (flag)
        {
            return -1;
        } else
        {
            return i * 2 + 1;
        }
    }

    public boolean readBit()
    {
        return readBits(1) == 1;
    }

    public int readBits(int i)
    {
        int j;
        int k;
        if (i == 0)
        {
            return 0;
        }
        k = 0;
        j = i;
        i = k;
        while (j >= 8) 
        {
            if (bitOffset != 0)
            {
                k = (data[byteOffset] & 0xff) << bitOffset | (data[byteOffset + 1] & 0xff) >>> 8 - bitOffset;
            } else
            {
                k = data[byteOffset];
            }
            j -= 8;
            i |= (k & 0xff) << j;
            byteOffset = byteOffset + 1;
        }
        k = i;
        if (j <= 0) goto _L2; else goto _L1
_L1:
        k = bitOffset + j;
        j = (byte)(255 >> 8 - j);
        if (k <= 8) goto _L4; else goto _L3
_L3:
        i |= ((data[byteOffset] & 0xff) << k - 8 | (data[byteOffset + 1] & 0xff) >> 16 - k) & j;
        byteOffset = byteOffset + 1;
_L6:
        bitOffset = k % 8;
        k = i;
_L2:
        assertValidOffset();
        return k;
_L4:
        j = i | (data[byteOffset] & 0xff) >> 8 - k & j;
        i = j;
        if (k == 8)
        {
            byteOffset = byteOffset + 1;
            i = j;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int readSignedExpGolombCodedInt()
    {
        int i = readExpGolombCodeNum();
        byte byte0;
        if (i % 2 == 0)
        {
            byte0 = -1;
        } else
        {
            byte0 = 1;
        }
        return byte0 * ((i + 1) / 2);
    }

    public int readUnsignedExpGolombCodedInt()
    {
        return readExpGolombCodeNum();
    }

    public void reset(byte abyte0[])
    {
        reset(abyte0, abyte0.length);
    }

    public void reset(byte abyte0[], int i)
    {
        data = abyte0;
        byteOffset = 0;
        bitOffset = 0;
        byteLimit = i;
    }

    public void setPosition(int i)
    {
        byteOffset = i / 8;
        bitOffset = i - byteOffset * 8;
        assertValidOffset();
    }

    public void skipBits(int i)
    {
        byteOffset = byteOffset + i / 8;
        bitOffset = bitOffset + i % 8;
        if (bitOffset > 7)
        {
            byteOffset = byteOffset + 1;
            bitOffset = bitOffset - 8;
        }
        assertValidOffset();
    }
}
