// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.appsearch.patchupdate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.baidu.appsearch.patchupdate:
//            MD5State, MD5InputStream

public class MD5
{

    private static final char HEX_CHARS[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    private static boolean mNativeLibInitPending = true;
    private static boolean mNativeLibLoaded = false;
    static byte padding[] = {
        -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0
    };
    MD5State finals;
    MD5State state;

    public MD5()
    {
        if (mNativeLibInitPending)
        {
            initToNativeLibrary();
        }
        init();
    }

    public MD5(Object obj)
    {
        this();
        update(obj.toString());
    }

    private void Transform(MD5State md5state, byte abyte0[], int i, int ai[])
    {
        int i1 = md5state.state[0];
        int j = md5state.state[1];
        int l = md5state.state[2];
        int k = md5state.state[3];
        decode(abyte0, i, ai);
        i = i1 + (((j & l | ~j & k) + ai[0]) - 0x28955b88);
        i = (i >>> 25 | i << 7) + j;
        k += ((i & j | ~i & l) + ai[1]) - 0x173848aa;
        k = (k >>> 20 | k << 12) + i;
        l += (k & i | ~k & j) + ai[2] + 0x242070db;
        l = (l >>> 15 | l << 17) + k;
        j += ((l & k | ~l & i) + ai[3]) - 0x3e423112;
        j = (j >>> 10 | j << 22) + l;
        i += ((j & l | ~j & k) + ai[4]) - 0xa83f051;
        i = (i >>> 25 | i << 7) + j;
        k += (i & j | ~i & l) + ai[5] + 0x4787c62a;
        k = (k >>> 20 | k << 12) + i;
        l += ((k & i | ~k & j) + ai[6]) - 0x57cfb9ed;
        l = (l >>> 15 | l << 17) + k;
        j += ((l & k | ~l & i) + ai[7]) - 0x2b96aff;
        j = (j >>> 10 | j << 22) + l;
        i += (j & l | ~j & k) + ai[8] + 0x698098d8;
        i = (i >>> 25 | i << 7) + j;
        k += ((i & j | ~i & l) + ai[9]) - 0x74bb0851;
        k = (k >>> 20 | k << 12) + i;
        l += ((k & i | ~k & j) + ai[10]) - 42063;
        l = (l >>> 15 | l << 17) + k;
        j += ((l & k | ~l & i) + ai[11]) - 0x76a32842;
        j = (j >>> 10 | j << 22) + l;
        i += (j & l | ~j & k) + ai[12] + 0x6b901122;
        i = (i >>> 25 | i << 7) + j;
        k += ((i & j | ~i & l) + ai[13]) - 0x2678e6d;
        k = (k >>> 20 | k << 12) + i;
        l += ((k & i | ~k & j) + ai[14]) - 0x5986bc72;
        l = (l >>> 15 | l << 17) + k;
        j += (l & k | ~l & i) + ai[15] + 0x49b40821;
        j = (j >>> 10 | j << 22) + l;
        i += ((j & k | ~k & l) + ai[1]) - 0x9e1da9e;
        i = (i >>> 27 | i << 5) + j;
        k += ((i & l | ~l & j) + ai[6]) - 0x3fbf4cc0;
        k = (k >>> 23 | k << 9) + i;
        l += (k & j | ~j & i) + ai[11] + 0x265e5a51;
        l = (l >>> 18 | l << 14) + k;
        j += ((l & i | ~i & k) + ai[0]) - 0x16493856;
        j = (j >>> 12 | j << 20) + l;
        i += ((j & k | ~k & l) + ai[5]) - 0x29d0efa3;
        i = (i >>> 27 | i << 5) + j;
        k += (i & l | ~l & j) + ai[10] + 0x2441453;
        k = (k >>> 23 | k << 9) + i;
        l += ((k & j | ~j & i) + ai[15]) - 0x275e197f;
        l = (l >>> 18 | l << 14) + k;
        j += ((l & i | ~i & k) + ai[4]) - 0x182c0438;
        j = (j >>> 12 | j << 20) + l;
        i += (j & k | ~k & l) + ai[9] + 0x21e1cde6;
        i = (i >>> 27 | i << 5) + j;
        k += ((i & l | ~l & j) + ai[14]) - 0x3cc8f82a;
        k = (k >>> 23 | k << 9) + i;
        l += ((k & j | ~j & i) + ai[3]) - 0xb2af279;
        l = (l >>> 18 | l << 14) + k;
        j += (l & i | ~i & k) + ai[8] + 0x455a14ed;
        j = (j >>> 12 | j << 20) + l;
        i += ((j & k | ~k & l) + ai[13]) - 0x561c16fb;
        i = (i >>> 27 | i << 5) + j;
        k += ((i & l | ~l & j) + ai[2]) - 0x3105c08;
        k = (k >>> 23 | k << 9) + i;
        l += (k & j | ~j & i) + ai[7] + 0x676f02d9;
        l = (l >>> 18 | l << 14) + k;
        j += ((l & i | ~i & k) + ai[12]) - 0x72d5b376;
        j = (j >>> 12 | j << 20) + l;
        i += ((j ^ l ^ k) + ai[5]) - 0x5c6be;
        i = (i >>> 28 | i << 4) + j;
        k += ((i ^ j ^ l) + ai[8]) - 0x788e097f;
        k = (k >>> 21 | k << 11) + i;
        l += (k ^ i ^ j) + ai[11] + 0x6d9d6122;
        l = (l >>> 16 | l << 16) + k;
        j += ((l ^ k ^ i) + ai[14]) - 0x21ac7f4;
        j = (j >>> 9 | j << 23) + l;
        i += ((j ^ l ^ k) + ai[1]) - 0x5b4115bc;
        i = (i >>> 28 | i << 4) + j;
        k += (i ^ j ^ l) + ai[4] + 0x4bdecfa9;
        k = (k >>> 21 | k << 11) + i;
        l += ((k ^ i ^ j) + ai[7]) - 0x944b4a0;
        l = (l >>> 16 | l << 16) + k;
        j += ((l ^ k ^ i) + ai[10]) - 0x41404390;
        j = (j >>> 9 | j << 23) + l;
        i += (j ^ l ^ k) + ai[13] + 0x289b7ec6;
        i = (i >>> 28 | i << 4) + j;
        k += ((i ^ j ^ l) + ai[0]) - 0x155ed806;
        k = (k >>> 21 | k << 11) + i;
        l += ((k ^ i ^ j) + ai[3]) - 0x2b10cf7b;
        l = (l >>> 16 | l << 16) + k;
        j += (l ^ k ^ i) + ai[6] + 0x4881d05;
        j = (j >>> 9 | j << 23) + l;
        i += ((j ^ l ^ k) + ai[9]) - 0x262b2fc7;
        i = (i >>> 28 | i << 4) + j;
        k += ((i ^ j ^ l) + ai[12]) - 0x1924661b;
        k = (k >>> 21 | k << 11) + i;
        l += (k ^ i ^ j) + ai[15] + 0x1fa27cf8;
        l = (l >>> 16 | l << 16) + k;
        j += ((l ^ k ^ i) + ai[2]) - 0x3b53a99b;
        j = (j >>> 9 | j << 23) + l;
        i += (((~k | j) ^ l) + ai[0]) - 0xbd6ddbc;
        i = (i >>> 26 | i << 6) + j;
        k += ((~l | i) ^ j) + ai[7] + 0x432aff97;
        k = (k >>> 22 | k << 10) + i;
        l += (((~j | k) ^ i) + ai[14]) - 0x546bdc59;
        l = (l >>> 17 | l << 15) + k;
        j += (((~i | l) ^ k) + ai[5]) - 0x36c5fc7;
        j = (j >>> 11 | j << 21) + l;
        i += ((~k | j) ^ l) + ai[12] + 0x655b59c3;
        i = (i >>> 26 | i << 6) + j;
        k += (((~l | i) ^ j) + ai[3]) - 0x70f3336e;
        k = (k >>> 22 | k << 10) + i;
        l += (((~j | k) ^ i) + ai[10]) - 0x100b83;
        l = (l >>> 17 | l << 15) + k;
        j += (((~i | l) ^ k) + ai[1]) - 0x7a7ba22f;
        j = (j >>> 11 | j << 21) + l;
        i += ((~k | j) ^ l) + ai[8] + 0x6fa87e4f;
        i = (i >>> 26 | i << 6) + j;
        k += (((~l | i) ^ j) + ai[15]) - 0x1d31920;
        k = (k >>> 22 | k << 10) + i;
        l += (((~j | k) ^ i) + ai[6]) - 0x5cfebcec;
        l = (l >>> 17 | l << 15) + k;
        j += ((~i | l) ^ k) + ai[13] + 0x4e0811a1;
        j = (j >>> 11 | j << 21) + l;
        i += (((~k | j) ^ l) + ai[4]) - 0x8ac817e;
        i = (i >>> 26 | i << 6) + j;
        k += (((~l | i) ^ j) + ai[11]) - 0x42c50dcb;
        k = (k >>> 22 | k << 10) + i;
        l += ((~j | k) ^ i) + ai[2] + 0x2ad7d2bb;
        l = (l >>> 17 | l << 15) + k;
        j += (((~i | l) ^ k) + ai[9]) - 0x14792c6f;
        abyte0 = md5state.state;
        abyte0[0] = i + abyte0[0];
        abyte0 = md5state.state;
        abyte0[1] = (j >>> 11 | j << 21) + l + abyte0[1];
        abyte0 = md5state.state;
        abyte0[2] = abyte0[2] + l;
        md5state = md5state.state;
        md5state[3] = md5state[3] + k;
    }

    private native void Transform_native(int ai[], byte abyte0[], int i, int j);

    public static String asHex(byte abyte0[])
    {
        int j = 0;
        char ac[] = new char[abyte0.length * 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            int k = j + 1;
            ac[j] = HEX_CHARS[abyte0[i] >>> 4 & 0xf];
            j = k + 1;
            ac[k] = HEX_CHARS[abyte0[i] & 0xf];
        }

        return new String(ac);
    }

    private void decode(byte abyte0[], int i, int ai[])
    {
        ai[0] = abyte0[i] & 0xff | (abyte0[i + 1] & 0xff) << 8 | (abyte0[i + 2] & 0xff) << 16 | abyte0[i + 3] << 24;
        ai[1] = abyte0[i + 4] & 0xff | (abyte0[i + 5] & 0xff) << 8 | (abyte0[i + 6] & 0xff) << 16 | abyte0[i + 7] << 24;
        ai[2] = abyte0[i + 8] & 0xff | (abyte0[i + 9] & 0xff) << 8 | (abyte0[i + 10] & 0xff) << 16 | abyte0[i + 11] << 24;
        ai[3] = abyte0[i + 12] & 0xff | (abyte0[i + 13] & 0xff) << 8 | (abyte0[i + 14] & 0xff) << 16 | abyte0[i + 15] << 24;
        ai[4] = abyte0[i + 16] & 0xff | (abyte0[i + 17] & 0xff) << 8 | (abyte0[i + 18] & 0xff) << 16 | abyte0[i + 19] << 24;
        ai[5] = abyte0[i + 20] & 0xff | (abyte0[i + 21] & 0xff) << 8 | (abyte0[i + 22] & 0xff) << 16 | abyte0[i + 23] << 24;
        ai[6] = abyte0[i + 24] & 0xff | (abyte0[i + 25] & 0xff) << 8 | (abyte0[i + 26] & 0xff) << 16 | abyte0[i + 27] << 24;
        ai[7] = abyte0[i + 28] & 0xff | (abyte0[i + 29] & 0xff) << 8 | (abyte0[i + 30] & 0xff) << 16 | abyte0[i + 31] << 24;
        ai[8] = abyte0[i + 32] & 0xff | (abyte0[i + 33] & 0xff) << 8 | (abyte0[i + 34] & 0xff) << 16 | abyte0[i + 35] << 24;
        ai[9] = abyte0[i + 36] & 0xff | (abyte0[i + 37] & 0xff) << 8 | (abyte0[i + 38] & 0xff) << 16 | abyte0[i + 39] << 24;
        ai[10] = abyte0[i + 40] & 0xff | (abyte0[i + 41] & 0xff) << 8 | (abyte0[i + 42] & 0xff) << 16 | abyte0[i + 43] << 24;
        ai[11] = abyte0[i + 44] & 0xff | (abyte0[i + 45] & 0xff) << 8 | (abyte0[i + 46] & 0xff) << 16 | abyte0[i + 47] << 24;
        ai[12] = abyte0[i + 48] & 0xff | (abyte0[i + 49] & 0xff) << 8 | (abyte0[i + 50] & 0xff) << 16 | abyte0[i + 51] << 24;
        ai[13] = abyte0[i + 52] & 0xff | (abyte0[i + 53] & 0xff) << 8 | (abyte0[i + 54] & 0xff) << 16 | abyte0[i + 55] << 24;
        ai[14] = abyte0[i + 56] & 0xff | (abyte0[i + 57] & 0xff) << 8 | (abyte0[i + 58] & 0xff) << 16 | abyte0[i + 59] << 24;
        ai[15] = abyte0[i + 60] & 0xff | (abyte0[i + 61] & 0xff) << 8 | (abyte0[i + 62] & 0xff) << 16 | abyte0[i + 63] << 24;
    }

    private byte[] encode(int ai[], int i)
    {
        byte abyte0[] = new byte[i];
        int j = 0;
        int k = 0;
        for (; j < i; j += 4)
        {
            abyte0[j] = (byte)(ai[k] & 0xff);
            abyte0[j + 1] = (byte)(ai[k] >>> 8 & 0xff);
            abyte0[j + 2] = (byte)(ai[k] >>> 16 & 0xff);
            abyte0[j + 3] = (byte)(ai[k] >>> 24 & 0xff);
            k++;
        }

        return abyte0;
    }

    public static byte[] getHash(File file)
    {
        long l;
        long l1;
        long l2;
        l1 = 0x10000L;
        l = 512L;
        if (!file.exists())
        {
            throw new FileNotFoundException(file.toString());
        }
        byte abyte0[];
        try
        {
            l2 = file.length();
            break MISSING_BLOCK_LABEL_34;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            md5inputstream = null;
        }
          goto _L1
_L4:
        abyte0 = new byte[(int)l];
        md5inputstream = new MD5InputStream(new FileInputStream(file));
        while (md5inputstream.read(abyte0) != -1) ;
        md5inputstream.close();
        file = md5inputstream.hash();
        return file;
_L1:
        if (md5inputstream != null)
        {
            try
            {
                md5inputstream.close();
            }
            catch (Exception exception)
            {
                throw file;
            }
        }
        throw file;
        file;
        if (true) goto _L1; else goto _L2
_L2:
        MD5InputStream md5inputstream;
        if (l2 >= 512L)
        {
            l = l2;
        }
        if (l > 0x10000L)
        {
            l = l1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean hashesEqual(byte abyte0[], byte abyte1[])
    {
        int i;
        boolean flag;
        boolean flag1;
        flag = true;
        i = 16;
        flag1 = false;
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        if (abyte1 != null)
        {
            flag = false;
        }
_L4:
        return flag;
_L2:
        flag = flag1;
        if (abyte1 == null) goto _L4; else goto _L3
_L3:
        if (abyte0.length >= 16)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        flag = flag1;
        if (abyte1.length != abyte0.length) goto _L4; else goto _L5
_L5:
        i = abyte0.length;
_L8:
        int j = 0;
_L7:
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        flag = flag1;
        if (abyte0[j] != abyte1[j]) goto _L4; else goto _L6
_L6:
        j++;
          goto _L7
        if (abyte1.length < 16)
        {
            return false;
        }
          goto _L8
        return true;
    }

    public static boolean initNativeLibrary()
    {
        com/baidu/appsearch/patchupdate/MD5;
        JVM INSTR monitorenter ;
        boolean flag = initNativeLibrary(false);
        com/baidu/appsearch/patchupdate/MD5;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean initNativeLibrary(boolean flag)
    {
        com/baidu/appsearch/patchupdate/MD5;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        mNativeLibInitPending = false;
_L1:
        flag = mNativeLibLoaded;
        com/baidu/appsearch/patchupdate/MD5;
        JVM INSTR monitorexit ;
        return flag;
        initToNativeLibrary();
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    private static void initToNativeLibrary()
    {
        com/baidu/appsearch/patchupdate/MD5;
        JVM INSTR monitorenter ;
        boolean flag = mNativeLibInitPending;
        if (flag) goto _L2; else goto _L1
_L1:
        com/baidu/appsearch/patchupdate/MD5;
        JVM INSTR monitorexit ;
        return;
_L2:
        mNativeLibLoaded = loadNativeLibrary();
        mNativeLibInitPending = false;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static boolean loadNativeLibrary()
    {
        com/baidu/appsearch/patchupdate/MD5;
        JVM INSTR monitorenter ;
        System.loadLibrary("MD5");
        boolean flag = true;
_L2:
        com/baidu/appsearch/patchupdate/MD5;
        JVM INSTR monitorexit ;
        return flag;
        Object obj;
        obj;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public String asHex()
    {
        return asHex(finalEncode());
    }

    public byte[] finalEncode()
    {
        this;
        JVM INSTR monitorenter ;
        MD5State md5state;
        byte abyte1[];
        int i;
        if (finals != null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        md5state = new MD5State(state);
        abyte1 = encode(new int[] {
            (int)(md5state.count << 3), (int)(md5state.count >> 29)
        }, 8);
        i = (int)(md5state.count & 63L);
        byte abyte0[];
        if (i < 56)
        {
            i = 56 - i;
        } else
        {
            i = 120 - i;
        }
        update(md5state, padding, 0, i);
        update(md5state, abyte1, 0, 8);
        finals = md5state;
        abyte0 = encode(finals.state, 16);
        this;
        JVM INSTR monitorexit ;
        return abyte0;
        Exception exception;
        exception;
        throw exception;
    }

    public void init()
    {
        this;
        JVM INSTR monitorenter ;
        state = new MD5State();
        finals = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void update(byte byte0)
    {
        update(new byte[] {
            byte0
        }, 1);
    }

    public void update(int i)
    {
        update((byte)(i & 0xff));
    }

    public void update(MD5State md5state, byte abyte0[], int i, int j)
    {
        int k;
        int l;
        int i1;
        int j1;
        i1 = 0;
        finals = null;
        l = j;
        if (j - i > abyte0.length)
        {
            l = abyte0.length - i;
        }
        j1 = (int)(md5state.count & 63L);
        md5state.count = md5state.count + (long)l;
        k = 64 - j1;
        j = i1;
        i1 = j1;
        if (l < k) goto _L2; else goto _L1
_L1:
        if (!mNativeLibLoaded) goto _L4; else goto _L3
_L3:
        if (k == 64)
        {
            k = 0;
        } else
        {
            for (j = 0; j < k; j++)
            {
                md5state.buffer[j + j1] = abyte0[j + i];
            }

            Transform_native(md5state.state, md5state.buffer, 0, 64);
        }
        j1 = (l - k) / 64;
        i1 = l - k;
        for (j = k + i; i1 > 0x10000; j += 0x10000)
        {
            Transform_native(md5state.state, abyte0, j, 0x10000);
            i1 -= 0x10000;
        }

        Transform_native(md5state.state, abyte0, j, i1);
        k = j1 * 64 + k;
_L6:
        i1 = 0;
        j = k;
_L2:
        if (j < l)
        {
            for (k = j; k < l; k++)
            {
                md5state.buffer[(i1 + k) - j] = abyte0[k + i];
            }

        }
        break MISSING_BLOCK_LABEL_383;
_L4:
        int ai[] = new int[16];
        if (k == 64)
        {
            j = 0;
        } else
        {
            for (j = 0; j < k; j++)
            {
                md5state.buffer[j + j1] = abyte0[j + i];
            }

            Transform(md5state, md5state.buffer, 0, ai);
            j = k;
        }
        do
        {
            k = j;
            if (j + 63 >= l)
            {
                break;
            }
            Transform(md5state, abyte0, j + i, ai);
            j += 64;
        } while (true);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void update(String s)
    {
        s = s.getBytes();
        update(((byte []) (s)), s.length);
    }

    public void update(String s, String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "ISO8859_1";
        }
        s = s.getBytes(s2);
        update(((byte []) (s)), s.length);
    }

    public void update(byte abyte0[])
    {
        update(abyte0, 0, abyte0.length);
    }

    public void update(byte abyte0[], int i)
    {
        update(state, abyte0, 0, i);
    }

    public void update(byte abyte0[], int i, int j)
    {
        update(state, abyte0, i, j);
    }

}
