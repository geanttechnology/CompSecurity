// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;


// Referenced classes of package com.penthera.virtuososdk.download:
//            MD5State

class MD5
{

    private static final byte padding[];
    private int decodeBuffer[];
    private MD5State finalState;
    private MD5State workingState;

    public MD5()
    {
        workingState = new MD5State();
        finalState = new MD5State();
        decodeBuffer = new int[16];
        reset();
    }

    private static int FF(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        i = i + (j & k | ~j & l) + i1 + k1;
        return (i << j1 | i >>> 32 - j1) + j;
    }

    private static int GG(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        i = i + (j & l | ~l & k) + i1 + k1;
        return (i << j1 | i >>> 32 - j1) + j;
    }

    private static int HH(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        i = i + (j ^ k ^ l) + i1 + k1;
        return (i << j1 | i >>> 32 - j1) + j;
    }

    private static int II(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        i = i + ((~l | j) ^ k) + i1 + k1;
        return (i << j1 | i >>> 32 - j1) + j;
    }

    private int[] decode(byte abyte0[], int i, int j)
    {
        int k = 0;
        int l = 0;
        do
        {
            if (k >= i)
            {
                return decodeBuffer;
            }
            decodeBuffer[l] = abyte0[k + j] & 0xff | (abyte0[k + 1 + j] & 0xff) << 8 | (abyte0[k + 2 + j] & 0xff) << 16 | (abyte0[k + 3 + j] & 0xff) << 24;
            l++;
            k += 4;
        } while (true);
    }

    private static byte[] encode(long l)
    {
        return (new byte[] {
            (byte)(int)(l & 255L), (byte)(int)(l >>> 8 & 255L), (byte)(int)(l >>> 16 & 255L), (byte)(int)(l >>> 24 & 255L), (byte)(int)(l >>> 32 & 255L), (byte)(int)(l >>> 40 & 255L), (byte)(int)(l >>> 48 & 255L), (byte)(int)(l >>> 56 & 255L)
        });
    }

    private static byte[] encode(int ai[], int i)
    {
        byte abyte0[] = new byte[i];
        int j = 0;
        int k = 0;
        do
        {
            if (j >= i)
            {
                return abyte0;
            }
            abyte0[j] = (byte)(ai[k] & 0xff);
            abyte0[j + 1] = (byte)(ai[k] >>> 8 & 0xff);
            abyte0[j + 2] = (byte)(ai[k] >>> 16 & 0xff);
            abyte0[j + 3] = (byte)(ai[k] >>> 24 & 0xff);
            k++;
            j += 4;
        } while (true);
    }

    private static String toHex(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
        int j = abyte0.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return stringbuffer.toString();
            }
            int k = abyte0[i] & 0xff;
            if (k < 16)
            {
                stringbuffer.append("0");
            }
            stringbuffer.append(Integer.toHexString(k));
            i++;
        } while (true);
    }

    private static void transform(MD5State md5state, int ai[])
    {
        int j = md5state.state[0];
        int i = md5state.state[1];
        int l = md5state.state[2];
        int k = md5state.state[3];
        j = FF(j, i, l, k, ai[0], 7, 0xd76aa478);
        k = FF(k, j, i, l, ai[1], 12, 0xe8c7b756);
        l = FF(l, k, j, i, ai[2], 17, 0x242070db);
        i = FF(i, l, k, j, ai[3], 22, 0xc1bdceee);
        j = FF(j, i, l, k, ai[4], 7, 0xf57c0faf);
        k = FF(k, j, i, l, ai[5], 12, 0x4787c62a);
        l = FF(l, k, j, i, ai[6], 17, 0xa8304613);
        i = FF(i, l, k, j, ai[7], 22, 0xfd469501);
        j = FF(j, i, l, k, ai[8], 7, 0x698098d8);
        k = FF(k, j, i, l, ai[9], 12, 0x8b44f7af);
        l = FF(l, k, j, i, ai[10], 17, -42063);
        i = FF(i, l, k, j, ai[11], 22, 0x895cd7be);
        j = FF(j, i, l, k, ai[12], 7, 0x6b901122);
        k = FF(k, j, i, l, ai[13], 12, 0xfd987193);
        l = FF(l, k, j, i, ai[14], 17, 0xa679438e);
        i = FF(i, l, k, j, ai[15], 22, 0x49b40821);
        j = GG(j, i, l, k, ai[1], 5, 0xf61e2562);
        k = GG(k, j, i, l, ai[6], 9, 0xc040b340);
        l = GG(l, k, j, i, ai[11], 14, 0x265e5a51);
        i = GG(i, l, k, j, ai[0], 20, 0xe9b6c7aa);
        j = GG(j, i, l, k, ai[5], 5, 0xd62f105d);
        k = GG(k, j, i, l, ai[10], 9, 0x2441453);
        l = GG(l, k, j, i, ai[15], 14, 0xd8a1e681);
        i = GG(i, l, k, j, ai[4], 20, 0xe7d3fbc8);
        j = GG(j, i, l, k, ai[9], 5, 0x21e1cde6);
        k = GG(k, j, i, l, ai[14], 9, 0xc33707d6);
        l = GG(l, k, j, i, ai[3], 14, 0xf4d50d87);
        i = GG(i, l, k, j, ai[8], 20, 0x455a14ed);
        j = GG(j, i, l, k, ai[13], 5, 0xa9e3e905);
        k = GG(k, j, i, l, ai[2], 9, 0xfcefa3f8);
        l = GG(l, k, j, i, ai[7], 14, 0x676f02d9);
        i = GG(i, l, k, j, ai[12], 20, 0x8d2a4c8a);
        j = HH(j, i, l, k, ai[5], 4, 0xfffa3942);
        k = HH(k, j, i, l, ai[8], 11, 0x8771f681);
        l = HH(l, k, j, i, ai[11], 16, 0x6d9d6122);
        i = HH(i, l, k, j, ai[14], 23, 0xfde5380c);
        j = HH(j, i, l, k, ai[1], 4, 0xa4beea44);
        k = HH(k, j, i, l, ai[4], 11, 0x4bdecfa9);
        l = HH(l, k, j, i, ai[7], 16, 0xf6bb4b60);
        i = HH(i, l, k, j, ai[10], 23, 0xbebfbc70);
        j = HH(j, i, l, k, ai[13], 4, 0x289b7ec6);
        k = HH(k, j, i, l, ai[0], 11, 0xeaa127fa);
        l = HH(l, k, j, i, ai[3], 16, 0xd4ef3085);
        i = HH(i, l, k, j, ai[6], 23, 0x4881d05);
        j = HH(j, i, l, k, ai[9], 4, 0xd9d4d039);
        k = HH(k, j, i, l, ai[12], 11, 0xe6db99e5);
        l = HH(l, k, j, i, ai[15], 16, 0x1fa27cf8);
        i = HH(i, l, k, j, ai[2], 23, 0xc4ac5665);
        j = II(j, i, l, k, ai[0], 6, 0xf4292244);
        k = II(k, j, i, l, ai[7], 10, 0x432aff97);
        l = II(l, k, j, i, ai[14], 15, 0xab9423a7);
        i = II(i, l, k, j, ai[5], 21, 0xfc93a039);
        j = II(j, i, l, k, ai[12], 6, 0x655b59c3);
        k = II(k, j, i, l, ai[3], 10, 0x8f0ccc92);
        l = II(l, k, j, i, ai[10], 15, 0xffeff47d);
        i = II(i, l, k, j, ai[1], 21, 0x85845dd1);
        j = II(j, i, l, k, ai[8], 6, 0x6fa87e4f);
        k = II(k, j, i, l, ai[15], 10, 0xfe2ce6e0);
        l = II(l, k, j, i, ai[6], 15, 0xa3014314);
        i = II(i, l, k, j, ai[13], 21, 0x4e0811a1);
        j = II(j, i, l, k, ai[4], 6, 0xf7537e82);
        k = II(k, j, i, l, ai[11], 10, 0xbd3af235);
        l = II(l, k, j, i, ai[2], 15, 0x2ad7d2bb);
        i = II(i, l, k, j, ai[9], 21, 0xeb86d391);
        ai = md5state.state;
        ai[0] = ai[0] + j;
        ai = md5state.state;
        ai[1] = ai[1] + i;
        ai = md5state.state;
        ai[2] = ai[2] + l;
        md5state = md5state.state;
        md5state[3] = md5state[3] + k;
    }

    private void update(MD5State md5state, byte abyte0[], int i, int j)
    {
        int k;
        int l;
        int i1;
        int j1;
        finalState.valid = false;
        l = j;
        if (j + i > abyte0.length)
        {
            l = abyte0.length - i;
        }
        k = (int)(md5state.bitCount >>> 3) & 0x3f;
        md5state.bitCount = md5state.bitCount + (long)(l << 3);
        j1 = 64 - k;
        j = 0;
        i1 = k;
        if (l < j1) goto _L2; else goto _L1
_L1:
        System.arraycopy(abyte0, i, md5state.buffer, k, j1);
        transform(md5state, decode(md5state.buffer, 64, 0));
        j = j1;
_L7:
        if (j + 63 < l) goto _L4; else goto _L3
_L3:
        i1 = 0;
_L2:
        if (j >= l) goto _L6; else goto _L5
_L5:
        k = j;
_L8:
        if (k < l)
        {
            break MISSING_BLOCK_LABEL_161;
        }
_L6:
        return;
_L4:
        transform(md5state, decode(abyte0, 64, j));
        j += 64;
          goto _L7
        md5state.buffer[(i1 + k) - j] = abyte0[k + i];
        k++;
          goto _L8
    }

    MD5State currentState()
    {
        MD5State md5state = new MD5State();
        md5state.copy(workingState);
        return md5state;
    }

    public byte[] getHash()
    {
        if (!finalState.valid)
        {
            finalState.copy(workingState);
            long l = finalState.bitCount;
            int i = (int)(l >>> 3 & 63L);
            if (i < 56)
            {
                i = 56 - i;
            } else
            {
                i = 120 - i;
            }
            update(finalState, padding, 0, i);
            update(finalState, encode(l), 0, 8);
            finalState.valid = true;
        }
        return encode(finalState.state, 16);
    }

    public String getHashString()
    {
        return toHex(getHash());
    }

    public void reset()
    {
        workingState.reset();
        finalState.valid = false;
    }

    void setState(MD5State md5state)
    {
        reset();
        if (md5state != null)
        {
            workingState.copy(md5state);
        }
    }

    public String toString()
    {
        return getHashString();
    }

    public void update(byte abyte0[], int i, int j)
    {
        update(workingState, abyte0, i, j);
    }

    static 
    {
        byte abyte0[] = new byte[64];
        abyte0[0] = -128;
        padding = abyte0;
    }
}
