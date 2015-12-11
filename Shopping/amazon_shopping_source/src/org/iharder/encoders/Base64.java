// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.iharder.encoders;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Base64
{
    public static class OutputStream extends FilterOutputStream
    {

        private byte b4[];
        private boolean breakLines;
        private byte buffer[];
        private int bufferLength;
        private byte decodabet[];
        private boolean encode;
        private int lineLength;
        private int options;
        private int position;
        private boolean suspendEncoding;

        public void close()
            throws IOException
        {
            flushBase64();
            super.close();
            buffer = null;
            out = null;
        }

        public void flushBase64()
            throws IOException
        {
label0:
            {
                if (position > 0)
                {
                    if (!encode)
                    {
                        break label0;
                    }
                    out.write(Base64.encode3to4(b4, buffer, position, options));
                    position = 0;
                }
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void write(int i)
            throws IOException
        {
            if (!suspendEncoding) goto _L2; else goto _L1
_L1:
            out.write(i);
_L4:
            return;
_L2:
            if (!encode)
            {
                break; /* Loop/switch isn't completed */
            }
            byte abyte0[] = buffer;
            int j = position;
            position = j + 1;
            abyte0[j] = (byte)i;
            if (position >= bufferLength)
            {
                out.write(Base64.encode3to4(b4, buffer, bufferLength, options));
                lineLength = lineLength + 4;
                if (breakLines && lineLength >= 76)
                {
                    out.write(10);
                    lineLength = 0;
                }
                position = 0;
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (decodabet[i & 0x7f] <= -5)
            {
                continue; /* Loop/switch isn't completed */
            }
            byte abyte1[] = buffer;
            int k = position;
            position = k + 1;
            abyte1[k] = (byte)i;
            if (position < bufferLength) goto _L4; else goto _L5
_L5:
            i = Base64.decode4to3(buffer, 0, b4, 0, options);
            out.write(b4, 0, i);
            position = 0;
            return;
            if (decodabet[i & 0x7f] == -5) goto _L4; else goto _L6
_L6:
            throw new IOException("Invalid character in Base64 data.");
        }

        public void write(byte abyte0[], int i, int j)
            throws IOException
        {
            if (suspendEncoding)
            {
                out.write(abyte0, i, j);
            } else
            {
                int k = 0;
                while (k < j) 
                {
                    write(abyte0[i + k]);
                    k++;
                }
            }
        }

        public OutputStream(java.io.OutputStream outputstream, int i)
        {
            boolean flag1 = true;
            super(outputstream);
            int j;
            boolean flag;
            if ((i & 8) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            breakLines = flag;
            if ((i & 1) != 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            encode = flag;
            if (encode)
            {
                j = 3;
            } else
            {
                j = 4;
            }
            bufferLength = j;
            buffer = new byte[bufferLength];
            position = 0;
            lineLength = 0;
            suspendEncoding = false;
            b4 = new byte[4];
            options = i;
            decodabet = Base64.getDecodabet(i);
        }
    }


    static final boolean $assertionsDisabled;
    private static final byte _ORDERED_ALPHABET[] = {
        45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 
        57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 
        74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 
        84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 
        99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 
        109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 
        119, 120, 121, 122
    };
    private static final byte _ORDERED_DECODABET[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 
        3, 4, 5, 6, 7, 8, 9, 10, -9, -9, 
        -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 
        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 
        26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 
        36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 
        41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
        51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
        61, 62, 63, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9
    };
    private static final byte _STANDARD_ALPHABET[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte _STANDARD_DECODABET[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9
    };
    private static final byte _URL_SAFE_ALPHABET[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    private static final byte _URL_SAFE_DECODABET[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9
    };

    private Base64()
    {
    }

    public static byte[] decode(String s)
        throws IOException
    {
        return decode(s, 0);
    }

    public static byte[] decode(String s, int i)
        throws IOException
    {
        if (s == null)
        {
            throw new NullPointerException("Input string was null.");
        }
        byte abyte0[] = s.getBytes("US-ASCII");
        s = abyte0;
_L6:
        Object obj;
        Object obj1;
        byte abyte1[];
        String s2;
        Object obj3;
        Object obj5;
        Object obj6;
        Object obj7;
        byte abyte2[];
        abyte2 = decode(((byte []) (s)), 0, s.length, i);
        Object obj4;
        byte abyte3[];
        if ((i & 4) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (abyte2 == null || abyte2.length < 4 || i != 0 || 35615 != (abyte2[0] & 0xff | abyte2[1] << 8 & 0xff00)) goto _L2; else goto _L1
_L1:
        abyte1 = null;
        obj6 = null;
        obj1 = null;
        obj3 = null;
        obj5 = null;
        obj4 = null;
        s2 = null;
        obj7 = null;
        abyte3 = new byte[2048];
        s = new ByteArrayOutputStream();
        obj = new ByteArrayInputStream(abyte2);
        obj1 = new GZIPInputStream(((java.io.InputStream) (obj)));
_L5:
        i = ((GZIPInputStream) (obj1)).read(abyte3);
        if (i < 0) goto _L4; else goto _L3
_L3:
        s.write(abyte3, 0, i);
          goto _L5
        abyte1;
        obj4 = obj1;
        obj1 = abyte1;
_L9:
        abyte1 = ((byte []) (obj));
        s2 = s;
        obj3 = obj4;
        ((IOException) (obj1)).printStackTrace();
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        try
        {
            ((GZIPInputStream) (obj4)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        try
        {
            ((ByteArrayInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return abyte2;
        }
_L2:
        return abyte2;
        obj;
        s = s.getBytes();
          goto _L6
_L4:
        abyte1 = s.toByteArray();
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        try
        {
            ((GZIPInputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        try
        {
            ((ByteArrayInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return abyte1;
        }
        return abyte1;
        obj1;
        obj = s2;
        s = abyte1;
_L8:
        try
        {
            ((ByteArrayOutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        try
        {
            ((GZIPInputStream) (obj3)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        throw obj1;
        obj1;
        obj = s;
        s = obj6;
        obj3 = obj5;
        continue; /* Loop/switch isn't completed */
        Object obj2;
        obj2;
        obj1 = s;
        s = ((String) (obj));
        obj = obj1;
        obj3 = obj5;
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        String s1 = s;
        s = ((String) (obj));
        obj = s1;
        obj3 = obj1;
        obj1 = exception;
        if (true) goto _L8; else goto _L7
_L7:
        s1;
        obj = obj1;
        s = obj7;
        obj1 = s1;
          goto _L9
        s1;
        obj = obj1;
        obj1 = s1;
          goto _L9
        obj1;
          goto _L9
    }

    public static byte[] decode(byte abyte0[])
        throws IOException
    {
        return decode(abyte0, 0, abyte0.length, 0);
    }

    public static byte[] decode(byte abyte0[], int i, int j, int k)
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i < 0 || i + j > abyte0.length)
        {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[] {
                Integer.valueOf(abyte0.length), Integer.valueOf(i), Integer.valueOf(j)
            }));
        }
        if (j == 0)
        {
            return new byte[0];
        }
        if (j < 4)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Base64-encoded string must have at least four characters, but length specified was ").append(j).toString());
        }
        byte abyte2[] = getDecodabet(k);
        byte abyte1[] = new byte[(j * 3) / 4];
        int i1 = 0;
        byte abyte3[] = new byte[4];
        int j1 = i;
        int l = 0;
        do
        {
            int k1;
label0:
            {
label1:
                {
label2:
                    {
                        if (j1 < i + j)
                        {
                            k1 = abyte2[abyte0[j1] & 0xff];
                            if (k1 < -5)
                            {
                                break label2;
                            }
                            if (k1 < -1)
                            {
                                break label1;
                            }
                            int l1 = l + 1;
                            abyte3[l] = abyte0[j1];
                            l = l1;
                            k1 = i1;
                            if (l1 <= 3)
                            {
                                break label0;
                            }
                            i1 += decode4to3(abyte3, 0, abyte1, i1, k);
                            l = 0;
                            k1 = i1;
                            if (abyte0[j1] != 61)
                            {
                                break label0;
                            }
                        }
                        abyte0 = new byte[i1];
                        System.arraycopy(abyte1, 0, abyte0, 0, i1);
                        return abyte0;
                    }
                    throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[] {
                        Integer.valueOf(abyte0[j1] & 0xff), Integer.valueOf(j1)
                    }));
                }
                k1 = i1;
            }
            j1++;
            i1 = k1;
        } while (true);
    }

    private static int decode4to3(byte abyte0[], int i, byte abyte1[], int j, int k)
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("Source array was null.");
        }
        if (abyte1 == null)
        {
            throw new NullPointerException("Destination array was null.");
        }
        if (i < 0 || i + 3 >= abyte0.length)
        {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] {
                Integer.valueOf(abyte0.length), Integer.valueOf(i)
            }));
        }
        if (j < 0 || j + 2 >= abyte1.length)
        {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] {
                Integer.valueOf(abyte1.length), Integer.valueOf(j)
            }));
        }
        byte abyte2[] = getDecodabet(k);
        if (abyte0[i + 2] == 61)
        {
            abyte1[j] = (byte)(((abyte2[abyte0[i]] & 0xff) << 18 | (abyte2[abyte0[i + 1]] & 0xff) << 12) >>> 16);
            return 1;
        }
        if (abyte0[i + 3] == 61)
        {
            i = (abyte2[abyte0[i]] & 0xff) << 18 | (abyte2[abyte0[i + 1]] & 0xff) << 12 | (abyte2[abyte0[i + 2]] & 0xff) << 6;
            abyte1[j] = (byte)(i >>> 16);
            abyte1[j + 1] = (byte)(i >>> 8);
            return 2;
        } else
        {
            i = (abyte2[abyte0[i]] & 0xff) << 18 | (abyte2[abyte0[i + 1]] & 0xff) << 12 | (abyte2[abyte0[i + 2]] & 0xff) << 6 | abyte2[abyte0[i + 3]] & 0xff;
            abyte1[j] = (byte)(i >> 16);
            abyte1[j + 1] = (byte)(i >> 8);
            abyte1[j + 2] = (byte)i;
            return 3;
        }
    }

    private static byte[] encode3to4(byte abyte0[], int i, int j, byte abyte1[], int k, int l)
    {
        int j1 = 0;
        byte abyte2[] = getAlphabet(l);
        int i1;
        if (j > 0)
        {
            l = (abyte0[i] << 24) >>> 8;
        } else
        {
            l = 0;
        }
        if (j > 1)
        {
            i1 = (abyte0[i + 1] << 24) >>> 16;
        } else
        {
            i1 = 0;
        }
        if (j > 2)
        {
            j1 = (abyte0[i + 2] << 24) >>> 24;
        }
        i = i1 | l | j1;
        switch (j)
        {
        default:
            return abyte1;

        case 3: // '\003'
            abyte1[k] = abyte2[i >>> 18];
            abyte1[k + 1] = abyte2[i >>> 12 & 0x3f];
            abyte1[k + 2] = abyte2[i >>> 6 & 0x3f];
            abyte1[k + 3] = abyte2[i & 0x3f];
            return abyte1;

        case 2: // '\002'
            abyte1[k] = abyte2[i >>> 18];
            abyte1[k + 1] = abyte2[i >>> 12 & 0x3f];
            abyte1[k + 2] = abyte2[i >>> 6 & 0x3f];
            abyte1[k + 3] = 61;
            return abyte1;

        case 1: // '\001'
            abyte1[k] = abyte2[i >>> 18];
            abyte1[k + 1] = abyte2[i >>> 12 & 0x3f];
            abyte1[k + 2] = 61;
            abyte1[k + 3] = 61;
            return abyte1;
        }
    }

    private static byte[] encode3to4(byte abyte0[], byte abyte1[], int i, int j)
    {
        encode3to4(abyte1, 0, i, abyte0, 0, j);
        return abyte0;
    }

    public static String encodeBytes(byte abyte0[])
    {
        Object obj = null;
        try
        {
            abyte0 = encodeBytes(abyte0, 0, abyte0.length, 0);
        }
        catch (IOException ioexception)
        {
            abyte0 = obj;
            if (!$assertionsDisabled)
            {
                throw new AssertionError(ioexception.getMessage());
            }
        }
        if (!$assertionsDisabled && abyte0 == null)
        {
            throw new AssertionError();
        } else
        {
            return abyte0;
        }
    }

    public static String encodeBytes(byte abyte0[], int i)
        throws IOException
    {
        return encodeBytes(abyte0, 0, abyte0.length, i);
    }

    public static String encodeBytes(byte abyte0[], int i, int j, int k)
        throws IOException
    {
        abyte0 = encodeBytesToBytes(abyte0, i, j, k);
        String s;
        try
        {
            s = new String(abyte0, "US-ASCII");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return new String(abyte0);
        }
        return s;
    }

    public static byte[] encodeBytesToBytes(byte abyte0[], int i, int j, int k)
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot have negative offset: ").append(i).toString());
        }
        if (j < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot have length offset: ").append(j).toString());
        }
        if (i + j > abyte0.length)
        {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(abyte0.length)
            }));
        }
        if ((k & 2) == 0) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        obj1 = null;
        obj8 = null;
        obj3 = null;
        obj5 = null;
        obj4 = null;
        obj2 = null;
        obj7 = null;
        obj6 = null;
        Object obj = new ByteArrayOutputStream();
        int l;
        int i1;
        boolean flag;
        int j1;
        int k1;
        int l1;
        try
        {
            obj1 = new OutputStream(((java.io.OutputStream) (obj)), k | 1);
        }
        catch (IOException ioexception)
        {
            abyte0 = ((byte []) (obj));
            obj = ioexception;
            ioexception = obj6;
            obj3 = obj4;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj1 = obj;
            obj = obj7;
            obj3 = obj5;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
_L3:
            obj2 = new GZIPOutputStream(((java.io.OutputStream) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            abyte0 = ((byte []) (obj));
            obj = obj2;
            obj3 = obj4;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj2 = obj;
            obj = obj1;
            obj1 = obj2;
            obj3 = obj5;
            continue; /* Loop/switch isn't completed */
        }
        ((GZIPOutputStream) (obj2)).write(abyte0, i, j);
        ((GZIPOutputStream) (obj2)).close();
        try
        {
            ((GZIPOutputStream) (obj2)).close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[]) { }
        try
        {
            ((OutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[]) { }
        try
        {
            ((ByteArrayOutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[]) { }
        return ((ByteArrayOutputStream) (obj)).toByteArray();
        obj;
        obj3 = obj4;
        abyte0 = obj8;
        obj1 = obj6;
_L6:
        obj2 = obj1;
        obj1 = abyte0;
        throw obj;
        abyte0;
        obj = obj2;
_L4:
        try
        {
            ((GZIPOutputStream) (obj3)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2) { }
        try
        {
            ((OutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        try
        {
            ((ByteArrayOutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        throw abyte0;
_L2:
        if ((k & 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i1 = j / 3;
        if (j % 3 > 0)
        {
            l = 4;
        } else
        {
            l = 0;
        }
        i1 = i1 * 4 + l;
        l = i1;
        if (flag)
        {
            l = i1 + i1 / 76;
        }
        obj = new byte[l];
        j1 = 0;
        l = 0;
        i1 = 0;
        while (j1 < j - 2) 
        {
            encode3to4(abyte0, j1 + i, 3, ((byte []) (obj)), l, k);
            l1 = i1 + 4;
            k1 = l;
            i1 = l1;
            if (flag)
            {
                k1 = l;
                i1 = l1;
                if (l1 >= 76)
                {
                    obj[l + 4] = 10;
                    k1 = l + 1;
                    i1 = 0;
                }
            }
            j1 += 3;
            l = k1 + 4;
        }
        i1 = l;
        if (j1 < j)
        {
            encode3to4(abyte0, j1 + i, j - j1, ((byte []) (obj)), l, k);
            i1 = l + 4;
        }
        if (i1 <= obj.length - 1)
        {
            abyte0 = new byte[i1];
            System.arraycopy(obj, 0, abyte0, 0, i1);
            return abyte0;
        } else
        {
            return ((byte []) (obj));
        }
        abyte0;
        obj3 = obj;
        obj = obj1;
        obj1 = obj3;
        obj3 = obj2;
        if (true) goto _L4; else goto _L3
        IOException ioexception1;
        ioexception1;
        abyte0 = ((byte []) (obj));
        obj = ioexception1;
        ioexception1 = ((IOException) (obj2));
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static final byte[] getAlphabet(int i)
    {
        if ((i & 0x10) == 16)
        {
            return _URL_SAFE_ALPHABET;
        }
        if ((i & 0x20) == 32)
        {
            return _ORDERED_ALPHABET;
        } else
        {
            return _STANDARD_ALPHABET;
        }
    }

    private static final byte[] getDecodabet(int i)
    {
        if ((i & 0x10) == 16)
        {
            return _URL_SAFE_DECODABET;
        }
        if ((i & 0x20) == 32)
        {
            return _ORDERED_DECODABET;
        } else
        {
            return _STANDARD_DECODABET;
        }
    }

    static 
    {
        boolean flag;
        if (!org/iharder/encoders/Base64.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }



}
