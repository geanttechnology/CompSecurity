// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;


public final class BitArray
{

    private int bits[];
    private int size;

    public BitArray()
    {
        size = 0;
        bits = new int[1];
    }

    public BitArray(int i)
    {
        size = i;
        bits = makeArray(i);
    }

    BitArray(int ai[], int i)
    {
        bits = ai;
        size = i;
    }

    private void ensureCapacity(int i)
    {
        if (i > bits.length * 32)
        {
            int ai[] = makeArray(i);
            System.arraycopy(bits, 0, ai, 0, bits.length);
            bits = ai;
        }
    }

    private static int[] makeArray(int i)
    {
        return new int[(i + 31) / 32];
    }

    public void appendBit(boolean flag)
    {
        ensureCapacity(size + 1);
        if (flag)
        {
            int ai[] = bits;
            int i = size / 32;
            ai[i] = ai[i] | 1 << (size & 0x1f);
        }
        size = size + 1;
    }

    public void appendBitArray(BitArray bitarray)
    {
        int j = bitarray.size;
        ensureCapacity(size + j);
        for (int i = 0; i < j; i++)
        {
            appendBit(bitarray.get(i));
        }

    }

    public void appendBits(int i, int j)
    {
        if (j < 0 || j > 32)
        {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(size + j);
        while (j > 0) 
        {
            boolean flag;
            if ((i >> j - 1 & 1) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            appendBit(flag);
            j--;
        }
    }

    public void clear()
    {
        int j = bits.length;
        for (int i = 0; i < j; i++)
        {
            bits[i] = 0;
        }

    }

    public void flip(int i)
    {
        int ai[] = bits;
        int j = i / 32;
        ai[j] = ai[j] ^ 1 << (i & 0x1f);
    }

    public boolean get(int i)
    {
        return (bits[i / 32] & 1 << (i & 0x1f)) != 0;
    }

    public int[] getBitArray()
    {
        return bits;
    }

    public int getNextSet(int i)
    {
        if (i >= size)
        {
            i = size;
        } else
        {
            int j = i / 32;
            for (i = bits[j] & ~((1 << (i & 0x1f)) - 1); i == 0; i = bits[j])
            {
                j++;
                if (j == bits.length)
                {
                    return size;
                }
            }

            j = Integer.numberOfTrailingZeros(i) + j * 32;
            i = j;
            if (j > size)
            {
                return size;
            }
        }
        return i;
    }

    public int getNextUnset(int i)
    {
        if (i >= size)
        {
            i = size;
        } else
        {
            int j = i / 32;
            for (i = ~bits[j] & ~((1 << (i & 0x1f)) - 1); i == 0; i = ~bits[j])
            {
                j++;
                if (j == bits.length)
                {
                    return size;
                }
            }

            j = Integer.numberOfTrailingZeros(i) + j * 32;
            i = j;
            if (j > size)
            {
                return size;
            }
        }
        return i;
    }

    public int getSize()
    {
        return size;
    }

    public int getSizeInBytes()
    {
        return (size + 7) / 8;
    }

    public boolean isRange(int i, int j, boolean flag)
    {
        int l;
        int j1;
        int l1;
        int i2;
        if (j < i)
        {
            throw new IllegalArgumentException();
        }
        if (j == i)
        {
            return true;
        }
        l1 = j - 1;
        j1 = i / 32;
        i2 = l1 / 32;
        l = j1;
_L6:
        int i1;
        if (l > i2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l > j1)
        {
            j = 0;
        } else
        {
            j = i & 0x1f;
        }
        if (l < i2)
        {
            i1 = 31;
        } else
        {
            i1 = l1 & 0x1f;
        }
        if (j != 0 || i1 != 31) goto _L2; else goto _L1
_L1:
        j = -1;
_L4:
        i1 = bits[l];
        int k;
        int k1;
        if (flag)
        {
            k = j;
        } else
        {
            k = 0;
        }
        if ((i1 & j) != k)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_166;
_L2:
        k = 0;
        do
        {
            k1 = j;
            j = k;
            if (k1 > i1)
            {
                break;
            }
            j = k1 + 1;
            k = 1 << k1 | k;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        l++;
        if (true) goto _L6; else goto _L5
_L5:
        return true;
    }

    public void reverse()
    {
        boolean flag = true;
        int ai[] = new int[bits.length];
        int k = (size - 1) / 32;
        int l1 = k + 1;
        for (int i = 0; i < l1; i++)
        {
            long l2 = bits[i];
            l2 = (l2 & 0x55555555L) << 1 | l2 >> 1 & 0x55555555L;
            l2 = (l2 & 0x33333333L) << 2 | l2 >> 2 & 0x33333333L;
            l2 = (l2 & 0xf0f0f0fL) << 4 | l2 >> 4 & 0xf0f0f0fL;
            l2 = (l2 & 0xff00ffL) << 8 | l2 >> 8 & 0xff00ffL;
            ai[k - i] = (int)((l2 & 65535L) << 16 | l2 >> 16 & 65535L);
        }

        if (size != l1 * 32)
        {
            int i2 = l1 * 32 - size;
            int l = 0;
            int j = 1;
            for (; l < 31 - i2; l++)
            {
                j = j << 1 | 1;
            }

            int j1 = ai[0] >> i2 & j;
            for (int i1 = ((flag) ? 1 : 0); i1 < l1; i1++)
            {
                int k1 = ai[i1];
                ai[i1 - 1] = j1 | k1 << 32 - i2;
                j1 = k1 >> i2 & j;
            }

            ai[l1 - 1] = j1;
        }
        bits = ai;
    }

    public void set(int i)
    {
        int ai[] = bits;
        int j = i / 32;
        ai[j] = ai[j] | 1 << (i & 0x1f);
    }

    public void setBulk(int i, int j)
    {
        bits[i / 32] = j;
    }

    public void setRange(int i, int j)
    {
        if (j < i)
        {
            throw new IllegalArgumentException();
        }
        if (j != i) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int l;
        int j1;
        int l1;
        int i2;
        l1 = j - 1;
        j1 = i / 32;
        i2 = l1 / 32;
        l = j1;
_L6:
        if (l > i2) goto _L1; else goto _L3
_L3:
        int k;
        int i1;
        int ai[];
        if (l > j1)
        {
            j = 0;
        } else
        {
            j = i & 0x1f;
        }
        if (l < i2)
        {
            i1 = 31;
        } else
        {
            i1 = l1 & 0x1f;
        }
        if (j != 0 || i1 != 31) goto _L5; else goto _L4
_L4:
        k = -1;
_L8:
        ai = bits;
        ai[l] = k | ai[l];
        l++;
          goto _L6
_L5:
        boolean flag = false;
        k = j;
        j = ((flag) ? 1 : 0);
_L9:
        int k1;
        k1 = k;
        k = j;
        if (k1 > i1) goto _L8; else goto _L7
_L7:
        k = k1 + 1;
        j = 1 << k1 | j;
          goto _L9
    }

    public void toBytes(int i, byte abyte0[], int j, int k)
    {
        for (int l = 0; l < k; l++)
        {
            int i1 = 0;
            int j1;
            int k1;
            for (j1 = 0; i1 < 8; j1 = k1)
            {
                k1 = j1;
                if (get(i))
                {
                    k1 = j1 | 1 << 7 - i1;
                }
                i++;
                i1++;
            }

            abyte0[j + l] = (byte)j1;
        }

    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(size);
        int i = 0;
        while (i < size) 
        {
            if ((i & 7) == 0)
            {
                stringbuilder.append(' ');
            }
            char c;
            if (get(i))
            {
                c = 'X';
            } else
            {
                c = '.';
            }
            stringbuilder.append(c);
            i++;
        }
        return stringbuilder.toString();
    }

    public void xor(BitArray bitarray)
    {
        if (bits.length != bitarray.bits.length)
        {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < bits.length; i++)
        {
            int ai[] = bits;
            ai[i] = ai[i] ^ bitarray.bits[i];
        }

    }
}
