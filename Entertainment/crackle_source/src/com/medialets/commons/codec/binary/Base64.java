// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.commons.codec.binary;

import com.medialets.commons.codec.BinaryDecoder;
import com.medialets.commons.codec.BinaryEncoder;
import com.medialets.commons.codec.DecoderException;
import com.medialets.commons.codec.EncoderException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Base64
    implements BinaryDecoder, BinaryEncoder
{

    private static byte a[] = {
        13, 10
    };
    private static final byte b[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte c[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51
    };
    private final int d;
    private final byte e[];
    private final int f;
    private final int g;
    private byte h[];
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private int n;

    public Base64()
    {
        this(76, a);
    }

    public Base64(int i1)
    {
        this(i1, a);
    }

    public Base64(int i1, byte abyte0[])
    {
        d = i1;
        e = new byte[abyte0.length];
        System.arraycopy(abyte0, 0, e, 0, abyte0.length);
        String s;
        if (i1 > 0)
        {
            g = abyte0.length + 4;
        } else
        {
            g = 4;
        }
        f = g - 1;
        if (!a(abyte0)) goto _L2; else goto _L1
_L1:
        s = new String(abyte0, "UTF-8");
        abyte0 = s;
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("lineSeperator must not contain base64 characters: [").append(abyte0).append("]").toString());
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        abyte0 = new String(abyte0);
        if (true) goto _L3; else goto _L2
_L2:
    }

    private int a(byte abyte0[], int i1, int j1)
    {
        i1 = 0;
        if (h == null) goto _L2; else goto _L1
_L1:
label0:
        {
            if (h != null)
            {
                i1 = i - j;
            } else
            {
                i1 = 0;
            }
            i1 = Math.min(i1, j1);
            if (h != abyte0)
            {
                System.arraycopy(h, j, abyte0, 0, i1);
                j = j + i1;
                if (j < i)
                {
                    break label0;
                }
            }
            h = null;
        }
_L4:
        return i1;
_L2:
        if (m)
        {
            return -1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a()
    {
        if (h == null)
        {
            h = new byte[8192];
            i = 0;
            j = 0;
            return;
        } else
        {
            byte abyte0[] = new byte[h.length << 1];
            System.arraycopy(h, 0, abyte0, 0, h.length);
            h = abyte0;
            return;
        }
    }

    private static boolean a(byte abyte0[])
    {
        boolean flag1 = false;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < abyte0.length)
                {
                    if (!isBase64(abyte0[i1]))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private void b(byte abyte0[], int i1, int j1)
    {
        if (abyte0 != null && abyte0.length == j1)
        {
            h = abyte0;
            i = 0;
            j = 0;
        }
    }

    private void c(byte abyte0[], int i1, int j1)
    {
        if (!m) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (j1 >= 0) goto _L4; else goto _L3
_L3:
        m = true;
        if (h == null || h.length - i < g)
        {
            a();
        }
        l;
        JVM INSTR tableswitch 1 2: default 72
    //                   1 115
    //                   2 228;
           goto _L5 _L6 _L7
_L5:
        if (d > 0)
        {
            System.arraycopy(e, 0, h, i, e.length);
            i = i + e.length;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = b[n >> 2 & 0x3f];
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = b[n << 4 & 0x3f];
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = 61;
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = 61;
        continue; /* Loop/switch isn't completed */
_L7:
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = b[n >> 10 & 0x3f];
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = b[n >> 4 & 0x3f];
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = b[n << 2 & 0x3f];
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = 61;
        if (true) goto _L5; else goto _L4
_L4:
        int k1 = 0;
        while (k1 < j1) 
        {
            if (h == null || h.length - i < g)
            {
                a();
            }
            int l1 = l + 1;
            l = l1;
            l = l1 % 3;
            byte byte0 = abyte0[i1];
            l1 = byte0;
            if (byte0 < 0)
            {
                l1 = byte0 + 256;
            }
            n = l1 + (n << 8);
            if (l == 0)
            {
                byte abyte1[] = h;
                int i2 = i;
                i = i2 + 1;
                abyte1[i2] = b[n >> 18 & 0x3f];
                abyte1 = h;
                i2 = i;
                i = i2 + 1;
                abyte1[i2] = b[n >> 12 & 0x3f];
                abyte1 = h;
                i2 = i;
                i = i2 + 1;
                abyte1[i2] = b[n >> 6 & 0x3f];
                abyte1 = h;
                i2 = i;
                i = i2 + 1;
                abyte1[i2] = b[n & 0x3f];
                k = k + 4;
                if (d > 0 && d <= k)
                {
                    System.arraycopy(e, 0, h, i, e.length);
                    i = i + e.length;
                    k = 0;
                }
            }
            k1++;
            i1++;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    private void d(byte abyte0[], int i1, int j1)
    {
        if (!m) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k1;
        if (j1 < 0)
        {
            m = true;
        }
        k1 = 0;
_L9:
        byte byte0;
        if (k1 >= j1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (h == null || h.length - i < f)
        {
            a();
        }
        byte0 = abyte0[i1];
        if (byte0 != 61) goto _L4; else goto _L3
_L3:
        n = n << 6;
        l;
        JVM INSTR tableswitch 2 3: default 104
    //                   2 110
    //                   3 152;
           goto _L5 _L6 _L7
_L5:
        m = true;
        return;
_L6:
        n = n << 6;
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = (byte)(n >> 16);
        continue; /* Loop/switch isn't completed */
_L7:
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = (byte)(n >> 16);
        abyte0 = h;
        i1 = i;
        i = i1 + 1;
        abyte0[i1] = (byte)(n >> 8);
        if (true) goto _L5; else goto _L4
_L4:
        if (byte0 >= 0 && byte0 < c.length)
        {
            byte0 = c[byte0];
            if (byte0 >= 0)
            {
                int i2 = l + 1;
                l = i2;
                l = i2 % 4;
                n = byte0 + (n << 6);
                if (l == 0)
                {
                    byte abyte1[] = h;
                    int l1 = i;
                    i = l1 + 1;
                    abyte1[l1] = (byte)(n >> 16);
                    abyte1 = h;
                    l1 = i;
                    i = l1 + 1;
                    abyte1[l1] = (byte)(n >> 8);
                    abyte1 = h;
                    l1 = i;
                    i = l1 + 1;
                    abyte1[l1] = (byte)n;
                }
            }
        }
        k1++;
        i1++;
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L1; else goto _L10
_L10:
    }

    public static byte[] decodeBase64(byte abyte0[])
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            return abyte0;
        } else
        {
            Base64 base64 = new Base64();
            byte abyte1[] = new byte[(int)(long)((abyte0.length * 3) / 4)];
            base64.b(abyte1, 0, abyte1.length);
            base64.d(abyte0, 0, abyte0.length);
            base64.d(abyte0, 0, -1);
            abyte0 = new byte[base64.i];
            base64.a(abyte0, 0, abyte0.length);
            return abyte0;
        }
    }

    public static BigInteger decodeInteger(byte abyte0[])
    {
        return new BigInteger(1, decodeBase64(abyte0));
    }

    public static byte[] encodeBase64(byte abyte0[])
    {
        return encodeBase64(abyte0, false);
    }

    public static byte[] encodeBase64(byte abyte0[], boolean flag)
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            return abyte0;
        }
        Base64 base64;
        long l1;
        long l2;
        long l3;
        if (flag)
        {
            base64 = new Base64();
        } else
        {
            base64 = new Base64(0);
        }
        l2 = (abyte0.length << 2) / 3;
        l3 = l2 % 4L;
        l1 = l2;
        if (l3 != 0L)
        {
            l1 = l2 + (4L - l3);
        }
        l2 = l1;
        if (flag)
        {
            l2 = l1 + (1L + l1 / 76L) * (long)a.length;
        }
        if (l2 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("Input array too big, output array would be bigger than Integer.MAX_VALUE=2147483647");
        }
        byte abyte1[] = new byte[(int)l2];
        base64.b(abyte1, 0, abyte1.length);
        base64.c(abyte0, 0, abyte0.length);
        base64.c(abyte0, 0, -1);
        if (base64.h != abyte1)
        {
            base64.a(abyte1, 0, abyte1.length);
        }
        return abyte1;
    }

    public static byte[] encodeBase64Chunked(byte abyte0[])
    {
        return encodeBase64(abyte0, true);
    }

    public static byte[] encodeInteger(BigInteger biginteger)
    {
        if (biginteger == null)
        {
            throw new NullPointerException("encodeInteger called with null parameter");
        }
        int k1 = (biginteger.bitLength() + 7 >> 3) << 3;
        byte abyte0[] = biginteger.toByteArray();
        if (biginteger.bitLength() % 8 != 0 && biginteger.bitLength() / 8 + 1 == k1 / 8)
        {
            biginteger = abyte0;
        } else
        {
            int i1 = abyte0.length;
            int j1;
            int l1;
            if (biginteger.bitLength() % 8 == 0)
            {
                j1 = 1;
                i1--;
            } else
            {
                j1 = 0;
            }
            l1 = k1 / 8;
            biginteger = new byte[k1 / 8];
            System.arraycopy(abyte0, j1, biginteger, l1 - i1, i1);
        }
        return encodeBase64(biginteger, false);
    }

    public static boolean isArrayByteBase64(byte abyte0[])
    {
        int i1 = 0;
_L7:
        if (i1 >= abyte0.length) goto _L2; else goto _L1
_L1:
        if (isBase64(abyte0[i1]))
        {
            continue; /* Loop/switch isn't completed */
        }
        abyte0[i1];
        JVM INSTR lookupswitch 4: default 64
    //                   9: 72
    //                   10: 72
    //                   13: 72
    //                   32: 72;
           goto _L3 _L4 _L4 _L4 _L4
_L3:
        boolean flag = false;
_L6:
        if (!flag)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        i1++;
          goto _L7
_L2:
        return true;
    }

    public static boolean isBase64(byte byte0)
    {
        return byte0 == 61 || byte0 >= 0 && byte0 < c.length && c[byte0] != -1;
    }

    public Object decode(Object obj)
        throws DecoderException
    {
        if (!(obj instanceof byte[]))
        {
            throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
        } else
        {
            return decode((byte[])obj);
        }
    }

    public byte[] decode(byte abyte0[])
    {
        return decodeBase64(abyte0);
    }

    public Object encode(Object obj)
        throws EncoderException
    {
        if (!(obj instanceof byte[]))
        {
            throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
        } else
        {
            return encode((byte[])obj);
        }
    }

    public byte[] encode(byte abyte0[])
    {
        return encodeBase64(abyte0, false);
    }

}
