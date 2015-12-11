// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK.libcore;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class CacheUtils
{

    private static final char DIGITS[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    private static final byte MAP[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };

    private static String bytesToHexString(byte abyte0[])
    {
        char ac[] = DIGITS;
        char ac1[] = new char[abyte0.length * 2];
        int k = abyte0.length;
        int i = 0;
        int j = 0;
        for (; i < k; i++)
        {
            byte byte0 = abyte0[i];
            int l = j + 1;
            ac1[j] = ac[byte0 >> 4 & 0xf];
            j = l + 1;
            ac1[l] = ac[byte0 & 0xf];
        }

        return new String(ac1);
    }

    private static byte[] decode(byte abyte0[])
    {
        byte abyte1[];
        int j1;
        int k1;
        k1 = abyte0.length;
        int i = (k1 / 4) * 3;
        if (i == 0)
        {
            return new byte[0];
        }
        abyte1 = new byte[i];
        j1 = 0;
_L2:
        int j;
        byte byte0;
        byte0 = abyte0[k1 - 1];
        j = j1;
        if (byte0 != 10)
        {
            j = j1;
            if (byte0 != 13)
            {
                j = j1;
                if (byte0 != 32)
                {
                    if (byte0 != 9)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    j = j1;
                }
            }
        }
_L3:
        k1--;
        j1 = j;
        if (true) goto _L2; else goto _L1
_L1:
        if (byte0 == 61)
        {
            j = j1 + 1;
        } else
        {
            int k;
label0:
            {
                int j2 = 0;
                int k2 = 0;
                int i2 = 0;
                k = 0;
                while (i2 < k1) 
                {
                    int l = abyte0[i2];
                    if (l != 10 && l != 13 && l != 32 && l != 9)
                    {
                        if (l >= 65 && l <= 90)
                        {
                            l -= 65;
                        } else
                        if (l >= 97 && l <= 122)
                        {
                            l -= 71;
                        } else
                        if (l >= 48 && l <= 57)
                        {
                            l += 4;
                        } else
                        if (l == 43)
                        {
                            l = 62;
                        } else
                        if (l == 47)
                        {
                            l = 63;
                        } else
                        {
                            return null;
                        }
                        k2 = k2 << 6 | (byte)l;
                        if (j2 % 4 == 3)
                        {
                            l = k + 1;
                            abyte1[k] = (byte)(k2 >> 16);
                            int l2 = l + 1;
                            abyte1[l] = (byte)(k2 >> 8);
                            k = l2 + 1;
                            abyte1[l2] = (byte)k2;
                        }
                        j2++;
                    }
                    i2++;
                }
                int i1 = k;
                if (j1 > 0)
                {
                    int l1 = k2 << j1 * 6;
                    i1 = k + 1;
                    abyte1[k] = (byte)(l1 >> 16);
                    k = i1;
                    if (j1 != 1)
                    {
                        break label0;
                    }
                    k = i1 + 1;
                    abyte1[i1] = (byte)(l1 >> 8);
                    i1 = k;
                }
                k = i1;
            }
            abyte0 = new byte[k];
            System.arraycopy(abyte1, 0, abyte0, 0, k);
            return abyte0;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private static String encode(byte abyte0[])
    {
        byte abyte1[];
        int i;
        int l;
        abyte1 = new byte[((abyte0.length + 2) * 4) / 3];
        l = abyte0.length - abyte0.length % 3;
        int j = 0;
        i = 0;
        for (; j < l; j += 3)
        {
            int i1 = i + 1;
            abyte1[i] = MAP[(abyte0[j] & 0xff) >> 2];
            i = i1 + 1;
            abyte1[i1] = MAP[(abyte0[j] & 3) << 4 | (abyte0[j + 1] & 0xff) >> 4];
            i1 = i + 1;
            abyte1[i] = MAP[(abyte0[j + 1] & 0xf) << 2 | (abyte0[j + 2] & 0xff) >> 6];
            i = i1 + 1;
            abyte1[i1] = MAP[abyte0[j + 2] & 0x3f];
        }

        abyte0.length % 3;
        JVM INSTR tableswitch 1 2: default 172
    //                   1 187
    //                   2 248;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_248;
_L4:
        int k;
        try
        {
            abyte0 = new String(abyte1, 0, i, "US-ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AssertionError(abyte0);
        }
        return abyte0;
_L2:
        k = i + 1;
        abyte1[i] = MAP[(abyte0[l] & 0xff) >> 2];
        i = k + 1;
        abyte1[k] = MAP[(abyte0[l] & 3) << 4];
        k = i + 1;
        abyte1[i] = 61;
        abyte1[k] = 61;
        i = k + 1;
          goto _L4
        k = i + 1;
        abyte1[i] = MAP[(abyte0[l] & 0xff) >> 2];
        i = k + 1;
        abyte1[k] = MAP[(abyte0[l] & 3) << 4 | (abyte0[l + 1] & 0xff) >> 4];
        k = i + 1;
        abyte1[i] = MAP[(abyte0[l + 1] & 0xf) << 2];
        i = k + 1;
        abyte1[k] = 61;
          goto _L4
    }

    static Certificate[] readCertArray(BufferedReader bufferedreader)
        throws IOException
    {
        int i = Integer.parseInt(bufferedreader.readLine());
        if (i != -1) goto _L2; else goto _L1
_L1:
        Certificate acertificate[] = null;
_L4:
        return acertificate;
_L2:
        Certificate acertificate1[];
        CertificateFactory certificatefactory;
        try
        {
            certificatefactory = CertificateFactory.getInstance("X.509");
            acertificate1 = new Certificate[i];
        }
        // Misplaced declaration of an exception variable
        catch (BufferedReader bufferedreader)
        {
            throw new IOException(bufferedreader.getMessage());
        }
        i = 0;
        acertificate = acertificate1;
        if (i >= acertificate1.length) goto _L4; else goto _L3
_L3:
        acertificate1[i] = certificatefactory.generateCertificate(new ByteArrayInputStream(decode(bufferedreader.readLine().getBytes("US-ASCII"))));
        i++;
        break MISSING_BLOCK_LABEL_34;
    }

    public static String uriToKey(URI uri)
    {
        try
        {
            uri = bytesToHexString(MessageDigest.getInstance("MD5").digest(uri.toString().getBytes("UTF-8")));
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            throw new AssertionError(uri);
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            throw new AssertionError(uri);
        }
        return uri;
    }

    static void writeCertArray(Writer writer, Certificate acertificate[])
        throws IOException
    {
        if (acertificate != null) goto _L2; else goto _L1
_L1:
        writer.write("0\n");
_L6:
        return;
_L2:
        String s;
        int i;
        int j;
        try
        {
            writer.write((new StringBuilder()).append(Integer.toString(acertificate.length)).append('\n').toString());
            j = acertificate.length;
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer)
        {
            throw new IOException(writer.getMessage());
        }
        i = 0;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = encode(acertificate[i].getEncoded());
        writer.write((new StringBuilder()).append(s).append('\n').toString());
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_86;
_L4:
        break MISSING_BLOCK_LABEL_44;
        if (true) goto _L6; else goto _L5
_L5:
    }

}
