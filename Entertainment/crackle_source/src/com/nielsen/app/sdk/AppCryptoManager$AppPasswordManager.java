// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nielsen.app.sdk;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.nielsen.app.sdk:
//            AppCryptoManager

public static class 
{

    private static final String a = "HmacSHA1";
    private static byte b[];
    private static Mac c;
    private static int d;
    private static byte e[] = new byte[20];
    private static int f = 0;
    private static int g = 0;
    private static int h = 1;

    public static void Setup(String s, byte abyte0[])
        throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException
    {
        Setup(s, abyte0, 1000);
    }

    public static void Setup(String s, byte abyte0[], int i)
        throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException
    {
        Setup(s.getBytes("UTF8"), abyte0, i);
    }

    public static void Setup(byte abyte0[], byte abyte1[], int i)
        throws NoSuchAlgorithmException, InvalidKeyException
    {
        if (abyte1 == null || abyte1.length < 8)
        {
            throw new InvalidKeyException("Salt must be 8 bytes or more");
        }
        if (abyte0 == null)
        {
            throw new InvalidKeyException("Password cannot be null");
        } else
        {
            b = abyte1;
            d = i;
            c = Mac.getInstance("HmacSHA1");
            c.init(new SecretKeySpec(abyte0, "HmacSHA1"));
            return;
        }
    }

    private static byte[] a()
    {
        c.update(b, 0, b.length);
        byte abyte1[] = c.doFinal(a(h));
        c.reset();
        int i = 2;
        byte abyte0[] = abyte1;
        for (; i <= d; i++)
        {
            abyte0 = c.doFinal(abyte0);
            for (int j = 0; j < 20; j++)
            {
                abyte1[j] = (byte)(abyte1[j] ^ abyte0[j]);
            }

        }

        if (h >= 0x7fffffff)
        {
            h = 0;
            return abyte1;
        } else
        {
            h++;
            return abyte1;
        }
    }

    private static byte[] a(int i)
    {
        return (new byte[] {
            (byte)(i >>> 24), (byte)(i >>> 16), (byte)(i >>> 8), (byte)i
        });
    }

    public static byte[] getBytes(int i)
    {
label0:
        {
            byte abyte0[] = new byte[i];
            int j = g - f;
            int k;
            if (j > 0)
            {
                if (j > i)
                {
                    System.arraycopy(e, f, abyte0, 0, i);
                    f += i;
                } else
                {
                    System.arraycopy(e, f, abyte0, 0, j);
                    f = 0;
                    g = 0;
                }
                j += 0;
            } else
            {
                j = 0;
            }
            do
            {
                if (j >= i)
                {
                    break label0;
                }
                k = i - j;
                e = a();
                if (k <= 20)
                {
                    break;
                }
                System.arraycopy(e, 0, abyte0, j, 20);
                j += 20;
            } while (true);
            System.arraycopy(e, 0, abyte0, j, k);
            f = k;
            g = 20;
        }
        return abyte0;
    }


    public ()
    {
    }
}
