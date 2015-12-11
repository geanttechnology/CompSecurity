// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.binary;

import com.comcast.cim.commonscodecandroid.BinaryDecoder;
import com.comcast.cim.commonscodecandroid.BinaryEncoder;
import com.comcast.cim.commonscodecandroid.EncoderException;

// Referenced classes of package com.comcast.cim.commonscodecandroid.binary:
//            StringUtils

public class Base64
    implements BinaryDecoder, BinaryEncoder
{

    static final byte CHUNK_SEPARATOR[] = {
        13, 10
    };
    private static final byte DECODE_TABLE[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51
    };
    private static final byte STANDARD_ENCODE_TABLE[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte URL_SAFE_ENCODE_TABLE[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    private byte buffer[];
    private int currentLinePos;
    private final int decodeSize;
    private final int encodeSize;
    private final byte encodeTable[];
    private boolean eof;
    private final int lineLength;
    private final byte lineSeparator[];
    private int modulus;
    private int pos;
    private int readPos;
    private int x;

    public Base64()
    {
        this(false);
    }

    public Base64(int i, byte abyte0[], boolean flag)
    {
        byte abyte1[] = abyte0;
        if (abyte0 == null)
        {
            i = 0;
            abyte1 = CHUNK_SEPARATOR;
        }
        int j;
        if (i > 0)
        {
            j = (i / 4) * 4;
        } else
        {
            j = 0;
        }
        lineLength = j;
        lineSeparator = new byte[abyte1.length];
        System.arraycopy(abyte1, 0, lineSeparator, 0, abyte1.length);
        if (i > 0)
        {
            encodeSize = abyte1.length + 4;
        } else
        {
            encodeSize = 4;
        }
        decodeSize = encodeSize - 1;
        if (containsBase64Byte(abyte1))
        {
            abyte0 = StringUtils.newStringUtf8(abyte1);
            throw new IllegalArgumentException("lineSeperator must not contain base64 characters: [" + abyte0 + "]");
        }
        if (flag)
        {
            abyte0 = URL_SAFE_ENCODE_TABLE;
        } else
        {
            abyte0 = STANDARD_ENCODE_TABLE;
        }
        encodeTable = abyte0;
    }

    public Base64(boolean flag)
    {
        this(76, CHUNK_SEPARATOR, flag);
    }

    private static boolean containsBase64Byte(byte abyte0[])
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            if (isBase64(abyte0[i]))
            {
                return true;
            }
        }

        return false;
    }

    public static byte[] decodeBase64(byte abyte0[])
    {
        return (new Base64()).decode(abyte0);
    }

    public static byte[] encodeBase64(byte abyte0[])
    {
        return encodeBase64(abyte0, false);
    }

    public static byte[] encodeBase64(byte abyte0[], boolean flag)
    {
        return encodeBase64(abyte0, flag, false);
    }

    public static byte[] encodeBase64(byte abyte0[], boolean flag, boolean flag1)
    {
        return encodeBase64(abyte0, flag, flag1, 0x7fffffff);
    }

    public static byte[] encodeBase64(byte abyte0[], boolean flag, boolean flag1, int i)
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            return abyte0;
        }
        long l = getEncodeLength(abyte0, 76, CHUNK_SEPARATOR);
        if (l > (long)i)
        {
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l + ") than the specified maxium size of " + i);
        }
        Base64 base64;
        if (flag)
        {
            base64 = new Base64(flag1);
        } else
        {
            base64 = new Base64(0, CHUNK_SEPARATOR, flag1);
        }
        return base64.encode(abyte0);
    }

    private static long getEncodeLength(byte abyte0[], int i, byte abyte1[])
    {
        int j = (i / 4) * 4;
        long l1 = (abyte0.length * 4) / 3;
        long l2 = l1 % 4L;
        long l = l1;
        if (l2 != 0L)
        {
            l = l1 + (4L - l2);
        }
        l1 = l;
        if (j > 0)
        {
            if (l % (long)j == 0L)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            l += (l / (long)j) * (long)abyte1.length;
            l1 = l;
            if (i == 0)
            {
                l1 = l + (long)abyte1.length;
            }
        }
        return l1;
    }

    public static boolean isBase64(byte byte0)
    {
        return byte0 == 61 || byte0 >= 0 && byte0 < DECODE_TABLE.length && DECODE_TABLE[byte0] != -1;
    }

    private void reset()
    {
        buffer = null;
        pos = 0;
        readPos = 0;
        currentLinePos = 0;
        modulus = 0;
        eof = false;
    }

    private void resizeBuffer()
    {
        if (buffer == null)
        {
            buffer = new byte[8192];
            pos = 0;
            readPos = 0;
            return;
        } else
        {
            byte abyte0[] = new byte[buffer.length * 2];
            System.arraycopy(buffer, 0, abyte0, 0, buffer.length);
            buffer = abyte0;
            return;
        }
    }

    int avail()
    {
        if (buffer != null)
        {
            return pos - readPos;
        } else
        {
            return 0;
        }
    }

    void decode(byte abyte0[], int i, int j)
    {
        if (!eof) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k;
        if (j < 0)
        {
            eof = true;
        }
        k = 0;
_L4:
        int l;
        if (k >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (buffer == null || buffer.length - pos < decodeSize)
        {
            resizeBuffer();
        }
        l = abyte0[i];
        if (l != 61)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        eof = true;
        if (!eof || modulus == 0) goto _L1; else goto _L3
_L3:
        x = x << 6;
        byte abyte1[];
        int i1;
        switch (modulus)
        {
        default:
            return;

        case 2: // '\002'
            x = x << 6;
            abyte0 = buffer;
            i = pos;
            pos = i + 1;
            abyte0[i] = (byte)(x >> 16 & 0xff);
            return;

        case 3: // '\003'
            abyte0 = buffer;
            break;
        }
        break MISSING_BLOCK_LABEL_365;
        if (l >= 0 && l < DECODE_TABLE.length)
        {
            l = DECODE_TABLE[l];
            if (l >= 0)
            {
                i1 = modulus + 1;
                modulus = i1;
                modulus = i1 % 4;
                x = (x << 6) + l;
                if (modulus == 0)
                {
                    abyte1 = buffer;
                    l = pos;
                    pos = l + 1;
                    abyte1[l] = (byte)(x >> 16 & 0xff);
                    abyte1 = buffer;
                    l = pos;
                    pos = l + 1;
                    abyte1[l] = (byte)(x >> 8 & 0xff);
                    abyte1 = buffer;
                    l = pos;
                    pos = l + 1;
                    abyte1[l] = (byte)(x & 0xff);
                }
            }
        }
        k++;
        i++;
          goto _L4
        i = pos;
        pos = i + 1;
        abyte0[i] = (byte)(x >> 16 & 0xff);
        abyte0 = buffer;
        i = pos;
        pos = i + 1;
        abyte0[i] = (byte)(x >> 8 & 0xff);
        return;
    }

    public byte[] decode(byte abyte0[])
    {
        reset();
        if (abyte0 == null || abyte0.length == 0)
        {
            return abyte0;
        } else
        {
            byte abyte1[] = new byte[(int)(long)((abyte0.length * 3) / 4)];
            setInitialBuffer(abyte1, 0, abyte1.length);
            decode(abyte0, 0, abyte0.length);
            decode(abyte0, 0, -1);
            abyte0 = new byte[pos];
            readResults(abyte0, 0, abyte0.length);
            return abyte0;
        }
    }

    public Object encode(Object obj)
        throws EncoderException
    {
        if (!(obj instanceof byte[]))
        {
            throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
        } else
        {
            return encode((byte[])(byte[])obj);
        }
    }

    void encode(byte abyte0[], int i, int j)
    {
        if (!eof) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_385;
        }
        eof = true;
        if (buffer == null || buffer.length - pos < encodeSize)
        {
            resizeBuffer();
        }
        switch (modulus)
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_247;
_L4:
        if (lineLength > 0 && pos > 0)
        {
            System.arraycopy(lineSeparator, 0, buffer, pos, lineSeparator.length);
            pos = pos + lineSeparator.length;
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        abyte0 = buffer;
        i = pos;
        pos = i + 1;
        abyte0[i] = encodeTable[x >> 2 & 0x3f];
        abyte0 = buffer;
        i = pos;
        pos = i + 1;
        abyte0[i] = encodeTable[x << 4 & 0x3f];
        if (encodeTable == STANDARD_ENCODE_TABLE)
        {
            abyte0 = buffer;
            i = pos;
            pos = i + 1;
            abyte0[i] = 61;
            abyte0 = buffer;
            i = pos;
            pos = i + 1;
            abyte0[i] = 61;
        }
          goto _L4
        abyte0 = buffer;
        i = pos;
        pos = i + 1;
        abyte0[i] = encodeTable[x >> 10 & 0x3f];
        abyte0 = buffer;
        i = pos;
        pos = i + 1;
        abyte0[i] = encodeTable[x >> 4 & 0x3f];
        abyte0 = buffer;
        i = pos;
        pos = i + 1;
        abyte0[i] = encodeTable[x << 2 & 0x3f];
        if (encodeTable == STANDARD_ENCODE_TABLE)
        {
            abyte0 = buffer;
            i = pos;
            pos = i + 1;
            abyte0[i] = 61;
        }
          goto _L4
        for (int k = 0; k < j;)
        {
            if (buffer == null || buffer.length - pos < encodeSize)
            {
                resizeBuffer();
            }
            int l = modulus + 1;
            modulus = l;
            modulus = l % 3;
            byte byte0 = abyte0[i];
            l = byte0;
            if (byte0 < 0)
            {
                l = byte0 + 256;
            }
            x = (x << 8) + l;
            if (modulus == 0)
            {
                byte abyte1[] = buffer;
                int i1 = pos;
                pos = i1 + 1;
                abyte1[i1] = encodeTable[x >> 18 & 0x3f];
                abyte1 = buffer;
                i1 = pos;
                pos = i1 + 1;
                abyte1[i1] = encodeTable[x >> 12 & 0x3f];
                abyte1 = buffer;
                i1 = pos;
                pos = i1 + 1;
                abyte1[i1] = encodeTable[x >> 6 & 0x3f];
                abyte1 = buffer;
                i1 = pos;
                pos = i1 + 1;
                abyte1[i1] = encodeTable[x & 0x3f];
                currentLinePos = currentLinePos + 4;
                if (lineLength > 0 && lineLength <= currentLinePos)
                {
                    System.arraycopy(lineSeparator, 0, buffer, pos, lineSeparator.length);
                    pos = pos + lineSeparator.length;
                    currentLinePos = 0;
                }
            }
            k++;
            i++;
        }

        return;
    }

    public byte[] encode(byte abyte0[])
    {
        reset();
        if (abyte0 != null && abyte0.length != 0)
        {
            byte abyte1[] = new byte[(int)getEncodeLength(abyte0, lineLength, lineSeparator)];
            setInitialBuffer(abyte1, 0, abyte1.length);
            encode(abyte0, 0, abyte0.length);
            encode(abyte0, 0, -1);
            if (buffer != abyte1)
            {
                readResults(abyte1, 0, abyte1.length);
            }
            abyte0 = abyte1;
            if (isUrlSafe())
            {
                abyte0 = abyte1;
                if (pos < abyte1.length)
                {
                    abyte0 = new byte[pos];
                    System.arraycopy(abyte1, 0, abyte0, 0, pos);
                    return abyte0;
                }
            }
        }
        return abyte0;
    }

    boolean hasData()
    {
        return buffer != null;
    }

    public boolean isUrlSafe()
    {
        return encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    int readResults(byte abyte0[], int i, int j)
    {
        if (buffer != null)
        {
            j = Math.min(avail(), j);
            if (buffer != abyte0)
            {
                System.arraycopy(buffer, readPos, abyte0, i, j);
                readPos = readPos + j;
                if (readPos >= pos)
                {
                    buffer = null;
                }
                return j;
            } else
            {
                buffer = null;
                return j;
            }
        }
        if (eof)
        {
            i = -1;
        } else
        {
            i = 0;
        }
        return i;
    }

    void setInitialBuffer(byte abyte0[], int i, int j)
    {
        if (abyte0 != null && abyte0.length == j)
        {
            buffer = abyte0;
            pos = i;
            readPos = i;
        }
    }

}
